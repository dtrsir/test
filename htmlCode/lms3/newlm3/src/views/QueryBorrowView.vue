<template>
  <div>
    <!--提示页头-->
    <el-tabs v-model="activeName" >
      <el-tab-pane label="记录详情" name="first"></el-tab-pane>
    </el-tabs>

    <el-form :model="borrowInfo" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <!--图书id，设置为不可修改状态-->
      <el-form-item label="记录编号" prop="borrowId">
        <el-input type="test" v-model="borrowInfo.borrowId" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="书名" prop="bookName">
        <el-input type="test" v-model="borrowInfo.bookName" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="借阅人" prop="userName">
        <el-input type="text" v-model="borrowInfo.userName" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="借阅如期" prop="borrowDate">
        <el-input type="text" v-model="borrowInfo.borrowDate" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="借阅状态" prop="borrowState">
        <el-input type="text" v-model="borrowInfo.borrowState" autocomplete="off"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="success" @click="back">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import Mock from "mockjs";

export default {
  name: "QueryBorrowView",
  created() {
    this.borrowInfo.borrowId = this.$route.params.borrow.borrowId
    this.borrowInfo.bookName = this.$route.params.borrow.bookName
    this.borrowInfo.userName = this.$route.params.borrow.userName
    this.borrowInfo.borrowDate = this.$route.params.borrow.borrowDate
    this.borrowInfo.borrowState = this.$route.params.borrow.borrowState
  },
  data() {
    return {
      /*提示页头激活*/
      activeName: 'first',
      borrowInfo: {
        borrowId: '',
        bookName: '',
        userName: '',
        borrowDate: '',
        borrowState: ''
      },
    };
  },
  methods: {
    back() {
      this.$router.push('/borrow')
    }
  }
}
</script>

<style scoped>

</style>
