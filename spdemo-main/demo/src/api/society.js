import request from '@/utils/request.js'
//获取社区详细信息
export const userInterService = (id) => {
  return request.get('/companies/inter', {
    params: {
      id
    }
  })
}
//获取社区
export const societyList = () => {
  return request.get('/companies/list')
}
//获取分类表
export const getCategoryList = () => {
  return request.get('/category/list')
}
//获取某个分类信息
export const getSocietyByCategoryId = (id) => {
  return request.get('/category/societyById', {
    params: {
      id
    }
  })
}
//关键字搜索
export const searchBykeyForTitle = (title, currentPage, size) => {
  return request.get('/society/stitle', {
    params: {
      title,
      currentPage,
      size
    }
  })
}
//上传新社区
export const uploadSociety = (form) => {
  console.log(form)
  return request.put('/society/upload', form, {
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}
