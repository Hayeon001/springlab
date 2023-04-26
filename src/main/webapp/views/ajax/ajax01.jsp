<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>

    //�ٸ������ index0421.js�� ����
    let ajax01 = {
        init:function (){
            //3�ʿ� �ѹ��� �Լ� ȣ��. js�������
            //setInterval(function (){},3000);
            setInterval(function (){

            //ajax�� ��û�Ѵ�
            $.ajax({
                url:'/getservertime',
                success:function (data){
                    //alert(data);  //System. -> ����
                                  //alert -> �׽�Ʈ�ϰ� �� �����ֱ�
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