<template>
  <div class="item">
    <div class="userPic"><img src="@/assets/backgroud/b1.jpg" /></div>
    <div class="userName"><span>用户名:UserName</span><p1>op</p1></div>
  </div>
</template>
<script setup></script>
<style scoped lang="scss">
.item {
  width: 100%;
  height: 150px;
  margin: 2px 0;
  background: #ffffff;
  border-bottom: 2px #555555 dotted;
  display: flex;
  .userPic {
    margin-left: 30px;
    padding-top: 15px;
    img {
      width: 120px;
      height: 120px;
      border-radius: 50%;
    }
  }
  .userName {
    margin: 25px 30px;
    display: flex;
    flex-direction: column;
    span {
      font-size: 24px;
    }
    p1 {
      margin-top: 30px;
    }
  }
}
</style>
