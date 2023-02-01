/*导入mock依赖*/
import Mock from 'mockjs'
//随机类
const Random = Mock.Random;
Random.word(5);//随机5位英文
Random.csentence(5);//随机5个中文，模拟图书名称
Random.cword(3)//随机3个中文，模拟出版社
Random.date();//随机日期
Random.county(true)//随机地址


/**
 * 伪造数据库
 */
var users = [];//用户信息表
var roles = ['admin', 'manage', 'reader'];//用户角色表
var back = ['已归还', '未归还'];//归还状态表
var books = [];//图书信息表
var borrows = [];//借阅记录表
var userStates = [true,false]


/**
 * 伪造数据库数据
 * */
//伪造用户数据
/*管理员账号*/
let admin = {
  id: 0,//模拟用户id
  name: Mock.mock('@cname'),//模拟用户姓名
  userCode: 'admin',
  password: '123456',
  role: roles[0],
  state: true
};
/*图书管理员账号*/
let manage = {
  id: 1,//模拟用户id
  name: Mock.mock('@cname'),//模拟用户姓名
  userCode: 'manage',
  password: '123456',
  role: roles[1],
  state: true
};
/*读者账号*/
let reader = {
  id: 2,//模拟用户id
  name: Mock.mock('@cname'),//模拟用户姓名
  userCode: 'reader',
  password: '123456',
  role: roles[2],
  state: true
}
users.push(admin);
users.push(manage);
users.push(reader);
for (let i = 3; i < 50; i++) {
  //创建用户对象
  let userInfo = {
    id: i,//模拟用户id
    name: Mock.mock('@cname'),//模拟用户姓名
    userCode: Mock.mock('@word(5)'),
    password: '123456',//模拟用户密码
    role: roles[parseInt(Mock.mock({'number|0-2':1}).number)],//模拟用户角色
    state: userStates[parseInt(Mock.mock({'number|0-1':1}).number)]
  }
  users.push(userInfo); //将模拟的数据放到数组中
}

//伪造图书数据
for (let i = 0; i < 50; i++) {
  //创建图书对象
  let bookInfo = {
    bookId: i,//模拟图书id
    bookName: Mock.mock('@csentence(5)'),//模拟图书名称
    author: Mock.mock('@cname'),//模拟作者
    public: Mock.mock('@cword(3)'),//模拟出版社
    stock: parseInt(Mock.mock({'number|0-10':10}).number),//模拟库存
    value: parseInt(Mock.mock({'number|0-5':5}).number)//模拟评分
  }
  books.push(bookInfo); //将模拟的数据放到数组中
}

//伪造借阅记录
for (let i = 0; i < 50; i++) {
  //伪造借阅记录
  let borrowInfo = {
    borrowId: i,//模拟借阅记录编号
    bookName: Mock.mock('@csentence(5)'),//模拟图书名称
    userName: Mock.mock('@cname'),//模拟借阅人姓名
    borrowDate: Mock.mock('@date'),//模拟借阅日期
    borrowState: back[parseInt(Mock.mock({'number|0-1':1}).number)],//模拟归还状态
    address: Mock.mock('@county(true)')//模拟地址
  }
  borrows.push(borrowInfo); //将模拟的数据放到数组中
}






/**
 * 用户管理接口
 * author : zhonzheng
 * */

//改变账号状态
let updateUserState = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      let user = body.user;
      users[user.id] = user;

      break;
    case 'post': break;
    default: break;
  }
  return {
  }
}
Mock.mock('/updateUserState', /get|post/i, updateUserState);

//用户列表查询
let getUserList = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      pageSize = 10;//一页显示的记录数
      let pageSize = parseInt(body.pageSize);


      let currentPageNo = parseInt(body.currentPageNo);//当前页数
      let startNo = 0;
      startNo = (currentPageNo - 1) * pageSize;//显示数据的起始下标


     var userList = [];
      for (let i = startNo; i < startNo + pageSize && i < users.length ; i++) {
        userList.push(users[i]); //将模拟的数据放到数组中
      }
      break;
    case 'post': break;
    default: break;
  }
  return {
    data: [userList, users.length]
  }
}
Mock.mock('/getUserList', /get|post/i, getUserList);

