const mongoose = require('mongoose');
const {Schema} = mongoose;

const KeywordSchema = new Schema({
  _id: String,
  name: String
});

module.exports = mongoose.model('keywords', KeywordSchema);
