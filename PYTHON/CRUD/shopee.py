from pymongo import MongoClient

connection_mongodb = "mongodb://127.0.0.1:27017/"
client = MongoClient(connection_mongodb)
db = client["shopee"]
collectionProducts = db["products"]

if collectionProducts is not None:
    print("Connected.")
else:
    print("Connect faild!")

def add_product():
    name = input("Enter product name: ")
    price = input("Enter product price: ")
    quantity = input("Enter quantity: ")

    product_obj = {
        "productName": name,
        "price" : price,
        "quantity" : quantity
    }
    collectionProducts.insert_one(product_obj)
    print("Insert product success.")

def del_product():
    key = input("Enter product name: ")
    condition = {"productName" : key}
    product = collectionProducts.find(condition)

    if product:
        collectionProducts.delete_one(condition)
        print("Delete product success.")
    else:
        print("Product is not found!")

def find_product_by_price():
    key = input("Enter price: ")
    condition = {"price" : key}
    products = collectionProducts.find(condition)
    
    if products:
        for p in products:
            print("Product name: " + p["productName"])
            print("Price: " + p["price"])
            print("Quantities: " + p["quantity"])
            print("\n")
    else:
        print("Product is null!")

def list_products():
    documents = collectionProducts.find()
    for doc in documents:
        print("Product name: " + doc["productName"])
        print("Price: " + doc["price"])
        print("Quantities: " + doc["quantity"])
        print("\n")
        
if __name__ == "__main__":
    print("1. Add product.")
    print("2. Delete prodct.")
    print("3. find all products")
    print("4. find product by price.")

    while True:
        choice = input("Please choice 0 to 9: ")

        if choice == '1':
            print("Add new product\n")
            add_product()
        
        if choice == '2':
            print("Delete product\n")
            del_product()
        
        if choice == '3':
            print("List products\n")
            list_products()

        if choice == '4':
            print("Find products by price\n")
            find_product_by_price()
        
        if choice == '0':
            print("Goodbye !")
            break




