from pymongo import MongoClient
from bson import objectid
client = MongoClient("mongodb://localhost:27017/")
db_connect = client["WareHouseManagement"]

product_collection = db_connect["products"]
ware_house_collection = db_connect["ware_house"]

def save_product(product_request):
    product = product_collection.insert_one(product_request)
    prodct_id = objectid(product["id"])
    so_luong = product_request["soLuong"]
    
    data_insert_to_ware_house = {}
    data_insert_to_ware_house["product_id"] = prodct_id
    data_insert_to_ware_house["so_luong"] = so_luong
    ware_house_collection.insert_one(data_insert_to_ware_house)
    return "Insert product to db success."

try:
    client.admin.command("PING...")
    print("MongoDB connected.")
except Exception as e:
    print(e)
