const keywordRepository = require('../repository/keyword');
const KeywordModel = require('../model/keyword');

async function getAllKeywords() {
  const keywords = await keywordRepository.getAll();

  return keywords;
}

async function getKeywordById(id) {
  const keyword = await keywordRepository.getById(id);

  return keyword;
}

async function saveKeyword(id, name) {
  const keywordInstance = new KeywordModel({_id: id, name});

  await keywordRepository.saveKeyword(keywordInstance);
}

async function updateKeyword(id, name) {
  const keywordInstance = new KeywordModel({_id: id, name});
  keywordInstance.isNew = false;

  await keywordRepository.saveKeyword(keywordInstance);
}

async function deleteKeyword(id) {
  await keywordRepository.deleteKeyword(id);
}

module.exports = {
  getAllKeywords,
  getKeywordById,
  saveKeyword,
  updateKeyword,
  deleteKeyword
}
