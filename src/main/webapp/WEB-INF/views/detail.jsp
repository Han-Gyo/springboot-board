<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>게시글 상세보기</title>
</head>
<body>

<h1>게시글 상세보기</h1>

<p>번호: ${board.id}</p>
<p>제목: ${board.title}</p>
<p>내용: ${board.content}</p>
<p>작성자: ${board.writer}</p>

<hr>

<a href="/boards">목록으로</a>
<a href="/boards/update/${board.id}">수정</a>
<a href="/boards/delete/${board.id}">삭제</a>

</body>
</html>