//用户修改
let userUpdate = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      let user = body.user;
      users[user.id] = user;
      break;
    case 'post': break;
    default: break;
  }
  return {
  }
}
Mock.mock('/userUpdate', /get|post/i, userUpdate);

//特定用户查询
let getUserById = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      var searcherId = body.searchId;
      var userList = [];
      userList.push(users[searcherId]);
      break;
    case 'post': break;
    default: break;
  }
  return {
    data: userList
  }
}
Mock.mock('/getUserById', /get|post/i, getUserById);

//用户删除
let deleteUserById = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      let user = body.user;
      users = users.filter(function (val) {
        /*true保留数据，false过滤数据*/
        return val.id != user.id; // 过滤掉前台传过来的id对应的相应数据，返回新的数组
      });
      break;
    case 'post': break;
    default: break;
  }
  return {
  }
}
Mock.mock('/deleteUserById', /get|post/i, deleteUserById);

//新增用户
let addUser = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);
      let user = {
        id: '',
        name: '',
        userCode: '',
        password: '',
        role: ''
      };
      user.id = users.length;
      user.name = body.user.name;
      user.userCode = body.user.userCode;
      user.password = body.user.password;
      user.role = body.user.role;
      users.push(user);
      break;
    case 'post': break;
    default: break;
  }
  return {
  }
}
Mock.mock('/addUser', /get|post/i, addUser);



/**
 * 图书管理接口
 * author : zhonzheng
 * */
//图书列表查询
let getBookList = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      pageSize = 10;//一页显示的记录数
      let pageSize = parseInt(body.pageSize);


      let currentPageNo = parseInt(body.currentPageNo);//当前页数
      let startNo = 0;
      startNo = (currentPageNo - 1) * pageSize;//显示数据的起始下标


      var bookList = [];
      for (let i = startNo; i < startNo + pageSize && i < books.length ; i++) {
        bookList.push(books[i]); //将模拟的数据放到数组中
      }
      break;
    case 'post': break;
    default: break;
  }
  return {
    data: [bookList, books.length]
  }
}
Mock.mock('/getBookList', /get|post/i, getBookList);

//图书修改
let bookUpdate = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);
      let book = body.book;
      books[book.bookId] = book;
      break;
    case 'post': break;
    default: break;
  }
  return {
  }
}
Mock.mock('/bookUpdate', /get|post/i, bookUpdate);

//图书删除
let deleteBookById = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      let book = body.book;
      books = books.filter(function (val) {
        /*true保留数据，false过滤数据*/
        return val.bookId != book.bookId; // 过滤掉前台传过来的id对应的相应数据，返回新的数组
      });
      break;
    case 'post': break;
    default: break;
  }
  return {
  }
}
Mock.mock('/deleteBookById', /get|post/i, deleteBookById);

//通过图书id查找图书
let getBookById = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      var searchBookId = body.searchBookId;
      var bookList = [];
      bookList.push(books[searchBookId]);
      break;
    case 'post': break;
    default: break;
  }
  return {
    data: bookList
  }
}
Mock.mock('/getBookById', /get|post/i, getBookById);

//添加图书信息
let addBook = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);
      let book = {
        bookId: '',
        bookName: '',
        author: '',
        public: '',
        stock: '',
      };
      book.bookId = books.length;
      book.bookName = body.book.bookName;
      book.author = body.book.author;
      book.public = body.book.public;
      book.stock = body.book.stock;
      books.push(book);
      break;
    case 'post': break;
    default: break;
  }
  return {
  }
}
Mock.mock('/addBook', /get|post/i, addBook);


/**
 * 借阅记录管理接口
 * author : liuyaoming
 * */
