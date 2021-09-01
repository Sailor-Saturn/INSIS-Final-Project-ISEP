const rc = require('rc');

module.exports = rc('app', {
  port: 3001,
  configManagementQueryURL: 'http://192.168.1.84:3000',
  amqpConfig: {
    protocol: 'amqp',
    hostname: '192.168.1.84',
    port: 5672,
    username: 'guest',
    password: 'guest'
  }
});