<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../include/header.jsp" %>

    <style>
        .test1 {
            padding-top: 300px;
            padding-bottom: 190px;

        }

        .test2 {
            font-size: 12px;
            font-family: -apple-system, BlinkMacSystemFont, "Apple SD Gothic Neo", "Malgun Gothic", "맑은 고딕", arial, Dotum, 돋움, sans-serif;
            /*    폰트는 나중에 바꾸자*/
        }

        table {
            width: 65%;
            margin: 0 auto;
        }

        th {
            text-align: center;
        }

        tr {
            text-align: center;

        }

        thead tr {
            border-top: 2px solid #df9a9a;
            border-bottom: 1px solid #df9a9a;

        }

        tbody tr {
            border-bottom: 1px solid #df9a9a;
        }

        .board_title {
            text-align: left;
        }

        th, td:nth-child(1) {
            width: 10%;
        }

        th, td:nth-child(2) {
            width: 50%;
        }

        th, td:nth-child(3) {
            width: 15%;
        }

        th, td:nth-child(4) {
            width: 15%;
        }

        th, td:nth-child(5) {
            width: 5%;
        }

        th, td:nth-child(6) {
            width: 5%;
        }

    </style>

</head>
<body>
<div>
    <%@include file="../include/nav.jsp" %>

    <section class="test1">
        <div class="test2">

            <table>

                <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>글쓴이</th>
                    <th>작성일</th>
                    <th>조회</th>
                    <th>추천</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="b" items="${bList}">
                    <tr>
                        <td>${b.board_no}</td>
                        <td class="board_title">${b.title}</td>
<%--                        <td>${b.user_name}</td>--%>
                        <td>2020.02.02</td>
                        <td>14</td>
                        <td>2</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
        <a href="/board/write">글쓰기</a>
    </section>

    <%@include file="../include/footer.jsp" %>
</div>
</body>
</html>
