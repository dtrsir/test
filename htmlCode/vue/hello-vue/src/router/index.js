import Vue from "vue";
import VueRouter from "vue-router";

import Login from "../views/Login";
import Main from "../views/Main";

import UserList from '../views/user/List';
import UserProfile from "../views/user/Profile";
import NotFound from "../views/NotFound";
import Test from '../views/Test';

Vue.use(VueRouter);

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/main',
      component: Main,  //注意这里是component，不是components
      //使用嵌套路由
      children: [
        /*路由需要接收参数要，给这个路由命名，前端通过名字找到这个路由
        * 路径需要带上/:参数名，这个参数名字要和前端传递的参数名字相同
        * 设置props为true传递到组件的js中*/

        {path: '/user/profile/:id', name: 'UserProfile', component: UserProfile, props: true},
        {path: '/user/list', component: UserList},
      ]

    },
    {
      path: '/login',
      component: Login
    },
    /*重定向设置*/
    {
      path: '/goHome',
      redirect: '/main'
    },
    /*路由会匹配上面的路径，匹配不到则会走这个配置的*路径*/
    {
      path: '*',
      component: NotFound
    },
    {
      path: '/test',
      component: Test
    }
  ]
});
