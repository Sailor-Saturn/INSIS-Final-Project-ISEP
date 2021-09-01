const ApproachDTO = require('../dto/approachDTO');

class ApproachesDTO {
  constructor(approaches) {
    this.approaches = [];

    approaches.forEach(approach => {
      this.approaches.push(
        new ApproachDTO(approach)
      );
    });
  }
}

module.exports = ApproachesDTO;
