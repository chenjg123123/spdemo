<script setup>
import { NavBar } from 'vant'
import { onMounted, ref } from 'vue'
import { useRouter } from 'vue-router'
import { userInterService } from '@/api/society.js'
const refSrc = ref(
  'https://lnu-liang-web-tlias.oss-cn-guangzhou.aliyuncs.com/c6a798dc-6811-4ad2-b3f1-555f6048fc29.jpg'
)
const router = useRouter()
//methods
const onClickLeft = () => {
  router.go(-1)
}
const idInfo = ref({
  picurls: '',
  id: ''
})
const GetuserInterService = async (ids) => {
  const res = await userInterService(ids)
  idInfo.value = res.data.data
  console.log(idInfo.value)
}
//onmounted
onMounted(() => {
  const test = router.currentRoute.value.params.id
  console.log(test)
  GetuserInterService(test)
})
</script>
<template>
  <NavBar class="bar" left-text="返回" left-arrow @click-left="onClickLeft" />

  <div class="pic">
    <el-carousel height="400px" class="carousel">
      <el-carousel-item>
        <!-- <img src="@/assets/backgroud/b1.jpg" /> -->
        <img
          :src="
            idInfo.picurls
              ? idInfo.picurls.url1
                ? idInfo.picurls.url1
                : refSrc
              : refSrc
          "
        />
      </el-carousel-item>
      <el-carousel-item>
        <img
          :src="
            idInfo.picurls
              ? idInfo.picurls.url2
                ? idInfo.picurls.url2
                : refSrc
              : refSrc
          "
        />
      </el-carousel-item>
      <el-carousel-item>
        <img
          :src="
            idInfo.picurls
              ? idInfo.picurls.url3
                ? idInfo.picurls.url3
                : refSrc
              : refSrc
          "
        />
      </el-carousel-item>
      <el-carousel-item>
        <img
          :src="
            idInfo.picurls
              ? idInfo.picurls.url4
                ? idInfo.picurls.url4
                : refSrc
              : refSrc
          "
        />
      </el-carousel-item>
    </el-carousel>
  </div>
  <div class="span">{{ idInfo ? idInfo.id.title : 'TEST' }}</div>
  <div class="span1">{{ idInfo ? idInfo.id.content : 'test' }}</div>
</template>
<style scoped lang="scss">
.span {
  position: relative;
  height: 100px;
  width: 500px;
  margin: auto;
  font-size: 30px;
  font-weight: 300;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
    'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

.span1 {
  position: relative;
  height: 400px;
  width: 500px;
  margin: auto;
  font-size: 12px;
  font-weight: 300;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
    'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}
.pic {
  margin: 20px 0px;
  display: flex;
  justify-content: center;
  align-items: center;
  img {
    height: 400px;
    width: 400px;
  }
  .carousel {
    width: 400px;
    height: 400px;
    border: 3px solid silver;
  }
}
</style>
