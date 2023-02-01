import axios from 'axios'
let MyAxios = axios.create({
  baseURL: 'http://localhost:8080',//设置基础地址，以后配置这个axios的请求都会走这个基础地址
  withCredentials: true //开启cookie携带，这里需要配后后端开启@CrossOrigin(value= "前端项目地址", allowCredentials="true")
  //开启之后可以让前后端传递cookie，验证登陆
});

MyAxios.interceptors.request.use(
  function(config) {
    config.headers = {
      Authorrization: 'xxxxx'
    }
    return config;
  },
  function(error) {
    return Promise.reject(error);
  }
);

MyAxios.interceptors.response.use(
  function(response) {
    return response;
  },
  function(error) {
    if(error.response.status === 404) {
      console.log('资源未找到');
      return Pormise.resolve(404);
    }
    return Promise.reject(error);
  }
);

export default MyAxios
