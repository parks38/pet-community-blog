<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link href="/css/login.css" rel="stylesheet">
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <title>Shop Homepage - Start Bootstrap Template</title>

</head>
<body>
<div class="sidenav">
    <div class="login-main-text">
        <img src = "/image/login.png" alt = "" height="500px" style="margin-left: 15px;"/>
        <h2></h2>
    </div>
</div>
<div class="main">
    <div class="col-md-6 col-sm-12">
        <div class="login-form">
            <form action = "/auth/loginProc" method = "post" >
                <div class="form-group">
                    <label for="username"> 아이디 </label>
                    <input type="text" name = "username" class="form-control" placeholder="Enter username" id="username">
                </div>
                <div class="form-group">
                    <label for="password"> 비밀번호 </label>
                    <input type="password" name = "password" class="form-control" placeholder="Enter password" id="password">
                </div>
                <button id="btn-login" class="btn btn-outline-success">로그인</button>
                <a href = "/auth/joinForm">
                    <button type="submit" class="btn btn-outline-success">회원가입</button>
                </a>
                <a href = "https://kauth.kakao.com/oauth/authorize?client_id=dd1369c9935bb08442e6d3de15206eb6&redirect_uri=http://localhost:8081/auth/kakao/callback&response_type=code">
                    <img height = "38px" src = "/image/kakao_login.png"></a>
            </form>
        </div>
    </div>
</div>
</body>
</html>

