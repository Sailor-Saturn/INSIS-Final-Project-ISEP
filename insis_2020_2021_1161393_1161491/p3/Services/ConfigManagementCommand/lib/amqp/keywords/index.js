const {NEW_KEYWORD_EXCHANGE, UPDATE_KEYWORD_EXCHANGE, DELETE_KEYWORD_EXCHANGE} = require('./constants');

const {getChannel} = require('../index');

function publishKeyword(keyword) {
  console.log('publish new keyword', keyword);
  channel = getChannel();
  channel.publish(NEW_KEYWORD_EXCHANGE, '', Buffer.from(JSON.stringify(keyword)));
}

function publishUpdateKeyword(keyword) {
  channel = getChannel();
  channel.publish(UPDATE_KEYWORD_EXCHANGE, '', Buffer.from(JSON.stringify(keyword)));
}

function publishDeleteKeyword(id) {
  channel = getChannel();
  channel.publish(DELETE_KEYWORD_EXCHANGE, '', Buffer.from(JSON.stringify({id})));
}

module.exports = {
  publishKeyword,
  publishUpdateKeyword,
  publishDeleteKeyword
}
