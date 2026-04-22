<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>게시글 목록</title>
</head>
<body>

<h1>게시글 목록</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>제목</th>
        <th>작성자</th>
    </tr>

    <c:forEach var="board" items="${boards}">
        <tr>
            <td>${board.id}</td>
            <td><a href="/boards/${board.id}">${board.title}</a></td>
            <td>${board.writer}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>