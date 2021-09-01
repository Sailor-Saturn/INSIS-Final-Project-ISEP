const keywordsService = require('../service/keywordsService');
const KeywordDTO = require('../dto/keywordDTO');
const KeywordsDTO = require('../dto/keywordsDTO')

async function getKeywords(req, res) {
  const keywords = await keywordsService.getAllKeywords();

  res.send(new KeywordsDTO(keywords));
}

async function getKeywordById(req, res) {
  const {id} = req.params;

  const keyword = await keywordsService.getKeywordById(id);

  if (!keyword) {
    res.status(404).end();
    return;
  }

  res.send(new KeywordDTO(keyword));
}

module.exports = {
  getKeywords,
  getKeywordById
}
