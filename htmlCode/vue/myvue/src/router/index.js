/*router配置文件，习惯性命名为index*/
import Vue from 'vue';
/*导入vue-router*/
import VueRouter from 'vue-router';

import Content from "../components/Content";
import Main from "../components/Main";

/*显示声明router*/
Vue.use(VueRouter);

/*配置导出路由*/
export default new VueRouter({
  /*注意这里是routers，不是route*/
  routes: [
    {
      //路由路径需要加上斜杠
      path: '/content',
      //路由名字
      name: 'content',
      //跳转到的组件
      component: Content
    },
    {
      path: '/main',
      name: 'main',
      component: Main
    }
  ]
})
