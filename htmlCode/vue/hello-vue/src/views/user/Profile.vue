<template>
  <div>
<h1>个人信息</h1>
    <!--取出js中的参数-->
    {{id}}
  </div>

</template>

<script>
export default {
  /*从路由中接收参数*/
  props: ['id'],
  name: "UserProfile",
  /*参数和filter过滤器类似，to相当于request，from相当于respond， next相当于chain*/
  beforeRouteEnter: (to, from, next)=>{
    alert("进入路由之前");
    next(vm => {
      vm.getData();
      vm.getData2();
    });
  },
  beforeRouteLeave: (to, from, next)=>{
    alert("离开路由之前");
    next();
  },
  methods: {
    getData: function () {
      this.axios({
        method: 'get',
        url: 'http://localhost:8080/static/mock/data.json'
      }).then(response=>{
        console.log(response);
      })
    },
    /*第二种使用axios的方式，更像java编程，async意识是异步的调用该方法，await的意思是在异步的这个方法中同步的调用一个东西*/
    /*const常量，调用axios之后返回一个jason对象，这个对象必须被使用，webpack才能正常打包*/
    async getData2() {
      const resp = await this.axios.get('http://localhost:8080/static/mock/data.json');
      console.log(resp);
    }
  }
}
</script>

<style scoped>

</style>
