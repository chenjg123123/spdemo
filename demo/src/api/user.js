import request from '@/utils/request.js'
//用户注册
export const userRegisterService = (data) => {
  return request.post('/user/register', data)
}
//用户登录
export const userLoginService = (data) => {
  return request.post('/user/login', data)
}
//获取搜索分类
export const userInterService = (id) => {
  return request.get('/companies/inter', {
    params: {
      id
    }
  })
}