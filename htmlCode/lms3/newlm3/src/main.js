import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import Mock from './mock'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'


Vue.config.productionTip = false
Vue.use(router);
Vue.use(VueAxios, axios)
Vue.use(ElementUI);

new Vue({
  el: '#app',
  router,
  render: h => h(App) //使用elementUI
})
