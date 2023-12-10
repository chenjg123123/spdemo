<script setup></script>
<template>
  <el-drawer title="Postman" size="60%" style="margin-bottom: 5px">
    <div class="Header">title</div>
    <el-scrollbar> <div class="contain">content</div> </el-scrollbar>
    <div class="date">2023-11-23</div>
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
  width: 80%;
}
.date {
  width: 100%;
  text-align: right;
}
</style>
