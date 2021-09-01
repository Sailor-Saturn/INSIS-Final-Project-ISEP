const mongoose = require('mongoose');
const {Schema} = mongoose;

const UserSchema = new Schema({
  _id: String,
  name: String,
  roles: [String],
  state: String
});

module.exports = mongoose.model('users', UserSchema);
