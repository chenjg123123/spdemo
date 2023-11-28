<template>
  <div class="Header">社区</div>
  <div class="showMain">
    <ShowPicture></ShowPicture>
    <ShowPicture></ShowPicture>
    <ShowPicture></ShowPicture>
    <ShowPicture></ShowPicture>
    <ShowPicture></ShowPicture>
    <ShowPicture></ShowPicture>
    <ShowPicture></ShowPicture>
    <ShowPicture></ShowPicture>
    <ShowPicture></ShowPicture>
  </div>
</template>

<style scoped lang="scss">
.Header {
  display: flex;
  align-items: center; /* 垂直居中 */
  padding: 0;
  top: 0;
  left: 0;
  right: 0;
  bottom: 90%; /* 设置底部间距为 90% */
  height: 8%;
  font-size: 2em;
  font-weight: 400;
  justify-content: center; /* 水平居中 */
  background: linear-gradient(to bottom, #ffffff, #d5d5d5);
  border-bottom: 2px silver solid;
  border-bottom-right-radius: 16px;
  border-bottom-left-radius: 16px;
  color: #555555;
  position: fixed;
  z-index: 50;
}
.showMain {
  display: flex;
  margin-top: 8%;
  margin-left: 4%;
  position: relative;
  overflow: scroll;
  flex-wrap: wrap;
  @media screen and (max-width: 1500px) {
    /* 当屏幕宽度小于或等于 768px 时应用以下样式 */
    /* 添加针对小屏幕的特定样式 */
    flex-direction: column; /* 小屏幕下垂直排列 */
    justify-content: center;
    align-content: center;
    margin-left: 0;
  }
}
</style>
