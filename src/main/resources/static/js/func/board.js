let index = {
    init:function(){
        $("#btn-board-save").on("click", () => {
            this.save();
        });
        $("#btn-delete").on("click", () => {
            this.deleteById();
        });
        $("#btn-update").on("click", () => {
            this.update();
        });

    },

    save:function() {
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),

        };

        $ .ajax({
            //회원가입 수행 요청 (100초 가정)
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType : "application/json; charset=urf-8",
            dataType : "json" //생략 가능
        }).done(function (resp) {
            alert("글쓰기 완료 되었습니다. ");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    deleteById:function() {
        let id = $("#id").text();
        $ .ajax({
            type: "DELETE",
            url: "/api/board/"+id,
            dataType : "json" //생략 가능
        }).done(function (resp) {
            alert("삭제가 완료 되었습니다. ");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update:function() {
        let id = $("#id").val();
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),

        };

        $ .ajax({
            type: "PUT",
            url: "/api/board/"+id,
            data: JSON.stringify(data),
            contentType : "application/json; charset=urf-8",
            dataType : "json"
        }).done(function (resp) {
            alert("글 수정이 완료 되었습니다. ");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
}

index.init();