//借阅记录查询
let getBorrowList = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      pageSize = 10;//一页显示的记录数
      let pageSize = parseInt(body.pageSize);


      let currentPageNo = parseInt(body.currentPageNo);//当前页数
      let startNo = 0;
      startNo = (currentPageNo - 1) * pageSize;//显示数据的起始下标


      var borrowList = [];
      for (let i = startNo; i < startNo + pageSize && i < borrows.length ; i++) {
        borrowList.push(borrows[i]); //将模拟的数据放到数组中
      }
      break;
    case 'post': break;
    default: break;
  }
  return {
    data: [borrowList, borrows.length]
  }
}
Mock.mock('/getBorrowList', /get|post/i, getBorrowList);

//借阅删除
let deleteBorrowById = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      let borrow = body.borrow;
      borrows = borrows.filter(function (val) {
        /*true保留数据，false过滤数据*/
        return val.borrowId != borrow.borrowId; // 过滤掉前台传过来的id对应的相应数据，返回新的数组
      });
      break;
    case 'post': break;
    default: break;
  }
  return {
  }
}
Mock.mock('/deleteBorrowById', /get|post/i, deleteBorrowById);

//通过图书id查找图书
let getBorrowById = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      var searchBorrowId = body.searchBorrowId;
      var borrowList = [];
      borrowList.push(borrows[searchBorrowId]);
      break;
    case 'post': break;
    default: break;
  }
  return {
    data: borrowList
  }
}
Mock.mock('/getBorrowById', /get|post/i, getBorrowById);


/**
 * 登陆注销接口
 * author : zhonzheng
 * */

//用户登陆
let login = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      let loginUserCode = body.userCode;
      let loginPassword = body.password;

      var flag = false;
      var user = null;

      for(let i = 0;i < users.length;i++) {
        if (users[i].userCode == loginUserCode) {
          if (users[i].password == loginPassword) {
            flag = true;
            if (users[i].state===false) {
              flag = false;
            }
            user = users[i];
            break;
          }
        }
      }
      break;
    case 'post': break;
    default: break;
  }
  return {
    data: [flag, user]
  }
}
Mock.mock('/login', /get|post/i, login);




/*图书世界数据*/
/*图书连接*/
var picUrl = [
  "https://img3m8.ddimg.cn/89/17/29469518-1_u_3.jpg",
  "https://img3m9.ddimg.cn/12/34/29460729-1_w_12.jpg",
  "https://img3m6.ddimg.cn/79/7/29454856-1_w_18.jpg",
  "https://img3m0.ddimg.cn/16/13/29467960-1_w_17.jpg",
  "https://img3m7.ddimg.cn/90/18/29454867-1_w_4.jpg",
  "https://img3m1.ddimg.cn/97/30/29471011-1_w_9.jpg",
  "https://img3m9.ddimg.cn/24/13/29461929-1_w_4.jpg",
  "https://img3m4.ddimg.cn/34/35/29454514-1_w_3.jpg",

  "https://img3m8.ddimg.cn/74/7/28518608-1_w_15.jpg",
  "https://img3m4.ddimg.cn/26/5/29206214-1_x_31.jpg",

  "https://img3m8.ddimg.cn/89/17/29469518-1_u_3.jpg",
  "https://img3m8.ddimg.cn/89/17/29469518-1_u_3.jpg",
  "https://img3m8.ddimg.cn/89/17/29469518-1_u_3.jpg",
  "https://img3m8.ddimg.cn/89/17/29469518-1_u_3.jpg",
  "https://img3m8.ddimg.cn/89/17/29469518-1_u_3.jpg",
  "https://img3m8.ddimg.cn/89/17/29469518-1_u_3.jpg",
  "https://img3m8.ddimg.cn/89/17/29469518-1_u_3.jpg",
  "https://img3m8.ddimg.cn/89/17/29469518-1_u_3.jpg",
  "https://img3m8.ddimg.cn/89/17/29469518-1_u_3.jpg",
  "https://img3m8.ddimg.cn/89/17/29469518-1_u_3.jpg",
];
/*图书名称*/
var bookName = [
  "敏捷史话",
  "Web安全攻防从入门到精通",
  "Excel数据透视表应用大全",
  "高性能MySQL（第4版）",
  "数据要素五论",
  "算法竞赛（清华科技大讲堂）",
  "工业大数据分析算法实战",
  "Vlog短视频创作从新手到高手",

  " C Primer Plus 第6版",
  "Python编程 从入门到实践",
  "敏捷史话",
  "敏捷史话",
  "敏捷史话",
  "敏捷史话",
  "敏捷史话",
  "敏捷史话",
  "敏捷史话",
  "敏捷史话",
  "敏捷史话",
  "敏捷史话",
];

