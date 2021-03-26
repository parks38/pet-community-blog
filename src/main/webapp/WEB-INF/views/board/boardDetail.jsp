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
        <p class="lead">
            ${board.content}
        </p>
    </div>

    <hr>
    <div class="d-flex justify-content-center">
        <a href="/board" class="btn btn-outline-secondary"> 목록 </a>
        <c:if test="${board.user.id eq principal.user.id}">
            <p> &ensp;</p>
            <a href="/board/${board.id}/updateForm" class="btn btn-outline-secondary">수정</a>
            <p> &ensp;</p>
            <form>
                <input type = "hidden" id = "id" value = "${board.id}"/>
            </form>
            <button id = "btn-delete" class="btn btn-outline-secondary">삭제</button>
        </c:if>

    </div>

    <!-- Comments Form -->
    <div class="card my-4">
        <h5 class="card-header" style="background-color: rebeccapurple; color: white">댓글 남기기</h5>
        <div class="card-body" style="border: 1px solid rebeccapurple">
            <form>
                <input type="hidden" id="userId" value="${principal.user.id}"/>
                <input type="hidden" id="boardId" value="${board.id}"/>
                <div class="card-body"><textarea id="reply-content" class="form-control"
                                                 rows="3"> </textarea></div>
                <div class="card-footer d-flex flex-row-reverse">
                    <button type="button" id="btn-reply-save" class="btn btn-outline-success"> 등록
                    </button>
                </div>
            </form>
        </div>
    </div>

    <!-- Single Comment -->
    <div class="media my-4">
        <ul id="reply-box" class="card-body list-group">
            <c:forEach var="reply" items="${board.replys}">
                <li id="reply-${reply.id}" class="list-group-item d-flex justify-content-between">
                    <img class="d-flex mr-3 rounded-circle" src="/image/chat.png"
                         style="width: 58px;" alt="">
                    <div class="media-body">
                        <div class="d-flex justify-content-between" style="margin-top: 12px;">
                            <div>
                                <td>${reply.content}</td>
                            </div>
                            <div class="d-flex flex-row-reverse">
                                <c:if test="${reply.user.id eq principal.user.id}">
                                    <button onClick="index.replyDelete(${board.id}, ${reply.id})"
                                            style="margin-left: 10px;"
                                            class="btn btn-outline-danger btn-sm"> X
                                    </button>
                                </c:if>

                                <c:set var="username" value="${reply.user.username}"/>
                                <c:choose>
                                    <c:when test="${fn:contains(username, '@')}">
                                        <c:set var="user" value="${fn:split(username, '@')}"/>
                                        <td> 작성자 : ${user[0]}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td> 작성자 : ${reply.user.username}</td>
                                    </c:otherwise>
                                </c:choose>
                            </div>

                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>

</div>
<!-- /.col-lg-9 -->
<script>
  $('.summernote').summernote({
    placeholder: 'Hello Bootstrap 4',
    tabsize: 2,
    height: 300
  });
</script>
<script src="/js/func/board.js"></script>


<%@ include file="../layout/footer.jsp" %>
