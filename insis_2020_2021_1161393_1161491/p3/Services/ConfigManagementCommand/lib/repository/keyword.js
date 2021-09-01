const {publishKeyword, publishUpdateKeyword, publishDeleteKeyword} = require('../amqp/keywords');

function deleteKeyword(id) {
  publishDeleteKeyword(id);
}

async function saveKeyword(keyword) {
  publishKeyword(keyword);
}

async function updateKeyword(keyword) {
  publishUpdateKeyword(keyword);
}

module.exports = {
  saveKeyword,
  updateKeyword,
  deleteKeyword
}