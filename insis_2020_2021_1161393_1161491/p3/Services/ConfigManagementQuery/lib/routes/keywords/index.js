const express = require('express');
const router = express.Router();
const keywordsController = require('../../controller/keywordsController');

router.get('/', keywordsController.getKeywords);
router.get('/:id', keywordsController.getKeywordById);

module.exports = router;

