<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    let ajax02={
        init:function (){
            //초기화
            this.keyupevent();
            this.sendevent();
        },
        keyupevent:function (){ <%--keyup이벤트가 발생하면--%>
            $('#r_form> input[name=id]').keyup(function (){
                var id = $(this).val();
                //ID가 4자리 이상이 안되면 알려주기
                if(id.length <= 3){
                    $('#r_form> #idspan').text('ID는 4자리 이상입니다');
                    return ;
                    //return안하면 4자리가 아니라 오류인데 아래 코드가 실행되버림.
                    //흐름제어!!
                }
                //alert(id);
                $.ajax({
                    url:'/checkid',
                    data:{'id':id}, <%--id라는 이름으로 id 값을 보내겠다--%>
                    success:function (result){<%--결과값 사용할수 있니없니--%>
                        if(result ==0){
                            //$('').text('사용가능합니다.'); 명확히 표시
                            $('#r_form> #idspan').text('사용가능합니다.');
                            //포커스 이동
                            $('#r_form> input[name=pwd]').focus();
                        } else{
                            $('#r_form> #idspan').text('사용불가능합니다.')
                        }
                    }
                })
            })
        },
        sendevent:function (){}
    };
    $(function(){
        ajax02.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <h3>AJAX02</h3>
        <form id="r_form">
<%----%>
            ID<input type="text" name="id">
            <span id="idspan"></span><br/>
            PWD<input type="text" name="pwd"><br/>
            NAME<input type="text" name="name"><br/>
            <input type="button" value="Register"><br/>
        </form>
    </div>
</div>