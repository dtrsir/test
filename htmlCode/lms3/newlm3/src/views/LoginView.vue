<template>
  <div class="background-img">
    <!--表单主体-->
    <el-form ref="loginForm" :model="form" :rules="rules" label-width="80px" class="login-box">

      <h3 class="login-title">欢迎登录</h3>

      <!--登陆账号-->
      <el-form-item label="账号" prop="userCode">
        <el-input type="text" placeholder="请输入账号" v-model="form.userCode"/>
      </el-form-item>
      <!--登陆密码-->
      <el-form-item label="密码" prop="password">
        <el-input type="password" placeholder="请输入密码" v-model="form.password"/>
      </el-form-item>
      <!--登陆按钮-->
      <el-form-item class="login-button">
        <el-button type="primary" v-on:click="onSubmit('loginForm')">登录</el-button>
      </el-form-item>
    </el-form>

    <!--校验弹框-->
    <el-dialog title="温馨提示" :visible.sync="dialogVisible" width="30%" :before-close="handleClose" :append-to-body="true">
      <span>请输入账号和密码</span>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>


  </div>
</template>

<script>
import MyAxios from "../utils/MyAxios";
import Mock from "mockjs";
export default {
  name: "Login",
  data() {
    return {
      user: {
        id: '',
        name: '',
        userCode: '',
        password: '',
        role: '',
        state:true
      },
      form: {
        userCode: '',
        password: ''
      },
      info: [],
      error: '',
      //表单验证，需要在el-form-item 元素中增加prop 属性
      rules: {
        userCode: [
          {required: true, message: " 账号不可为空", trigger: 'blur'}
        ],
        password: [
          {required: true, message: " 密码不可为空 ", trigger: 'blur'}
        ]
      },
//对话框显示和隐藏
      dialogVisible: false,
      flag: false
    };
  },
  methods: {
    /*登陆提交*/
    async onSubmit(formName) {
      //为表单绑定验证功能
      await this.login();
       this.$refs [formName].validate((valid) => {
        if (valid) {
          if (this.flag) {
             this.$router.push({
              name: 'hello',
              params: {
                id: this.user.id,
                name: this.user.name,
                password: this.user.password,
                role: this.user.role,
                userCode: this.user.userCode,
              }
            })
          }else {
            this.accountError();
          }
          return ;
        } else {
          this.dialogVisible = true;
          return false;
        }
      });
    },
    //登陆请求
    async login() {
      await this.axios.get("/login", {
        data: {
          userCode: this.form.userCode,
          password: this.form.password,
        }
      }).then(res => {
        this.flag = res.data.data[0];
        this.user = res.data.data[1];
      });
    },
    //弹出框设置
    handleClose(done) {
      this.dialogVisible = !this.dialogVisible;
    },
    //无法登陆提示信息
    accountError() {
      this.$message.error('账号或者密码错误');
    }
  },
  /*axios建议写在mounted里面*/
  mounted(){//钩子函数
    /*钩子函数是一种链式编程*/
    /*axios发起get请求，然后es6语法创建一个响应函数，通过给model层的键值对赋值可以让视图层拿到数据*/
    /*通过headers携带参数*/
    // MyAxios.get('/user/userinfo').then(response=>(this.info = response.data));
  }
}
</script>

<style lang="scss" scoped>
.background-img {
  background-color: #FFDEE9;
  background-image: linear-gradient(315deg, #FFDEE9 26%, #B5FFFC 82%);
}
.login-box {
  border: 1px solid #DCDFE6;
  width: 350px;
  margin: 180px auto;
  padding: 35px 35px 15px 35px;
  border-radius: 5px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  box-shadow: 0 0 25px #909399;
}

.login-title {
  text-align: center;
  margin: 0 auto 40px auto;
  color: #303133;
}
.login-button {
  margin-left: -80px;
}
</style>
