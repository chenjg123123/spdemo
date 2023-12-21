<script setup>
import { NavBar, Sidebar, SidebarItem, Icon } from 'vant'
import { onMounted, ref } from 'vue'
import { chatWithId, getMessageListById } from '@/api/chat.js'
import { getIsCollect, collectOrnot } from '@/api/community.js'
import { useRouter } from 'vue-router'
import { getById } from '@/api/community.js'
import { useUserStore } from '@/stores'
const activeKey = ref(0)
const userStore = useUserStore()
const refSrc = ref(
  'https://lnu-liang-web-tlias.oss-cn-guangzhou.aliyuncs.com/c6a798dc-6811-4ad2-b3f1-555f6048fc29.jpg'
)
const redtrue = ref(0)
const router = useRouter()
const showDetail = ref(false)
const test = router.currentRoute.value.params.id

//methods
const handlershowDetail = async () => {
  const res = await chatWithId(userStore.userid, idInfo.value.comunity.userId)
  showDetail.value = true
  const res1 = await getMessageListById(res.data.data.one.massageId)
  userStore.chat = res1.data.data.messagelists
}
const handleThum = () => {
  redtrue.value = redtrue.value === 0 ? 1 : 0
}
const handleDescription = () => {
  router.push(`/container/CompanyIntro/${idInfo.value.comunity.companiesId}`)
}
const onClickLeft = () => {
  router.go(-1)
}
const handleCollect = async () => {
  const res = await collectOrnot(userStore.userid, parseInt(test))
  GetCollect(userStore.userid, parseInt(test))
  ElMessage.success(res.data.msg)
}
const isCollect = ref()
const idInfo = ref({
  picurls: '',
  comunity: ''
})
const GetuserInterService = async (ids) => {
  const res = await getById(ids)
  idInfo.value = { ...res.data.data }
  console.log(idInfo.value)
}
const GetCollect = async (userId, companyId) => {
  const res = await getIsCollect(userId, parseInt(companyId))
  isCollect.value = res.data.data.code
}
//onmounted
onMounted(() => {
  GetuserInterService(test)
  GetCollect(userStore.userid, parseInt(test))
})
</script>
<template>
  <NavBar class="bar" left-text="返回" left-arrow @click-left="onClickLeft" />
  <ShowChatDetail v-model="showDetail"></ShowChatDetail>

  <div class="main">
    <sidebar v-model="activeKey" class="operate">
      <div
        style="
          display: flex;
          align-items: center;
          justify-content: center;
          margin-right: 10px;
        "
      >
        <Icon
          :class="{ red: redtrue === 1 }"
          name="like-o"
          size="30px"
          @click="handleThum"
        />
      </div>
      <sidebar-item title="点赞" @click="handleThum" />
      <div
        style="
          display: flex;
          align-items: center;
          justify-content: center;
          margin-right: 10px;
        "
      >
        <Icon
          :class="{ red: isCollect === 1 }"
          name="star-o"
          size="30px"
          @click="handleCollect"
        />
      </div>
      <sidebar-item title="收藏" @click="handleCollect" />
      <sidebar-item title="私聊" @click="handlershowDetail" />
      <sidebar-item title="简介" @click="handleDescription" />
    </sidebar>
    <div class="pic">
      <el-carousel height="400px" class="carousel">
        <el-carousel-item>
          <!-- <img src="@/assets/backgroud/b1.jpg" /> -->
          <img
            :src="
              idInfo.picurls
                ? idInfo.picurls.url1
                  ? idInfo.picurls.url1
                  : refSrc
                : refSrc
            "
          />
        </el-carousel-item>
        <el-carousel-item>
          <img
            :src="
              idInfo.picurls
                ? idInfo.picurls.url2
                  ? idInfo.picurls.url2
                  : refSrc
                : refSrc
            "
          />
        </el-carousel-item>
        <el-carousel-item>
          <img
            :src="
              idInfo.picurls
                ? idInfo.picurls.url3
                  ? idInfo.picurls.url3
                  : refSrc
                : refSrc
            "
          />
        </el-carousel-item>
        <el-carousel-item>
          <img
            :src="
              idInfo.picurls
                ? idInfo.picurls.url4
                  ? idInfo.picurls.url4
                  : refSrc
                : refSrc
            "
          />
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="text">
      <div class="span">
        {{ idInfo ? idInfo.comunity.workName : 'TEST' }}
      </div>
      <div class="span">
        {{ idInfo ? idInfo.comunity.workRemuneration : 'test' }}
      </div>
    </div>
    <div class="text">
      <div class="span1">
        {{ idInfo ? idInfo.comunity.workContent : 'test' }}
      </div>
    </div>
    <div class="span">
      {{ idInfo ? idInfo.comunity.workLocations : 'TEST' }}
    </div>
  </div>
</template>
<style scoped lang="scss">
.red {
  color: red;
}
.operate {
  position: fixed;
  right: 0%;
}
.text {
  display: flex;
  justify-content: space-between;
  width: 500px;
  margin: auto;
}
.main {
  margin: 60px 0;
}
.span {
  position: relative;
  text-align: center;
  height: 50px;
  width: 500px;
  margin: auto;
  font-size: 30px;
  font-weight: 300;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
    'Lucida Sans Unicode', Geneva, Verdana, sans-serif;

  color: green;
}
.span1 {
  position: relative;
  height: 50px;
  width: 500px;
  margin: auto;
  font-size: 12px;
  font-weight: 300;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
    'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  color: green;
}
.pic {
  margin: 20px 0px;
  display: flex;
  justify-content: center;
  align-items: center;
  img {
    height: 400px;
    width: 400px;
  }
  .carousel {
    width: 400px;
    height: 400px;
    border: 3px solid silver;
  }
}
</style>
