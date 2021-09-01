const amqp = require('amqplib');
const {amqpConfig} = require('../../config');
const {NEW_USER_EXCHANGE, DELETE_USER_EXCHANGE, UPDATE_USER_ROLES_EXCHANGE, UPDATE_USER_NAME_EXCHANGE, UPDATE_USER_STATE, THREE_PROPONENTS_REJECTED} = require('./constants');
const userService = require('../service/userService');

let connection;
let channel;

async function connect() {
  connection = await amqp.connect(amqpConfig);
  channel = await connection.createChannel();
  await setupExchanges();
}

async function setupExchanges() {
  await channel.assertExchange(NEW_USER_EXCHANGE, 'fanout', {durable: false});
  const q = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(q.queue, NEW_USER_EXCHANGE, '');
  channel.consume(q.queue, handleNewUser);

  await channel.assertExchange(DELETE_USER_EXCHANGE, 'fanout', {durable: false});
  const qDelete = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(qDelete.queue, DELETE_USER_EXCHANGE, '');
  channel.consume(qDelete.queue, handleDeleteUser);

  await channel.assertExchange(UPDATE_USER_ROLES_EXCHANGE, 'fanout', {durable: false});
  const qUpdate = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(qUpdate.queue, UPDATE_USER_ROLES_EXCHANGE, '');
  channel.consume(qUpdate.queue, handleUserRolesUpdates);

  await channel.assertExchange(UPDATE_USER_NAME_EXCHANGE, 'fanout', {durable: false});
  const qUpdate2 = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(qUpdate2.queue, UPDATE_USER_NAME_EXCHANGE, '');
  channel.consume(qUpdate2.queue, handleUserNameUpdate);

  await channel.assertExchange(UPDATE_USER_STATE, 'fanout', {durable: false});
  const qUpdate3 = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(qUpdate3.queue, UPDATE_USER_STATE, '');
  channel.consume(qUpdate3.queue, handleUserStateUpdate);

  await channel.assertExchange(THREE_PROPONENTS_REJECTED, 'fanout', {durable: false});
  const qUpdate4 = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(qUpdate4.queue, THREE_PROPONENTS_REJECTED, '');
  channel.consume(qUpdate4.queue, handleRejectedProponents);
}

function handleNewUser(msg) {
  const {id, name, roles, state} = JSON.parse(msg.content.toString());
  userService.saveUser(id, name, roles, state);
}

function handleDeleteUser(msg) {
  const {id} = JSON.parse(msg.content.toString());
  userService.deleteUser(id);
}

function handleUserRolesUpdates(msg) {
  const {id, roles} = JSON.parse(msg.content.toString());
  userService.updateUserRoles(id, roles);
}

function handleUserNameUpdate(msg) {
  const {id, name} = JSON.parse(msg.content.toString());
  userService.updateUserName(id, name);
}

function handleUserStateUpdate(msg) {
  const {id, state} = JSON.parse(msg.content.toString());
  userService.updateUserState(id, state);
}

function handleRejectedProponents(msg) {
  const {id} = JSON.parse(msg.content.toString());
  userService.updateUserState(id, 'inactive');
}

module.exports = {
  connect
}