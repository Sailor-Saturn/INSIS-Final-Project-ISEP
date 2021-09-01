const express = require('express');
const router = express.Router();

const keywordsRouter = require('./keywords');
const approachesRouter = require('./approaches');
const technologyRouter = require('./technologies');

router.use('/approach', approachesRouter);
router.use('/keyword', keywordsRouter);
router.use('/technology', technologyRouter);

module.exports = router;

