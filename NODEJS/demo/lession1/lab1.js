// WRITE AN APP TODO TASK MANAGEMENT (CRUD)

const bodyParser = require('body-parser');
const express = require('express') // load instance of express

const app = express(); // init
const port = 3000;

//const uuid = require('uuid')
const {v4 : uuidv4} = require('uuid');

//use body-parser
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}))

//Get all todo tasks
let tasks = []

//api add task
app.post('/api/v1/add-task', (req, res) => {
    //define input
    const {title, description, date} = req.body;

    const newTask = {
        id : uuidv4(),
        title : title,
        description : description,
        date : date,
        isCompleted : false 
    }

    tasks.push(newTask)
    //node throw error code for add new resource success : 200
    res.status(201).json(newTask); 
})

//api/version/{{domain-name}}
app.get('/api/v1/tasks', (req, res) => {
    //req : request api go into app
    res.json(tasks);
})

// running app
app.listen(port, () => {
    console.log(`App is running in http://localhost:${port}`)
})