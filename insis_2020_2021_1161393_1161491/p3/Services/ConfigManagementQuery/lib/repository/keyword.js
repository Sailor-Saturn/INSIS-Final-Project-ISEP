const KeywordModel = require('../model/keyword');

function saveKeyword(keyword) {
  return keyword.save();
}

function getAll() {
  return KeywordModel.find({});
}

function getById(id) {
  return KeywordModel.findOne({_id: id})
}

function deleteKeyword(id) {
  return KeywordModel.deleteOne({_id: id});
}

module.exports = {
  deleteKeyword,
  saveKeyword,
  getAll,
  getById
}