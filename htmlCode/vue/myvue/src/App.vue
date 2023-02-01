<template>
  <div id="app">
    <h1>123</h1>
    <!--使用vue路由的跳转方式，弃用a标签-->
    <router-link to="/main">首页</router-link>
    <router-link to="/content">内容页</router-link>
    <router-view></router-view><!--显示视图-->

  </div>
</template>

<script>
/*导入一个组件*/
import Content from "./components/Content";
import Main from "./components/Main";

export default {
  name: 'App',
  /*在绑定的元素中显示声明组件*/
  components: {
    Content,
    Main
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
