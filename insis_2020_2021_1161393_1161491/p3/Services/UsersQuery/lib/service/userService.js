const UserModel = require('../model/user');
const userRepository = require('../repository/userRepository');

async function getUsers() {
  const users = await userRepository.getAll();

  return users;
}

async function getUserById(id) {
  const user = await userRepository.getById(id);

  return user;
}

async function saveUser(id, name, roles, state) {
  const userInstance = new UserModel({_id: id, name, roles, state});

  await userRepository.save(userInstance);
}

async function updateUserName(id, name) {
  const user = await getUserById(id);

  user.name = name;

  await userRepository.save(user);
}

async function updateUserRoles(id, roles) {
  const user = await getUserById(id);

  user.roles = roles;

  await userRepository.save(user);
}

async function updateUserState(id, state) {
  const user = await getUserById(id);

  user.state = state;

  await userRepository.save(user);
}

async function deleteUser(id) {
  await userRepository.deleteUser(id);
}

module.exports = {
  getUsers,
  getUserById,
  saveUser,
  updateUserName,
  updateUserRoles,
  deleteUser,
  updateUserState
}