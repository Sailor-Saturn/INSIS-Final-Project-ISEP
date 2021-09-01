const technologyService = require('../service/technologyService');
const TechnologyDTO = require('../dto/technologyDTO');
const TechnologiesDTO = require('../dto/technologiesDTO')

async function getTechnologies(req, res) {
  const technologies = await technologyService.getAllTechnologies();

  res.send(new TechnologiesDTO(technologies));
}

async function getTechnologyById(req, res) {
  const {id} = req.params;

  const technology = await technologyService.getTechnologyById(id);

  if (!technology) {
    res.status(404).end();
    return;
  }

  res.send(new TechnologyDTO(technology));
}

module.exports = {
  getTechnologies,
  getTechnologyById
}
