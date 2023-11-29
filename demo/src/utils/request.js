import axios from 'axios'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
import { useUserStore } from '@/stores'

const userStore = useUserStore()
const router = useRouter()
const baseURL = '/api'
const instance = axios.create({
  baseURL,
  timeout: 10000
})


instance.interceptors.request.use(
  function (config) {
    if (userStore.token) {
      config.headers['Token'] = userStore.token
    }
    return config
  },
  function (error) {
    // 对请求错误做些什么
    return Promise.reject(error)
  }
)

// 添加响应拦截器
instance.interceptors.response.use(
  function (response) {
    //成功接受
    if (response.data.code === 1 && response.status === 200) {
      ElMessage({ message: response.data.msg, type: 'success' })
      return response
    }
    //失败
    ElMessage({ message: response.data.msg, type: 'error' })
    return Promise.reject(response)
  },
  function (error) {
    // 对响应错误做点什么
    if (error.response && error.response.data) {
      ElMessage({
        message: error.response.data.message || '服务异常',
        type: 'error'
      })
    }
    console.log(error)
    if (error.response?.status === 401) {
      router.push('/login')
    }
    return Promise.reject(error)
  }
)
export default instance
export { baseURL }
