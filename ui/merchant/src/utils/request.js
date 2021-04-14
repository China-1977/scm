/**
 * request 网络请求工具
 * 更详细的 api 文档: https://github.com/umijs/umi-request
 */
import {extend} from 'umi-request';
import {removeToken} from '@/utils/token';
import {isDifferentRouter} from '@/utils/utils';
import {history} from 'umi';
import {notification} from 'antd';
import React from 'react';
import defaultSettings from "../../config/defaultSettings";

const codeMessage = {
  200: '服务器成功返回请求的数据',
  201: '新建或修改数据成功',
  202: '一个请求已经进入后台排队',
  204: '删除数据成功',
  400: '发出的请求有错误，服务器没有进行新建或修改数据的操作',
  401: '用户没有登录或登录已经超时',
  403: '用户已登录，但是访问是被禁止的',
  404: '发出的请求针对的是不存在的记录，服务器没有进行操作',
  406: '请求的格式不可得',
  410: '请求的资源被永久删除，且不会再得到的',
  422: '当创建一个对象时，发生一个验证错误',
  500: '服务器发生错误，请检查服务器',
  502: '网关错误',
  503: '服务不可用，服务器暂时过载或维护',
  504: '网关超时',
  510: '操作因业务校验不通过被阻止'
};
/**
 * 异常处理程序
 */

export const errorHandler = (error) => {
  const {response = {}, data} = error;
  const {status, statusText} = response;
  const errortext = codeMessage[status] || statusText;

  if (status === 401) {
    notification.error({
      key: `request:error:${status}`,
      // message: `错误代码 ${status}`,
      message: codeMessage["401"],
      description: errortext,
    });
    // 删除cookie
    removeToken();
    if (isDifferentRouter('/user/login')) {
      const search = !history.location.query?.redirect ? `redirect=${window.location.href}` : `redirect=${history.location.query?.redirect}`;
      history.push({pathname: '/user/login', search});
    }
  } else if (status === 510) {
    const description =
      data instanceof Array ? data.map((item) => <div>{item.message}</div>) : data.message;
    notification.warning({
      key: `request:error:${status}`,
      message: `操作失败`,
      description,
    });
  } else if (status === 404) {
    notification.error({
      key: `request:error:${status}`,
      message: errortext,
      description: data.path,
    });
  }else if (status === 403) {
    notification.warn({
      key: `request:error:${status}`,
      message: '暂无此功能操作权限'
      // message:codeMessage[status],
      //description: data.path,
    });
  } else {
    const description =
      data instanceof Array ? data.map((item) => <div>{item.message}</div>) : data.message;

    notification.error({
      key: `request:error:${status}`,
      message: `错误代码 ${status}`,
      description,
    });
  }

  const throwError = new Error(errortext);
  throwError.status = status;
  throwError.data = data;
  throw error;
};
/**
 * 配置request请求时的默认参数
 */
const request = extend({
  prefix: defaultSettings.requestPrefix,
  errorHandler,
  // 默认错误处理
  credentials: 'include', // 默认请求是否带上cookie
  requestType: 'form',
});

// 全局拦截请求，将Moment转换为YYYY-MM-DD HH:mm:ss字符串格式
request.interceptors.request.use((url, options) => {
  const {method, data} = options;
  if (method.toLowerCase() === 'post') {
    if (data) {
      Object.keys(data).forEach((key) => {
        Object.keys(data).forEach(key => {
          // no-underscore-dangle
          if (typeof data[key] === 'object' && data[key]?._isAMomentObject) {
            data[key] = data[key].format('YYYY-MM-DD HH:mm:ss');
          }
          if (data[key] instanceof Array) {
            data[key].forEach((item, idx) => {
              // no-underscore-dangle
              if (typeof item === 'object' && item?._isAMomentObject) {
                data[key][idx] = item.format('YYYY-MM-DD HH:mm:ss');
              }
            })
          }
        });
      })
    }
    return {
      url,
      options: {
        ...options,
        data: data,
      },
    };
  }
  return {url, options};
});

export default request;

