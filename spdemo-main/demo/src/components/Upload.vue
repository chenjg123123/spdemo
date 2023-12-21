<script setup>
import { ref, onMounted } from 'vue'
import { useUserStore } from '@/stores/index.js'
import { getCategoryList, uploadSociety } from '@/api/society.js'
const prop = defineProps({
  method1: [Function]
})
const imgUrl = ref([])
const categoryList = ref()
const userStore = useUserStore()
const formDataRef = ref({
  userid: userStore.userid,
  imageFile: [],
  title: '',
  content: '',
  categoryid: ''
})
const formData = ref({
  userid: userStore.userid,
  imageFile: [],
  title: '',
  content: '',
  categoryid: ''
})
//methods
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
const uploadFile = async (item, index) => {
  imgUrl.value[index] = URL.createObjectURL(item.raw)
  formData.value.imageFile[index] = item.raw
  console.log(123)
}
const upload = async () => {
  console.log(formDataRef.value, formData.value)
  if (
    !formData.value.userid ||
    !formData.value.title ||
    !formData.value.content ||
    !formData.value.categoryid
  ) {
    return
  }
  var flag = false
  for (let i = 0; i < 4; i++) {
    if (formData.value.imageFile[i]) {
      flag = true
    }
  }
  if (!flag) {
    console.log(654)
    return
  }
  const FORM_DATA = new FormData()
  FORM_DATA.append('userid', formData.value.userid)
  FORM_DATA.append('title', formData.value.title)
  FORM_DATA.append('content', formData.value.content)
  FORM_DATA.append('categoryid', formData.value.categoryid)

  // // 逐个添加图片
  // for (let i = 0; i < 4; i++) {
  //   if (formData.value.imageFile[i]) {
  //     FORM_DATA.append(`image${i}`, formData.value.imageFile[i])
  //   }
  // }
  for (let i = 0; i < 4; i++) {
    FORM_DATA.append('imageFile', formData.value.imageFile[i])
  }
  console.log(FORM_DATA)
  const res = await uploadSociety(FORM_DATA)
  if (res.data.code === 1) {
    ElMessage.success(res.data.msg)
  }
  prop.method1()
}

const getCategory = async () => {
  const res = await getCategoryList()
  categoryList.value = res.data.data.categoryList
}
//
onMounted(() => {
  getCategory()
})
</script>
<template>
  <el-dialog title="添加" width="60%">
    <el-form label-width="60px" ref="formDataRef" :model="formData">
      <el-form-item label="图片" style="display: flex">
        <el-upload
          class="avatar-uploader"
          :show-file-list="false"
          :before-upload="beforeAvatarUpload"
          action="#"
          auto-upload="false"
          :on-change="
            (item) => {
              uploadFile(item, 0)
            }
          "
        >
          <!-- action="/api/user/upload" -->
          <!-- :on-success="handleAvatarSuccess" -->

          <img
            v-if="imgUrl[0]"
            :src="imgUrl[0]"
            class="avatar"
            style="width: 178px; height: 178px"
          />
          <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
        </el-upload>
        <el-upload
          class="avatar-uploader"
          :show-file-list="false"
          :before-upload="beforeAvatarUpload"
          auto-upload="false"
          action="#"
          :on-change="
            (item) => {
              uploadFile(item, 1)
            }
          "
        >
          <!-- action="/api/user/upload" -->
          <!-- :on-success="handleAvatarSuccess" -->

          <img
            v-if="imgUrl[1]"
            :src="imgUrl[1]"
            class="avatar"
            style="width: 178px; height: 178px"
          />
          <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
        </el-upload>

        <el-upload
          class="avatar-uploader"
          :show-file-list="false"
          :before-upload="beforeAvatarUpload"
          auto-upload="false"
          action="#"
          :on-change="
            (item) => {
              uploadFile(item, 2)
            }
          "
        >
          <!-- action="/api/user/upload" -->
          <!-- :on-success="handleAvatarSuccess" -->

          <img
            v-if="imgUrl[2]"
            :src="imgUrl[2]"
            class="avatar"
            style="width: 178px; height: 178px"
          />
          <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
        </el-upload>
        <el-upload
          class="avatar-uploader"
          :show-file-list="false"
          :before-upload="beforeAvatarUpload"
          auto-upload="false"
          action="#"
          :on-change="
            (item) => {
              uploadFile(item, 3)
            }
          "
        >
          <!-- action="/api/user/upload" -->
          <!-- :on-success="handleAvatarSuccess" -->

          <img
            v-if="imgUrl[3]"
            :src="imgUrl[3]"
            class="avatar"
            style="width: 178px; height: 178px"
          />
          <el-icon v-else class="avatar-uploader-icon"
            ><Plus
          /></el-icon> </el-upload
      ></el-form-item>
      <el-form-item label="标题" prop="title">
        <el-input
          v-model="formData.title"
          placeholder="请输入标题"
          :style="{ width: '400px' }"
        ></el-input
      ></el-form-item>
      <el-form-item label="内容" prop="content">
        <el-input
          type="textarea"
          :rows="12"
          placeholder="请输入内容"
          v-model="formData.content"
          :style="{ width: '400px', verticalAlign: 'top' }"
      /></el-form-item>
      <el-form-item label="分类" prop="categoryid"
        ><el-select v-model="formData.categoryid" placeholder="请选择">
          <el-option
            v-for="item in categoryList"
            :key="item.categoryid"
            :label="item.categoryname"
            :value="item.categoryid"
          >
          </el-option>
          <!-- <el-option :label="'男性'" :value="'F'"></el-option>
          <el-option :label="'女性'" :value="'M'"></el-option>  -->
        </el-select></el-form-item
      >
      <el-form-item>
        <el-button @click="handlecancle">取消</el-button>
        <el-button type="primary" @click="upload">上传</el-button>
      </el-form-item>
    </el-form>
    <!-- <el-button @click="dialogVisible = true">取消</el-button> -->
  </el-dialog>
</template>

<style lang="scss" scoped>
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
.avatar {
  margin: auto;
}
</style>
