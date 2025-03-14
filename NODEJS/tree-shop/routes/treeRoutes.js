const express = require("express");
const multer = require("multer");
const Tree = require("../models/treeModel");
const router = express.Router();

// Cấu hình lưu ảnh
const storage = multer.diskStorage({
    destination: (req, file, cb) => cb(null, "public/uploads"),
    filename: (req, file, cb) => cb(null, file.originalname),
});
const upload = multer({ storage: storage });

// Route hiển thị trang chủ
router.get("/", async (req, res) => {
    const trees = await Tree.find();
    res.render("index", { trees });
});

// Route thêm cây mới
router.post("/add", upload.single("image"), async (req, res) => {
    const { treename, description } = req.body;
    const image = req.file ? "/uploads/" + req.file.filename : "";

    if (!treename || !description) {
        return res.redirect("/");
    }

    await Tree.create({ treename, description, image });
    res.redirect("/");
});

// Route xóa tất cả dữ liệu
router.post("/reset", async (req, res) => {
    await Tree.deleteMany({});
    res.redirect("/");
});


// Route hiển thị trang chỉnh sửa
router.get("/edit/:id", async (req, res) => {
    try {
        const tree = await Tree.findById(req.params.id);
        if (!tree) {
            return res.status(404).send("Cây không tồn tại");
        }
        res.render("edit", { tree });
    } catch (error) {
        res.status(500).send("Lỗi máy chủ");
    }
});

// Route xử lý cập nhật cây
router.post("/edit/:id", upload.single("image"), async (req, res) => {
    try {
        let updateData = {
            treename: req.body.treename, // Đảm bảo tên đúng với model
            description: req.body.description
        };

        if (req.file) {
            updateData.image = "/uploads/" + req.file.filename;
        } else {
            // Nếu không có ảnh mới, giữ ảnh cũ
            const existingTree = await Tree.findById(req.params.id);
            if (existingTree) {
                updateData.image = existingTree.image;
            }
        }

        await Tree.findByIdAndUpdate(req.params.id, updateData);
        res.redirect("/");
    } catch (err) {
        res.status(500).send("Lỗi khi cập nhật cây");
    }
});


router.get("/delete/:id", async (req, res) => {
    try {
        const tree = await Tree.findById(req.params.id);
        if (!tree) {
            return res.status(404).send("Cây không tồn tại");
        }

        await Tree.findByIdAndDelete(req.params.id);
        res.redirect("/");
    } catch (err) {
        res.status(500).send("Lỗi khi xóa cây");
    }
});


module.exports = router;
