<template>
  <div>
    <!--提示页头-->
    <el-tabs v-model="activeName" >
      <el-tab-pane label="图书编辑" name="first"></el-tab-pane>
    </el-tabs>

    <el-form :model="bookInfo" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <!--图书id，设置为不可修改状态-->
      <el-form-item label="id" prop="bookId">
        <el-input disabled type="test" v-model="bookInfo.bookId" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="书名" prop="bookName">
        <el-input type="test" v-model="bookInfo.bookName" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="作者" prop="author">
        <el-input type="text" v-model="bookInfo.author" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="出版社" prop="public">
        <el-input type="text" v-model="bookInfo.public" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="库存" prop="stock">
        <el-input type="text" v-model="bookInfo.stock" autocomplete="off"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'ModifyBookView',
  created() {
    this.bookInfo.bookId = this.$route.params.book.bookId
    this.bookInfo.bookName = this.$route.params.book.bookName
    this.bookInfo.author = this.$route.params.book.author
    this.bookInfo.public = this.$route.params.book.public
    this.bookInfo.stock = parseInt(this.$route.params.book.stock)
  },
  data() {
    return {
      /*提示页头激活*/
      activeName: 'first',
      /*需要被修改的图书信息*/
      bookInfo: {
        bookId: '',
        bookName: '',
        author: '',
        public: '',
        stock: ''
      },
      /*校验规则*/
      rules: {
        bookName: [
          {validator: validateBookName, trigger: 'blur'}
        ],
        author: [
          {validator: validateAuthor, trigger: 'blur'}
        ],
        public: [
          {validator: validatePublic, trigger: 'blur'}
        ],
        stock: [
          {validator: validateStock, trigger: 'blur'}
        ]
      }
    };
    /*图书名称校验*/
    var validateBookName = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入书名'));
      } else {
        callback();
      }
    };
    /*作者名称校验*/
    var validateAuthor = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入作者名字'));
      } else {
        callback();
      }
    };
    /*出版社校验*/
    var validatePublic = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入出版社名字'));
      } else {
        callback();
      }
    };
    /*库存校验*/
    var validateStock = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('库存不能为空'));
      }
      setTimeout(() => {
        if (!Number.isInteger(value)) {
          callback(new Error('请输入数字值'));
        } else {
          if (value < 0) {
            callback(new Error('库存不能为负数'));
          } else {
            callback();
          }
        }
      }, 1000);
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('修改成功!');
          /*axios修改图书数据*/
          this.axios.get("/bookUpdate", {
            data: {
              book: this.bookInfo
            }
          });
          this.$router.push('/book')
        } else {
          alert('修改失败');
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
