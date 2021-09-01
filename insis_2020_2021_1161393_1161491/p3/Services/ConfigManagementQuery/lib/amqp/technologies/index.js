const technologyService = require('../../service/technologyService');
const {NEW_TECHNOLOGY_EXCHANGE, UPDATE_TECHNOLOGY_EXCHANGE, DELETE_TECHNOLOGY_EXCHANGE} = require('./constants');

async function setupTechnologies(channel) {
  await setupNewTechnologySubscription(channel);
  await setupUpdateTechnologySubscription(channel);
  await setupDeleteTechnologySubscription(channel);
}

async function setupNewTechnologySubscription(channel) {
  await channel.assertExchange(NEW_TECHNOLOGY_EXCHANGE, 'fanout', {durable: false});
  const q = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(q.queue, NEW_TECHNOLOGY_EXCHANGE, '');
  channel.consume(q.queue, handleNewTechnology);
}

async function setupUpdateTechnologySubscription(channel) {
  await channel.assertExchange(UPDATE_TECHNOLOGY_EXCHANGE, 'fanout', {durable: false});
  const q = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(q.queue, UPDATE_TECHNOLOGY_EXCHANGE, '');
  channel.consume(q.queue, handleTechnologyUpdate);
}

async function setupDeleteTechnologySubscription(channel) {
  await channel.assertExchange(DELETE_TECHNOLOGY_EXCHANGE, 'fanout', {durable: false});
  const q = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(q.queue, DELETE_TECHNOLOGY_EXCHANGE, '');
  channel.consume(q.queue, handleDeleteTechnology);
}

function handleNewTechnology(msg) {
  const {id, name} = JSON.parse(msg.content.toString());
  technologyService.saveTechnology(id, name);
}

function handleTechnologyUpdate(msg) {
  const {id, name} = JSON.parse(msg.content.toString());
  technologyService.updateTechnology(id, name);
}

function handleDeleteTechnology(msg) {
  const {id} = JSON.parse(msg.content.toString());
  technologyService.deleteTechnology(id);
}

module.exports = {
  setupTechnologies
}