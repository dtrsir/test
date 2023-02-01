<template>
  <!--父div-->
  <div>
    <h3 style="display: inline-block" >图书世界</h3>
<!--    <el-pagination layout="->,prev, pager, next"
                   :total="total" :page-size="pageSize" @prev-click="upClick" @next-click="nextClick"></el-pagination>-->
    <el-row style="display: flex;justify-content: space-between;margin: 0px 100px 0 0">
      <el-col style="width: 250px;height: 250px" :span="8" v-for="index in 4" :key="index" :offset="index > 0 ? 2 : 0">
        <el-card :body-style="{ padding: '0px',width:'250px', margin:'0' }" >
          <img :src="urlList[index-1]" class="image">
          <div style="padding: 14px;">
            <span @click="toAbout(index-1)">{{bookNameList[index-1]}}</span>
            <div class="bottom clearfix">
              <time class="time">{{ bookIntList[index-1] }}</time>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-row style="display: flex;justify-content: space-between;margin: 100px 100px 0 0">
      <el-col style="width: 250px;height: 250px" :span="8" v-for="index in 4" :key="index" :offset="index > 0 ? 2 : 0">
        <el-card :body-style="{ padding: '0px' }" >
          <img :src="urlList[index+3]" class="image">
          <div style="padding: 14px;">
            <span @click="toAbout(index+3)">{{bookNameList[index+3]}}</span>
            <div class="bottom clearfix">
              <time class="time">{{ bookIntList[index+3] }}</time>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <br>

  </div>
</template>

<script>
export default {
  name:'BookWorldView',
  props:[''],
  data () {
    return {
      urlList: [],
      bookNameList:[],
      bookIntList:[],
      currentPageNo: 1,
      pageSize: 8,
      total: 16,
    };
  },
  methods: {
    //查询图书列表，参数当前页数
    getPicUrlList(currentPageNo) {
      this.axios.get("/getPicUrl", {
        data: {
          currentPageNo: currentPageNo,
          pageSize: this.pageSize,
        }
      }).then(res => {
        this.urlList = res.data.data[0];
        this.bookNameList = res.data.data[1];
        this.bookIntList = res.data.data[2];
      });
    },
    nextClick() {
      this.getPicUrlList(2);

    },
    upClick() {
      this.getPicUrlList(1);
    },
    toAbout(index) {
      this.$router.push({
        name: 'bookAbout',
        params: {
          index: index
        }
      })

    }
  },
  mounted() {
    this.getPicUrlList(1);
  }
}
</script>

<style scoped>

.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}


.bookWorld{
  float: left;
}
.bookWorld .book{
  display: inline-block;
  width: 19%;
  border-right: solid 1px #ccc;
  margin-left: 10px;
}
.bookWorld a:hover{
  color: red;
}
.bookWorld img {
  width: 120px;
  height: 100px
}
.bookWorld span{
  color: #cdcdcd;
  text-decoration: line-through;
}
</style>
