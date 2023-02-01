<template>
  <div>
    <!--提示页头-->
    <el-tabs v-model="activeName" >
      <el-tab-pane label="图书新增" name="first"></el-tab-pane>
    </el-tabs>

    <!--添加用户表单-->
    <div style="width: 300px">
      <el-form :model="bookInfo" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

        <!--图书名称-->
        <el-form-item label="图书名称" prop="bookName">
          <el-input type="text" v-model="bookInfo.bookName" autocomplete="off"></el-input>
        </el-form-item>

        <!--作者-->
        <el-form-item label="作者" prop="author">
          <el-input type="text" v-model="bookInfo.author" autocomplete="off"></el-input>
        </el-form-item>

        <!--出版社-->
        <el-form-item label="出版社" prop="public">
          <el-input type="text" v-model="bookInfo.public" autocomplete="off"></el-input>
        </el-form-item>

        <!--库存-->
        <el-form-item label="库存" prop="stock">
          <el-input type="text" v-model="bookInfo.stock" autocomplete="off"></el-input>
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
import Mock from "mockjs";

export default {
  name: "AddBookView",
  data() {
    /*图书名称校验*/
    var validateBookName = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入图书名称'));
      } else {
        callback();
      }
    };
    /*作者校验*/
    var validateAuthor = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入作者姓名'));
      } else {
        callback();
      }
    };
    /*出版社名称校验*/
    var validatePublic = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入出版社'));
      } else {
        callback();
      }
    };
    /*库存合法性校验*/
    var validateStock = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('库存不能为空'));
      }
      setTimeout(() => {
          if (value < 0) {
            callback(new Error('库存不能为负数'));
          } else {
            callback();
          }
      }, 1000);
    };

    return {
      /*新增图书信息*/
      bookInfo: {
        bookId: '',
        bookName: '',
        author: '',
        public: '',
        stock: ''
      },
      /*调用的校验规则*/
      rules: {
        bookName: [
          { validator: validateBookName, trigger: 'blur' }
        ],
        author: [
          { validator: validateAuthor, trigger: 'blur' }
        ],
        public: [
          { validator: validatePublic, trigger: 'blur' }
        ],
        stock: [
          { validator: validateStock, trigger: 'blur' }
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
          this.axios.get("/addBook", {
            data: {
              book:this.bookInfo
            }
          });
          alert('提交成功！！即将回到图书管理页面');
          this.$router.push({
            name: 'bookList'
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
