<script setup>
import { onMounted, ref } from 'vue'
import { getChatList, getInformList, getInformByID } from '@/api/chat.js'
import { getMessageListById } from '@/api/chat.js'
import { useUserStore } from '@/stores'
const isChat = ref(true)
const showDetail = ref(false)
const showDetailData = ref()
const ShowMessageF = ref(false)
const chatList = ref()
const userStore = useUserStore()
const informList = ref()
// const massageId = ref()
//methods
const handlerChat = async () => {
  isChat.value = true
  const res = await getChatList(userStore.userid)
  chatList.value = res.data.data.list
}
const handleMessage = async () => {
  isChat.value = false
  const res = await getInformList(userStore.userid)
  informList.value = res.data.data.list
}
const handlershowDetail = async (id) => {
  showDetail.value = true
  userStore.messageId = id
  const res = await getMessageListById(id)
  userStore.chat = res.data.data.messagelists
}

const handleshowMessageF = async (informid) => {
  ShowMessageF.value = true
  const res = await getInformByID(informid)
  showDetailData.value = res.data.data.inform
}
const init = async () => {
  const res = await getChatList(userStore.userid)
  chatList.value = res.data.data.list
}
//onMounted
onMounted(() => {
  init()
})
</script>
<template>
  <div class="Header">
    <div :class="{ message: true, active: isChat }" @click="handlerChat()">
      聊天
    </div>
    <div :class="{ chat: true, active: !isChat }" @click="handleMessage()">
      通知
    </div>
  </div>

  <div class="Chat" v-show="isChat">
    <ShowChat
      v-for="item in chatList"
      :key="item.massageId"
      @click="handlershowDetail(item.massageId)"
    >
      <template #username>{{
        item.senderId !== userStore.userid ? item.senderName : item.receiverName
      }}</template>
    </ShowChat>
    <ShowChatDetail v-if="showDetail" v-model="showDetail"></ShowChatDetail>
  </div>
  <div class="Chat" v-show="!isChat">
    <ShowMessage
      v-for="item in informList"
      :key="item.senderName"
      @click="handleshowMessageF(item.informid)"
      :date="item.createTime"
      :title="item.title"
      :content="item.content"
    ></ShowMessage>
    <ShowMessageDetail v-model="ShowMessageF">
      <template #title>{{
        showDetailData ? showDetailData.title : 'test'
      }}</template>
      <template #content>{{
        showDetailData ? showDetailData.content : 'test'
      }}</template>
      <template #time>{{
        showDetailData ? showDetailData.createTime.replace('T', '  ') : 'test1'
      }}</template>
    </ShowMessageDetail>
  </div>

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
