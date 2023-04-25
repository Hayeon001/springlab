<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    let ajax02={
        init:function (){
            //�ʱ�ȭ
            this.keyupevent();
            this.sendevent();
        },
        keyupevent:function (){ <%--keyup�̺�Ʈ�� �߻��ϸ�--%>
            $('#r_form> input[name=id]').keyup(function (){
                var id = $(this).val();
                //ID�� 4�ڸ� �̻��� �ȵǸ� �˷��ֱ�
                if(id.length <= 3){
                    $('#r_form> #idspan').text('ID�� 4�ڸ� �̻��Դϴ�');
                    return ;
                    //return���ϸ� 4�ڸ��� �ƴ϶� �����ε� �Ʒ� �ڵ尡 ����ǹ���.
                    //�帧����!!
                }
                //alert(id);
                $.ajax({
                    url:'/checkid',
                    data:{'id':id}, <%--id��� �̸����� id ���� �����ڴ�--%>
                    success:function (result){<%--����� ����Ҽ� �ִϾ���--%>
                        if(result ==0){
                            //$('').text('��밡���մϴ�.'); ��Ȯ�� ǥ��
                            $('#r_form> #idspan').text('��밡���մϴ�.');
                            //��Ŀ�� �̵�
                            $('#r_form> input[name=pwd]').focus();
                        } else{
                            $('#r_form> #idspan').text('���Ұ����մϴ�.')
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