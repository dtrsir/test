import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {//定义共享数据，这里的定义的数据可以被直接读取，但是不可以修改
    name: '', //或者可以定义为null,这样name属性就被共享了
    role: ''
  },
  getters: {

  },
  mutations: {//这里加一个方法来修改上马state定义的被共享的数据
    setName(state, name) {
      state.name = name;
    },
    setRole(state, role) {
      state.role = role;
    }

  },
  actions: {

  },
  modules: {

  }
})
