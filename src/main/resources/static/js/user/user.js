let index = {
    init:function(){
        $("#btn-save").on("click", () => {
            this.save();
        });
    },

    save:function() {
        // user 의 save 함수 호출됨.
        // form 의 id 의 값을 받아오기
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()

        }
        console.log(data);
        $ .ajax().done().fail(); //ajax 통신 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
    }
}

index.init();