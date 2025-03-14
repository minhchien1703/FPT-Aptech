from flask import Flask, jsonify, request, render_template
from flask_cors import CORS 
from bson import ObjectId
from mongodb_utils import add_student, del_student, list_students, find_student_by_name, update_student, upload_student_image

app = Flask(__name__)
CORS(app)

@app.route('/api/v1/add-student', methods = ['POST'])
def api_add_student():
    data = request.json
    message = add_student(data)
    return jsonify({
        "message" : message
    })

@app.route('/api/v1/delete-student', methods=['DELETE'])
def api_del_student():
    data = request.get_json()
    # Kiểm tra nếu không có _id trong request body
    if not data or "_id" not in data:
        return jsonify({"message": "Missing student ID"}), 400  

    try:
        student_id = ObjectId(data["_id"])  # Chuyển đổi string thành ObjectId
    except:
        return jsonify({"message": "Invalid student ID"}), 400

    message = del_student(student_id)
    return jsonify({
        "message" : message
    })

@app.route('/api/v1/find-students', methods=['GET'])
def api_fetch_students():
    students = list_students()
    return jsonify(students)


@app.route('/api/v1/student', methods=['GET'])
def api_find_student_by_name():
    data = request.get_json()
    if not data or "name" not in data:
        return jsonify({
            "error" : "Missing name in requset body!"
        }), 400

    name = data["name"]
    students = find_student_by_name(name)
    return jsonify(students)


@app.route('/api/v1/update-student', methods=['PUT'])
def api_update_student():
    data = request.json

    if not data or "_id" not in data:
        return jsonify({"message": "Missing student ID"}), 400

    try:
        student_id = ObjectId(data["_id"])  # Chuyển đổi string thành ObjectId
    except:
        return jsonify({"message": "Invalid student ID"}), 400

    updated_data = {}
    if "name" in data:
        updated_data["name"] = data["name"]
    if "age" in data:
        updated_data["age"] = data["age"]
    if "className" in data:
        updated_data["className"] = data["className"]

    if not updated_data:
        return jsonify({"message": "No update data provided"}), 400

    message = update_student(student_id, updated_data)
    return jsonify({"m essage": message})


@app.route('/api/v1/upload-image', methods=['POST'])
def api_upload_image():
    if 'image' not in request.files:
        return jsonify({"error": "No image uploaded"}), 400

    image = request.files['image']
    student_id = request.form.get('student_id')  # Lấy ID của student cần cập nhật ảnh

    result = upload_student_image(image, student_id)
    
    return jsonify(result)


if __name__ == "__main__":
    print("RUN APP.")
    app.run(debug=True, port=8080)