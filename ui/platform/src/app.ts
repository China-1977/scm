import {RequestConfig, history} from 'umi';
import {useRequest} from "@@/plugin-request/request";

export const request: RequestConfig = {
  errorConfig: {
    adaptor: (resData) => {
      if (resData.code) {
        switch (resData) {
          case  'SESSION_EXPIRE':
            history.push("/login");
            break;
          default:
            break;
        }
        return {success: false, errorCode: resData.code, errorMessage: resData.message, data: resData.content}
      } else {
        return {success: true, data: resData};
      }
    },
  },
};

export async function getInitialState() {
  const data = await useRequest("/platform/plans");
  console.log(data)
  return data;
}
