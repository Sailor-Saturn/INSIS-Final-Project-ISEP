const keywordsService = require('../service/keywordsService');
const NoKeywordFoundException = require('../exception/NoKeywordFoundException');
const KeywordDTO = require('../dto/keywordDTO');

async function saveKeyword(req, res) {
  const {name} = req.body;

  try {
    console.log('saving keyword with name', name);

    const createdKeyword = await keywordsService.saveKeyword(name);
    const dto = new KeywordDTO(createdKeyword);

    res.status(201).send(dto);
    return;
  } catch (e) {
    console.log(e);

    res.status(500).end();
    return;
  }

}

async function updateKeyword(req, res) {
  const {id} = req.params;
  const {name} = req.body;

  try {
    const updatedKeyword = await keywordsService.updateKeyword(id, name);
    const dto = new KeywordDTO(updatedKeyword);
    res.status(200).send(dto);
    return;
  } catch (e) {
    console.log(e);

    if (e instanceof NoKeywordFoundException) {
      res.status(404).end();
      return;
    }

    res.status(500).end();
    return;
  }

}

async function deleteKeyword(req, res) {
  const {id} = req.params;

  try {
    await keywordsService.deleteKeyword(id);
    res.status(204).end();
    return;
  } catch (e) {
    console.log(e);

    if (e instanceof NoKeywordFoundException) {
      res.status(404).end();
      return;
    }

    return res.status(500).end();
  }

}

module.exports = {
  updateKeyword,
  saveKeyword,
  deleteKeyword
}
