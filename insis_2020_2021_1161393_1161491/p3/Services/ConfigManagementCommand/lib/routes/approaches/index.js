const express = require('express');
const router = express.Router();
const approachesController = require('../../controller/approachController');

router.post('/', approachesController.saveApproach);
router.put('/:id', approachesController.updateApproach);
router.delete('/:id', approachesController.deleteApproach);

module.exports = router;

