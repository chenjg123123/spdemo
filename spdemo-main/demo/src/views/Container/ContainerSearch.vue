<script setup>
import { Plus } from '@element-plus/icons-vue'
import { onMounted, ref } from 'vue'
import {
  societyList,
  getCategoryList,
  getSocietyByCategoryId
} from '@/api/society.js'
import { useRouter } from 'vue-router'
const searchKey = ref()
const categoryList = ref()
const societyListData = ref([])
const picUrls = ref()
const loading = ref(false)
const router = useRouter()
const selected = ref()
const isUpload = ref(false)
//method
const getinter = async (id) => {
  router.push(`/container/society/${id}`)
}
const getList = async () => {
  loading.value = true
  const res = await societyList()
  societyListData.value = res.data.data.list
  picUrls.value = res.data.data.picurls
  loading.value = false
}
const getCategroy = async () => {
  const res = await getCategoryList()
  categoryList.value = res.data.data.categoryList
  console.log(res)
}
const handleCategory = async (categoryid) => {
  loading.value = true
  selected.value = categoryid
  const res = await getSocietyByCategoryId(categoryid)
  societyListData.value = res.data.data.list
  picUrls.value = res.data.data.picurls
  loading.value = false
}
const search = () => {
  router.push(`/container/searchkey/${searchKey.value}`)
  searchKey.value = ''
}
const handleOpen = () => {
  isUpload.value = true
}
const colseUpload = () => {
  isUpload.value = false
}
//onMounted
onMounted(() => {
  getList()
  getCategroy()
})
</script>
<template>
  <Upload v-model="isUpload" :method1="colseUpload"></Upload>
  <div class="Header">
    <span>搜索</span>
    <el-input
      style="width: 400px; margin-top: 20px; font-size: 30px; color: red"
      placeholder=""
      v-model="searchKey"
      prefix-icon="search"
      size="large"
      clearable
    ></el-input>
    <el-button
      type="primary"
      style="height: 40px; margin-top: 20px"
      @click="search()"
      >搜索</el-button
    >
    <el-icon size="30px" @click="handleOpen"><Plus /></el-icon>
  </div>
  <!-- <div class="navtabbar"> -->
  <el-scrollbar>
    <div class="scrollbar-flex-content">
      <p
        v-for="item in categoryList"
        :key="item.categoryid"
        :class="{
          'scrollbar-demo-item': true,
          selected: selected === item.categoryid
        }"
        @click="handleCategory(item.categoryid)"
      >
        {{ item.categoryname }}
      </p>
    </div>
  </el-scrollbar>
  <!-- </div> -->
  <keep-alive>
    <div class="main" v-loading="loading">
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
  </keep-alive>
</template>

<style scoped lang="scss">
.Header {
  display: flex;
  align-items: center;
  justify-content: center;
  span {
    font-size: 50px;
    margin-right: 30px;
    margin-top: 10px;
    font-weight: 100;
    position: absolute;
    left: 100px;
  }
  .el-icon {
    margin-top: 20px;
    margin-left: 20px;
    width: 40px;
    height: 40px;
    border-radius: 50%;
    background-color: rgb(247, 247, 17);
  }
  .el-icon:hover {
    scale: 1.2;
    background-color: orange;
  }
}

.scrollbar-flex-content {
  display: flex;
}
.scrollbar-demo-item {
  flex-shrink: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100px;
  height: 50px;
  margin: 10px;
  text-align: center;
  border-radius: 4px;
  // color: var(--el-color-danger);
}
.selected {
  background: var(--el-color-danger-light-9);
}
.main {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin-bottom: 60px;
}
</style>
