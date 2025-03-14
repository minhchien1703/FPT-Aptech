const API_URL = "http://127.0.0.1:8080/api/v1";

export async function getStudents() {
    const response = await fetch(`${API_URL}/find-students`);
    return response.json();
}

export async function addStudent(student) {
    const response = await fetch(`${API_URL}/add-student`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(student),
    });
    return response.json();
}

export async function deleteStudent(studentId) {
    const response = await fetch(`${API_URL}/delete-student`, {
        method: "DELETE",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ _id: studentId }),
    });
    return response.json();
}


export async function updateStudent(studentId, updatedData) {
    try {
        const response = await fetch(`${API_URL}/update-student`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ _id: studentId, ...updatedData }),
        });

        const data = await response.json();
        return data.message;
    } catch (error) {
        console.error("Error updating student:", error);
        return "Failed to update student";
    }
}


