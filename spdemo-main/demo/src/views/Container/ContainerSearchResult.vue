<script setup>
import { NavBar } from 'vant'
import { onMounted, ref } from 'vue'

import { searchBykeyForTitle } from '@/api/society.js'
// const refSrc = ref(
//   'https://lnu-liang-web-tlias.oss-cn-guangzhou.aliyuncs.com/c6a798dc-6811-4ad2-b3f1-555f6048fc29.jpg'
// )
import { useRouter } from 'vue-router'
const router = useRouter()
//methods
const onClickLeft = () => {
  router.go(-1)
}
const currenPage = ref()
const pagecount = ref()
const total = ref()
const getinter = async (id) => {
  router.push(`/container/society/${id}`)
}
const societyListData = ref([])
const picUrls = ref()
const search = async (key, page) => {
  if (!page) {
    const res = await searchBykeyForTitle(key, 1, 15)
    if (res.data.data.page.pageNum < 1) {
      ElMessage({ message: '未搜索到', type: 'error' })
    }
    currenPage.value = 1
    pagecount.value = 1
    total.value = res.data.data.page.total
    societyListData.value = res.data.data.page.list
    picUrls.value = res.data.data.picurls

    // console.log(societyListData.value, picUrls.value)
  } else {
    const res = await searchBykeyForTitle(key, page, 15)
    if (res) {
      societyListData.value = res.data.data.page.list
      picUrls.value = res.data.data.picurls
    }
  }
}
const handleCurrent = () => {
  const test = router.currentRoute.value.params.key
  search(test, currenPage.value)
}
//onmounted
onMounted(() => {
  const test = router.currentRoute.value.params.key
  search(test)
  setTimeout(() => {}, 3000)
})
</script>
<template>
  <NavBar class="bar" left-text="返回" left-arrow @click-left="onClickLeft" />

  <div class="main">
    <show-society
      v-for="(item, index) in societyListData"
      :key="item.sid"
      @click="getinter(item.sid)"
      :src="picUrls[index] ? picUrls[index].url1 : null"
      :src1="
        picUrls[index]
          ? picUrls[index].url2
            ? picUrls[index].url2
            : picUrls[index].url1
          : null
      "
    >
      <template #title>{{ item.title }}</template>
      <template #username>{{ item.username }}</template>
    </show-society>
  </div>
  <div class="page">
    <el-pagination
      :page-size="15"
      :pager-count="10"
      layout="prev, pager, next"
      :total="total"
      v-model:current-page="currenPage"
      @current-change="handleCurrent"
    />
  </div>
</template>
<style scoped lang="scss">
.main {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin-bottom: 60px;
}
.page {
  width: 100%;
  height: 30px;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin-bottom: 80px;
}
</style>
