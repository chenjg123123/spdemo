<script setup></script>
<template>
  <div class="main">
    <img class="imgBig" src="@\assets\backgroud\b1.jpg" />
    <div class="tradition">
      <div class="Text"><slot>123</slot></div>

      <div class="smallPic">
        <img class="small" src="@\assets\backgroud\b1.jpg" />
        <img class="small" src="@\assets\backgroud\b1.jpg" />
        <img class="small" src="@\assets\backgroud\b1.jpg" />
      </div>
    </div>
  </div>
</template>
<style scoped lang="scss">
.main {
  width: 50%;
  margin: 0;
  display: flex;
  margin-bottom: 4%;
  position: relative;
  .imgBig {
    margin: 2% 2%;
    width: 180px;
    height: 270px;
    border: 3px silver solid;
    transition: all 0.5s linear;
    &:hover {
      transform: scale(1.05);
    }
  }
  .tradition {
    width: 400px;
    margin-top: 2%;
    height: 276px;
    .Text {
      margin: 0% 3%;
      padding: 0;
      width: 100%;
      height: 50%;
    }
    .smallPic {
      position: relative;
      width: 104%;
      display: flex;
      height: 50%;
      margin-top: 5%;
      .small {
        margin: 2% 13px;
        width: 100px;
        height: 100px;
        border: 2px black solid;
        transition: all 0.5s linear;
        &:hover {
          transform: scale(1.05);
        }
      }
    }
  }
}
</style>
