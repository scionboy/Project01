<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/header.jsp" %>
    <title>Title</title>
    <style>
        body {
            background-color: #eee;
            font-family: Arial, sans-serif;
            font-size: 16px;
        }

        .container2 {
            width: 400px;
            margin: 0 auto;
            padding: 30px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            margin-top: 10%;
            margin-bottom: 5%;
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
        }

        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: #fff;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .register {
            text-align: right;
            margin-top: 10px;
        }

        .register a {
            color: #333;
            text-decoration: none;
            padding-right: 10%;
        }

        .register a:hover {
            text-decoration: underline;
        }
    </style>
    </style>
</head>
<body>
<%@include file="../include/nav.jsp" %>
<section>
    <div class="container2">
        <h1>로그인</h1>
        <form action="/admin/login" method="post">
            <label for="userid">이메일</label>
            <input type="text" id="userid" name="user_email" placeholder="이메일을 입력하세요">

            <label for="password">비밀번호</label>
            <input type="password" id="password" name="user_pass" placeholder="비밀번호를 입력하세요">

            <button class="btn btn-primary btn-block" id="regist-btn">로그인</button>

            <div class="register">
                <a href="#">회원가입</a>
                <a href="#">아이디/비밀번호 찾기</a>
            </div>
        </form>
    </div>
</section>
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
