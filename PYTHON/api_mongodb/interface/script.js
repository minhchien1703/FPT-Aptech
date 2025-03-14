const API_URL = "http://127.0.0.1:8080/api/v1";  

function loadStudents() {
    fetch("http://127.0.0.1:8080/api/v1/find-students")
        .then(response => response.json())
        .then(data => {
            const studentList = document.getElementById("studentList");
            studentList.innerHTML = ""; // Xóa dữ liệu cũ

            data.forEach(student => {
                const row = document.createElement("tr");

                row.innerHTML = `
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.className}</td>
                    <td>
                        <button onclick="showEditForm('${student._id}', '${student.name}', ${student.age}, '${student.className}')">✏️ Edit</button>
                        <button onclick="deleteStudent('${student._id}')">🗑️ Delete</button>
                    </td>
                `;

                studentList.appendChild(row);
            });
        })
        .catch(error => console.error("Error:", error));
}



async function addStudent() {
    let name = document.getElementById("nameInput").value;
    let age = document.getElementById("ageInput").value;
    let className = document.getElementById("classInput").value;

    if (!name || !age || !className) return alert("Please enter all fields!");

    await fetch(`${API_URL}/add-student`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, age, className })
    });

    document.getElementById("nameInput").value = "";
    document.getElementById("ageInput").value = "";
    document.getElementById("classInput").value = "";

    loadStudents();
}

function saveStudent() {
    const id = document.getElementById("studentId").value;
    const name = document.getElementById("studentName").value;
    const age = document.getElementById("studentAge").value;
    const className = document.getElementById("studentClass").value;

    const studentData = { name, age, className };

    if (id) {
        // Nếu có ID, cập nhật sinh viên
        studentData["_id"] = id;

        fetch("http://127.0.0.1:8080/api/v1/update-student", {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(studentData)
        })
        .then(response => response.json())
        .then(data => {
            alert(data.message);
            resetForm();
            loadStudents();
        })
        .catch(error => console.error("Error:", error));
    } else {
        // Nếu không có ID, thêm mới sinh viên
        fetch("http://127.0.0.1:8080/api/v1/add-student", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(studentData)
        })
        .then(response => response.json())
        .then(data => {
            alert(data.message);
            resetForm();
            loadStudents();
        })
        .catch(error => console.error("Error:", error));
    }
}

// Reset form sau khi thêm/cập nhật
function resetForm() {
    document.getElementById("studentId").value = "";
    document.getElementById("studentName").value = "";
    document.getElementById("studentAge").value = "";
    document.getElementById("studentClass").value = "";
    document.getElementById("saveBtn").innerText = "Add Student";
}


async function deleteStudent(id) {
    await fetch(`${API_URL}/delete-student`, {
        method: "DELETE",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ _id: id })
    });

    loadStudents();
}

async function findStudent() {
    let name = document.getElementById("searchInput").value;
    if (!name) return alert("Please enter a name!");

    let response = await fetch(`${API_URL}/student`, {
        method: "GET",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name })
    });

    let students = await response.json();
    let studentList = document.getElementById("studentList");
    studentList.innerHTML = ""; 

    students.forEach(student => {
        let li = document.createElement("li");
        li.innerHTML = `${student.name} - ${student.age} - ${student.className} 
            <button onclick="deleteStudent('${student._id}')">Delete</button>`;
        studentList.appendChild(li);
    });
}

function showEditForm(id, name, age, className) {
    document.getElementById("studentId").value = id;  // Lưu ID để cập nhật
    document.getElementById("studentName").value = name;
    document.getElementById("studentAge").value = age;
    document.getElementById("studentClass").value = className;

    document.getElementById("saveBtn").innerText = "Update Student"; // Đổi nút thành "Update"
}


loadStudents();
