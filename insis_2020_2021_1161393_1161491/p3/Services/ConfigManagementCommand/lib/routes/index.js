const express = require('express');
const router = express.Router();

const keywordsRouter = require('./keywords');
const approachRouter = require('./approaches');
const technologyRouter = require('./technology');

router.use('/approach', approachRouter);
router.use('/keyword', keywordsRouter);
router.use('/technology', technologyRouter);

module.exports = router;

