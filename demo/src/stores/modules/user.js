import { defineStore } from 'pinia'
import { ref } from 'vue'

//用户模块
export const useUserStore = defineStore(
  'user',
  () => {
    const token = ref('')
    const setToken = (t) => (token.value = t)
    const removeToken = () => {
      token.value = ''
    }

    return { token, setToken, removeToken }
  },
  {
    persist: true
  }
)