/*图书介绍*/
var bookInt = [
  "系统性的整理了《敏捷宣言》的17位签署人的敏捷事迹及敏捷初心，从而让读者更加深入了解敏捷的初心和精髓，徐毅、王明兰、杨瑞等业界人士倾情推荐",
  "以新手实操为出发点，搭建漏洞靶场：解析攻防原理+详解攻防手法+构建完整攻防体系。",
  "ExcelHome全新讲授Excel数据透视表多项绝秘应用，全面揭秘数据透视表技术内幕，不需要任何公式与函数，教你在1分钟之内就能创建高级报表，赠送海量视频教程和案例练习文件等学习资源！",
  "毫无争议的领域圣经十年后全版更新||彻底告别5.5全面拥抱8.0||重磅剖析现代云数据库与大规模运维实践||中国首批DBA精琢翻译5大头部国产数据库创始人联合力荐",
  " 数据要素五论：信息、权属、价值、安全、交易",
  "一本算法竞赛大全，全面深入解析算法专题、数据结构、模板代码。10个专题，330个知识点，102个章节视频讲解。",
  "工业大数据分析算法实战",
  "千万级流量博主刘川多年实战总结。 脚本、音效等海量Vlog素材免费赠送。",

  "C语言入门经典教程，畅销30余年的C语言编程入门书籍，近百万程序员的C语言编程启蒙教材，技术大牛案头常备的工具书，被誉为C语言百科全书，购书赠送价值99元的e读版电子书+在线编程环境",
  "零基础学Python编程教程书籍，数据分析、网络爬虫、深度学习技能，畅销经典蟒蛇书升级版，附赠源代码、练习答案、学习视频、学习速查地图读者交流群等资源。 ",
];
/*图书简介*/
var bookInt2 = [
  "系统性的整理了《敏捷宣言》的17位签署人的敏捷事迹及敏捷初心...",
  "以新手实操为出发点，搭建漏洞靶场：解析攻防原理+详解攻防手...",
  "ExcelHome全新讲授Excel数据透视表多项绝秘应用，全面揭秘...",
  "毫无争议的领域圣经十年后全版更新||彻底告别5.5全面拥抱...",
  "最重要的书籍，数据要素五论：信息、权属、价值、安全、交易...",
  "一本算法竞赛大全，全面深入解析算法专题、数据结构、模板代码...",
  "工业大数据分析算法实战，带给你全新的学习体验，给你百万级别...",
  "千万级流量博主刘川多年实战总结。 脚本、音效等海量Vlog素材...",

  "系统性的整理了《敏捷宣言》的17位签署人的敏捷事迹及敏捷初心...",
  "系统性的整理了《敏捷宣言》的17位签署人的敏捷事迹及敏捷初心...",
  "系统性的整理了《敏捷宣言》的17位签署人的敏捷事迹及敏捷初心...",
];


