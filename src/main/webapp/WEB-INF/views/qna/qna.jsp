<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../../views/layout/header.jsp" %>


<div class="col-lg-9">

    <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
        <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
                <img class="d-block img-fluid" src="/image/qna.png" alt="First slide">
            </div>
        </div>
    </div>

    <div class="row">
        <!-- 시작 -->
        <div class="col-12">

            <!--- Post Form Begins -->
            <section class="card">
                <div class="card-body">
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="posts" role="tabpanel"
                             aria-labelledby="posts-tab">
                            <div class="form-group">
                                <label class="sr-only" for="post">post</label>
                                <form>
                                <textarea class="form-control" id="post" rows="3"
                                          placeholder="내용을 적어주세요 .... "></textarea>
                                </form>
                            </div>

                        </div>
                    </div>
                    <div class="text-right">
                        <button id="btn-post-save" class="btn btn-outline-success"> 공유 하기</button>
                    </div>
                </div>
            </section>
            <!--- Post Form Ends -->
            <c:forEach var="posts" items="${qna.content}">
                <!-- Post Begins -->
                <section class="card mt-4">
                    <div class="border p-2">
                        <!-- post header -->
                        <div class="row m-0">
                            <div class="">
                                <a class="text-decoration-none" href="#">
                                    <img class="d-flex mr-3 rounded-circle" src="/image/chat.png"
                                         style="width: 58px;" alt="">
                                </a>
                            </div>
                            <div class="flex-grow-1 pl-2">
                                <a class="text-decoration-none" href="#">
                                    <h2 class="text-capitalize h5 mb-0">${posts.user.username} </h2>
                                </a>
                                <p class="small text-secondary m-0 mt-1"><javatime:format
                                        value="${posts.createDate}" pattern="yyyy/MM/dd"/></p>
                            </div>

                            <div>
                                <form>
                                    <input type="hidden" id="id" value="${posts.id}"/>
                                </form>
                                <button type="button" id="btn-delete"
                                        class="btn btn-sm btn-outline-danger"> x
                                </button>
                            </div>
                        </div>
                        <!-- post body -->
                        <div class="">
                            <p class="my-2"
                               style="padding: 10px; padding-left: 30px; padding-right: 30px;">
                                    ${posts.content}
                            </p>
                        </div>
                        <hr class="my-1">
                        <!-- post footer begins -->
                        <footer class="">
                            <!-- post actions -->
                            <div class="">
                                <ul class="list-group list-group-horizontal">
                                    <li class="list-group-item flex-fill text-center p-0 px-lg-2 border border-right-0 border-top-0 border-bottom-0">
                                        <a class="small text-decoration-none" data-toggle="collapse"
                                           href="#collapseExample" role="button"
                                           aria-expanded="false"
                                           aria-controls="collapseExample">
                                            <i class="fas fa-comment-alt"></i> Comment
                                        </a>
                                    </li>
                                </ul>
                            </div>


                            <!-- collapsed comments begins -->
                            <div class="collapse" id="collapseExample">
                                <div class="card border border-right-0 border-left-0 border-bottom-0 mt-1">
                                    <!-- new comment form -->
                                    <section class="mt-3">
                                        <form action="">
                                            <div class="input-group input-group">
                                                <form>
                                                    <input type="hidden" id="userId"
                                                           value="${principal.user.id}"/>
                                                    <input type="hidden" id="postId"
                                                           value="${posts.id}"/>
                                                    <input
                                                            id="reply-content" type="text"
                                                            class="form-control"
                                                            placeholder="답글을 남겨주세요 "
                                                            aria-describedby="basic-addon2"/>
                                                </form>

                                                <div class="input-group-append">
                                                    <button type="button"
                                                            class=" btn btn-outline-success"
                                                            id="btn-reply-save"> 등록
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
                                    </section>
                                    <!-- comment card bgins -->
                                    <c:forEach var="comment" items="${posts.qnaReplys}">
                                        <section>
                                            <div class="card p-2 mt-3">
                                                <!-- comment header -->
                                                <div class="d-flex">
                                                    <div class="">
                                                        <a class="text-decoration-none" href="#">
                                                            <img class="d-flex mr-3 rounded-circle"
                                                                 src="/image/chat.png"
                                                                 style="width: 58px;" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="flex-grow-1 pl-2">
                                                        <a class="text-decoration-none text-capitalize h6 m-0"
                                                           href="#">${comment.user.username}</a>
                                                    </div>
                                                    <div>
                                                        <form>
                                                            <input type="hidden" id="ids"
                                                                   value="${comment.id}"/>
                                                        </form>
                                                        <button type="button" id="btn"
                                                                class="btn btn-sm btn-outline-danger">
                                                            x
                                                        </button>
                                                    </div>
                                                </div>
                                                <!-- comment header -->
                                                <!-- comment body -->
                                                <div class="card-body p-0">
                                                    <p class="card-text h7 mb-1">${comment.content}</p>
                                                </div>
                                            </div>
                                        </section>
                                    </c:forEach>
                                    <!-- comment card ends -->

                                </div>
                            </div>
                            <!-- collapsed comments ends -->
                        </footer>
                        <!-- post footer ends -->
                    </div>
                </section>
                <!-- Post Ends -->
            </c:forEach>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.col-lg-9 -->

</div>
<!-- /.row -->

<script src="/js/func/qna.js"></script>

<%@ include file="../layout/footer.jsp" %>

