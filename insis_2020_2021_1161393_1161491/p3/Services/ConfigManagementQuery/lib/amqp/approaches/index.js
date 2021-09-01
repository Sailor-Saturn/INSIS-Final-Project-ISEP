const approachService = require('../../service/approachesService');
const {NEW_APPROACH_EXCHANGE, UPDATE_APPROACH_EXCHANGE, DELETE_APPROACH_EXCHANGE} = require('./constants');

async function setupApproaches(channel) {
  await setupNewApproachSubscription(channel);
  await setupUpdateApproachSubscription(channel);
  await setupDeleteApproachSubscription(channel);
}

async function setupNewApproachSubscription(channel) {
  await channel.assertExchange(NEW_APPROACH_EXCHANGE, 'fanout', {durable: false});
  const q = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(q.queue, NEW_APPROACH_EXCHANGE, '');
  channel.consume(q.queue, handleNewApproach);
}

async function setupUpdateApproachSubscription(channel) {
  await channel.assertExchange(UPDATE_APPROACH_EXCHANGE, 'fanout', {durable: false});
  const q = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(q.queue, UPDATE_APPROACH_EXCHANGE, '');
  channel.consume(q.queue, handleApproachUpdate);
}

async function setupDeleteApproachSubscription(channel) {
  await channel.assertExchange(DELETE_APPROACH_EXCHANGE, 'fanout', {durable: false});
  const q = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(q.queue, DELETE_APPROACH_EXCHANGE, '');
  channel.consume(q.queue, handleDeleteApproach);
}

function handleNewApproach(msg) {
  const {id, name} = JSON.parse(msg.content.toString());
  approachService.saveApproach(id, name);
}

function handleApproachUpdate(msg) {
  const {id, name} = JSON.parse(msg.content.toString());
  approachService.updateApproach(id, name);
}

function handleDeleteApproach(msg) {
  const {id} = JSON.parse(msg.content.toString());
  approachService.deleteApproach(id);
}

module.exports = {
  setupApproaches,
  handleNewApproach,
  handleApproachUpdate,
  handleDeleteApproach
}