<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header1.jsp"%>

<div class="container">
    <form >
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" placeholder="Enter title" id="title">
        </div>
        <div class="form-group">
            <label for= "content"> Content:</label>
            <textarea id = "content" class = "form-control summernote" rows="5"></textarea>
        </div>

    </form>
    <button id="btn-board-save" class="btn btn-primary"> 글쓰기 완료</button>
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

