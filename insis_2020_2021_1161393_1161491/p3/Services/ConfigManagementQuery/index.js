const express = require('express');
const app = express();
const {port, mongoURI} = require('./config');
const router = require('./lib/routes');
const mongoose = require('mongoose');
const amqp = require('./lib/amqp');

(async function() {
  app.use(express.json());
  app.use('/', router);

  console.log('mongo connetion string', mongoURI);

  try {
    await mongoose.connect(mongoURI, {useNewUrlParser: true, useUnifiedTopology: true});
  } catch (e) {
    console.log('error connecting to mongo');
    console.log(e);
  }

  await amqp.connect();

  app.listen(port, () => {
    console.log(`Listening in port ${port}`);
  });


})();


