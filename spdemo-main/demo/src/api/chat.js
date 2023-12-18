import request from '@/utils/request.js'
//根据用户ID搜索聊天人
export const getChatList = (userid) => {
  return request.get('/messages/messagelist', {
    params: {
      userid
    }
  })
}
//根据用户ID搜索通知
export const getInformList = (userid) => {
  return request.get('/messages/informlist', {
    params: {
      userid
    }
  })
}
//根据informId搜索通知
export const getInformByID = (informid) => {
  return request.get('/messages/informid', {
    params: {
      informid
    }
  })
}
//根据ID搜索聊天记录
export const getMessageListById = (messageid) => {
  return request.get('/messages/messageid', {
    params: {
      messageid
    }
  })
}
//建立聊天
export const chatWithId = (senderId, receiverCompanyId) => {
  return request.post('/messages/buildchat', {
    senderId: senderId,
    receiverCompanyId: receiverCompanyId
  })
}
