<script setup>
import { Plus } from '@element-plus/icons-vue'
import { ref } from 'vue'
const searchKey = ref()
</script>
<template>
  <div class="Header">
    <span>社区</span>
    <el-input
      style="width: 400px; margin-top: 20px; font-size: 30px; color: red"
      placeholder=""
      v-model="searchKey"
      prefix-icon="search"
      size="large"
      clearable
    ></el-input>
    <el-icon size="30px"><Plus /></el-icon>
  </div>
  <div class="navtabbar">
    <el-scrollbar>
      <span v-for="index in 10" @click="handlerCategory">genshin</span>
    </el-scrollbar>
  </div>
  <div class="main">
    <show-society v-for="index in 10"></show-society>
  </div>
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
.navtabbar {
  margin-top: 20px;
  font-size: 30px;
  display: flex;
  border-bottom: 1px solid black;
  span {
    margin: 0 30px;
  }
}
.main {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin-bottom: 60px;
}
</style>
