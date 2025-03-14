from pymongo import MongoClient
from pymongo.server_api import ServerApi
from bson import ObjectId

import cloudinary
import cloudinary.uploader
import cloudinary.api

cloudinary.config(
    cloud_name="dhswbkiyf",
    api_key="684263618233828",
    api_secret="RpBohYbI1bHv0ctnqzhKk6GQZl4"
)

uri = "mongodb+srv://20200361:WZiZj5Abj7c5p7ZX@cluster0.oksvz.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
client = MongoClient(uri, server_api=ServerApi('1'))
db = client['mongo_atlas_test']
studentCollection = db['students']

try:
    client.admin.command('ping')
    print("Pinged your deployment. You successfully connected to MongoDB!")
except Exception as e:
    print(e)

def add_student(student_obj):
    studentCollection.insert_one(student_obj)
    return {"message" : "Add student success"}

def del_student(student_id):
    condition = {"_id" : student_id}
    result = studentCollection.delete_one(condition)

    if result.deleted_count > 0:
        return {"message" :"Delete student successfull."}
    else: 
        return {"message" : "Delete student faild"}

def list_students():
    # documents = studentCollection.find({}, {"_id":0}) neu không muốn lấy id thì sẽ viết như thê này
    documents = studentCollection.find()
    result = []
    
    for doc in documents:
        doc["_id"] = str(doc["_id"])
        result.append(doc)

    return list(result)

def find_student_by_name(name):
    documents = studentCollection.find({"name" : name})
    students = []

    if documents:
        for std in documents:
            std["_id"] = str(std["_id"]) 
            students.append(std)
        return students
    else:
        return {"message": "Student not found"}
    
        
def update_student(student_id, updated_data):
    result = studentCollection.update_one({"_id": student_id}, {"$set": updated_data})
    if result.modified_count > 0:
        return "Student updated successfully"
    return "No changes made or student not found"


def upload_student_image(image, student_id):
    try:
        # Upload ảnh lên Cloudinary
        upload_result = cloudinary.uploader.upload(image)
        image_url = upload_result['secure_url']
        public_id = upload_result['public_id']

        # Cập nhật thông tin ảnh vào student
        if student_id:
            studentCollection.update_one(
                {"_id": ObjectId(student_id)},
                {"$set": {"image_url": image_url, "public_id": public_id}}
            )

        return {"image_url": image_url, "public_id": public_id}
    except Exception as e:
        return {"error": str(e)}