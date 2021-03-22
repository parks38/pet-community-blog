<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>
<div class="col-lg-9">
    <div class="container" style="margin-top: 50px;">
        <h2 style="text-align: center">&#11088; 집사 일기 &#11088;</h2>
        <br>
        <form >
            <div class="form-group">
                <label for="title">제목:</label>
                <input type="text" class="form-control" placeholder="Enter title" id="title">
            </div>
            <div class="form-group">
                <label for= "content"> 내용:</label>
                <textarea id = "content" class = "form-control summernote" rows="5"></textarea>
            </div>

        </form>
        <button id="btn-board-save" class="btn btn-outline-success"> 글쓰기 완료</button>
    </div>
    <script>
        $('.summernote').summernote({
            placeholder: 'Hello Bootstrap 4',
            tabsize: 2,
            height: 300
        });
    </script>
    <script src = "/js/func/board.js"></script>
</div>

<%@ include file="../layout/footer.jsp"%>

