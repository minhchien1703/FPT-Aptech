from underthesea import word_tokenize, spell_check

# Danh sách từ điển tiếng Việt đơn giản (thay bằng dữ liệu lớn hơn nếu cần)
tu_dien_viet = {"học", "người", "thông minh", "bạn", "đi", "về", "trường", "sách"}

# Danh sách lưu từ không hợp lệ
invalid_words = []

def check_spelling(word):
    suggestions = spell_check(word)  # Kiểm tra chính tả
    if not suggestions or suggestions[0][1] < 0.7:  # Nếu confidence < 0.7 thì sai
        invalid_words.append(word)
        return f"'{word}' có thể sai chính tả. Gợi ý: {suggestions[0][0] if suggestions else 'Không có'}"
    return f"'{word}' là từ đúng."

def check_meaning(word):
    if word in tu_dien_viet:
        return f"'{word}' có nghĩa trong tiếng Việt."
    else:
        invalid_words.append(word)
        return f"'{word}' không có trong từ điển tiếng Việt."

def full_check(word):
    print("Kết quả kiểm tra:")
    print(check_spelling(word))
    print(check_meaning(word))

# Vòng lặp chính
while True:
    user_input = input("Nhập từ cần kiểm tra (hoặc 'exit' để thoát): ")
    if user_input.lower() == 'exit':
        break
    full_check(user_input)

# Log lại các từ sai sau khi kết thúc chương trình
if invalid_words:
    print("\n📌 Danh sách từ không hợp lệ:")
    for word in set(invalid_words):  # Loại bỏ trùng lặp
        print(f"- {word}")
else:
    print("\n✅ Không có từ sai nào được ghi nhận.")
