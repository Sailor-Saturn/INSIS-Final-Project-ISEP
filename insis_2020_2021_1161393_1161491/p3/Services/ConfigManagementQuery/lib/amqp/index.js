const amqp = require('amqplib');
const {amqpConfig} = require('../../config');
const {setupKeywords} = require('./keywords');
const {setupApproaches} = require('./approaches');
const {setupTechnologies} = require('./technologies');

let connection;
let channel;

async function connect() {
  console.log('rabbitmq config', amqpConfig);
  connection = await amqp.connect(amqpConfig);
  channel = await connection.createChannel();
  await setupKeywords(channel);
  await setupApproaches(channel);
  await setupTechnologies(channel);
}

module.exports = {
  connect
}