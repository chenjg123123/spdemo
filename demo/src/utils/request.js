import axios from 'axios';
import { ElMessage } from 'element-plus';
import router from '@/router/index.js'; // 使用已经导入的 router
import { useUserStore } from '@/stores';

const userStore = useUserStore();
const baseURL = '/api';
const instance = axios.create({
  baseURL,
  timeout: 10000
});

instance.interceptors.request.use(
  function (config) {
    if (userStore.token) {
      config.headers['Token'] = userStore.token;
    }
    return config;
  },
  function (error) {
    return Promise.reject(error);
  }
);

instance.interceptors.response.use(
  function (response) {
    if (response.data.code === 1 && response.status === 200) {
      if (response.msg) {
        ElMessage({ message: response.msg, type: 'success' });
      }
      // console.log(response);
      return response;
    }
    if (response.data.code === 402) {
      if (response.msg) {
        ElMessage({ message: response.data.msg, type: "error" });
      }
      router.push('/login');
      return Promise.reject(response);
    }
    ElMessage({ message: response.data.msg, type: 'error' });
    return Promise.reject(response);
  },
  function (error) {
    if (error.response && error.response.data) {
      ElMessage({
        message: error.response.data.message || '服务异常',
        type: 'error'
      });
    }
    console.log(error);
    if (error.response?.status === 401) {
      router.push('/login');
    }
    return Promise.reject(error);
  }
);

export default instance;
export { baseURL };
