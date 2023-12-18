<script setup></script>
<template>
  <div class="main">
    <div class="date"><h1>原神刷图业务</h1></div>
    <div class="title"><h3>原神3.5</h3></div>
    <div class="content"><h6>刷图抢宝箱</h6></div>
  </div>
</template>
<style scoped lang="scss">
.main {
  width: 98%;
  height: 250px;
  margin: 5px auto;
  border: 3px black solid;
  border-radius: 16px;
  display: flex;
  flex-direction: column;
  .date {
    margin-left: 20px;
  }
  .title {
    margin-left: 50px;
    h3 {
      margin: 0;
    }
  }
  .content {
    margin-left: 60px;
    h6 {
      margin: 10px;
    }
  }
}
</style>
