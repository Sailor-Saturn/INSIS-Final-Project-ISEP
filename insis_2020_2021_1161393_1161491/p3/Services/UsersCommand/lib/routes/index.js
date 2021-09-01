const userController = require('../controller/userController');

const express = require('express');
const router = express.Router();

router.patch('/:id/state', userController.updateUserState);
router.patch('/:id/roles', userController.updateUserRoles);
router.patch('/:id/name', userController.updateUserName);
router.delete('/:id', userController.deleteUser);
router.post('/', userController.createUser);

module.exports = router;

