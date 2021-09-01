const approachRepository = require('../repository/approach');
const ApproachModel = require('../model/approach');

async function getAllApproaches() {
  const approaches = await approachRepository.getAll();

  return approaches;
}

async function getApproachById(id) {
  const approach = await approachRepository.getById(id);

  return approach;
}

async function saveApproach(id, name) {
  const approachInstance = new ApproachModel({_id: id, name});

  await approachRepository.saveApproach(approachInstance);
}

async function updateApproach(id, name) {
  const approachInstance = new ApproachModel({_id: id, name});
  approachInstance.isNew = false;

  await approachRepository.saveApproach(approachInstance);
}

async function deleteApproach(id) {
  await approachRepository.deleteApproach(id);
}

module.exports = {
  getAllApproaches,
  getApproachById,
  saveApproach,
  updateApproach,
  deleteApproach
}
