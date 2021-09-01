const {publishApproach, publishUpdateApproach, publishDeleteApproach} = require('../amqp/approaches');

function deleteApproach(id) {
  publishDeleteApproach(id);
}

async function saveApproach(approach) {
  publishApproach(approach);
}

async function updateApproach(approach) {
  publishUpdateApproach(approach);
}

module.exports = {
  saveApproach,
  updateApproach,
  deleteApproach
}