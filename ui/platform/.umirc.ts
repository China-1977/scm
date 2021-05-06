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
  qiankun: {
    master: {
      apps: [
        {
          name: 'app1', // 唯一 id
          entry: '//localhost:7001', // html entry
        },
        {
          name: 'app2', // 唯一 id
          entry: '//localhost:7002', // html entry
        },
      ],
    },
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
          component: '@/pages/index',
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
          component: '@/pages/index',
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
          component: '@/pages/index',
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
          component: '@/pages/index',
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
          component: '@/pages/index',
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
          component: '@/pages/index',
        }
      ],
    },
  ],
  fastRefresh: {},
});
