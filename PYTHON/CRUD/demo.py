from pymongo import MongoClient

connection_mongodb = "mongodb://127.0.0.1:27017/"

client = MongoClient(connection_mongodb)

db = client["crud_with_python"]

collectionStudents = db["students"]

if collectionStudents is not None:
    print("connected")
else:
    print("Can not connected!")

def add_student():
    name = input("Enter name: ")
    age = input("Enter age: ")
    className = input("Enter class name: ")

    student_obj = {
        "name": name,
        "age" : age,
        "className" : className
    }
    collectionStudents.insert_one(student_obj)
    print("Insert student success.")

def del_student():
    key = input("Enter name: ")
    condition = {"name" : key}
    
    # result = collectionStudents.delete_one(condition)
    # if result.deleted_count > 0:
    #     print("Delete student success.")
    # else: 
    #     print("Delete student faild")

    # cach cua thay
    student = collectionStudents.find(condition)

    if student is not None:
        collectionStudents.delete_one(condition)
        print("Delete student success.")
    else:
        print("Student is not found!")


def list_students():
    documents = collectionStudents.find()
    for doc in documents:
        print("Name: " + doc["name"])
        print("age: " + doc["age"])
        print("class name: " + doc["className"])
        # print(doc["name"] + " " + doc["age"] + " " + doc["className"])
        print("\n")
        

if __name__ == "__main__":
    print("Enter Number")
    print("1. Add student")
    print("2. Delete student")
    print("3. List students")
    print("0. Break")

    while True:
        choice = input("Please enter a number 0 to 9: ")
        if (choice == '1'):
            print("Add student")
            add_student()

        if (choice == '2'):
            print("Delete student")
            del_student()

        if (choice == '3'):
            print("List student\n")
            list_students()


        if (choice == '0'):
            break

