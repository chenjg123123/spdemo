<script setup>
import { useRouter } from 'vue-router'
import { NavBar } from 'vant'
import { ref, onMounted } from 'vue'
import { getUserInfo, updataById } from '@/api/user.js'
import { useUserStore } from '@/stores'
const router = useRouter()
const imgUrl = ref()
const userStore = useUserStore()
const Info = ref()
const ruleForm = ref({
  imageUrl: [],
  sex: '',
  name: '',
  company: '',
  companyAddress: '',
  phone: '',
  message: ''
})
const formdata = ref({
  id: userStore.userid,
  usex: '',
  avatar: '',
  uname: '',
  uphone: '',
  profile: ''
})
const uploadFile = () => {
  console.log(1234) // 这里添加上传文件逻辑
}
const submitForm = async () => {
  // 添加表单提交逻辑，包括向后端提交图片数据的逻辑
  formdata.value.usex = ruleForm.value.sex
  formdata.value.avatar = ruleForm.value.imageUrl[0]
  formdata.value.uname = ruleForm.value.name
  formdata.value.uphone = ruleForm.value.phone
  formdata.value.profile = ruleForm.value.message
  const res = await updataById(formdata.value)
}

const resetForm = () => {
  // 添加表单重置逻辑
}
const handleAvatarSuccess = (response, uploadFile) => {
  imgUrl.value = URL.createObjectURL(uploadFile.raw)
  ruleForm.value.imageUrl[0] = imgUrl
}

const beforeAvatarUpload = (rawFile) => {
  if (rawFile.type !== 'image/jpeg') {
    ElMessage.error('只能是jpg格式!')
    return false
  } else if (rawFile.size / 1024 / 1024 > 8) {
    ElMessage.error('文件过大!')
    return false
  }
  return true
}

const onClickLeft = () => {
  router.go(-1)
}

const init = async () => {
  const res = await getUserInfo(userStore.userid)
  Info.value = res.data.data
  ruleForm.value.sex = Info.value.Info.usex
  imgUrl.value = Info.value.Info.avatar
  ruleForm.value.name = Info.value.Info.uname
  ruleForm.value.company = Info.value.company.companyName
  ruleForm.value.phone = Info.value.Info.uphone
  ruleForm.value.companyAddress = Info.value.company.companyAddress
  ruleForm.value.message = Info.value.Info.profile
}
//onMounted
onMounted(() => {
  init()
})
</script>
<template>
  <NavBar
    class="bar"
    left-text="返回"
    title="个人信息"
    left-arrow
    :http-request="uploadFile"
    @click-left="onClickLeft"
  />
  <div class="form">
    <el-form
      ref="ruleFormRef"
      :model="ruleForm"
      status-icon
      :rules="rules"
      label-width="120px"
      class="demo-ruleForm"
    >
      <el-form-item label="头像" prop="imageUrl">
        <el-upload
          class="avatar-uploader"
          action="/api/user/upload"
          :show-file-list="false"
          :before-upload="beforeAvatarUpload"
          :on-success="handleAvatarSuccess"
        >
          <img
            v-if="imgUrl"
            :src="imgUrl"
            class="avatar"
            style="width: 178px; height: 178px"
          />
          <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
        </el-upload>
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-select v-model="ruleForm.sex" placeholder="">
          <el-option :label="'男性'" :value="'F'"></el-option>
          <el-option :label="'女性'" :value="'M'"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="昵称" prop="name">
        <el-input v-model="ruleForm.name" />
      </el-form-item>
      <el-form-item label="公司" prop="company">
        <el-input v-model="ruleForm.company" disabled />
      </el-form-item>
      <el-form-item label="公司地址" prop="companyAddress">
        <el-input v-model="ruleForm.companyAddress" disabled />
      </el-form-item>
      <el-form-item label="联系方式" prop="phone">
        <el-input v-model="ruleForm.phone" />
      </el-form-item>
      <el-form-item label="个性签名" prop="message">
        <el-input v-model="ruleForm.message" type="textarea" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm()">Submit</el-button>
        <el-button @click="resetForm()">Reset</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style scoped lang="scss">
.form {
  width: 60%;
  margin: 50px auto 100px auto;
}
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
  width: 178px;
  height: 178px;
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
.avatar-uploader .el-upload-dragger {
  width: 178px;
  height: 178px;
}
</style>
