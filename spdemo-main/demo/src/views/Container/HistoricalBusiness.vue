<script setup>
import { NavBar } from 'vant'
import { useRouter } from 'vue-router'
const router = useRouter()
const onClickLeft = () => {
  router.go(-1)
}
</script>
<template>
  <div>
    <NavBar
      class="bar"
      left-text="返回"
      title="历史业务"
      left-arrow
      @click-left="onClickLeft"
    />

    <div class="His">
      <div class="showHisWrapper">
        <ShowHis v-for="index in 5" :key="index"></ShowHis>
      </div>
    </div>
  </div>
</template>

<style scoped>
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
.showHisWrapper {
  display: flex;
  flex-wrap: wrap;
  gap: 100px; /* 可选，设置间隔 */
}
.Title {
  margin: 0 auto;
  font-size: inherit;
  font-weight: inherit;
}
</style>
