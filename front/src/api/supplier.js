import request from '@/utils/request'

export default {

  listAll(){
    return request({
      url: `/business/supplier/listAll`,
      method: 'get'
    })
  },

  pageList(page, limit, searchObj) {
    return request({
      url: `/business/supplier/list/${page}/${limit}`,
      method: 'get',
      params: searchObj
    })
  },

  removeById(id) {
    return request({
      url: `/business/supplier/remove/${id}`,
      method: 'delete'
    })
  },

  save(supplier) {
    return request({
      url: '/business/supplier/save',
      method: 'post',
      data: supplier
    })
  },

  getById(id){
    return request({
      url: `/business/supplier/get/${id}`,
      method: 'get'
    })
  },

  updateById(supplier){
    return request({
      url: '/business/supplier/update',
      method: 'put',
      data: supplier
    })
  }
}
