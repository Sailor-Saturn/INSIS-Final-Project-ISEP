const approachesService = require('../service/approachesService');
const ApproachDTO = require('../dto/approachDTO');
const ApproachesDTO = require('../dto/approachesDTO')

async function getApproaches(req, res) {
  const approaches = await approachesService.getAllApproaches();

  res.send(new ApproachesDTO(approaches));
}

async function getApproachById(req, res) {
  const {id} = req.params;

  const approach = await approachesService.getApproachById(id);

  if (!approach) {
    res.status(404).end();
    return;
  }

  res.send(new ApproachDTO(approach));
}

module.exports = {
  getApproaches,
  getApproachById
}
