<template>
  <NavBar class="bar" title="收藏业务" left-arrow @click-left="onClickLeft" />
  <div class="collection">
    <ShowCollection
      v-for="item in Info"
      :key="item.collectId"
      :name="item.workName"
      :location="item.workLocations"
      :sal="item.workRemuneration"
      @click="handleCollect(item.communityId)"
    >
    </ShowCollection>
  </div>
</template>

<script setup>
import { NavBar } from 'vant'
import { getCollectByid } from '@/api/user.js'
import { useRouter } from 'vue-router'
import { ref, onMounted } from 'vue'
import { useUserStore } from '@/stores'
const userStore = useUserStore()
const router = useRouter()
const onClickLeft = () => {
  router.go(-1)
}
const Info = ref()
const init = async () => {
  const res = await getCollectByid(userStore.userid)
  Info.value = res.data.data.data
}
onMounted(() => {
  init()
})
const handleCollect = (id) => {
  router.push(`/Container/societyCommunity/${id}`)
}
</script>

<style scoped>
.collection {
  width: 100%;
  height: 80%;
  display: flex;
  margin: 50px 30px 70px 30px;
  flex-wrap: wrap;
}
</style>
