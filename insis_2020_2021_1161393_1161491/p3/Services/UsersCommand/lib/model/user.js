const { v4: uuidv4 } = require('uuid');

class User {
  constructor(id, name) {
    if (!id) {
      this.id = uuidv4();
    } else {
      this.id = id;
    }
    this.name = name;

    this.roles = [];
    this.state = 'active';
  }
}

module.exports = User;
