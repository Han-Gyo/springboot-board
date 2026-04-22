<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>게시글 수정</title>
</head>
<body>

<h1>게시글 수정</h1>

<form action="/boards/update/${board.id}" method="post">
    <p>번호: ${board.id}</p>

    제목: <input type="text" name="title" value="${board.title}"><br>
    내용: <textarea name="content">${board.content}</textarea><br>
    작성자: <input type="text" name="writer" value="${board.writer}"><br>

    <button type="submit">수정 완료</button>
</form>

<br>
<a href="/boards/${board.id}">취소</a>

</body>
</html>