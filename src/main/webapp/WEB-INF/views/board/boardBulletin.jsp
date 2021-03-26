<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>


      <div class="col-lg-9">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="/image/info.png" alt="First slide">
            </div>
          </div>
        </div>
        <div class = "d-flex flex-row-reverse">
          <a href = "board/saveForm" class="btn btn-sm btn-outline-success" style="margin-right: 10px;"> 글쓰기</a>
        </div>
        <br>

        <div class="row">
          <div class="panel panel-primary filterable">

            <table class="table" style= "margin-left: 15px">
              <thead>
              <tr>
                <th style="width: 100px; text-align: center" >번호</th>
                <th style="width: 500px; text-align: center">제목</th>
                <th style="width: 100px; text-align: center">글쓴이</th>
                <th style="width: 100px; text-align: center">작성일</th>
              </tr>
              </thead>
              <c:forEach var = "board" items = "${boards.content}">
                <tbody>
                <tr style="text-align: center">
                  <td>${board.id}</td>
                  <td><a href="/board/${board.id}">${board.title}</a></td>
                  <c:set var = "username" value = "${board.user.username}"/>
                  <c:choose>
                    <c:when test = "${fn:contains(username, '@')}">
                      <c:set var = "user" value="${fn:split(username, '@')}"/>
                      <td>${user[0]}</td>
                    </c:when>
                    <c:otherwise>
                      <td>${board.user.username}</td>
                    </c:otherwise>
                  </c:choose>
                  <td><javatime:format value="${board.createDate}" pattern="MM/dd/yy"/></td>
                </tr>
                </tbody>
              </c:forEach>
            </table>
          </div>
        </div>
        <ul class="pagination justify-content-center">
          <c:choose>
            <c:when test = "${boards.first}">
              <li class="page-item disabled"><a class="page-link" href="?page=${boards.number -1 }">Previous</a></li>
            </c:when>
            <c:otherwise>
              <li class="page-item"><a class="page-link" href="?page=${boards.number - 1}">Previous</a></li>
            </c:otherwise>
          </c:choose>

          <c:choose>
            <c:when test = "${boards.last}">
              <li class="page-item disabled"><a class="page-link" href="?page=${boards.number + 1}">Next</a></li>
            </c:when>
            <c:otherwise>
              <li class="page-item"><a class="page-link" href="?page=${boards.number + 1}">Next</a></li>
            </c:otherwise>
          </c:choose>
        </ul>
      </div>
</div>
</div>

<%@ include file="../layout/footer.jsp"%>

