from flask import Blueprint, jsonify, request

bp = Blueprint('main', __name__)

@bp.route('/test', methods=['POST'])
def index():
    return jsonify("RUNNING...")