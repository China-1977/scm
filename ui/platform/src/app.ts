import { RequestConfig } from 'umi';
import {useRequest} from "@@/plugin-request/request";

export const request: RequestConfig = {
  errorConfig: {
    adaptor: (resData) => {
      return {
        ...resData,
        success: resData.ok,
        errorMessage: resData.message,
      };
    },
  },
};

export async function getInitialState() {
  const data = await useRequest("/platform/plans");
  console.log(data)
  return data;
}
