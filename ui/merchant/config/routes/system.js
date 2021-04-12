export default [
  {
    path: '/system',
    name: '系统设置',
    routes: [
       /* 基础数据-存货分类 */
      { path: '/system/user',name: '用户管理', component: './account/settings' },
    ],
  },
];
