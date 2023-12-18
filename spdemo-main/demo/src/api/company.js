import request from '@/utils/request.js'
export const getCompanyById = (companyId) => {
  return request.get('/companies/getId', {
    params: {
      companyId
    }
  })
}
