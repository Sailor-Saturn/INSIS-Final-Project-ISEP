const rc = require('rc');

module.exports = rc('app', {
  port: 3003,
  userQueryURL: 'http://192.168.1.84:3002',
  amqpConfig: {
    protocol: 'amqp',
    hostname: '192.168.1.84',
    port: 5672,
    username: 'guest',
    password: 'guest'
  }
});