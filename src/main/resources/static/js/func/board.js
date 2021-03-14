let index = {
    init:function(){
        $("#btn-board-save").on("click", () => {
            this.save();
        });
        $("#btn-delete").on("click", () => {
            this.deleteById();
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
        var id = $("#id").text();
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
    }
}

index.init();