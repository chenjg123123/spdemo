<template>
  <NavBar
    class="bar"
    left-text="返回"
    title="合作企业"
    left-arrow
    @click-left="onClickLeft"
  />
  <div class="coop">
    <el-col :span="10">
      <hr />
      <div
        class="block"
        style="
          display: flex;
          align-items: center;
          justify-content: space-between;
        "
      >
        <div class="info">
          <h3>原神刷图业务有限公司</h3>
          <h4>
            规模：<span>所属行业：<span>主营业务：</span></span>
          </h4>
        </div>
        <div class="avatar-wrapper">
          <el-avatar shape="square" :size="75" :src="squareUrl"
            >公司头像</el-avatar
          >
        </div>
      </div>
      <hr />
    </el-col>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'
import { NavBar } from 'vant'
// 组件逻辑
const router = useRouter()
const onClickLeft = () => {
  router.go(-1)
}
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
.coop {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 750px;
}

.block {
  display: flex;
  align-items: center;
}

.info {
  flex: 1;
  /* 根据需要设置内容的样式 */
}

.avatar-wrapper {
  margin-left: 20px;
  /* 或者根据需要设置其他样式 */
}
</style>
