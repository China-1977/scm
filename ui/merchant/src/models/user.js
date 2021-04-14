// import { getUserInfo, getCmds } from '@/services/user';
import { getToken, setToken, removeToken } from '@/utils/token';
import { setAuthority } from '@/utils/authority';

const UserModel = {
  namespace: 'user',
  state: {
    currentUser: {},
    cmds: [],
    token: getToken(),
  },
  effects: {
    *getUserInfo(_, { call, put }) {
      // const currentUser = yield call(getUserInfo);
      // const cmds = yield call(getCmds);
      // yield put({
      //   type: 'saveUserInfo',
      //   payload: { currentUser, cmds },
      // });
    },
  },
  reducers: {
    saveUserInfo(state, { payload }) {
      setAuthority(payload.cmds);
      return {
        ...state,
        ...payload,
      };
    },
    saveToken(state, { payload }) {
      if (payload) {
        setToken(payload);
      } else {
        removeToken();
      }
      return {
        ...state,
        token: payload,
      };
    },
    /* changeNotifyCount(
      state = {
        currentUser: {},
      },
      action,
    ) {
      return {
        ...state,
        currentUser: {
          ...state.currentUser,
          notifyCount: action.payload.totalCount,
          unreadCount: action.payload.unreadCount,
        },
      };
    }, */
  },
};
export default UserModel;
