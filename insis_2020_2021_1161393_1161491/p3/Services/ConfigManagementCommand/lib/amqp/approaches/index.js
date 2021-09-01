const {NEW_APPROACH_EXCHANGE, UPDATE_APPROACH_EXCHANGE, DELETE_APPROACH_EXCHANGE} = require('./constants');

const {getChannel} = require('../index');

function publishApproach(approach) {
  channel = getChannel();
  channel.publish(NEW_APPROACH_EXCHANGE, '', Buffer.from(JSON.stringify(approach)));
}

function publishUpdateApproach(approach) {
  channel = getChannel();
  channel.publish(UPDATE_APPROACH_EXCHANGE, '', Buffer.from(JSON.stringify(approach)));
}

function publishDeleteApproach(id) {
  channel = getChannel();
  channel.publish(DELETE_APPROACH_EXCHANGE, '', Buffer.from(JSON.stringify({id})));
}

module.exports = {
  publishApproach,
  publishUpdateApproach,
  publishDeleteApproach
}
