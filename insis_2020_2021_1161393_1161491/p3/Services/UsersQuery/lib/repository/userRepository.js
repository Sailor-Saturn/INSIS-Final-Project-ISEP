const UserModel = require('../model/user');

function save(user) {
  return user.save();
}

function getAll() {
  return UserModel.find({});
}

function getById(id) {
  return UserModel.findOne({_id: id})
}

function deleteUser(id) {
  return UserModel.deleteOne({_id: id});
}

module.exports = {
  save,
  getAll,
  getById,
  deleteUser
}
