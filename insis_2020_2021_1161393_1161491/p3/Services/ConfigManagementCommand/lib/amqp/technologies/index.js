const {NEW_TECHNOLOGY_EXCHANGE, UPDATE_TECHNOLOGY_EXCHANGE, DELETE_TECHNOLOGY_EXCHANGE} = require('./constants');

const {getChannel} = require('../index');

function publishTechnology(technology) {
  channel = getChannel();
  channel.publish(NEW_TECHNOLOGY_EXCHANGE, '', Buffer.from(JSON.stringify(technology)));
}

function publishUpdateTechnology(technology) {
  channel = getChannel();
  channel.publish(UPDATE_TECHNOLOGY_EXCHANGE, '', Buffer.from(JSON.stringify(technology)));
}

function publishDeleteTechnology(id) {
  channel = getChannel();
  channel.publish(DELETE_TECHNOLOGY_EXCHANGE, '', Buffer.from(JSON.stringify({id})));
}

module.exports = {
  publishTechnology,
  publishUpdateTechnology,
  publishDeleteTechnology
}
