import React, { useEffect, useState } from "react";
import { Button, Form, Card, Row, Col, Spinner } from "react-bootstrap";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const StudentForm = ({ onSave, studentToEdit, onCancel }) => {
    const [student, setStudent] = useState({ name: "", age: "", className: "", image_url: "" });
    const [photo, setPhoto] = useState(null);
    const [uploading, setUploading] = useState(false);
    const [saving, setSaving] = useState(false);

    useEffect(() => {
        if (studentToEdit) {
            setStudent(studentToEdit);
        } else {
            setStudent({ name: "", age: "", className: "", image_url: "" });
        }
    }, [studentToEdit]);

    const handleChange = (e) => {
        setStudent((prev) => ({ ...prev, [e.target.name]: e.target.value }));
    };

    const handleFileChange = (e) => {
        setPhoto(e.target.files[0]);
    };

    const uploadImage = async () => {
        if (!photo) return null;

        setUploading(true);
        const formData = new FormData();
        formData.append("image", photo);

        try {
            const response = await fetch("http://127.0.0.1:5000/upload-image", {
                method: "POST",
                body: formData,
            });
            console.log("RES", response.data)
            const data = await response.json();
            return data.image_url || null;
        } catch (error) {
            console.error("Upload failed:", error);
            return null;
        } finally {
            setUploading(false);
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setSaving(true);

        let imageUrl = student.image_url;
        if (photo) {
            const uploadedUrl = await uploadImage();
            if (uploadedUrl) {
                imageUrl = uploadedUrl;
            }
        }

        onSave({ ...student, image_url: imageUrl });

        toast.success(studentToEdit ? "Student updated successfully!" : "Student added successfully!");

        setSaving(false);
    };

    return (
        <Card className="p-3 shadow-sm">
            <h4 className="text-center mb-3">{studentToEdit ? "Edit Student" : "Add Student"}</h4>
            <Form onSubmit={handleSubmit}>
                <Row>
                    <Col md={4}>
                        <Form.Group>
                            <Form.Label>Name</Form.Label>
                            <Form.Control type="text" name="name" value={student.name} onChange={handleChange} required />
                        </Form.Group>
                    </Col>
                    <Col md={4}>
                        <Form.Group>
                            <Form.Label>Age</Form.Label>
                            <Form.Control type="number" name="age" value={student.age} onChange={handleChange} required />
                        </Form.Group>
                    </Col>
                    <Col md={4}>
                        <Form.Group>
                            <Form.Label>Class</Form.Label>
                            <Form.Control type="text" name="className" value={student.className} onChange={handleChange} required />
                        </Form.Group>
                    </Col>
                </Row>

                <Form.Group className="mt-3">
                    <Form.Label>Upload Photo</Form.Label>
                    <Form.Control type="file" onChange={handleFileChange} accept="image/*" />
                    {student.image_url && (
                        <div className="mt-2">
                            <img src={student.image_url} alt="Uploaded" width="100" height="100" />
                        </div>
                    )}
                </Form.Group>

                <div className="d-flex justify-content-center gap-3 mt-3">
                    <Button variant="primary" type="submit" disabled={saving || uploading}>
                        {saving ? <Spinner animation="border" size="sm" /> : studentToEdit ? "Update Student" : "Add Student"}
                    </Button>
                    {studentToEdit && <Button variant="secondary" onClick={onCancel}>Cancel</Button>}
                </div>
            </Form>
        </Card>
    );
};

export default StudentForm;
