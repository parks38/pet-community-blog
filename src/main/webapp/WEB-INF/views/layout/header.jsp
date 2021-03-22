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
    <link href="/css/shop-homepage.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>



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
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" style="color: white;" href="/auth/joinForm">회원가입</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white;" href="/auth/loginForm">로그인</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<br><br>

<!-- Page Content -->
<div class="container" >

    <div class="row">

        <div class="col-lg-3 sidenav">
            <br>
            <img src = "/image/icon.png" alt ="" width = "95px"/>
            <img src = "/image/name.png" alt ="" width = "110px"/>
            <br><br>
            <div class="list-group" >
                <a href="/" class="list-group-item list-group-item-action list-group-item-light" style="color: black"> <b>전체</b></a>
                <a href="/mypet" class="list-group-item list-group-item-action list-group-item-light" style="color: black">울 주인님 자랑하기</a>
                <a href="/daily" class="list-group-item list-group-item-action list-group-item-light" style="color: black">집사 일기</a>
                <a href="/info" class="list-group-item list-group-item-action list-group-item-light" style="color: black">꿀템 정보</a>
                <a href="/qna" class="list-group-item list-group-item-action list-group-item-light" style="color: black">Q/A 소통</a>
            </div>
        </div>
        <!-- /.col-lg-3 -->