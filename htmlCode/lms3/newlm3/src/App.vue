<template>
  <div id="app">
    <!--子路由充满屏幕-->
    <router-view class="full"></router-view>
  </div>
</template>

<script>
export default {
  name: 'App'
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
.full {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
}
</style>
