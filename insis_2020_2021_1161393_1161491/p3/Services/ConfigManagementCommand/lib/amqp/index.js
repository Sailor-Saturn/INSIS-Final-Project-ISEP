const amqp = require('amqplib');
const {amqpConfig} = require('../../config');
const {NEW_KEYWORD_EXCHANGE, UPDATE_KEYWORD_EXCHANGE, DELETE_KEYWORD_EXCHANGE} = require('./keywords/constants');
const {NEW_APPROACH_EXCHANGE, UPDATE_APPROACH_EXCHANGE, DELETE_APPROACH_EXCHANGE} = require('./approaches/constants');
const {NEW_TECHNOLOGY_EXCHANGE, UPDATE_TECHNOLOGY_EXCHANGE, DELETE_TECHNOLOGY_EXCHANGE} = require('./technologies/constants');

let connection;
let channel;

async function connect() {
  console.log('amqp config', amqpConfig);
  try {
    connection = await amqp.connect(amqpConfig);
    await createChannel();
  } catch (e) {
    console.log(e);
  }
}

async function createChannel() {
  channel = await connection.createChannel();
  channel.assertExchange(NEW_KEYWORD_EXCHANGE, 'fanout', {durable: false});
  channel.assertExchange(UPDATE_KEYWORD_EXCHANGE, 'fanout', {durable: false});
  channel.assertExchange(DELETE_KEYWORD_EXCHANGE, 'fanout', {durable: false});

  channel.assertExchange(NEW_APPROACH_EXCHANGE, 'fanout', {durable: false});
  channel.assertExchange(UPDATE_APPROACH_EXCHANGE, 'fanout', {durable: false});
  channel.assertExchange(DELETE_APPROACH_EXCHANGE, 'fanout', {durable: false});

  channel.assertExchange(NEW_TECHNOLOGY_EXCHANGE, 'fanout', {durable: false});
  channel.assertExchange(UPDATE_TECHNOLOGY_EXCHANGE, 'fanout', {durable: false});
  channel.assertExchange(DELETE_TECHNOLOGY_EXCHANGE, 'fanout', {durable: false});
}

function getChannel() {
  return channel;
}

module.exports = {
  connect,
  getChannel
}