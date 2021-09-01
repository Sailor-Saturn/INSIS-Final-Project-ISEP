const ApproachModel = require('../model/approach');

function saveApproach(approach) {
  return approach.save();
}

function getAll() {
  return ApproachModel.find({});
}

function getById(id) {
  return ApproachModel.findOne({_id: id})
}

function deleteApproach(id) {
  return ApproachModel.deleteOne({_id: id});
}

module.exports = {
  deleteApproach,
  saveApproach,
  getAll,
  getById
}