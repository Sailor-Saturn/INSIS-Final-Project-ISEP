class UserDTO {
  constructor(user) {
    this.id = user.id;
    this.name = user.name;
    this.roles = user.roles || [];
    this.state = user.state;
  }
}

module.exports = UserDTO;
