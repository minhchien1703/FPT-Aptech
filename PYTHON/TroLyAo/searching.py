import g4f

def search_online(question):
    response = g4f.ChatCompletion.create(
        model="gpt-3.5-turbo", 
        messages=[{"role": "user", "content": question}],
        provider=g4f.Provider.Forefront  
    )
    return response

question = "What is the capital of France?"
answer = search_online(question)
print("GPT4Free Answer:", answer)
