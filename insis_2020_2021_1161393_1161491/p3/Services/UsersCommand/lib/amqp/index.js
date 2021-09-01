const amqp = require('amqplib');
const {amqpConfig} = require('../../config');
const {NEW_USER_EXCHANGE, DELETE_USER_EXCHANGE, UPDATE_USER_ROLES_EXCHANGE, UPDATE_USER_NAME_EXCHANGE, UPDATE_USER_STATE_EXCHANGE} = require('./constants');

let connection;
let channel;

async function connect() {
  connection = await amqp.connect(amqpConfig);
  channel = await connection.createChannel();
  channel.assertExchange(NEW_USER_EXCHANGE, 'fanout', {durable: false});
}

function publishSaveUser(user) {
  return channel.publish(NEW_USER_EXCHANGE, '', Buffer.from(JSON.stringify(user)));
}

function publishDeleteUser(id) {
  return channel.publish(DELETE_USER_EXCHANGE, '', Buffer.from(JSON.stringify({id})));
}

function publishUpdateUserName(id, name) {
  console.log('sending name', name);
  return channel.publish(UPDATE_USER_NAME_EXCHANGE, '', Buffer.from(JSON.stringify({id, name})));
}

function publishUpdateUserRoles(id, roles) {
  return channel.publish(UPDATE_USER_ROLES_EXCHANGE, '', Buffer.from(JSON.stringify({id, roles})));
}

function publishUpdateUserState(id, state) {
  return channel.publish(UPDATE_USER_STATE_EXCHANGE, '', Buffer.from(JSON.stringify({id, state})));
}

module.exports = {
  connect,
  publishSaveUser,
  publishDeleteUser,
  publishUpdateUserName,
  publishUpdateUserRoles,
  publishUpdateUserState
}