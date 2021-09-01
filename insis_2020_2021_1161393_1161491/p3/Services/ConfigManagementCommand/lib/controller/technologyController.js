const technologyService = require('../service/technologyService');
const NoTechnologyFoundException = require('../exception/NoTechnologyFoundException');
const TechnologyDTO = require('../dto/technologyDTO');

async function saveTechnology(req, res) {
  const {name} = req.body;

  try {
    const createdTechnology = await technologyService.saveTechnology(name);
    const dto = new TechnologyDTO(createdTechnology);

    res.status(201).send(dto);
    return;
  } catch (e) {
    console.log(e);

    res.status(500).end();
    return;
  }

}

async function updateTechnology(req, res) {
  const {id} = req.params;
  const {name} = req.body;

  try {
    const updatedKeyword = await technologyService.updateTechnology(id, name);
    const dto = new TechnologyDTO(updatedKeyword);
    res.status(200).send(dto);
    return;
  } catch (e) {
    console.log(e);

    if (e instanceof NoTechnologyFoundException) {
      res.status(404).end();
      return;
    }

    res.status(500).end();
    return;
  }

}

async function deleteTechnology(req, res) {
  const {id} = req.params;

  try {
    await technologyService.deleteTechnology(id);
    res.status(204).end();
    return;
  } catch (e) {
    console.log(e);
    
    if (e instanceof NoTechnologyFoundException) {
      res.status(404).end();
      return;
    }

    return res.status(500).end();
  }

}

module.exports = {
  saveTechnology,
  updateTechnology,
  deleteTechnology
}
