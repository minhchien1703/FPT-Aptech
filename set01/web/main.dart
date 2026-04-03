import 'dart:html';
import 'dart:convert';
import '../lib/order.dart';

List<Order> orders = [];

void main() {
  // 1. Chuỗi JSON được cung cấp từ đề bài
  String jsonString = '[{"Item": "A1000", "ItemName": "Iphone 15","Price": 1200,"Currency": "USD", "Quantity":1},{"Item": "A1001", "ItemName": "Iphone 16","Price": 1500,"Currency": "USD", "Quantity":1}]';

  // 2. Đọc chuỗi JSON và lưu vào list orders
  List<dynamic> parsedList = jsonDecode(jsonString);
  orders = parsedList.map((item) => Order.fromJson(item)).toList();

  // 3. Hiển thị danh sách ra màn hình
  renderTable(orders);

  // Gắn sự kiện cho các nút bấm
  querySelector('#addBtn')?.onClick.listen((_) => insertOrder());
  querySelector('#searchInput')?.onInput.listen((_) => searchOrder());
}

// Hàm vẽ bảng dữ liệu
void renderTable(List<Order> listToRender) {
  var tbody = querySelector('#orderTableBody');
  if (tbody == null) return;

  tbody.children.clear(); // Xóa dữ liệu cũ trước khi vẽ lại

  for (int i = 0; i < listToRender.length; i++) {
    var order = listToRender[i];
    var tr = TableRowElement();

    tr.children.addAll([
      TableCellElement()..text = (i + 1).toString(), // Tạo Id tự động
      TableCellElement()..text = order.item,
      TableCellElement()..text = order.itemName,
      TableCellElement()..text = order.quantity.toString(),
      TableCellElement()..text = order.price.toString(),
      TableCellElement()..text = order.currency,
    ]);

    tbody.children.add(tr);
  }
}

// Hàm thêm Order mới
void insertOrder() {
  var itemInput = querySelector('#itemInput') as InputElement;
  var nameInput = querySelector('#nameInput') as InputElement;
  var priceInput = querySelector('#priceInput') as InputElement;
  var currencyInput = querySelector('#currencyInput') as InputElement;
  var qtyInput = querySelector('#qtyInput') as InputElement;

  if (itemInput.value!.isEmpty || nameInput.value!.isEmpty) {
    window.alert('Vui lòng nhập đủ thông tin!');
    return;
  }

  // Tạo đối tượng Order mới
  var newOrder = Order(
    item: itemInput.value!,
    itemName: nameInput.value!,
    price: double.tryParse(priceInput.value!) ?? 0,
    currency: currencyInput.value!.isEmpty ? 'USD' : currencyInput.value!,
    quantity: int.tryParse(qtyInput.value!) ?? 1,
  );

  // Thêm vào danh sách và cập nhật UI
  orders.add(newOrder);
  renderTable(orders);

  // Mô phỏng việc cập nhật lại file JSON (in ra console vì web không cho ghi file trực tiếp)
  String updatedJson = jsonEncode(orders.map((e) => e.toJson()).toList());
  print('Updated order.json: $updatedJson');

  // Làm sạch form sau khi thêm
  itemInput.value = '';
  nameInput.value = '';
  priceInput.value = '';
}

// Hàm tìm kiếm Order theo ItemName
void searchOrder() {
  var searchInput = querySelector('#searchInput') as InputElement;
  String keyword = searchInput.value!.toLowerCase();

  // Lọc danh sách
  var filteredList = orders.where((order) {
    return order.itemName.toLowerCase().contains(keyword);
  }).toList();

  // Vẽ lại bảng với dữ liệu đã lọc
  renderTable(filteredList);
}