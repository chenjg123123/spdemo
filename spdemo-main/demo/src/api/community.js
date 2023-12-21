import request from '@/utils/request.js'
//获取社区信息
export const getAll = () => {
  return request.get('/community/all')
}
//根据ID获取社区
export const getById = (communityId) => {
  return request.get('/community/byCompanyId', {
    params: {
      communityId
    }
  })
}
//返回是否感兴趣
export const getIsCollect = (userId, communityId) => {
  return request.post('/usercollect/isCollect', { userId, communityId })
}
//收藏或者取消收藏
export const collectOrnot = (userId, communityId) => {
  return request.post('/usercollect/collectCommunity', { userId, communityId })
}
