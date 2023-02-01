<template>
  <div>
    <h2>图书详情</h2>
      <el-row>
          <div style="position:relative;display: inline;margin-left: -1000px" >
            <el-image
              style="width: 250px; height: 250px"
              :src="url"
              :fit="fits"></el-image>
          </div>
          <div style="width:1000px;position:absolute;top:0;display: inline-block;text-align: left;padding-left: 20px;margin-top: -10px">
            <div>
              <h3>{{ bookName }}</h3>
              <p>{{author}}</p>
              <el-divider></el-divider>
              <strong style="font-size: 25px">{{bookInt}}</strong>
            </div>
          </div>
      </el-row>
    <el-row>
      <div style="position:absolute;top: 20px;left: 200px;width: 800px">
        <el-tabs v-model="activeName" type="border-card" @tab-click="handleClick">
          <el-tab-pane label="图书介绍" name="first">
            <p>该刊创刊之时正处于中日战争爆发之时，其所属的浙江省立图书馆因受到战争的影响被迫的迁至丽水县，
              这种情况使读者在图书选购方面带来了很大的困扰，为了方便购书困难的读者进行选购，丽水县立民众教育馆成立，
              并刊行图书介绍一刊，将近期出版的图书进行重新统一编目、列出统计表，介绍给读者，方便读者选购。该刊物每次刊行大致两页内容，
              编订成册，由于战事条件的局限性，该刊物中的文章有手写完成，在编排上也有些散乱。刊中常设有新书介绍、论文介绍、参考资料、
              地图等特色栏目。“新书介绍”一栏将近期所新出版的书籍按照文学、艺术、社科等进行分类并刊出，一定程度上扩大了读者的阅读范围；
              “参考资料”一栏中对于比较有代表意义的图书、论文进行简要介绍，篇目中的经典片段进行摘录，并提供学者和著作者的史略，出版社信息以及相关的图书评论都有涉及，
              使渴望读书之人有门路可寻；“地图”一栏中主要是丽水县当地的文化、自然地理地图的出版信息的刊出。栏目之外还对丽水县当地的基本情况进行介绍，以及对近期出版的期刊进行统计，
              也刊载了部分战事消息，如《一年来抗战的情况》等。</p>
          </el-tab-pane>
          <el-tab-pane label="图书评价" name="second">
            <div v-for="n in 3">
              <div >
                <p>
                  <span style="display: flex;justify-content: left">张{{n}}：</span>
                  <el-rate
                    style="display: flex;margin: -20px 0 0 40px"
                    v-model="value[n - 1]"
                    disabled
                    show-text>
                  </el-rate>
                </p>
                <span style="display: flex;">书很好，感觉和一代伟人沟通交流</span>
              </div>


              <el-divider></el-divider>
            </div>
          </el-tab-pane>
          <el-tab-pane label="订购地址" name="third">
            指定供应商：<el-link href="http://www.dangdang.com/" type="danger">当当网</el-link>
          </el-tab-pane>
        </el-tabs>
      </div>

    </el-row>
  </div>
</template>

<script>
export default {
  name: "BookAboutView",
  created() {
    this.index = parseInt(this.$route.params.index)
  },
  data () {
    return {
      value: [3.7, 4.1, 5],
      activeName: 'first',
      index:0,
      fits: 'cover',
      url: '',
      bookName:'',
      bookInt:'',
      author:'',
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
    getBookAbout() {
      this.axios.get("/getBookAbout", {
        data: {
          index: this.index,
        }
      }).then(res => {
        this.bookName = res.data.data[0];
        this.bookInt = res.data.data[1];
        this.author = res.data.data[2];
        this.url = res.data.data[3];
      });
      console.log(this.url);
    },

  },
  mounted() {
    this.getBookAbout();
  }
}
</script>

<style scoped>

</style>
