import { useRequest } from 'ahooks';

export async function plans(params) {
  return useRequest('/api/plans');
}
