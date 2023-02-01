'use strict'
// Template version: 1.3.1
// see http://vuejs-templates.github.io/webpack for documentation.

const path = require('path')

module.exports = {
  dev: {

    // Paths
    assetsSubDirectory: 'static',
    assetsPublicPath: '/',
    //代理服务器配置表，用来解决跨域问题
    proxyTable: {
      //代理以 /api开头的请求
      '/api': {
        //需要转发到的目标服务器
        target: 'http://localhost:8081/',
        //如果是https协议需要开启，否则不写
        secure: false,
        //是否为跨域请求，开启为true
        changeOrigin: true,
        //配置路径重写，如果过说我们请求的路径不是后端服务器的接收请求的路径，
        //也就是说可能我们请求的是localhost：8080/api/user，但是后端服务器接收的请求却是localhost：8080/user
        //那么我们需要把前端请求的路径重写一成后端服务器能够接受的路径
        pathRewrite: {
          //这里的意思是我们target路径没有写成我们前端请求的路径的样子也就是http://localhost:8081/，所以我们需要拼接上这个请求
          '/^api': 'api/',
          //这里的意思是我们前端服务器有api这个请求但是我们后端服务器不接受这个请求，那么我们就要把/api去掉
          // '/^api': '',
        }

      }
    },

    // Various Dev Server settings
    host: 'localhost', // can be overwritten by process.env.HOST
    port: 8080, // can be overwritten by process.env.PORT, if port is in use, a free one will be determined
    autoOpenBrowser: false,
    errorOverlay: true,
    notifyOnErrors: true,
    poll: false, // https://webpack.js.org/configuration/dev-server/#devserver-watchoptions-


    /**
     * Source Maps
     */

    // https://webpack.js.org/configuration/devtool/#development
    devtool: 'cheap-module-eval-source-map',

    // If you have problems debugging vue-files in devtools,
    // set this to false - it *may* help
    // https://vue-loader.vuejs.org/en/options.html#cachebusting
    cacheBusting: true,

    cssSourceMap: true
  },

  build: {
    // Template for index.html
    index: path.resolve(__dirname, '../dist/index.html'),

    // Paths
    assetsRoot: path.resolve(__dirname, '../dist'),
    assetsSubDirectory: 'static',
    assetsPublicPath: '/',

    /**
     * Source Maps
     */

    productionSourceMap: true,
    // https://webpack.js.org/configuration/devtool/#production
    devtool: '#source-map',

    // Gzip off by default as many popular static hosts such as
    // Surge or Netlify already gzip all static assets for you.
    // Before setting to `true`, make sure to:
    // npm install --save-dev compression-webpack-plugin
    productionGzip: false,
    productionGzipExtensions: ['js', 'css'],

    // Run the build command with an extra argument to
    // View the bundle analyzer report after build finishes:
    // `npm run build --report`
    // Set to `true` or `false` to always turn it on or off
    bundleAnalyzerReport: process.env.npm_config_report
  }
}
