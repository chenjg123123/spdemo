import request from '@/utils/request.js'
//用户注册
export const userRegisterService = (data) => {
  return request.post('/user/register', data)
}
//用户登录
export const userLoginService = (data) => {
  return request.post('/user/login', data)
}
//修改头像
export const userSetHeader = (File) => {
  return request.post('/user/upload', File)
}
//获取收藏业务
export const getCollectByid = (userId) => {
  return request.get('/usercollect/getByUserId', {
    params: {
      userId
    }
  })
}
//获取用户信息
export const getUserInfo = (userId) => {
  return request.get('/user/userByid', {
    params: {
      userId
    }
  })
}
//
export const updataById = (user) => {
  return request.post('/user/update', user)
}
