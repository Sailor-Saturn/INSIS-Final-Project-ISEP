const rc = require('rc');

module.exports = rc('app', {
  port: 3002,
  mongoURI: 'mongodb://localhost:27018/db',
  amqpConfig: {
    protocol: 'amqp',
    hostname: '192.168.1.84',
    port: 5672,
    username: 'guest',
    password: 'guest'
  }
});