const UserDTO = require('../dto/userDTO');

class UsersDTO {
  constructor(users) {
    this.users = [];

    users.forEach(user => {
      this.users.push(
        new UserDTO(user)
      );
    });
  }
}

module.exports = UsersDTO;
