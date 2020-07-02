import request from '@/utils/request'

export default {
  pageList(page, limit, searchObj) {
    return request({
      url: `/business/bill/list/${page}/${limit}`,
      method: 'get',
      params: searchObj
    })
  },

  removeById(id) {
    return request({
      url: `/business/bill/remove/${id}`,
      method: 'delete'
    })
  },

  payment(id){
    return request({
        url: `/business/bill/payment/${id}`,
        method: 'get',
    })
  },

  save(bill) {
    return request({
      url: '/business/bill/save',
      method: 'post',
      data: bill
    })
  },

  getById(id){
    return request({
      url: `/business/bill/get/${id}`,
      method: 'get'
    })
  },

  updateById(bill){
    return request({
      url: '/business/bill/update',
      method: 'put',
      data: bill
    })
  }
}
