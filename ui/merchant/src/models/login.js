
import { history } from 'umi';
import { login, accountLogout } from '@/services/login';
import { getPageQuery } from '@/utils/utils';
import { setAuthority } from '@/utils/authority';
import { TOKEN_KEY } from '@/utils/token';
import { reloadAuthorized } from '@/utils/Authorized';
import { message } from 'antd';

const Model = {
  namespace: 'login',
  state: {
    status: undefined,
  },
  effects: {
    *login({ payload }, { call, put }) {
      const response = yield call(login, payload);
      yield put({
        type: 'changeLoginStatus',
        payload: response.content,
      });

      if (response.status === 'ok') {
        // 写入令牌
        yield put({
          type: 'user/saveToken',
          payload: response[TOKEN_KEY],
        });
        reloadAuthorized();
        const urlParams = new URL(window.location.href);
        const params = getPageQuery();
        let { redirect } = params;
        message.success('🎉 🎉 🎉  登录成功！');

        if (redirect) {
          const redirectUrlParams = new URL(redirect);

          if (redirectUrlParams.origin === urlParams.origin) {
            redirect = redirect.substr(urlParams.origin.length);

            if (redirect.match(/^\/.*#/)) {
              redirect = redirect.substr(redirect.indexOf('#') + 1);
            }
          } else {
            window.location.href = '/';
            return;
          }
        }

        history.replace(redirect || '/');
      }
    },

    *logout(_, { call, put }) {
      yield call(accountLogout);
      yield put({
        type: 'changeLoginStatus',
        payload: {
          status: false,
          currentAuthority: '-',
        },
      });

      const { redirect } = getPageQuery(); // Note: There may be security issues, please note

      if (window.location.pathname !== '/user/login' && !redirect) {
        history.replace({
          pathname: '/user/login',
          // search: stringify({
          //   redirect: window.location.href,
          // }),
        });
      }
    },
  },
  reducers: {
    changeLoginStatus(state, { payload }) {
      setAuthority(payload.currentAuthority);
      return { ...state, status: payload.status,reason: payload.reason, type: payload.type };
    },
  },
};
export default Model;
