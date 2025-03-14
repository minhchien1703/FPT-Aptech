const mongoose = require("mongoose");

const treeSchema = new mongoose.Schema({
    treename: String,
    description: String,
    image: String
});

const Tree = mongoose.model("Tree", treeSchema);
module.exports = Tree;
