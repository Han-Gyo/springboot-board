<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>글쓰기</title>
</head>
<body>

<h1>글쓰기</h1>

<form action="/boards/write" method="post">

    제목: <input type="text" name="title"><br>
    내용: <textarea name="content"></textarea><br>
    작성자: <input type="text" name="writer"><br>

    <button type="submit">저장</button>

</form>

</body>
</html>