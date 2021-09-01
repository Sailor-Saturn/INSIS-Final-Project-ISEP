const express = require('express');
const router = express.Router();
const technologiesController = require('../../controller/technologyController');

router.get('/', technologiesController.getTechnologies);
router.get('/:id', technologiesController.getTechnologyById);

module.exports = router;

