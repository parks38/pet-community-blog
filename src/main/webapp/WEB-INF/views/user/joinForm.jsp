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
            <form>
                <div class="form-group">
                    <label for="username">아이디</label>
                    <input type="text" class="form-control" placeholder="Enter username" id="username">
                </div>
                <div class="form-group">
                    <label for="email">이메일</label>
                    <input type="email" class="form-control" placeholder="Enter email" id="email">
                </div>
                <div class="form-group">
                    <label for="password">패스워드</label>
                    <input type="password" class="form-control" placeholder="Enter password" id="password">
                </div>
            </form>
            <button id = "btn-save" class="btn btn-outline-success">가입 완료 </button>
            <a href = "">
                <button type="submit" class="btn btn-outline-success">HOME</button>
            </a>
        </div>
        <script src = "/js/func/user.js"></script>
    </div>
</div>

</body>
</html>