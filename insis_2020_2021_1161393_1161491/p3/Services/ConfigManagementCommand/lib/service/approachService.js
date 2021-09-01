const Approach = require('../model/approach');
const approachRepository = require('../repository/approach');
const {approachWithIdExists} = require('../glue/configManagementQueryGlue');
const NoApproachFoundException = require('../exception/NoApproachFoundException');

async function saveApproach(name) {
  const approachInstance = new Approach(undefined, name);

  await approachRepository.saveApproach(approachInstance);
  return approachInstance;
}

async function updateApproach(id, name) {
  if (!(await approachWithIdExists(id))) {
    throw new NoApproachFoundException();
  }

  const updatedApproach = new Approach(id, name);

  await approachRepository.updateApproach(updatedApproach);

  return updatedApproach;
}

async function deleteApproach(id) {
  if (!(await approachWithIdExists(id))) {
    throw new NoApproachFoundException();
  }

  await approachRepository.deleteApproach(id);
}

module.exports = {
  saveApproach,
  updateApproach,
  deleteApproach
}
