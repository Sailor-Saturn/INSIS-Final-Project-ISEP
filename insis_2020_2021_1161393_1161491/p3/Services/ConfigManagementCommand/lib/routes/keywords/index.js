const express = require('express');
const router = express.Router();
const keywordsController = require('../../controller/keywordsController');

router.post('/', keywordsController.saveKeyword);
router.put('/:id', keywordsController.updateKeyword);
router.delete('/:id', keywordsController.deleteKeyword);

module.exports = router;

