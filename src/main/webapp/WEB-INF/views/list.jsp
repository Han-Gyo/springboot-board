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

<div>
    <c:forEach begin="0" end="${totalPages - 1}" var="i">

        <c:choose>
            <c:when test="${not empty writer and not empty keyword}">
                <a href="/boards/search?writer=${writer}&keyword=${keyword}&page=${i}">
                        ${i + 1}
                </a>
            </c:when>

            <c:otherwise>
                <a href="/boards?page=${i}">
                        ${i + 1}
                </a>
            </c:otherwise>
        </c:choose>

    </c:forEach>
</div>

</body>
</html>