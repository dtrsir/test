/*打包*/
module.exports = {
    /*指定程序入口*/
    entry: './modules/main.js',
    /*指定打包输出到哪里*/
    output: {
        /*一般惯用写法*/
        filename: "./js/bundle.js"
        //在终端使用webpack即可打包
        //终端使用webpack --watch实时监听实现热部署，更新js就会重新打包
    }
}