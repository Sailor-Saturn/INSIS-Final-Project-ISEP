const {publishSaveUser, publishDeleteUser, publishUpdateUserName, publishUpdateUserRoles, publishUpdateUserState} = require('../amqp');

function saveUser(user) {
  return publishSaveUser(user);
}

function deleteUser(id) {
  return publishDeleteUser(id);
}

function updateUserName(id, name) {
  return publishUpdateUserName(id, name);
}

function updateUserRoles(id, roles) {
  return publishUpdateUserRoles(id, roles);
}

function updateUserState(id, state) {
  return publishUpdateUserState(id, state);
}

module.exports = {
  saveUser,
  deleteUser,
  updateUserName,
  updateUserRoles,
  updateUserState
}