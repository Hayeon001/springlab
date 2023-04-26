<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    #getdata > div{
        width: 500px;
        border: 2px solid red;
    }
</style>
<script>
    let ajax03 ={
        init:function (){
            $('#getdata > button').click(function (){
                //서버에 요청해서 데이터 받기
                $.ajax({
                    url:'/getdata',
                    success:function (data){
                        //alert(data);
                        ajax03.display(data);
                        //json 으로 데이터 받아서 div 영역에 데이터 뿌릴거야
                    }
                })
            });

            //버튼을 누르지 않아도 3초에 한번씩
            //setInterval(function (){},3000);
            setInterval(function (){
                $.ajax({
                    url:'/getdata',
                    success:function(data){
                        ajax03.display(data);
                    }
                });
            },3000)
        },
        display:function(data){

            let result ="";
            $(data).each(function (index,item){
                //index
                //id
                result += '<h4>';
                result += item.id +' '+item.pwd +' '+item.name;
                result += '</h4>';
            });
            $('#getdata > div').html(result);
        },
    }
    $(function(){
        ajax03.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="container" id="getdata">
        <h3>AJAX03</h3>
        <button class="btn"class="btn btn-success">GET DATA</button>
        <div></div>
    </div>
</div>