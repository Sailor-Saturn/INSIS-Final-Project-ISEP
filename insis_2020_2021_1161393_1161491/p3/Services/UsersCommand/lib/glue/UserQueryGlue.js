const axios = require('axios');
const config = require('../../config');

async function userWithIdExists(id) {
  let response;
  try {
    response = await axios.get(`${config.userQueryURL}/${id}`);
  } catch (e) {
    if (e.response.status === 404) {
      return false;
    }
  }

  const data = response.data;

  return !!data;
}

module.exports = {
  userWithIdExists
}