<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>

    //다만들고나서 index0421.js에 통합
    let ajax01 = {
        init:function (){
            //3초에 한번씩 함수 호출. js제공기능
            //setInterval(function (){},3000);
            setInterval(function (){

            //ajax로 요청한다
            $.ajax({
                url:'/getservertime',
                success:function (data){
                    //alert(data);  //System. -> 금지
                                  //alert -> 테스트하고 꼭 지워주기
                                  //console
                    ajax01.display(data);
                },
                error:function (){
                    alert('Error...')
                }
            });
        },3000);
    },
        display: function(data){
            $('#server_time').text(data);
        }
    };
    $(function(){
        ajax01.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <h3>AJAX01</h3>
    <h4>Server Time</h4>
    <h5 id="server_time"></h5>
    </div>
</div>