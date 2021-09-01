const Technology = require('../model/technology');
const technologyRepository = require('../repository/technology');
const {technologyWithIdExists} = require('../glue/configManagementQueryGlue');
const NoTechnologyFoundException = require('../exception/NoTechnologyFoundException');

async function saveTechnology(name) {
  const technologyInstance = new Technology(undefined, name);

  await technologyRepository.saveTechnology(technologyInstance);
  return technologyInstance;
}

async function updateTechnology(id, name) {
  if (!(await technologyWithIdExists(id))) {
    throw new NoTechnologyFoundException();
  }

  const updatedTechnology = new Technology(id, name);

  await technologyRepository.updateTechnology(updatedTechnology);

  return updatedTechnology;
}

async function deleteTechnology(id) {
  if (!(await technologyWithIdExists(id))) {
    throw new NoTechnologyFoundException();
  }

  await technologyRepository.deleteTechnology(id);
}

module.exports = {
  updateTechnology,
  saveTechnology,
  deleteTechnology
}
