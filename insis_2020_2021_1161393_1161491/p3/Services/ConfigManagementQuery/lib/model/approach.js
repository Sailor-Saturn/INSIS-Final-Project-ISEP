const mongoose = require('mongoose');
const {Schema} = mongoose;

const ApproachSchema = new Schema({
  _id: String,
  name: String
});

module.exports = mongoose.model('approaches', ApproachSchema);
