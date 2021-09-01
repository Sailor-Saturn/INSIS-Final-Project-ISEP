const approachService = require('../service/approachService');
const NoApproachFoundException = require('../exception/NoApproachFoundException');
const ApproachDTO = require('../dto/approachDTO');

async function saveApproach(req, res) {
  const {name} = req.body;

  try {
    const createdApproach = await approachService.saveApproach(name);
    const dto = new ApproachDTO(createdApproach);

    res.status(201).send(dto);
    return;
  } catch (e) {
    console.log(e);

    res.status(500).end();
    return;
  }

}

async function updateApproach(req, res) {
  const {id} = req.params;
  const {name} = req.body;

  try {
    const updatedApproach = await approachService.updateApproach(id, name);
    const dto = new ApproachDTO(updatedApproach);
    res.status(200).send(dto);
    return;
  } catch (e) {
    if (e instanceof NoApproachFoundException) {
      res.status(404).end();
      return;
    }

    res.status(500).end();
    return;
  }

}

async function deleteApproach(req, res) {
  const {id} = req.params;

  try {
    await approachService.deleteApproach(id);
    res.status(204).end();
    return;
  } catch (e) {
    console.log(e);

    if (e instanceof NoApproachFoundException) {
      res.status(404).end();
      return;
    }

    return res.status(500).end();
  }

}

module.exports = {
  saveApproach,
  updateApproach,
  deleteApproach
}
