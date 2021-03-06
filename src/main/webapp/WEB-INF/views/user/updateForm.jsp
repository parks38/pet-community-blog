<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>

<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Homepage - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Custom styles for this template -->

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" style="background-color: rebeccapurple;">
    <div class="container">
        <img src = "/image/icon_2.png"  alt="logo" width = "100px" height = "35px"/>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto navbar-right">
                <li class="nav-item" >
                    <a class="nav-link" style="color: white;" href="/auth/joinForm">회원가입</a>
                </li>
                <li class="nav-item-active">
                    <a class="nav-link" style="color: white;" href="/auth/loginForm">로그인</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container" >

    <div class="row">

        <div class="col-lg-3">

            <h1 class="my-4"><img src = "/image/icon.png" alt ="" width = 95px"/> GATO</h1>
            <div class="list-group" >
                <a href="/" class="list-group-item" > 전체</a>
                <a href="/mypet" class="list-group-item">울 주인님 자랑하기</a>
                <a href="/info" class="list-group-item" >꿀템 정보</a>
                <a href="/daily" class="list-group-item" >집사 일기</a>
                <a href="/qna" class="list-group-item" >Q/A 소통</a>
            </div>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">
            <div class="row">
                <div class="panel panel-default" style="margin-left: 30px; border:  2px solid rebeccapurple;">
                    <div class="panel-heading" style="text-align: center; background-color: rebeccapurple">  <h3 style="color: white">고객님의 정보</h3></div>
                    <div class="panel-body">
                        <div class="col-md-4 col-xs-12 col-sm-6 col-lg-4">
                            <img alt="User Pic" src="/image/user.png" id="profile-image1" class="img-circle img-responsive">


                        </div>
                        <div class="col-md-8 col-xs-12 col-sm-6 col-lg-8" >
                            <form>
                                <input type="hidden" id="id" value="${principal.user.id}"/>
                                <div class="form-group">
                                    <label for="username">아이디 :</label>
                                    <input type="text" value="${principal.user.username}" class="form-control" placeholder="Enter username"
                                           id="username" readonly>
                                </div>
                                <c:if test="${ empty principal.user.oauth}">
                                    <div class="form-group">
                                        <label for="password">비밀번호 :</label>
                                        <input type="password" class="form-control" placeholder="Enter password" id="password">
                                    </div>
                                </c:if>
                                <div class="form-group">
                                    <label for="email">이메일 :</label>
                                    <input value="${principal.user.email}" type="email" class="form-control" placeholder="Enter email"
                                           id="email" readonly>

                                </div>
                            </form>
                            <br>
                            <button id="btn-update" class="btn btn-success">수정 완료</button>

                        </div>
                    </div>
                </div>

            </div>

        </div>

        <%@ include file="../layout/footer.jsp"%>
