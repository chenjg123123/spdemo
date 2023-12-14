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
    const userid = ref()
    const messageId = ref()
    const chat = ref()
    return { token, setToken, removeToken, userid, messageId, chat }
  },
  {
    persist: true
  }
)
