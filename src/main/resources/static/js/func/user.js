let index = {
    init:function(){
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-update").on("click", () => {
            this.update();
        });

    },

    save:function() {
        // user 의 save 함수 호출됨.
        // form 의 id 의 값을 받아오기
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()

        };

        // ajax 호출시 default가 비동기 호출
        //ajax 통신 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
        $ .ajax({
            //회원가입 수행 요청 (100초 가정)
            type: "POST",
            url: "/auth/joinProc",
            data: JSON.stringify(data),
            contentType : "application/json; charset=urf-8",
            dataType : "json" //생략 가능
        }).done(function (resp) {
            alert(resp);
            alert("회원가입이 완료 되었습니다. ");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    update:function() {
        let data = {
            id: $("#id").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()

        };

        $ .ajax({
            type: "PUT",
            url: "/user",
            data: JSON.stringify(data),
            contentType : "application/json; charset=urf-8",
            dataType : "json" //생략 가능
        }).done(function (resp) {
            //alert(resp);
            alert("회원수정이 완료 되었습니다. ");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

}

index.init();