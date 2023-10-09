const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function (app) {
  // Replace 'http://localhost:8080' with the actual URL of your backend server
  app.use(
    '/api',
    createProxyMiddleware({
      target: 'http://localhost:8080',
      changeOrigin: true,
    })
  );
};