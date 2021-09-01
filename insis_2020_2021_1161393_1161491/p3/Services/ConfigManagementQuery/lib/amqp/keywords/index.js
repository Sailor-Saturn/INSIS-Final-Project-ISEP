const keywordService = require('../../service/keywordsService');
const {NEW_KEYWORD_EXCHANGE, UPDATE_KEYWORD_EXCHANGE, DELETE_KEYWORD_EXCHANGE} = require('./constants');

async function setupKeywords(channel) {
  await setupNewKeywordSubscription(channel);
  await setupUpdateKeywordSubscription(channel);
  await setupDeleteKeywordSubscription(channel);
}

async function setupNewKeywordSubscription(channel) {
  await channel.assertExchange(NEW_KEYWORD_EXCHANGE, 'fanout', {durable: false});
  const q = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(q.queue, NEW_KEYWORD_EXCHANGE, '');
  channel.consume(q.queue, handleNewKeyword);
}

async function setupUpdateKeywordSubscription(channel) {
  await channel.assertExchange(UPDATE_KEYWORD_EXCHANGE, 'fanout', {durable: false});
  const q = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(q.queue, UPDATE_KEYWORD_EXCHANGE, '');
  channel.consume(q.queue, handleKeywordUpdate);
}

async function setupDeleteKeywordSubscription(channel) {
  await channel.assertExchange(DELETE_KEYWORD_EXCHANGE, 'fanout', {durable: false});
  const q = await channel.assertQueue('', {exclusive: true});
  await channel.bindQueue(q.queue, DELETE_KEYWORD_EXCHANGE, '');
  channel.consume(q.queue, handleDeleteKeyword);
}

function handleNewKeyword(msg) {
  console.log('new keyword...', msg);
  console.log('new keyword...', msg.content);
  const {id, name} = JSON.parse(msg.content.toString());
  keywordService.saveKeyword(id, name);
}

function handleKeywordUpdate(msg) {
  const {id, name} = JSON.parse(msg.content.toString());
  keywordService.updateKeyword(id, name);
}

function handleDeleteKeyword(msg) {
  const {id} = JSON.parse(msg.content.toString());
  keywordService.deleteKeyword(id);
}

module.exports = {
  setupKeywords,
  handleNewKeyword,
  handleKeywordUpdate,
  handleDeleteKeyword
}