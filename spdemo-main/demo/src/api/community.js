import request from '@/utils/request.js'
export const getAll = () => {
  return request.get('/community/all')
}
export const getById = (communityId) => {
  return request.get('/community/byCompanyId', {
    params: {
      communityId
    }
  })
}
