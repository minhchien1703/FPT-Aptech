from bson import objectid
from flask import Flask, jsonify, request
from model import save_product

app = Flask(__name__) 

@app.route('/api/v1/add-product', methods = ['POST'])
def add_product():
    data = request.json


if __name__ == "__main__":
    app.run(debug=True, port=8080)
    print("App runing...")

