<template>
  <div>
    <!--图书管理管理页面-->

    <!--顶部多功能栏-->
    <div style="padding-right: 1000px;width: 800px;margin-left: -125px;">

      <!--添加图书-->
      <div style="display: inline-block">
        <el-button type="success" round @click="toAddBookPage">添加图书</el-button>
      </div>
      <!--提示-->
      <div style="width: 100px;display: inline-block">
        <strong>搜索图书：</strong>
      </div>
      <!--输入框-->
      <div style="width: 160px;display: inline-block">
        <el-input v-model="searchBookId" placeholder="图书id"></el-input>
      </div>
      <!--输入按钮-->
      <div style="display: inline-block">
        <el-button icon="el-icon-search" circle @click="getBookById()"></el-button>
      </div>
      <!--回到图书列表-->
      <div style="display: inline-block">
        <el-button round @click="reset">返回第一页</el-button>
      </div>

    </div>

    <!--提示页头-->
    <el-tabs v-model="activeName" >
      <el-tab-pane label="图书数据" name="first"></el-tab-pane>
    </el-tabs>

    <!--列表展示数据-->
    <!--ref="singleTable"单选表格
    :data="this.bookListData"绑定数据-->
    <el-table ref="singleTable" :data="this.bookList" stripe style="width: 100%">
      <!--表头-->

      <el-table-column prop="bookId" label="id" width="180"></el-table-column>
      <el-table-column prop="bookName" label="书名" width="180"></el-table-column>
      <el-table-column prop="author" label="作者" width="180"></el-table-column>
      <el-table-column prop="public" label="出版社"></el-table-column>
      <el-table-column prop="stock" label="库存"></el-table-column>

      <el-table-column prop="value" label="评分" width="180">
        <template slot-scope="scope">
          <el-rate v-model="scope.row.value" disabled show-score text-color="#ff9900" score-template="{value}"></el-rate>
        </template>
      </el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="toUpdateBookPage(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="deleteBookById(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>


    <!--分页组件-->
    <!--@next-click="show"下一页，prev-click="show"上一页，@current-change="show"当前页-->
    <el-pagination @next-click="getBookList" @prev-click="getBookList" :page-size="this.pageSize" v-model:current-page="currentPageNo" @current-change="getBookList"
                   :page-sizes="[5, 10]" @size-change="handleSizeChange" background layout="total, sizes, prev, pager, next, jumper" :total="this.total">
    </el-pagination>
  </div>
</template>

<script>
import MyAxios from "../utils/MyAxios";
export default {
  name: "BookView",
  data() {
    return {
      bookList: [],
      currentPageNo: 1,
      pageSize: 5,
      total: 0,
      searchBookId: '',
      activeName: 'first'
    }
  },
  methods: {
    //查询图书列表，参数为当前页码
    getBookList(currentPageNo) {
      this.axios.get("/getBookList", {
        data: {
          currentPageNo: currentPageNo,
          pageSize: this.pageSize,
        }
      }).then(res => {
        this.bookList = res.data.data[0];
        this.total = res.data.data[1];
      });
    },
    //跳转到图书修改页面
    toUpdateBookPage(book) {
      this.$router.push({
        name: 'bookUpdatePage',
        params: {
          book: book
        }
      })
    },
    //通过id删除图书
    deleteBookById(book) {
      this.axios.get("/deleteBookById", {
        data: {
          book: book
        }
      });
      alert("删除成功");
      this.getBookList(this.currentPageNo);
    },
    //通过图书id查找图书
    getBookById() {
      if (this.searchBookId != null && this.searchBookId != '') {
        this.axios.get("/getBookById", {
          data: {
            searchBookId: this.searchBookId
          }
        }).then(res => {
          this.bookList = res.data.data;
          this.total = 1;
        });
      }else {
        alert("搜索值不能为空");
      }
    },
    //跳转到新增用户界面
    toAddBookPage() {
      this.$router.push({
        name: 'addBookPage'
      })

    },
    //查询之后返回第一页
    reset() {
      this.getBookList(1);
    },
    //修改页面容量
    handleSizeChange(val) {
      this.pageSize = val;
      this.getBookList(1);
      this.currentPageNo = 1;
    },

  },
  mounted() {
    /*进入组件时初始化数据*/
    this.getBookList(1);
  },
}
</script>


<style scoped>
.buttonMargin {
  margin: 15px 0;
}
</style>
