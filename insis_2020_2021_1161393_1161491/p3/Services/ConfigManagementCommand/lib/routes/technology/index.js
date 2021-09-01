const express = require('express');
const router = express.Router();
const technologyController = require('../../controller/technologyController');

router.post('/', technologyController.saveTechnology);
router.put('/:id', technologyController.updateTechnology);
router.delete('/:id', technologyController.deleteTechnology);

module.exports = router;

