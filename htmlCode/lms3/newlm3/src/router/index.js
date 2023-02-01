/*router配置文件，习惯性命名为index*/
import Vue from 'vue';/*基于vue，必须导入*/
/*导入vue-router*/
import VueRouter from 'vue-router';
import LoginView from "../views/LoginView";
import MainView from "../views/MainView";
import NotFound from "../views/404View";
import User from "../views/UserView";
import helloView from "../views/HelloView";


/*显示声明router*/
Vue.use(VueRouter);


/*配置导出路由*/
export default new VueRouter({
  //去掉路径#号
  mode: 'hash',
  /*注意这里是routers，不是route*/
  routes: [
    {
      /*设置项目首次进入的页面（登录页）*/
      path: '/',
      component: () => import('@/views/LoginView') //动态导入组件，提高加载效率
    },
    {/*mock测试页面路由*/
      path: '/mock',
      component: () => import('@/views/testMockView') //动态导入组件，提高加载效率
    },
    {/*退出系统路由*/
      path: '/exit',
      name: 'exit',
      component: () => import('@/views/LoginView') //动态导入组件，提高加载效率
    },
    {/*主体部分路由*/
      path: '/main',
      component: MainView,
      children: [
        {/*页面路由到欢迎页*/
          path: '/hello',
          name: 'hello',
          component: () => import('@/views/HelloView')
        },
        {/*页面路由到用户管理*/
          path: '/user',
          name: 'userList',
          component: () => import('@/views/UserView')
        },
        /*页内跳转到用户修改页面*/
        {
          path: '/userUpdatePage',
          name: 'userUpdatePage',
          component: () => import('@/views/modifyUserView')
        },
        /*页内跳转到添加用户页面*/
        {
          path: '/addUserPage',
          name: 'addUserPage',
          component: () => import('@/views/AddUserView')
        },
        {/*页面路由到图书管理*/
          path: '/book',
          name: 'bookList',
          component: () => import('@/views/BookView')
        },
        {/*页面路由到图书修改*/
          path: '/bookUpdatePage',
          name: 'bookUpdatePage',
          component: () => import('@/views/ModifyBookView')
        },
        /*页内跳转到新增图书页面*/
        {
          path: '/addBookPage',
          name: 'addBookPage',
          component: () => import('@/views/AddBookView')
        },
        {/*页面路由到借阅记录*/
          path: '/borrow',
          name: 'borrow',
          component: () => import('@/views/BorrowView')
        },
        {/*页面路由到借阅记录*/
          path: '/borrowQueryPage',
          name: 'borrowQueryPage',
          component: () => import('@/views/QueryBorrowView')
        },
        {/*页面路由到图书世界*/
          path: '/bookWorld',
          name: 'bookWorld',
          component: () => import('@/views/BookWorldView')
        },
        {/*页面路由到新书上架*/
          path: '/newBook',
          name: 'newBook',
          component: () => import('@/views/NewBookView')
        },
        {/*页面路由到新书上架*/
          path: '/bookAbout',
          name: 'bookAbout',
          component: () => import('@/views/BookAboutView')
        },
      ]
    },


    /*404路由*/
    {
      path: '/404',
      component: () => import('@/views/404View')
    },
    /*重定向到404路由，实现路径变更*/
    {
      path: '*',
      redirect: '404'
    }
  ]
})
