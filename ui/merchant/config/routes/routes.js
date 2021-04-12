import system from './system'

export default [
  {
    path: '/user',
    component: '../layouts/UserLayout',
    routes: [
      {
        name: '登录',
        path: '/user/login',
        component: './User/Login',
      }
    ],
  },
  {
    path: '/',
    component: '../layouts/SecurityLayout',
    routes: [
      {
        path: '/',
        component: '../layouts/BasicLayout',
        routes: [
          {
            path: '/',
            component: './Dashboard/',
          },
          {
            path: '/exception/403',
            component: './Exceptions/403',
          },
          {
            path: '/exception/404',
            component: './Exceptions/404',
          },
          {
            path: '/exception/500',
            component: './Exceptions/500',
          },
          ...system,
          {
            component: './Exceptions/404',
          },
        ],
      },
      {
        component: './Exceptions/404',
      },
    ],
  },
];

