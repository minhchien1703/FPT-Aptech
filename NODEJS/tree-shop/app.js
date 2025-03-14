const express = require("express");
const mongoose = require("mongoose");
const bodyParser = require("body-parser");
const treeRoutes = require("./routes/treeRoutes");

const app = express();

// Kết nối MongoDB
mongoose.connect("mongodb://localhost:27017/TreeShop", {
    useNewUrlParser: true,
    useUnifiedTopology: true
}).then(() => console.log("Connected to MongoDB"))
  .catch(err => console.log(err));

// Cấu hình middleware
app.set("view engine", "ejs");
app.use(express.static("public"));
app.use(bodyParser.urlencoded({ extended: true }));

// Sử dụng route
app.use("/", treeRoutes);

const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});
