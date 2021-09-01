const rc = require('rc');

module.exports = rc('app', {
  port: 3000,
  mongoURI: 'mongodb://localhost:27017/db',
  amqpConfig: {
    protocol: 'amqp',
    hostname: '192.168.1.84',
    port: 5672,
    username: 'guest',
    password: 'guest'
  }
});