<script setup>
import { useRouter } from 'vue-router'
// 组件逻辑
const router = useRouter()
import { NavBar } from 'vant'
const onClickLeft = () => {
  router.go(-1)
}
</script>
<template>
  <NavBar
    class="bar"
    left-text="返回"
    left-arrow
    title="公司介绍"
    @click-left="onClickLeft"
  />

  <div class="intro">
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
        <p>原神刷图业务有限公司</p>
        <div style="margin-right: 20px">
          <el-avatar shape="square" :size="75" :src="squareUrl">头像</el-avatar>
        </div>
      </div>
      <hr style="border: 1px dashed #000" />
      <p>公司地址：</p>
      <hr style="border: 1px dashed #000" />
      <p>公司规模：</p>
      <hr style="border: 1px dashed #000" />
      <p>所属行业：</p>
      <hr style="border: 1px dashed #000" />
      <p>主营业务：</p>
      <hr style="border: 1px dashed #000" />
      <p>工作时间：</p>
      <hr style="border: 1px dashed #000" />
      <p>公司介绍：</p>
      <hr style="border: 1px dashed #000" />
      <div>
        <p>公司照片：</p>
        <el-upload
          class="avatar-uploader"
          action="https://jsonplaceholder.typicode.com/posts/"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload"
        >
          <img v-if="imageUrl" :src="imageUrl" class="avatar" />
          <i v-else class="el-icon-plus avatar-uploader-icon">+</i>
        </el-upload>
      </div>
      <hr />
    </el-col>
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
.Title {
  margin: 0 auto;
  font-size: inherit;
  font-weight: inherit;
}

.intro {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 750px;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 100px;
  height: 100px;
  line-height: 100px;
  text-align: center;
}
</style>
