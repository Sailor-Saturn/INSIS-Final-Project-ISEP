const TechnologyDTO = require('../dto/technologyDTO');

class TechnologiesDTO {
  constructor(technologies) {
    this.technologies = [];

    technologies.forEach(tech => {
      this.technologies.push(
        new TechnologyDTO(tech)
      );
    });
  }
}

module.exports = TechnologiesDTO;
