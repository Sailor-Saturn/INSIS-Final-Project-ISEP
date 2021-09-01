const userService = require('../services/userService');
const UserDTO = require('../dto/userDTO');
const NoUserFoundException = require('../exception/UserNotFoundException');

async function createUser(req, res) {
  const {name} = req.body;

  try {
    const createdUser = await userService.saveUser(name);
    const dto = new UserDTO(createdUser);

    res.status(201).send(dto);
    return;
  } catch (e) {
    console.log(e);

    res.status(500).end();
    return;
  }
}

async function deleteUser(req, res) {
  const {id} = req.params;

  try {
    await userService.deleteUser(id);
    res.status(204).end();
    return;
  } catch (e) {
    console.log(e);

    if (e instanceof NoUserFoundException) {
      res.status(404).end();
      return;
    }

    return res.status(500).end();
  }
}

async function updateUserName(req, res) {
  const {id} = req.params;
  const {name} = req.body;

  try {
    await userService.updateUserName(id, name);
    res.status(200).end();
    return;
  } catch (e) {
    console.log(e);

    if (e instanceof NoUserFoundException) {
      res.status(404).end();
      return;
    }

    return res.status(500).end();
  }
}

async function updateUserRoles(req, res) {
  const {id} = req.params;
  const {roles} = req.body;

  try {
    await userService.updateUserRoles(id, roles);
    res.status(200).end();
    return;
  } catch (e) {
    console.log(e);

    if (e instanceof NoUserFoundException) {
      res.status(404).end();
      return;
    }

    return res.status(500).end();
  }
}

async function updateUserState(req, res) {
  const {id} = req.params;
  const {state} = req.body;

  try {
    await userService.updateUserState(id, state);
    res.status(200).end();
    return;
  } catch (e) {
    console.log(e);

    if (e instanceof NoUserFoundException) {
      res.status(404).end();
      return;
    }

    return res.status(500).end();
  }
}

module.exports = {
  createUser,
  deleteUser,
  updateUserName,
  updateUserRoles,
  updateUserState
}