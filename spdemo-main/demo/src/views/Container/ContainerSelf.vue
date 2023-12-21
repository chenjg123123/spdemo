<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useUserStore } from '../../stores'
const userStore = useUserStore()
const defaultSrc = ref(
  'https://tse2-mm.cn.bing.net/th/id/OIP-C.eSpAhJ8i75zSrfa1cacOQgHaHa?w=194&h=194&c=7&r=0&o=5&dpr=2&pid=1.7'
)
const router = useRouter()
const confirmLogout = () => {
  if (confirm('确定要退出吗？')) {
    // deleteTokenFromRepository();
    alert('已退出登录')
  }
}
const handleCompany = () => {
  router.push(`/container/CompanyIntro/${userStore.user.companyId}`)
}
</script>
<template>
  <div class="Header">个人中心</div>
  <div class="aaa">
    <el-col :span="10">
      <div class="demo-basic--circle">
        <div class="block" style="display: flex">
          <el-avatar
            :size="125"
            style="padding-top;: 50px"
            :src="userStore.user ? userStore.user.avatar : defaultSrc"
            >头像</el-avatar
          >
          <div
            class="user-info"
            style="
              display: inline-block;
              vertical-align: middle;
              margin-left: 50px;
            "
          >
            <p>
              用户名: {{ userStore.user.uname }}
              <router-link
                to="/container/self-setting"
                style="text-decoration: none; color: inherit"
              >
                <button style="vertical-align: middle; margin-left: 30px">
                  设置
                </button>
              </router-link>
            </p>
          </div>
        </div>
        <br />
        <hr />
        <div class="ellipse-window">
          <div
            style="display: flex; align-items: center"
            @click="handleCompany"
          >
            <el-avatar :size="50" :src="circleUrl"></el-avatar>
            <div class="user-info" style="margin-left: 40px">公司介绍</div>
          </div>
          <hr style="border: 1px dashed #000" />
          <div style="display: flex; align-items: center">
            <el-avatar :size="50" :src="circleUrl"></el-avatar>
            <div class="user-info" style="margin-left: 40px">
              <router-link
                to="/container/CollectionBusiness"
                style="text-decoration: none; color: inherit"
                >收藏业务</router-link
              >
            </div>
          </div>
          <hr style="border: 1px dashed #000" />
          <div style="display: flex; align-items: center">
            <el-avatar :size="50" :src="circleUrl"></el-avatar>
            <div class="user-info" style="margin-left: 40px">
              <router-link
                to="/container/CooperativeCompany"
                style="text-decoration: none; color: inherit"
                >合作企业</router-link
              >
            </div>
          </div>
          <hr />
          <div>
            <el-button
              @click="confirmLogout()"
              style="
                vertical-align: middle;
                margin: auto;
                width: 100%;
                height: 60px;
              "
            >
              退出登录
            </el-button>
          </div>
          <br />
          <hr />
        </div>
      </div>
    </el-col>
  </div>

  <!--   <div class="main">
    <show-society v-for="index in 1" @click="getinter"></show-society>
  </div> -->
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
// .main {
//   display: flex;
//   // flex-wrap: wrap;
//   justify-content: center;
//   // margin-bottom: 100px;
// }
.aaa {
  display: flex;
  // align-items: center;
  justify-content: center;
  height: 750px;
  border-radius: 30px;
  margin: 100px auto 60px auto;
}
</style>
