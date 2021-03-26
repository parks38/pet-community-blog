<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>


<div class="col-lg-9">

    <!-- Title -->
    <br>
    <h1 class="mt-4">${board.title}</h1>
    <hr>
    <div class="d-flex justify-content-between">
        <!-- Author -->
        <c:set var="username" value="${board.user.username}"/>
        <c:choose>
            <c:when test="${fn:contains(username, '@')}">
                <c:set var="user" value="${fn:split(username, '@')}"/>
                <td>
                    <h5>작성자: &nbsp; ${user[0]}</h5></td>
            </c:when>
            <c:otherwise>
                <td><h6> 작성자: &nbsp; ${board.user.username} </h6></td>
            </c:otherwise>
        </c:choose>

        <!-- Date/Time -->
        <p>작성 날짜 : <javatime:format value="${board.createDate}" pattern="yyyy/MM/dd HH:mm:ss"/></p>
    </div>
    <hr>

    <!-- Post Content -->
    <div>
        <form >
            <input type = "hidden" id = "id" value = "${board.id}"/>
            <input value = "${board.title}" type="hidden" id="title">
            <div class="form-group">
                <textarea id = "content" class = "form-control summernote" rows="10">${board.content}</textarea>
            </div>

        </form>
    </div>

    <hr>
    <div class="d-flex justify-content-center">
        <a href="/board" class="btn btn-outline-secondary"> 목록 </a>
        <p> &ensp;</p>
        <button id="btn-update" class="btn btn-outline-secondary">수정 완료</button>
        <p> &ensp;</p>
        <button id = "btn-delete" class="btn btn-outline-secondary">삭제</button>
    </div>


</div>
<!-- /.col-lg-9 -->
<script>
  $('.summernote').summernote({
    placeholder: 'Hello Bootstrap 4',
    tabsize: 2,
    height: 600
  });
</script>
<script src="/js/func/board.js"></script>


<%@ include file="../layout/footer.jsp" %>