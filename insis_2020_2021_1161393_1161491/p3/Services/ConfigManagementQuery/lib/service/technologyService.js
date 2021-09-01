const technologyRepository = require('../repository/technology');
const TechnologyModel = require('../model/technology');

async function getAllTechnologies() {
  const technologies = await technologyRepository.getAll();

  return technologies;
}

async function getTechnologyById(id) {
  const technology = await technologyRepository.getById(id);

  return technology;
}

async function saveTechnology(id, name) {
  const technologyInstance = new TechnologyModel({_id: id, name});

  await technologyRepository.saveTechnology(technologyInstance);
}

async function updateTechnology(id, name) {
  const technologyInstance = new TechnologyModel({_id: id, name});
  technologyInstance.isNew = false;

  await technologyRepository.saveTechnology(technologyInstance);
}

async function deleteTechnology(id) {
  await technologyRepository.deleteTechnology(id);
}

module.exports = {
  getAllTechnologies,
  getTechnologyById,
  saveTechnology,
  updateTechnology,
  deleteTechnology
}