let getPicUrl = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      pageSize = 8;//一页显示的记录数
      let pageSize = parseInt(body.pageSize);


      let currentPageNo = parseInt(body.currentPageNo);//当前页数
      let startNo = 0;
      startNo = (currentPageNo - 1) * pageSize;//显示数据的起始下标


      var pUrl = [];
      var bookNameList = [];
      var bookIntList2 = [];
      for (let i = startNo; i < startNo + pageSize && i < picUrl.length ; i++) {
        pUrl.push(picUrl[i]); //将模拟的数据放到数组中
      }
      for (let i = startNo; i < startNo + pageSize && i < bookName.length ; i++) {
        bookNameList.push(bookName[i]); //将模拟的数据放到数组中
      }
      for (let i = startNo; i < startNo + pageSize && i < bookInt2.length ; i++) {
        bookIntList2.push(bookInt2[i]); //将模拟的数据放到数组中
      }
      break;
      break;
    case 'post': break;
    default: break;
  }
  return {
    data: [pUrl,bookNameList,bookIntList2]
  }
}
Mock.mock('/getPicUrl', /get|post/i, getPicUrl);


var authorInt = [
  "作者:禅道项目管理软件团队   出版社:人民邮电出版社   出版时间:2022年10月 ",
  "作者:红日安全   出版社:北京大学出版社   出版时间:2022年10月  ",
  "作者:Excel Home   出版社:北京大学出版社   出版时间:2022年09月  ",
  "作者:（美）Silvia Botros（西尔维亚·博特罗斯）, Jeremy Tinley（杰里米·廷利）   出版社:电子工业出版社   出版时间:2022年09月 ",
];

let getPicBook = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);
      pageSize = 8;//一页显示的记录数
      let pageSize = parseInt(body.pageSize);
      let currentPageNo = parseInt(body.currentPageNo);//当前页数
      let startNo = 0;
      startNo = (currentPageNo - 1) * pageSize;//显示数据的起始下标
      var pUrl = [];
      var bookNameList = [];
      var bookIntList2 = [];
      var authorList = [];
      for (let i = startNo; i < startNo + pageSize && i < picUrl.length ; i++) {
        pUrl.push(picUrl[i]); //将模拟的数据放到数组中
      }
      for (let i = startNo; i < startNo + pageSize && i < bookName.length ; i++) {
        bookNameList.push(bookName[i]); //将模拟的数据放到数组中
      }
      for (let i = startNo; i < startNo + pageSize && i < bookInt.length ; i++) {
        bookIntList2.push(bookInt[i]); //将模拟的数据放到数组中
      }
      for (let i = startNo; i < startNo + pageSize && i < authorInt.length ; i++) {
        authorList.push(authorInt[i]); //将模拟的数据放到数组中
      }
      break;
      break;
    case 'post': break;
    default: break;
  }
  return {
    data: [pUrl,bookNameList,bookIntList2,authorList]
  }
}
Mock.mock('/getPicBook', /get|post/i, getPicBook);


let getBookAbout = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      let index = parseInt(body.index);
      var bookNameAbout = bookName[index];
      var authorIntAbout = authorInt[index];
      var bookIntAbout = bookInt[index];
      var url = picUrl[index];



      break;
    case 'post': break;
    default: break;
  }
  return {
    data: [bookNameAbout,bookIntAbout,authorIntAbout,url]
  }
}
Mock.mock('/getBookAbout', /get|post/i, getBookAbout);


let getHello = function (options) {
  let rtype = options.type.toLowerCase();//获取请求的类型并转换为小写
  switch (rtype) {
    case 'get':
      var body = JSON.parse(options.body);

      var pUrl = [];
      var bookNameList = [];
      for (let i = 0; i < 4 && i < picUrl.length ; i++) {
        pUrl.push(picUrl[i]); //将模拟的数据放到数组中
      }
      for (let i = 0; i < 8 && i < bookName.length ; i++) {
        bookNameList.push(bookName[i]); //将模拟的数据放到数组中
      }


      break;
    case 'post': break;
    default: break;
  }
  return {
    data: [pUrl,bookNameList]
  }
}
Mock.mock('/gethello', /get|post/i, getHello);
