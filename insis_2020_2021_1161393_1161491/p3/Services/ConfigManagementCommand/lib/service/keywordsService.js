const Keyword = require('../model/keyword');
const keywordRepository = require('../repository/keyword');
const {keywordWithIdExists} = require('../glue/configManagementQueryGlue');
const NoKeywordFoundException = require('../exception/NoKeywordFoundException');

async function saveKeyword(name) {
  const keywordInstance = new Keyword(undefined, name);

  console.log('keyword instance', keywordInstance);

  await keywordRepository.saveKeyword(keywordInstance);
  return keywordInstance;
}

async function updateKeyword(id, name) {
  if (!(await keywordWithIdExists(id))) {
    throw new NoKeywordFoundException();
  }

  const updatedKeyword = new Keyword(id, name);

  await keywordRepository.updateKeyword(updatedKeyword);

  return updatedKeyword;
}

async function deleteKeyword(id) {
  if (!(await keywordWithIdExists(id))) {
    throw new NoKeywordFoundException();
  }

  await keywordRepository.deleteKeyword(id);
}

module.exports = {
  updateKeyword,
  saveKeyword,
  deleteKeyword
}
