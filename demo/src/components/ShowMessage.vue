<script setup></script>
<template>
  <div class="main">
    <div class="date"><h1>日期 2023-11-23</h1></div>
    <div class="title"><h3>原神3.5</h3></div>
    <div class="content"><h6>上线送10抽</h6></div>
    <div class="pic"><img src="@/assets/backgroud/b1.jpg" /></div>
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
  .pic {
    position: relative;
    left: 68%;
    top: -140px;
    img {
      width: 230px;
      height: 230px;
      border-radius: 50%;
      border: 3px solid black;
    }
  }
}
</style>
