import { listUserMenus } from '@/services/user';

const etlMenuToAntMenu = (originMenu) => {
  // 匹配外链
  if (originMenu.menuUrl.startsWith('http://') || originMenu.menuUrl.startsWith('https://')) {
    return {
      name: originMenu.name,
      target: '_blank',
      path: originMenu.menuUrl,
      // icon: originMenu.menuIcon || null,
    };
  }
  return {
    name: originMenu.name,
    path: originMenu.menuUrl,
    // icon: originMenu.menuIcon || null,
  };
};

/**
 * @description 将后端菜单树转换为Ant菜单树
 * @param {Array} originMenus
 * @returns {Array}
 */
const etlMenuDatas = (originMenus) => {
  const etlMenus = [];
  originMenus.forEach((originMenu) => {
    // 将后端数据转换成路由数据
    const etlMenu = etlMenuToAntMenu(originMenu);
    // 如果后端数据有下级，则递归处理下级
    if (originMenu.children && originMenu.children.length !== 0) {
      etlMenu.children = etlMenuDatas(originMenu.children);
    }
    etlMenus.push(etlMenu);
  });
  return etlMenus;
};

export default {
  namespace: 'menu',

  state: {
    menuData: [],
  },

  effects: {
    *getMenuData(_, { call, put }) {
      const originalMenuData = yield call(listUserMenus);
      yield put({
        type: 'save',
        payload: { menuData: etlMenuDatas(originalMenuData) },
      });
    },
  },

  reducers: {
    save(state, { payload }) {
      return {
        ...state,
        ...payload,
      };
    },
  },
};
