import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/ucenter/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/ucenter/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/ucenter/logout',
    method: 'post'
  })
}
