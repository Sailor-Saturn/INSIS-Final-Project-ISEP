const userService = require('../service/userService');
const UsersDTO = require('../dto/usersDTO');
const UserDTO = require('../dto/userDTO');

async function getAllUsers(req, res) {
  const users = await userService.getUsers();

  res.send(new UsersDTO(users));
}

async function getUserById(req, res) {
  const {id} = req.params;

  const user = await userService.getUserById(id);

  if (!user) {
    res.status(404).end();
    return;
  }

  res.send(new UserDTO(user));
}

module.exports = {
  getAllUsers,
  getUserById
}