import json

class VirtualAssistant:
    def __init__(self, name):
        self.name = name
        self.database = self.load_database()

    def load_database(self):
        try:
            with open("database.json", "r") as file:
                return json.load(file)
        except FileNotFoundError:
            return {}

    def save_to_database(self, question, answer):
        self.database[question] = answer
        with open("database.json", "w") as file:
            json.dump(self.database, file)

# Sửa dòng này: truyền tham số name
assistant = VirtualAssistant("SmartBot")
print(f"Trợ lý ảo {assistant.name} đã được khởi tạo!")