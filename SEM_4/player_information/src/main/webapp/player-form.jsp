<form action="players" method="post">
    <input type="hidden" name="id" value="${player.id}">
    <label>Name:</label> <input type="text" name="name" value="${player.name}"><br>
    <label>Age:</label> <input type="number" name="age" value="${player.age}"><br>
    <label>Index:</label> <input type="text" name="indexName" value="${player.indexName}"><br>
    <label>Value:</label> <input type="number" name="value" value="${player.value}"><br>
    <button type="submit" style="background: #d17a5d; color: white;">Save</button>
</form>