const KeywordDTO = require('../dto/keywordDTO');

class KeywordsDTO {
  constructor(keywords) {
    this.keywords = [];

    keywords.forEach(keyword => {
      this.keywords.push(
        new KeywordDTO(keyword)
      );
    });
  }
}

module.exports = KeywordsDTO;
