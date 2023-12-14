<script setup>
import { ref } from 'vue'
defineProps({
  src: [String],
  src1: [String]
})
const refSrc = ref(
  'https://lnu-liang-web-tlias.oss-cn-guangzhou.aliyuncs.com/c6a798dc-6811-4ad2-b3f1-555f6048fc29.jpg'
)
</script>
<template>
  <div class="show">
    <img :src="src != null ? src : refSrc" />
    <div class="span"><slot name="title"></slot></div>
    <div class="user">
      <img :src="src1 != null ? src1 : refSrc" />
      <span><slot name="username"></slot></span>
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
    overflow: hidden;
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
      overflow: hidden;
    }
  }
}
</style>
