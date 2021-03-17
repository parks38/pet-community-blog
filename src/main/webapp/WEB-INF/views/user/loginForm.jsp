<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form action = "/auth/loginProc" method = "post" >
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" name = "username" class="form-control" placeholder="Enter email" id="username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name = "password" class="form-control" placeholder="Enter password" id="password">
        </div>
        <button id="btn-login" class="btn btn-primary">로그인</button>
        <a href = "https://kauth.kakao.com/oauth/authorize?client_id=dd1369c9935bb08442e6d3de15206eb6&redirect_uri=http://localhost:8081/auth/kakao/callback&response_type=code">
            <img height = "38px" src = "/image/kakao_login.png"></a>

        <a href = "https://kauth.kakao.com/oauth/logout?client_id=dd1369c9935bb08442e6d3de15206eb6&logout_redirect_uri=http://localhost:8081/auth/kakao/logout">
            <img height = "38px" src = "/image/kakao_login.png"> logout</a>

    </form>

</div>
<%--<script src = "/js/user/user.js"></script>--%>

<%@ include file="../layout/footer.jsp" %>

