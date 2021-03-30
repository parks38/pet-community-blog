let index = {
    init:function(){
        $("#btn-post-save").on("click", () => {
            this.save();
        });
        $("#btn-delete").on("click", () => {
            this.deleteById();
        });

        $("#btn-reply-save").on("click", () => {
            this.replySave();
        });

    },

    save:function() {
        let data = {
            content: $("#post").val(),

        };

        $ .ajax({
            type: "POST",
            url: "/api/qna",
            data: JSON.stringify(data),
            contentType : "application/json; charset=urf-8",
            dataType : "json" //생략 가능
        }).done(function (resp) {
            alert("글쓰기 완료 되었습니다. ");
            location.href = "/qna";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    deleteById:function() {
        let id = $("#id").val();
        $ .ajax({
            type: "DELETE",
            url: "/api/qna/"+id,
            dataType : "json" //생략 가능
        }).done(function (resp) {
            alert("삭제가 완료 되었습니다. ");
            location.href = "/qna";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    replySave:function() {
        let data = {
            userId:$("#userId").val(),
            boardId: $("#postId").val(),
            content: $("#reply-content").val(),

        };

        $ .ajax({
            type: "POST",
            url: `/api/qna/${data.postId}/reply`,
            data: JSON.stringify(data),
            contentType : "application/json; charset=urf-8",
            dataType : "json" //생략 가능
        }).done(function (resp) {
            alert("댓글 작성이 완료 되었습니다. ");
            location.href = "/qna";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    replyDelete : function(boardId, replyId){
        $.ajax({
            type: "DELETE",
            url: `/api/board/${boardId}/reply/${replyId}`,
            dataType: "json"
        }).done(function(resp){
            alert("댓글삭제 성공");
            location.href = "/qna";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
}

index.init();