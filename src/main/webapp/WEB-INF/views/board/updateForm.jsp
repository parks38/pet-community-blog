<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header1.jsp"%>

<div class="container">
    <form >
        <input type = "hidden" id = "id" value = "${board.id}"/>
        <div class="form-group">
            <input value = "${board.title}" type="text" class="form-control" placeholder="Enter title" id="title">
        </div>
        <div class="form-group">
            <textarea id = "content" class = "form-control summernote" rows="5">${board.content}</textarea>
        </div>

    </form>
    <button id="btn-update" class="btn btn-primary"> 수정 완료</button>
</div>
<script>
    $('.summernote').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 300
    });
</script>
<script src = "/js/func/board.js"></script>

<%@ include file="../layout/footer1.jsp"%>

