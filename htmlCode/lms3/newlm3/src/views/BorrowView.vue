<template>
  <div>
    <!--借阅记录页面-->
    <!--顶部多功能栏-->
    <div style="padding-right: 1000px;width: 800px;margin-left: -125px;">
      <!--提示-->
      <div style="width: 120px;display: inline-block">
        <strong>搜索借阅记录：</strong>
      </div>
      <!--输入框-->
      <div style="width: 160px;display: inline-block">
        <el-input v-model="searchBorrowId" placeholder="借阅记录编号"></el-input>
      </div>
      <!--输入按钮-->
      <div style="display: inline-block">
        <el-button icon="el-icon-search" circle @click="getBorrowById()"></el-button>
      </div>
      <!--回到借阅记录列表-->
      <div style="display: inline-block">
        <el-button round @click="reset">返回首页</el-button>
      </div>
    </div>
    <!--提示页头-->
    <el-tabs v-model="activeName" >
      <el-tab-pane label="借阅记录" name="first"></el-tab-pane>
    </el-tabs>
    <!--表格数据-->
    <!--ref="singleTable"单选表格；stripe斑马纹-->
    <el-table ref="singleTable" :data="this.borrowList" stripe style="width: 100%">
      <!--表头-->
      <el-table-column prop="borrowId" label="记录编号" width="180"></el-table-column><!--记录编号-->
      <el-table-column prop="bookName" label="被借图书" width="180"></el-table-column><!--被借图书-->
      <el-table-column label="借阅人" width="180">
        <template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <p>姓名: {{ scope.row.userName }}</p>
            <p>住址: {{ scope.row.address }}</p>
            <div slot="reference" class="name-wrapper">
              <el-tag size="medium">{{ scope.row.userName }}</el-tag>
            </div>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column prop="borrowDate" label="借阅日期"></el-table-column><!--借阅日期-->
      <el-table-column prop="borrowState" label="当前状态"></el-table-column><!--当前状态-->
      <el-table-column label="操作">
        <template slot-scope="scope"><!--操作--><!--slot-scope="scope"限制对当前行进行操作-->
          <el-button size="mini" @click="toQueryBorrowPage(scope.row)">详情</el-button>
          <el-button size="mini" type="danger" @click="deleteBorrowById(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--表格结束-->

    <!--分页组件-->
    <!--@next-click="show"下一页，prev-click="show"上一页，@current-change="show"当前页-->
    <el-pagination @next-click="getBorrowList" @prev-click="getBorrowList" :page-size="this.pageSize" v-model:current-page="currentPageNo" @current-change="getBorrowList"
                   :page-sizes="[5, 10]" @size-change="handleSizeChange" background layout="total, sizes, prev, pager, next, jumper" :total="this.total">
    </el-pagination>
  </div>
</template>

<script>
import Mock from "mockjs";

export default {
  name: "BorrowView",
  data() {
    return {
      borrowList: [],
      currentPageNo: 1,
      pageSize: 10,
      total: 0,
      searchBorrowId: '',
      activeName: 'first',

    }
  },
  methods: {
    //查询借阅记录，参数当前页数
    getBorrowList(currentPageNo) {
      this.axios.get("/getBorrowList", {
        data: {
          currentPageNo: currentPageNo,
          pageSize: this.pageSize,
        }
      }).then(res => {
        this.borrowList = res.data.data[0];
        this.total = res.data.data[1];
      });
    },
    //修改页面容量
    handleSizeChange(val) {
      this.pageSize = val;
      this.getBorrowList(1);
      this.currentPageNo = 1;
    },
    //跳转到记录查看页面
    toQueryBorrowPage(borrow) {
      this.$router.push({
        name: 'borrowQueryPage',
        params: {
          borrow: borrow
        }
      })
    },
    //通过记录编号删除借阅记录
    deleteBorrowById(borrow) {
      this.axios.get("/deleteBorrowById", {
        data: {
          borrow: borrow
        }
      });
      alert("删除成功");
      this.getBorrowList(this.currentPageNo);
    },
    //通过记录编号查询借阅记录
    getBorrowById() {
      if (this.searchBorrowId != null && this.searchBorrowId != '') {
        this.axios.get("/getBorrowById", {
          data: {
            searchBorrowId: this.searchBorrowId
          }
        }).then(res => {
          this.borrowList = res.data.data;
          this.total = 1;
        });
      }else {
        alert("搜索值不能为空");
      }
    },
    //查询之后返回第一页
    reset() {
      this.getBorrowList(1);
    }

  },
  mounted() {
    this.getBorrowList(1);
  }
}
</script>

<style scoped>
.like {
  cursor: pointer;
  font-size: 25px;
  display: inline-block;
}
</style>
