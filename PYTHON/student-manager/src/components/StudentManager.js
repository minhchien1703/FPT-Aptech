import React, { useEffect, useState } from "react";
import { getStudents, addStudent, deleteStudent, updateStudent } from "../api/api";
import StudentForm from "./forms/StudentForm";
import { Button, Card, Table, Container, Form, Row, Col } from "react-bootstrap";


function StudentManager() {
    const [students, setStudents] = useState([]);
    const [filteredStudents, setFilteredStudents] = useState([]);
    const [editingStudent, setEditingStudent] = useState(null);

    // State lưu trữ bộ lọc
    const [ageFilter, setAgeFilter] = useState("");
    const [classFilter, setClassFilter] = useState("");

    useEffect(() => {
        loadStudents();
    }, []);

    async function loadStudents() {
        const data = await getStudents();
        const processedData = data.map(student => ({
            ...student,
            age: Number(student.age), 
        }));
        setStudents(processedData);
        setFilteredStudents(processedData);
    }


    async function handleSaveStudent(student) {
        if (student._id) {
            await updateStudent(student._id, {
                name: student.name,
                age: student.age,
                className: student.className
            });
        } else {
            await addStudent(student);
        }
        setEditingStudent(null);
        loadStudents();
    }

    function handleEditStudent(student) {
        setEditingStudent(student);
    }

    function handleCancelEdit() {
        setEditingStudent(null);
    }

    async function handleDeleteStudent(id) {
        await deleteStudent(id);
        loadStudents();
    }

    useEffect(() => {
        let filtered = students;

        if (ageFilter) {
            filtered = filtered.filter(student => String(student.age) === ageFilter);
        }
        if (classFilter) {
            filtered = filtered.filter(student => student.className.toLowerCase().includes(classFilter.toLowerCase()));
        }

        setFilteredStudents(filtered);
    }, [ageFilter, classFilter, students]);



    return (
        <Container className="mt-4">
            <h1 className="text-center mb-4">📚 Student Manager</h1>

            {/* Form dùng chung để Thêm & Chỉnh sửa */}
            <StudentForm onSave={handleSaveStudent} studentToEdit={editingStudent} onCancel={handleCancelEdit} />

            {/* Bộ lọc */}
            <Card className="mt-4 p-3 shadow-sm">
                <h5 className="text-center mb-3">🔍 Filter Students</h5>
                <Row>
                    <Col md={6}>
                        <Form.Group>
                            <Form.Label>Filter by Age</Form.Label>
                            <Form.Control
                                type="number"
                                value={ageFilter}
                                onChange={(e) => setAgeFilter(e.target.value)}
                                placeholder="Enter age"
                            />
                        </Form.Group>
                    </Col>
                    <Col md={6}>
                        <Form.Group>
                            <Form.Label>Filter by Class</Form.Label>
                            <Form.Control
                                type="text"
                                value={classFilter}
                                onChange={(e) => setClassFilter(e.target.value)}
                                placeholder="Enter class name"
                            />
                        </Form.Group>
                    </Col>
                </Row>
            </Card>

            {/* Danh sách sinh viên */}
            <Card className="mt-4 shadow-sm">
                <Card.Body>
                    <h4 className="text-center mb-3">👨‍🎓 Student List</h4>
                    <Table striped bordered hover responsive className="text-center">
                        <thead className="table-dark">
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Age</th>
                                <th>Class</th>
                                <th>Photo</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {filteredStudents.length > 0 ? (
                                filteredStudents.map((student, index) => (
                                    <tr key={student._id}>
                                        <td>{index + 1}</td>
                                        <td>{student.name}</td>
                                        <td>{student.age}</td>
                                        <td>{student.className}</td>
                                        <td>
                                            {student.image_url ? (
                                                <img src={student.image_url} alt="Student" width="50" height="50" />
                                            ) : (
                                                "No Image"
                                            )}
                                        </td>
                                        <td>
                                            <Button variant="warning" className="me-2" onClick={() => handleEditStudent(student)}>
                                                ✏ Edit
                                            </Button>
                                            <Button variant="danger" onClick={() => handleDeleteStudent(student._id)}>
                                                🗑 Delete
                                            </Button>
                                        </td>
                                    </tr>
                                ))
                            ) : (
                                <tr>
                                    <td colSpan="6">No students found</td>
                                </tr>
                            )}
                        </tbody>
                    </Table>

                </Card.Body>
            </Card>
        </Container>
    );
}

export default StudentManager;
