const mongoose = require('mongoose');
const {Schema} = mongoose;

const TechnologySchema = new Schema({
  _id: String,
  name: String
});

module.exports = mongoose.model('technologies', TechnologySchema);
