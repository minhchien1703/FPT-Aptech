from pymongo import MongoClient

uri = "mongodb+srv://20200361:WZiZj5Abj7c5p7ZX@cluster0.oksvz.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
client = MongoClient(uri)
db = client['mongo_atlas_test']
student_col = db['students']

def menu():
    print( "Demo Aggregation.\n")
    while True:
        choose = input("\nEnter number: ")
        
        if choose == '1':
            print("Demo Aggregation.")
            age = input("\nEnter age: ")
            aggregation_match(age)

        if choose == '2':
            print("Demo Aggregation.")
            age = input("\nEnter age gt: ")
            aggregation_match_gt(age)
        

        if choose == '0':
            print("Bye!")
            break


def aggregation_match(age):
    match_by_age = {"$match":{"age" : age}}
    match_pipline = [match_by_age]
    result = student_col.aggregate(match_pipline)
    if result != None:
        for std in result:
            print("\nName: " + std['name'])
            print("Age: " + std['age'])
            print("Class: " + std['className'])
    else:
        print("Collection null!")

def aggregation_match_gt(age):
    match_by_age_gt = {"$match":{"age" : {"$gt" : age}}}
    match_pipline = [match_by_age_gt]
    result = student_col.aggregate(match_pipline)
    if result != None:
        for std in result:
            print("\nName: " + std['name'])
            print("Age: " + std['age'])
            print("Class: " + std['className'])
    else:
        print("Collection null!")

if __name__ == '__main__':
    print("RUNNING...")
    menu()