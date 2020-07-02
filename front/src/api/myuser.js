import request from '@/utils/request'

export default {
  pageList(page, limit, searchObj) {
    return request({
      url: `/user/list/${page}/${limit}`,
      method: 'get',
      params: searchObj
    })
  },

  removeById(id) {
    return request({
      url: `/user/remove/${id}`,
      method: 'delete'
    })
  },

  save(user) {
    return request({
      url: '/user/save',
      method: 'post',
      data: user
    })
  },

  getById(id){
    return request({
      url: `/user/get/${id}`,
      method: 'get'
    })
  },

  updateById(user){
    return request({
      url: '/user/update',
      method: 'put',
      data: user
    })
  }
}
