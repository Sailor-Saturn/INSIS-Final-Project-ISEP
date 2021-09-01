const { v4: uuidv4 } = require('uuid');

class Approach {
  constructor(id, name) {
    if (!id) {
      this.id = uuidv4();
    } else {
      this.id = id;
    }

    this.name = name;
  }
}

module.exports = Approach;
