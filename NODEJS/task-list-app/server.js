

require('dotenv').config();
const bodyParser = require('body-parser')
const express = require('express')
const app = express();
app.use(express.json());
const port = process.env.port || 3001;

const path = require('path');
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname + '/views'));

// setup mysql
const mysql = require('mysql2');
const { console } = require('inspector');

const connection = mysql.createPool({
    connectionLimit: 10,
    host: process.env.DB_HOST,
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_NAME
});



// app.get('/api/v1/tasks', (req, res) => {
//     connection.connect((err) => {
//         if (err) throw err;
//         console.log("Connected to MYSQL DB!")

//         const sql = 'select * from tasks LIMIT ? OFFSET ?';
//         const page = defaultPage;
//         const limit = defaultLimit;

//         let offset = (page - 1) * limit;

//         connection.query(sql, [limit, offset], (err, results) => {
//             if (err) {
//                 console.error("Lỗi truy vấn SQL:", err);
//                 return res.status(500).json({ error: "Lỗi truy vấn dữ liệu" });
//             }

//             return res.json(results);
//         })

//         // connection.query('Select * from tasks', (err, result) => {
//         //     if (err) throw err;
//         //     return res.json(result);
//         // })


//         connection.end();
//     })
// })


// app.post('/task/add-task', (req, res) => {
//     const { title, description, date, isCompleted } = req.body;

//     let sql = 'INSERT INTO tasks (title, description, expire_date, is_completed) values (?,?,?,?)'

//     connection.query(sql, [title, description, date, isCompleted], (err, result) => {
//         if (err) {
//             return res.status(500).json({ err: err.message })
//         }

//         res.status(201).json({
//             id: result.insertId,
//             title,
//             description,
//             date,
//             isCompleted
//         });
//     })
// })

app.post('/task/add-task', (req, res) => {
    const {title, description, date, isCompleted} = req.body;

    const SQL = 'INSERT INTO tasks (title, description, expire_date, is_completed) VALUES (?,?,?,?)';

    connection.query(SQL, [title, description, date, isCompleted], (err) => {
        if (err) {
            console.error('Add task error!');
            return res.status(500).send('Add task error!');
        }
        res.redirect('/tasks');
    });
});

app.post('/task/update-task', (req, res) => {
    const { id, title, description, expire_date, is_completed } = req.body;
    const sql = 'UPDATE tasks SET title = ?, description = ?, expire_date = ?, is_completed = ? WHERE id = ?';
    const values = [
        title,
        description || null,
        expire_date || null,
        is_completed ? 1 : 0,
        id
    ];

    connection.query(sql, values, (err) => {
        if (err) {
            console.error('Lỗi khi cập nhật task: ', err);
            return res.status(500).send('Lỗi khi cập nhật task!');
        }
        res.redirect('/tasks'); 
    });
});

app.post('/task/delete-task', (req, res) => {
    const { id } = req.body;

    const SQL = 'DELETE FROM tasks WHERE id = ?'

    connection.query(SQL, [id], (err) => {
        if (err) {
            console.error('Delete error!');
            return res.status(500).send('Delete task error!');
        }
        res.redirect('/tasks');
    })
});

app.get('/tasks', async (req, res) => {
    try {
        const page = parseInt(req.query.page) || 1;
        const limit = parseInt(req.query.limit) || 10;
        const offset = (page - 1) * limit;

        const [countResult] = await connection.promise().query('SELECT COUNT(*) as total FROM tasks');
        const totalRecords = countResult[0].total;
        const totalPages = Math.ceil(totalRecords / limit);

        const [results] = await connection.promise().query('SELECT * FROM tasks LIMIT ? OFFSET ?', [limit, offset]);

        return res.render('list_todo', {
            page,
            limit,
            totalRecords,
            totalPages,
            data: results
        });
    } catch (err) {
        console.error('Lỗi: ', err);
        return res.status(500).send('Lỗi truy vấn dữ liệu!');
    }
});


app.listen(port, () => {
    console.log(`App is running in http://localhost:${port}`)
})