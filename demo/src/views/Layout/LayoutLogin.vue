<script setup>
import { ref, watch } from 'vue'
import { userRegisterService, userLoginService } from '@/api/user.js'
import { useRouter } from 'vue-router'
import { User, Lock } from '@element-plus/icons-vue'
const router = useRouter()
const form = ref()
const formModel = ref({
  uphone: '',
  upassword: '',
  reupassword: ''
})
const isRegister = ref(false)
const rules = {
  uphone: [
    { required: true, message: '请输入手机号', trigger: 'blur' },
    {
      pattern: /^1[3456789]\d{9}$/,
      message: '手机号格式错误',
      trigger: 'blur'
    }
  ],
  upassword: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    {
      pattern: /^\S{6,15}$/,
      message: '密码必须是6-15位的非空字符',
      trigger: 'blur'
    }
  ],
  reupassword: [
    { required: true, message: '请再次输入密码', trigger: 'blur' },
    {
      pattern: /^\S{6,15}$/,
      message: '密码必须是6-15位的非空字符',
      trigger: 'blur'
    },
    {
      validator: (rule, value, callback) => {
        if (value != formModel.value.upassword) {
          callback(new Error('两次密码不一样'))
        } else {
          callback()
        }
      },
      trigger: 'blur'
    }
  ]
}
//methods
const onRegister = async () => {
  if (isRegister.value) {
    //行动
    await form.value.validate()
    await userRegisterService(formModel.value)
    isRegister.value = !isRegister.value
  } else {
    isRegister.value = !isRegister.value
  }
}
const onLogin = async () => {
  if (isRegister.value) {
    isRegister.value = !isRegister.value
  } else {
    // 行动
    await form.value.validate()
    await userLoginService(formModel.value)
    router.push('/')
  }
}
watch(isRegister, () => {
  formModel.value.reupassword = ''
})
</script>
<template>
  <div>
    <el-row class="Login">
      <el-col :span="12" class="pic">
        <!-- <img src="../../assets/testpic.jpg" /> -->
      </el-col>
      <el-col :span="12" class="form">
        <h1 v-if="isRegister">注册</h1>
        <h1 v-else>登录</h1>
        <el-form
          :model="formModel"
          autocomplete="off"
          label-width="100px"
          ref="form"
          :rules="rules"
          size="large"
        >
          <el-form-item label="手机号" prop="uphone"
            ><el-input
              v-model="formModel.uphone"
              :prefix-icon="User"
              placeholder="请输入手机号"
            ></el-input
          ></el-form-item>
          <el-form-item label="密码" prop="upassword"
            ><el-input
              v-model="formModel.upassword"
              :prefix-icon="Lock"
              placeholder="请输入密码"
              type="password"
            ></el-input
          ></el-form-item>
          <el-form-item label="确认密码" v-if="isRegister" prop="reupassword"
            ><el-input
              v-model="formModel.reupassword"
              :prefix-icon="Lock"
              placeholder="请再次输入密码"
              type="password"
            ></el-input
          ></el-form-item>
        </el-form>
        <div class="footer">
          <el-button type="primary" @click="onRegister">注册</el-button>
          <el-button type="primary" @click="onLogin">登录</el-button>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<style scoped lang="scss">
.Login {
  height: 100vh;
  background-color: #fff;
  .pic {
    background: url('../../assets/backgroud/testpic.jpg') no-repeat center/
      cover;
    border-radius: 0 20px 20px 0;
  }
  .form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    user-select: none;
    background: url('@/assets/backgroud/b2.jpg') no-repeat center/cover;
    padding: 20px;
  }
  h1 {
    color: #3498db;
  }
  .footer {
    display: flex;
    .el-button {
      width: 30%;
      margin-left: auto;
    }
  }
}
</style>
