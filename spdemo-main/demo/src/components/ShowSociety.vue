<script setup></script>
<template>
  <div class="show">
    <img src="@/assets/backgroud/b1.jpg" />
    <div class="span">1231231231</div>
    <div class="user">
      <img src="@/assets/backgroud/b1.jpg" />
      <span>userName</span>
    </div>
  </div>
</template>
<style scoped lang="scss">
.show {
  width: 300px;
  height: 300px;
  border: 1px solid black;
  margin: 20px 30px;
  display: flex;
  flex-direction: column;
  img {
    width: 280px;
    height: 160px;
    margin: 10px 10px;
  }
  .span {
    margin: 10px 10px;
    height: 50px;
  }
  .user {
    width: 300px;
    height: 50px;
    display: flex;
    img {
      width: 30px;
      height: 30px;
      margin: 10px 10px;
      border: 3px solid black;
      border-radius: 50%;
    }
    span {
      margin: 10px 10px;
    }
  }
}
</style>
