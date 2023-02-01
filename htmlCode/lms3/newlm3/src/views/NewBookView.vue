<template>
  <div>
    <h3 style="margin: -20px 0 0 0">热门榜单</h3>

    <div style="margin: 0 0 5px 0" v-for="n in 3">
      <el-row>
        <el-card shadow="hover">
          <div style="display: inline-block;margin-left: 0" >
            <el-image style="width: 100px; height: 100px;margin-right: 30px" src="static/1.png" v-if="n==1" :fit="fits"></el-image>
            <el-image style="width: 100px; height: 100px;margin-right: 30px" src="static/2.png" v-if="n==2" :fit="fits"></el-image>
            <el-image style="width: 100px; height: 100px;margin-right: 30px" src="static/3.png" v-if="n==3" :fit="fits"></el-image>
            <el-image style="width: 100px; height: 100px;margin-right: 30px" src="static/4.png" v-if="n==4" :fit="fits"></el-image>
              <el-image
                style="width: 130px; height: 130px"
                :src="urlList[n-1]"
                :fit="fits"></el-image>
          </div>
          <div style="width:800px;display: inline-block;text-align: left;padding-left: 20px;margin-top: -10px">
<!--            <el-link type="primary" style="text-align: right;margin-top: -50px">{{ bookNameList[n-1] }}</el-link>-->
            <div>
              <a href="#" >{{ bookNameList[n-1] }}</a>
              <p>{{authorList[n-1]}}</p>
              <p>{{bookIntList[n-1]}}</p>
              <p><el-button @click="toAbout(n-1)" type="primary" size="mini" plain>详情</el-button></p>
            </div>

          </div>

        </el-card>
      </el-row>
    </div>





  </div>
</template>

<script>
export default {
  name:'NewBookView',
  data () {
    return {
      fits: 'cover',
      urlList: [],
      bookNameList:[],
      bookIntList:[],
      authorList:[],
      currentPageNo: 1,
      pageSize: 4,
      total: 16,
    };
  },
  methods: {
    getPicUrl(currentPageNo) {
      this.axios.get("/getPicBook", {
        data: {
          currentPageNo: currentPageNo,
          pageSize: this.pageSize,
        }
      }).then(res => {
        this.urlList = res.data.data[0];
        this.bookNameList = res.data.data[1];
        this.bookIntList = res.data.data[2];
        this.authorList = res.data.data[3];
      });
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
    this.getPicUrl(1);
  }

}

</script>
<style scoped>

</style>
