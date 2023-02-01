<template>
  <div>
    <button @click="a3()">{{name}}</button>
  </div>
</template>

<script>
export default {
  name: "Test",
  data() {
    return {
      name: '123'
    }
  },
  /*实际上es的函数语法可以通用在任意地方，只要是写函数的地方就可以使用es6的函数语法*/
  methods: {
    a3() {
      alert('a3 is run...');
    }
  }
}
</script>

<style scoped>

</style>
