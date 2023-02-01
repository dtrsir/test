<template>
  <div>
    <!--提示页头-->
    <el-tabs v-model="activeName" >
      <el-tab-pane label="添加用户" name="first"></el-tab-pane>
    </el-tabs>
    <!--添加用户表单-->
    <div style="width: 300px">
      <el-form :model="userInfo" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <!--用户姓名-->
        <el-form-item label="姓名" prop="name">
          <el-input type="text" v-model="userInfo.name" autocomplete="off"></el-input>
        </el-form-item>
        <!--用户账号-->
        <el-form-item label="账号" prop="userCode">
          <el-input type="text" v-model="userInfo.userCode" autocomplete="off"></el-input>
        </el-form-item>
        <!--用户密码-->
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="userInfo.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="checkPassword">
          <el-input type="password" v-model="userInfo.checkPassword" autocomplete="off"></el-input>
        </el-form-item>
        <!--用户角色-->
        <el-form-item label="角色" prop="role">
<!--          <el-input type="password" v-model="userInfo.role" autocomplete="off"></el-input>-->
          <el-select v-model="userInfo.role" placeholder="请选择用户角色">
            <el-option label="admin" value="admin"></el-option>
            <el-option label="manage" value="manage"></el-option>
            <el-option label="reader" value="reader"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>

  </div>
</template>

<script>
export default {
  name: "AddUserView",

  data() {
    /*用户姓名校验*/
    var validateName = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户姓名'));
      } else {
        callback();
      }
    };
    /*用户账号校验*/
    var validateUserCode = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户账号'));
      } else {
        callback();
      }
    };
    /*用户密码校验*/
    var validatePassword = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.userInfo.checkPassword !== '') {
          this.$refs.ruleForm.validateField('checkPassword');
        }
        callback();
      }
    };
    /*用户确认密码校验*/
    var validatePassword2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.userInfo.password) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };

    return {
      /*新增用户信息*/
      userInfo: {
        id: '',
        name: '',
        userCode: '',
        password: '',
        checkPassword: '',
        role:'reader',
      },
      /*调用的校验规则*/
      rules: {
        password: [
          { validator: validatePassword, trigger: 'blur' }
        ],
        checkPassword: [
          { validator: validatePassword2, trigger: 'blur' }
        ],
        name: [
          { validator: validateName, trigger: 'blur' }
        ],
        userCode: [
          { validator: validateUserCode, trigger: 'blur' }
        ]
      },
      activeName: 'first'
    };
  },
  methods: {
    /*表单提交*/
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.axios.get("/addUser", {
            data: {
              user:this.userInfo
            }
          });
          alert('提交成功!即将回到用户列表页面');
          this.$router.push({
            name: 'userList'
          });
        } else {
          console.log('增加失败!!');
          return false;
        }
      });
    },
    /*表单重置*/
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>

</style>
