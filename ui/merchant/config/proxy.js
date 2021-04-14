export default {
  dev: {
    '/merchant/': {
      target: 'http://127.0.0.1:8901',
      changeOrigin: true,
      pathRewrite: {
        '^': '',
      },
    },
  },
  test: {
    '/merchant/': {
      target: 'http://127.0.0.1:8901',
      changeOrigin: true,
      pathRewrite: {
        '^': '',
      },
    },
  },
  pre: {
    '/merchant/': {
      target: 'http://127.0.0.1:8901',
      changeOrigin: true,
      pathRewrite: {
        '^': '',
      },
    },
  },
};
