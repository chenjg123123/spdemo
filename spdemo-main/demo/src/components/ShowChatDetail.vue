<script setup>
import { ref, onMounted, watch } from 'vue'
import { useUserStore } from '@/stores'
defineProps({
  userName: [String]
})
const scroll = ref(null)
const sendMessageData = ref({
  messageid: '',
  senderid: '',
  content: ''
})
const vLoading = ref(false)
const userStore = useUserStore()
const websocket = ref(null)
const onOpen = () => {
  // WebSocket 连接建立成功的处理
  console.log(userStore.userid)
  console.log('WebSocket 连接已建立')
}
const onClose = () => {
  // WebSocket 连接关闭的处理
  console.log('WebSocket 连接已关闭')
}
const onMessage = (event) => {
  // 处理收到的消息
  console.log('收到消息：', event ? event.data : '无消息')
  if (event) {
    userStore.chat.push(JSON.parse(event.data))
  }
  // 在这里处理接收到的消息并在页面上渲染
}
const onError = (event) => {
  // WebSocket 错误的处理
  console.error('WebSocket 错误', event ? event : '无消息')
}
const sendMessage = () => {
  // 发送消息
  sendMessageData.value.messageid = userStore.messageId
  sendMessageData.value.senderid = userStore.userid
  websocket.value.send(JSON.stringify(sendMessageData.value))
  sendMessageData.value.content = ''
}
const scrollToBottom = async () => {
  const height = ref(10)
  if (userStore.chat) {
    height.value = 94.2 * userStore.chat.length
  }
  if (scroll.value) {
    console.log(height)
    scroll.value.setScrollTop(height.value)
  }
}

onMounted(() => {
  // 这里建立 WebSocket 连接
  console.log(123)
  websocket.value = new WebSocket(
    `ws://localhost:8080/websocket/${userStore.userid}`
  )
  // 监听 WebSocket 的事件
  websocket.value.onopen = (event) => onOpen(event)
  websocket.value.onclose = (event) => onClose(event)
  websocket.value.onmessage = (event) => onMessage(event)
  websocket.value.onerror = (event) => onError(event)
  setTimeout(() => {
    scrollToBottom()
  }, 500)
})
watch(
  () => userStore.chat,
  () => {
    vLoading.value = true
    setTimeout(() => {
      scrollToBottom()
    }, 500)
    vLoading.value = false
  },
  { deep: true }
)
</script>
<template>
  <el-drawer
    :title="userName"
    size="60%"
    style="margin-bottom: 5px"
    v-loading="vLoading"
  >
    <div class="chat">
      <el-scrollbar ref="scroll">
        <div
          :class="{
            chatDetail: true,
            user: item.senderid === userStore.userid,
            oth: item.senderid !== userStore.userid
          }"
          v-for="item in userStore.chat"
          :key="item.createTime"
        >
          <img src="@/assets/backgroud/b1.jpg" />
          <span>{{ item.content }}</span>
        </div>
      </el-scrollbar>
    </div>

    <div class="box">
      <el-input
        v-model="sendMessageData.content"
        :autosize="{ minRows: 4, maxRows: 6 }"
        type="textarea"
      />
      <el-button class="button" type="primary" @click="sendMessage"
        >发送</el-button
      >
    </div>
  </el-drawer>
</template>

<style scoped lang="scss">
.box {
  display: flex;
  position: fixed;
  width: 57%;
  bottom: 10px;

  .el-textarea {
    width: 92%;
  }
}
.chat {
  display: flex;
  flex-direction: column;
  position: relative;
  height: 85%;
  overflow: auto;
  .chatDetail {
    height: 60px;
    margin: 3%;
  }

  img {
    width: 50px;
    height: 50px;
    border-radius: 50%;
    margin: 5px 5px;
  }
  span {
    margin: 5px 10px;
  }
}
.user {
  display: flex;
  justify-content: flex-start;
  background-color: rgb(239, 252, 239);
}

.oth {
  display: flex;
  justify-content: flex-start;
  background: linear-gradient(to right, #ffffff, #f5f5f5);
}
</style>
