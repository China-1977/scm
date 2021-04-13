import request  from 'umi-request';
import { notification } from 'antd';

export async function login(params) {
  console.log(params)
  return request.post("/merchant/login",{data:params}).then((res)=>{
    console.log(res);
  })
}
export async function getFakeCaptcha(mobile) {
  return request(`/api/login/captcha?mobile=${mobile}`);
}
