const axios = require('axios');
const config = require('../../config');

async function keywordWithIdExists(id) {
  let response;
  try {
    response = await axios.get(`${config.configManagementQueryURL}/keyword/${id}`);
  } catch (e) {
    if (e.response.status === 404) {
      return false;
    }
  }

  const data = response.data;

  return !!data;
}

async function approachWithIdExists(id) {
  let response;
  try {
    response = await axios.get(`${config.configManagementQueryURL}/approach/${id}`);
  } catch (e) {
    if (e.response.status === 404) {
      return false;
    }
  }

  const data = response.data;

  return !!data;
}

async function technologyWithIdExists(id) {
  let response;
  try {
    response = await axios.get(`${config.configManagementQueryURL}/technology/${id}`);
  } catch (e) {
    if (e.response.status === 404) {
      return false;
    }
  }

  const data = response.data;

  return !!data;
}

module.exports = {
  keywordWithIdExists,
  approachWithIdExists,
  technologyWithIdExists
}