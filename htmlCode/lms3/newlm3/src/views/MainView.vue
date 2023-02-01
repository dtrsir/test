<template>
  <el-container>
    <!--固定页头-->
    <el-header>
      <!--用户模块展示-->
      <el-row class="demo-avatar demo-basic">
        <!--系统icon-->
        <el-col :span="1">
          <img style="height: 50px;width: 50px;margin-top: 10px" src="@/assets/图标.png">
        </el-col>
        <el-col :span="2" >
          <h2>图书管理系统</h2>
        </el-col>
        <!--用户组-->
        <el-col :span="1" :offset="20">
          <div class="demo-basic--circle">
            <div class="block">
              <el-avatar :size="40" :src="circleUrl" style="margin-top: 10px;"></el-avatar><!--头像框-->
              <!--用户设置下拉菜单-->
              <el-dropdown>
                <span class="el-dropdown-link">
                <i class="el-icon-arrow-down el-icon-caret-bottom"></i><!--下拉三角图标-->
                </span>
                <el-dropdown-menu slot="dropdown"><!--下拉菜单主体-->
                  <!--<el-dropdown-item>个人中心</el-dropdown-item>-->
                  <el-dropdown-item><strong @click="toMain">首页</strong></el-dropdown-item>
                  <el-dropdown-item><strong @click="exit">退出登陆</strong></el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
              <!--用户设置下拉菜单结束-->
            </div>
          </div>
        </el-col>
      </el-row>
    </el-header>

    <el-container>
      <el-container>
        <!--导航-->
        <el-aside width="200px">
          <!--侧边导航栏开始-->
          <el-row class="tac fullTop">
            <el-col :span="24">

              <!--侧边导航栏展开收起控件-->
              <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
                <el-radio-button :label="false">展开</el-radio-button>
                <el-radio-button :label="true">收起</el-radio-button>
              </el-radio-group>

              <el-menu default-active="0" router class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">


                <!--回到首页-->
                <el-menu-item index="0" route="/hello">
                  <i class="el-icon-location"></i>
                  <span slot="title">首页</span>
                </el-menu-item>

                <!--用户管理页面-->
                <el-menu-item index="1" route="/user">
                  <i class="el-icon-user"></i>
                  <span slot="title">用户管理</span>
                </el-menu-item>

                <!--图书管理页面-->
                <el-menu-item index="2" route="/book">
                  <i class="el-icon-menu"></i>
                  <span slot="title">图书管理</span>
                </el-menu-item>

                <!--mock数据测试页面
                <el-menu-item index="2" route="/mock">
                  <i class="el-icon-menu"></i>
                  <span slot="title">mock测试</span>
                </el-menu-item>-->

                <!--借阅记录管理-->
                <el-menu-item index="3" route="/borrow">
                  <i class="el-icon-document"></i>
                  <span slot="title">借阅记录</span>
                </el-menu-item>


                <!--书库-->
                <el-menu-item index="4" route="/bookWorld">
                  <i class="el-icon-data-analysis"></i>
                  <span slot="title">图书世界</span>
                </el-menu-item>

                <!--新书上架-->
                <el-menu-item index="5" route="/newBook">
                  <i class="el-icon-notebook-1"></i>
                  <span slot="title">热门榜单</span>
                </el-menu-item>



                <!--退出系统-->
                <el-menu-item index="6" @click="exit()">
                  <i class="el-icon-house"></i>
                  <span slot="title">退出系统</span>
                </el-menu-item>


              </el-menu>
            </el-col>
          </el-row>
          <!--侧边导航栏结束-->
        </el-aside>
        <!--主体-->
        <el-main>
          <!--主体顶层面包条导航开始-->
<!--          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>活动管理</el-breadcrumb-item>
            <el-breadcrumb-item>活动列表</el-breadcrumb-item>
            <el-breadcrumb-item>活动详情</el-breadcrumb-item>
          </el-breadcrumb>-->
<!--          <crumbs></crumbs>-->
          <!--主体面包条导航结束-->
          <!--主体内容开始-->
          <router-view></router-view>
          <!--主体内容结束-->
        </el-main>
      </el-container>
      <!--固定页脚-->
      <el-footer>
        图书管理系统
        <a href="https://beian.miit.gov.cn/" target="_blank" style="text-decoration: none;color: black;font-weight: bold"></a>
      </el-footer>
    </el-container>
  </el-container>

</template>

<script>
import HelloView from "./HelloView";
import Crumbs from "../components/crumbs/index";
export default {
  name: "MainView",
  components: {Crumbs, HelloView},
  data() {
    return {
      //侧边栏展开标志
      isCollapse: false,
      /*头像图片地址，可选大小*/
      circleUrl: "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80",
      sizeList: ["large", "medium", "small"]
    }

  },
  methods: {
    /*侧边栏打开*/
    handleOpen(key, keyPath) {
    },
    /*侧边栏关闭*/
    handleClose(key, keyPath) {
    },
    /*退出系统*/
    exit() {
      localStorage.removeItem("role");
      localStorage.removeItem("name");
      this.$router.push({name:'exit'})
    },
    /*跳转到首页*/
    toMain() {
      this.$router.push({name:'hello'})
    }
  }
}
</script>

<style scoped>
.fullTop {
  height: 100%;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 190px;
  min-height: 400px;
}
</style>
