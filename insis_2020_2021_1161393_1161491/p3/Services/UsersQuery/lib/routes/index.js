const userController = require('../controller/userController');

const express = require('express');
const router = express.Router();

router.use('/:id', userController.getUserById);
router.use('/', userController.getAllUsers);

module.exports = router;

