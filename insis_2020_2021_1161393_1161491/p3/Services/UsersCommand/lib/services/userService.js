const User = require('../model/user');
const userRepository = require('../repository/userRepository');
const {userWithIdExists} = require('../glue/UserQueryGlue');
const NoUserFoundException = require('../exception/UserNotFoundException');

async function saveUser(name) {
  const userInstance = new User(undefined, name);

  await userRepository.saveUser(userInstance);
  return userInstance;
}

async function deleteUser(id) {
  if (!(await userWithIdExists(id))) {
    throw new NoUserFoundException();
  }

  return userRepository.deleteUser(id);
}

async function updateUserName(id, name) {
  if (!(await userWithIdExists(id))) {
    throw new NoUserFoundException();
  }

  return userRepository.updateUserName(id, name); 
}

async function updateUserRoles(id, roles) {
  if (!(await userWithIdExists(id))) {
    throw new NoUserFoundException();
  }

  return userRepository.updateUserRoles(id, roles); 
}

async function updateUserState(id, state) {
  if (!(await userWithIdExists(id))) {
    throw new NoUserFoundException();
  }

  return userRepository.updateUserState(id, state); 
}

module.exports = {
  deleteUser,
  saveUser,
  updateUserRoles,
  updateUserName,
  updateUserState
}