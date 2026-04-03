import 'package:student_management/student_management.dart';
import 'package:test/test.dart';
import 'dart:io';

class Student {
  String id;
  String name;
  String className;
  double jpa;

  Student(this.id, this.name, this.className, this.jpa);

  String ToString() {
    return '\nID: $id | NAME: $name | CLASS NAME: $className | JPA: $jpa';
  }
}

void main() {
  List<Map<String, dynamic>> student = [];

  while(true) {
    print('\n===== QUẢN LÝ SINH VIÊN =====');
    print('1. Thêm sinh viên mới');
    print('2. In danh sách sinh viên');
    print('3. Thoát');
    stdout.write("Chon: ");

    int choice = 0;

    try {
    } catch (e) {

    }

  }
}
