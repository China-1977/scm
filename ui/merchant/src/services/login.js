import request from '@/utils/request';

export async function login(params) {
  return request('/merchant/login', {
    method: 'POST',
    data: params,
  });
}
export async function accountLogout() {
  return request('/merchant/logout', {
    method: 'POST',
  });
}

export async function getFakeCaptcha() {
  return null;
}
