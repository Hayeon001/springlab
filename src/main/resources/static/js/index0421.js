//login.jsp
let login_form = {
    init:function (){
        $('#login_btn').click(function (){
            login_form.send();  //init이벤트 클릭되면 send 호출
        });
    },
    send:function (){
        $('#login_form').attr({
            'action':'/loginimpl',  //implement
            'method':'post',  //MainController로 보내기
        }); //여러
        $('#login_form').submit();
    }
};

//register.jsp
let update_form = {
    init:function(){
        $('#register_btn').click(function(){
            update_form.send();
        });
    },
    send:function(){
        //submit login_form to server
        $('#update_form').attr({
            'action':'/registerimpl',
            'method':'post'
        });
        $('#update_form').submit();

    }
};

//jsp01
let jsp01 = {
    data:0,
    // init:function (){
    //     //this.data = ${num},
    //     //this.data = '<c:out value="${num}"/>';
    //     this.data = 'test';
    //     this.display();
//     },
//     display:function (){
//     $('#jsp01').text(this.data+'');
// }
    init:function (num){

        this.data = num;
        this.display();
    },
    display:function (){
        $('#jsp01').text(this.data+'');
    }
};