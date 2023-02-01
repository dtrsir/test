import Vue from 'vue'
import App from './App'
import router from './router';/*因为我们的router配置文件使用index名字，这里只需要找到目录即可自动扫描配置文件*/

Vue.config.productionTip = false


new Vue({
  el: '#app',
  /*配置路由*/
  router,
  components: { App },
  template: '<App/>'
})
