<template>
<div>
  <!--提示页头-->
  <el-tabs v-model="activeName" >
    <el-tab-pane label="用户编辑" name="first"></el-tab-pane>
  </el-tabs>

  <!--用户修改表单-->
  <!--:model="ruleForm"设置为校验表单，:rules="rules"绑定校验规则，ref="ruleForm"表单类型为校验表单-->
  <!--status-icon校验结果反馈图标-->
  <el-form :model="userInfo" :rules="rules" ref="ruleForm" status-icon label-width="100px" label-position="left">
    <!--用户id，设置为不可修改状态-->
    <el-form-item label="id" prop="id">
      <el-input disabled type="test" v-model="userInfo.id" autocomplete="off"></el-input>
    </el-form-item>
    <!--用户名修改-->
    <el-form-item label="用户名" prop="name">
      <el-input type="test" v-model="userInfo.name" autocomplete="off"></el-input>
    </el-form-item>
    <!--用户账号修改-->
    <el-form-item label="账号" prop="userCode">
      <el-input type="text" v-model="userInfo.userCode" autocomplete="off"></el-input>
    </el-form-item>
    <!--用户角色修改-->
    <el-form-item label="角色" >
      <el-select style="margin-right: 947px;padding-right: 409px;margin-left: -10px;" v-model="userInfo.role" placeholder="请选择用户角色">
        <el-option label="admin" value="admin"></el-option>
        <el-option label="manage" value="manage"></el-option>
        <el-option label="reader" value="reader"></el-option>
      </el-select>
    </el-form-item>
    <!--用户密码修改-->
    <el-form-item label="密码" prop="password">
      <el-input type="test" v-model="userInfo.password" autocomplete="off"></el-input>
    </el-form-item>
    <!--操作按钮-->
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>

</div>
</template>

<script>
export default {
  name: 'modifyUserView',
  /*路由进入这个组件的时候就取出路由里要修改的用户信息*/
  created() {
    this.userInfo.id = this.$route.params.user.id
    this.userInfo.name = this.$route.params.user.name
    this.userInfo.userCode = this.$route.params.user.userCode
    this.userInfo.password = this.$route.params.user.password
    this.userInfo.role = this.$route.params.user.role
  },
  data() {
    return {
      activeName: 'first',
      /*需要被修改的用户信息*/
      userInfo: {
        id: '',
        name: '',
        userCode: '',
        password: '',
        role: '',
      },
      /*自定义校验规则*/
      rules: {
        password: [
          /*失去焦点执行*/
          { validator: validatePass, trigger: 'blur' }
        ],
        name: [
          {validator: validateUserName, trigger: 'blur'}
        ],
        userCode: [
          {validator: validateUserCode, trigger: 'blur'}
        ]
      }
    };
    /*密码校验规则*/
    var validatePass = (rule, value, callback) => {
      /*密码框为空*/
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.userInfo.password !== '') {
          this.$refs.ruleForm.validateField('password');
        }
        callback();
      }
    };
    /*用户姓名校验规则*/
    var validateUserName = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'));
      } else {
        callback();
      }
    };
    /*账号校验规则*/
    var validateUserCode = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入账号'));
      } else {
        callback();
      }
    };
  },
  methods: {
    /*表单提交事件*/
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('修改成功!');
          console.log(this.userInfo)
          /*axios修改用户数据*/
          this.axios.get("/userUpdate", {
            data: {
              user:this.userInfo
            }
          });
          this.$router.push('/user')
        } else {
          alert('修改失败!');
          console.log('error submit!!');
          return false;
        }
      });
    },
    /*重置为初始数据*/
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>
</style>
