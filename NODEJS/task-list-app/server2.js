require('dotenv').config();
const express = require('express');
const mysql = require('mysql2');

const app = express();
app.use(express.json());

const port = process.env.PORT || 3001;

const connection = mysql.createPool({
    connectionLimit: 10,
    host: process.env.DB_HOST,
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_NAME
});


app.post('/the-loai/add', (req, res) => {
    const { name } = req.body;
    const SQL = 'INSERT INTO the_loai (name) VALUES (?)';

    connection.query(SQL, [name], (err, result) => {
        if (err) {
            return res.status(500).json({ message: 'Loi them the loai!' });
        }
        res.status(201).json({ message: 'The loai duoc them thanh cong!' });
    });
});


app.post('/san-pham/add', async (req, res) => {
    try {
        const { name, theLoaiId, soLuong } = req.body;

        const [sanPham] = await connection.promise().query(
            'SELECT * FROM san_pham WHERE name = ? AND the_loai_id = ?',
            [name, theLoaiId]
        );

        let sanPhamId;
        if (sanPham.length > 0) {
            sanPhamId = sanPham[0].id; 

            if (theLoaiId == 2 && soLuong % 24 == 0) {
                const [tonKho] = await connection.promise().query(
                    'SELECT * FROM hang_ton_kho WHERE id = ?',
                    [theLoaiId]
                );

                if (tonKho.length > 0) {
                    let soluongkho = tonKho[0].so_luong + 1;
                    await connection.promise().query(
                        'UPDATE hang_ton_kho SET so_luong = ? WHERE id = ?',
                        [soluongkho, theLoaiId]
                    );
                }
            }

        } else {
            const [sanPhamSaved] = await connection.promise().query(
                'INSERT INTO san_pham (name, the_loai_id, so_luong) VALUES (?, ?, ?)',
                [name, theLoaiId, soLuong]
            );

            sanPhamId = sanPhamSaved.insertId;

            const SQLINSERTKHO = 'INSERT INTO hang_ton_kho (san_pham_id, the_loai_id, so_luong) VALUES (?, ?, ?)';
            await connection.promise().query(SQLINSERTKHO, [sanPhamId, theLoaiId, soLuong]);
        }

        res.status(200).json({ message: 'Them san pham thanh cong!' });
    } catch (error) {
        console.error(error);
        res.status(500).json({ message: 'Loi them san pham!' });
    }
});




app.listen(port, () => {
    console.log(`API server running at http://localhost:${port}`);
});
