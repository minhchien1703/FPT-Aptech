import 'dart:convert';
import 'package:http/http.dart' as http;
import '../models/place.dart';

class ApiService {
  // Nếu dùng Android Emulator, sử dụng 10.0.2.2 thay vì localhost
  static const String baseUrl = 'http://10.0.2.2:8080/api';

  Future<List<Place>> getAllPlace() async {
    final response = await http.get(Uri.parse('$baseUrl/getAllPlace'));

    if (response.statusCode == 200) {
      List jsonResponse = json.decode(response.body);
      return jsonResponse.map((place) => Place.fromJson(place)).toList();
    } else {
      throw Exception('Failed to load places');
    }
  }
}