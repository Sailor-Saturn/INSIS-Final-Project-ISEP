const {publishTechnology, publishUpdateTechnology, publishDeleteTechnology} = require('../amqp/technologies');

function deleteTechnology(id) {
  publishDeleteTechnology(id);
}

async function saveTechnology(technology) {
  publishTechnology(technology);
}

async function updateTechnology(technology) {
  publishUpdateTechnology(technology);
}

module.exports = {
  deleteTechnology,
  saveTechnology,
  updateTechnology
}