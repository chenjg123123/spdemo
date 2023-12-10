<script setup>
import { ref } from 'vue'

const isChat = ref(true)
const showDetail = ref(false)
const ShowMessageF = ref(false)
//methods
const handlerChat = (bool) => {
  isChat.value = bool
}
</script>
<template>
  <div class="Header">
    <div :class="{ message: true, active: isChat }" @click="handlerChat(true)">
      聊天
    </div>
    <div :class="{ chat: true, active: !isChat }" @click="handlerChat(false)">
      通知
    </div>
  </div>

  <div class="Chat" v-if="isChat">
    <ShowChat v-for="index in 5" @click="showDetail = true"></ShowChat>
  </div>
  <div class="Chat" v-if="!isChat">
    <ShowMessage v-for="index in 8" @click="ShowMessageF = true"></ShowMessage>
  </div>
  <ShowChatDetail v-model="showDetail"></ShowChatDetail>
  <ShowMessageDetail v-model="ShowMessageF"></ShowMessageDetail>
  <div class="Message"></div>
</template>
<style scoped lang="scss">
.Header {
  position: fixed;
  display: flex;
  background: #ede9e9;
  width: 100%;
  padding: 0;
  top: 0;
  left: 0;
  right: 0;
  font-weight: 100;
  z-index: 50;
  border-bottom: 1px solid black;
  // top: 0%;
  .message {
    width: 50%;
    text-align: center;
    font-size: 50px;
    border-right: 1px;
  }
  .chat {
    width: 50%;
    text-align: center;
    font-size: 50px;
  }
}
.Chat {
  width: 100%;
  margin: 80px 0;
  position: relative;
  height: 80%;
}
.active {
  color: rgb(136, 204, 240);
}
</style>
