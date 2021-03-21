<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../../views/layout/header.jsp" %>


      <div class="col-lg-9">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="/image/info.png" alt="First slide">
            </div>
          </div>
        </div>

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
              <tbody>
              <tr style="text-align: center">
                <td>1</td>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
</div>
</div>

<%@ include file="../layout/footer.jsp"%>

