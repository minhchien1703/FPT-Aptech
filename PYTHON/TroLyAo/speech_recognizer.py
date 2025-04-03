import speech_recognition as sr

def recognizer_speech():
    recognizer = sr.Recognizer()
    with sr.Microphone() as source:
        print("Hãy bắt đầu đặt câu hỏi... ")
        audio = recognizer.listen(source)
        try:
            question = recognizer.recognize_google(audio, language="vi-VN")
            print(f"Câu hỏi: {question}")
            return question
        except sr.UnknownValueError:
            return "Không nhận diện được giọng nói!"
        except sr.RequestError as e:
            return f"Connect error: {e}"
        
recognizer_speech()