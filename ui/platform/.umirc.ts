import {defineConfig} from 'umi';

export default defineConfig({
  nodeModulesTransform: {
    type: 'none',
  },
  antd: {},
  layout: {
    name: '供应链平台',
    locale: true,
  },
  routes: [
    {
      path: '/plans',
      name: '计划管理',
      icon: 'dashboard',
      routes: [
        {
          path: '/plans/list',
          name: '计划列表',
          icon: 'dashboard',
          component: '@/pages/Plan/List',
        }
      ],
    },
    {
      path: '/orders',
      name: '订单管理',
      icon: 'dashboard',
      routes: [
        {
          path: '/orders/list',
          name: '订单列表',
          icon: 'dashboard',
          component: '@/pages/Order/List',
        }
      ],
    },
    {
      path: '/products',
      name: '产品管理',
      icon: 'dashboard',
      routes: [
        {
          path: '/products/list',
          name: '产品列表',
          icon: 'dashboard',
          component: '@/pages/Product/List',
        }
      ],
    },
    {
      path: '/deliveries',
      name: '交付管理',
      icon: 'dashboard',
      routes: [
        {
          path: '/deliveries/list',
          name: '交付列表',
          icon: 'dashboard',
          component: '@/pages/Delivery/List',
        }
      ],
    },
    {
      path: '/merchants',
      name: '商户管理',
      icon: 'dashboard',
      routes: [
        {
          path: '/merchants/list',
          name: '商户列表',
          icon: 'dashboard',
          component: '@/pages/Merchant/List',
        }
      ],
    },
    {
      path: '/users',
      name: '用户管理',
      icon: 'dashboard',
      routes: [
        {
          path: '/users/list',
          name: '用户列表',
          icon: 'dashboard',
          component: '@/pages/User/List',
        }
      ],
    },
  ],
  fastRefresh: {},
  proxy: {
    '/platform': {
      'target': 'http://localhost:8902/platform',
      'changeOrigin': true,
      'pathRewrite': { '^/platform' : '' },
    },
  },

  request : {
    dataField: '',
  }
});
