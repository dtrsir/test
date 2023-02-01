<template>
  <div>
    <h1> </h1>
    <h2>欢迎进入图书管理系统 {{user.role}} {{user.name}}</h2>

    <!--轮播图-->
    <div style="width: 80%;margin: auto">
      <el-carousel indicator-position="outside" autoplay >
        <el-carousel-item v-for="item in img" :key="item">
          <img style="width: auto;height: auto" :src="item" alt="">
        </el-carousel-item>
      </el-carousel>
    </div>
    <h3>每日一读</h3>
    <el-card class="box-card" style="display:inline-block;width: 300px;margin-bottom: 55px;margin-right: 20px">
      <div slot="header" class="clearfix">
        <span>新书上榜</span>
      </div>
      <div @click="toAbout(o-1)" v-for="o in 4" :key="o" class="text item">
        {{bookNameList[o-1] }}
      </div>
    </el-card>
    <div style="display: inline-block" v-for="n in 2">
      <el-row>
        <el-card style="display: inline-block" :body-style="{ padding: '0px',width:'250px',height:'150px' }">
          <img :src="urlList[n-1]" class="image">
          <div style="padding: 14px;" @click="toAbout(n-1)">
            <span>{{ bookNameList[n-1] }}</span>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
              <el-button type="text" class="button"></el-button>
            </div>
          </div>
        </el-card>
      </el-row>

    </div>
    <div style="display: inline-block" v-for="n in 2">
      <el-row>
        <el-card style="display: inline-block" :body-style="{ padding: '0px',width:'250px',height:'150px' }">
          <img :src="urlList[n+1]" class="image">
          <div style="padding: 14px;" @click="toAbout(n+1)">
            <span>{{ bookNameList[n+1] }}</span>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
              <el-button type="text" class="button"></el-button>
            </div>
          </div>
        </el-card>
      </el-row>
    </div>
    <el-card class="box-card" style="display:inline-block;width: 300px;margin-bottom: 55px;margin-left: 20px">
      <div slot="header" class="clearfix">
        <span>热榜推荐</span>
      </div>
      <div @click="toAbout(o+3)" v-for="o in 4" :key="o" class="text item">
        {{bookNameList[o+3] }}
      </div>
    </el-card>
  </div>
</template>

<script>
import Mock from "mockjs";

export default {
  name: "helloView",
  data() {
    var img1 = require("../assets/1.jpg");
    var img2 = require("../assets/2.jpg");
    var img3 = require("../assets/3.jpg");
    return {

      user: {
        id: this.$route.params.id,
        name: this.$route.params.name,
        userCode: this.$route.params.userCode,
        password: this.$route.params.password,
        role: this.$route.params.role
      },
      img: [
        img1,
        img2,
        img3,
      ],
      urlList: [],
      bookNameList: [],
      currentDate:''
    }
  },
  /*生命周期函数，进入本组件会自动执行里面的函数*/
  mounted() {
    this.modify();
    this.getHello()
  },
  methods: {
    modify() {
      /*存在用户登陆信息就存入浏览器缓存*/
      if (this.user.name!=null || this.user.role!=null) {
        localStorage.setItem("name",JSON.stringify(this.user.name));
        localStorage.setItem("role",JSON.stringify(this.user.role));
      }else {/*不存在，就从浏览器缓存钟取出*/
        this.user.role = JSON.parse(localStorage.getItem('role'));
        this.user.name = JSON.parse(localStorage.getItem('name'));
      }
      /*调试日志*/
      console.log(this.user.role);
      console.log(this.user.name);
    },

    getHello() {
      this.axios.get("/gethello", {
        data: {
        }
      }).then(res => {
        this.urlList = res.data.data[0];
        this.bookNameList = res.data.data[1];
      });
    },
    toAbout(index) {
      this.$router.push({
        name: 'bookAbout',
        params: {
          index: index
        }
      })

    }
  },
}
</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both
}

.box-card {
  width: 480px;
}
</style>
