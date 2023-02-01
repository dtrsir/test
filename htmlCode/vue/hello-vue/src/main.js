import Vue from 'vue'
import App from './App'
import router from './router';
import Store from './store'

//导入elementUI
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from "axios";
import VueAxios from 'vue-axios';

Vue.config.productionTip = false

/*注意注册顺序，必须是VueAxios, axios这样的顺序，否则会报错*/
Vue.use(VueAxios, axios)
Vue.use(router);
Vue.use(ElementUI);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App) //使用elementUI
})
