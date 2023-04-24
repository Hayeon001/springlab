<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    // var a;
    // var a;
    //var는 중복체크 안해. 오류 아님

    ////////////////////
    //index0421.js로 이동
    // let login_form = {
    //     init:function (){
    //         $('#login_btn').click(function (){
    //            login_form.send();  //init이벤트 클릭되면 send 호출
    //         });
    //     },
    //     send:function (){
    //         $('#login_form').attr({
    //             'action':'/loginimpl',  //implement
    //             'method':'post',  //MainController로 보내기
    //         }); //여러
    //         $('#login_form').submit();
    //     }
    // };
    ////////////////////

    $(function(){
        login_form.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="container" style="width: 70%">
        <h1>Login Page</h1> <br/><br/>
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#home">login</a></li>
            <li><a data-toggle="tab" href="#menu2">naver</a></li>
            <li><a data-toggle="tab" href="#menu3">kakao</a></li>
        </ul>

        <div class="tab-content">
            <div id="home" class="tab-pane fade in active"><br/><br/>
                <%--form--%>
                <form class="form-horizontal" id="login_form">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="id">ID : </label>
                        <div class="col-sm-10">
                            <input type="text" name="id" class="form-control" id="id" placeholder="아이디를 입력하세요">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="pwd">Pwd : </label>
                        <div class="col-sm-10">
                            <input type="password" name="pwd" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label><input type="checkbox" name="remember"> Remember me</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" id="login_btn" class="btn btn-default">Login</button>
                        </div>
                    </div>
                </form> <%--form end--%>

            </div>
            <div id="menu2" class="tab-pane fade">
                <h3>Naver</h3>
                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
            </div>
            <div id="menu3" class="tab-pane fade">
                <h3>kakao</h3>
                <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
            </div>
        </div>
    </div>
</div>