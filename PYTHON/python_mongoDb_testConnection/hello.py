from pymongo import MongoClient

connection_mongodb = "mongodb://127.0.0.1:27017/"

client = MongoClient(connection_mongodb)

db = client["test_connection_mogodb"]

collectionUsers = db["user"]
collectionRoles = db["role"]

if collectionUsers is not None and collectionRoles  is not None:
    document = collectionUsers.find()
    print("connected")
    for doc in document:
        print(doc)
        print(doc["username"])
        print(doc["age"])
    
    document = collectionRoles.find()
    for doc in document:
        print(doc)
        print(doc["rolename"])

else:
    print("Can not connected !")


