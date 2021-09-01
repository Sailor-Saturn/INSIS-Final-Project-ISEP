const express = require('express');
const router = express.Router();
const approachesController = require('../../controller/approachesController');

router.get('/', approachesController.getApproaches);
router.get('/:id', approachesController.getApproachById);

module.exports = router;

