<%--
  Created by IntelliJ IDEA.
  User: scion
  Date: 2023-04-15
  Time: 오후 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/header.jsp" %>
    <style>
        /* 폼 요소들을 가운데 정렬합니다 */
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        /* 레이블 요소를 왼쪽으로 정렬합니다 */
        label {
            display: block;
            text-align: left;
            margin-bottom: 5px;
        }

        /* 입력 요소들을 스타일링합니다 */
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            padding: 10px;
            border-radius: 5px;
            border: none;
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);
            margin-bottom: 10px;
            width: 100%;
        }

        /* 가입하기 버튼을 스타일링합니다 */
        button[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px;
            cursor: pointer;
            margin-top: 10px;
        }

        /* 버튼에 호버 효과를 추가합니다 */
        button[type="submit"]:hover {
            background-color: #3e8e41;
        }

    </style>

    <title>Title</title>
</head>
<body>
<%@include file="../include/nav.jsp" %>
<form action="/admin/regist" method="post">
    <div class="form-group">
        <label for="user_name">사용자 이름</label>
        <input type="text" id="user_name" name="user_name" required>
    </div>
    <div class="form-group">
        <label for="user_email">이메일</label>
        <input type="text" id="user_email" name="user_email" required>
    </div>
    <div class="form-group">
        <label for="user_pass">비밀번호</label>
        <input type="password" id="user_pass" name="user_pass" required>
    </div>
<%--    <div class="form-group">--%>
<%--        <label for="confirm-password">비밀번호 확인</label>--%>
<%--        <input type="password" id="confirm-password" name="confirm-password" required>--%>
<%--    </div>--%>
    <button class="btn btn-primary btn-block" id="regist-btn">회원가입</button>
</form>
<%@include file="../include/footer.jsp" %>

</body>
<script>
    const $regBtn = document.getElementById('regist-btn');

    $regBtn.onclick = e => {
        const $form = document.getElementById('reigst-form');
        $form.submit();
    };

</script>

</html>
