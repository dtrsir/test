<template>
  <div>
    <!--用户管理页面-->
    <!--顶部多功能栏-->
    <div style="padding-right: 1000px;width: 800px;margin-left: -125px;">
      <!--添加用户-->
      <div style="display: inline-block">
        <el-button type="primary" round @click="toAddUserPage">添加用户</el-button>
      </div>
      <!--提示-->
      <div style="width: 100px;display: inline-block">
        <strong>搜索用户：</strong>
      </div>
      <!--输入框-->
      <div style="width: 160px;display: inline-block">
        <el-input v-model="searchId" placeholder="用户id"></el-input>
      </div>
      <!--输入按钮-->
      <div style="display: inline-block">
        <el-button icon="el-icon-search" circle @click="getUserById()"></el-button>
      </div>
      <!--回到用户列表-->
      <div style="display: inline-block">
        <el-button round @click="reset">返回第一页</el-button>
      </div>
    </div>
    <!--提示页头-->
    <el-tabs v-model="activeName" >
      <el-tab-pane label="用户数据" name="first"></el-tab-pane>
    </el-tabs>
    <!--表格数据-->
    <!--ref="singleTable"单选表格；stripe斑马纹-->
    <el-table ref="singleTable" :data="this.userList" stripe style="width: 100%">
      <!--表头-->
      <el-table-column prop="id" label="id号" width="180"></el-table-column><!--用户id-->
      <el-table-column prop="name" label="姓名" width="180"></el-table-column><!--用户姓名-->
      <el-table-column prop="userCode" label="账号"></el-table-column><!--用户账号-->
      <el-table-column prop="role" label="角色"></el-table-column><!--用户角色-->
      <!--<el-table-column prop="password" label="密码"></el-table-column>&lt;!&ndash;用户密码&ndash;&gt;-->
      <el-table-column label="状态"><!--用户状态-->
        <template slot-scope="scope">
          <el-tag v-if="scope.row.state" type="success">启用</el-tag>
          <el-tag v-if="!scope.row.state" type="danger">停用</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope"><!--操作--><!--slot-scope="scope"限制对当前行进行操作-->

          <el-switch
            @change="updateUserState(scope.row)"
            v-model="scope.row.state"
            active-color="#13ce66"
            inactive-color="#ff4949">
          </el-switch>

          <el-button size="mini" @click="toUpdateUserPage(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="deleteUserById(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--表格结束-->

    <!--分页组件-->
    <!--@next-click="show"下一页，prev-click="show"上一页，@current-change="show"当前页-->
    <el-pagination @next-click="getUserList" @prev-click="getUserList" :page-size="this.pageSize" v-model:current-page="currentPageNo" @current-change="getUserList"
                   :page-sizes="[5, 10]" @size-change="handleSizeChange" background layout="total, sizes, prev, pager, next, jumper" :total="this.total">
    </el-pagination>
  </div>
</template>

<script>

export default {
  name: "UserView",
  data() {
    return {
      userList: [],
      currentPageNo: 1,
      pageSize: 10,
      total: 0,
      searchId: '',
      activeName: 'first',
      state:true,
      style:'cellStyle'

    }
  },
  methods: {
    //改变账号状态
    updateUserState(user) {
      this.axios.get("/updateUserState", {
        data: {
          user: user
        }
      });
    },
    //查询用户列表，参数当前页数
    getUserList(currentPageNo) {
      this.axios.get("/getUserList", {
        data: {
          currentPageNo: currentPageNo,
          pageSize: this.pageSize,
        }
      }).then(res => {
        this.userList = res.data.data[0];
        this.total = res.data.data[1];
      });
    },
    //修改页面容量
    handleSizeChange(val) {
      this.pageSize = val;
      this.getUserList(1);
      this.currentPageNo = 1;
    },
    //跳转到用户修改页面
    toUpdateUserPage(user) {
      this.$router.push({
        name: 'userUpdatePage',
        params: {
          user: user
        }
      })
    },
    //通过id删除用户
    deleteUserById(user) {
      this.axios.get("/deleteUserById", {
        data: {
          user: user
        }
      });
      alert("删除成功");
      this.getUserList(this.currentPageNo);
    },
    //通过id查找用户
    getUserById() {
      if (this.searchId != null && this.searchId != '') {
        this.axios.get("/getUserById", {
          data: {
            searchId: this.searchId
          }
        }).then(res => {
          this.userList = res.data.data;
          this.total = 1;
        });
      }else {
        alert("搜索值不能为空");
      }
    },
    //跳转到新增用户界面
    toAddUserPage() {
      this.$router.push({
        name: 'addUserPage'
      })

    },
    //查询之后返回第一页
    reset() {
      this.getUserList(1);
    }

  },
  mounted() {
    this.getUserList(1);
  }
}
</script>

<style scoped>
.buttonMargin {
  margin: 15px 0;
}
.cellStyle{
  text-align: center;
  margin-left: -100px;
  background-color: black;
}

.cellWild {
  width: 100px;
}

</style>
