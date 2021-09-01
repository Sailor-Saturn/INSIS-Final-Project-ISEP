const express = require('express');
const app = express();
const {port} = require('./config');
const router = require('./lib/routes');
const amqp = require('./lib/amqp');

(async function() {
  app.use(express.json());
  app.use('/', router);

  await amqp.connect();

  app.listen(port, () => {
    console.log(`Listening in port ${port}`);
  });
})();

