<script setup></script>
<template>
  <el-drawer title="inform" size="60%" style="margin-bottom: 5px">
    <div class="Header"><slot name="title">123</slot></div>
    <el-scrollbar>
      <div class="contain"><slot name="content">123</slot></div>
    </el-scrollbar>
    <div class="date"><slot name="time">123</slot></div>
  </el-drawer>
</template>

<style scoped lang="scss">
.Header {
  margin: auto;
  width: 80%;
  text-align: center;
  font-size: 40px;
}
.contain {
  margin: 15px 10px;
  width: 98%;
  word-wrap: break-word;
}
.date {
  width: 100%;
  text-align: right;
}
</style>
