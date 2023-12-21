<template>
  <div class="Header">
    <NavBar class="bar" left-text="返回" left-arrow @click-left="onClickLeft" />
    <h2 class="Title">收藏业务</h2>
  </div>
  <br /><br /><br /><br />
  <div class="collection">
    <ShowCollection
      v-for="index in Info.length"
      :key="index"
      :data="Info[index - 1]"
    />
  </div>
</template>

<script setup>
import { NavBar } from 'vant'
// import { getCollectByid } from "@/api/user.js";
import { useRouter } from 'vue-router'
import { ref, onMounted } from 'vue'
import { useUserStore } from '@/stores'
import ShowCollection from '@/components/ShowCollection.vue'
const userStore = useUserStore()
const router = useRouter()
const onClickLeft = () => {
  router.go(-1)
}
const Info = ref([])
const init = async () => {
  // const res = await getCollectByid(userStore.userid);
  Info.value = [{}, {}, {}, {}]
}
onMounted(() => {
  init()
})
</script>

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
.Title {
  margin: 0 auto;
  font-size: inherit;
  font-weight: inherit;
}
.collection {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 750px;
}
</style>
