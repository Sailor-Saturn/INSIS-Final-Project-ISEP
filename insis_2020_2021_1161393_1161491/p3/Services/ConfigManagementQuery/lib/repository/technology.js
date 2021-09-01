const TechnologyModel = require('../model/technology');

function saveTechnology(technology) {
  return technology.save();
}

function getAll() {
  return TechnologyModel.find({});
}

function getById(id) {
  return TechnologyModel.findOne({_id: id})
}

function deleteTechnology(id) {
  return TechnologyModel.deleteOne({_id: id});
}

module.exports = {
  deleteTechnology,
  saveTechnology,
  getAll,
  getById
}