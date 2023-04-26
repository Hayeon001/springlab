<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--c �� jstl�� ���ڴٴ� �ǹ�--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script>
    ////////////////////
    //index0421.js�� �̵�
    <%--let jsp01 = {--%>
    <%--    data:0,--%>
    <%--    init:function (){--%>
    <%--        //this.data = ${num},--%>
    <%--        this.data = '<c:out value="${num}"/>';--%>
    <%--        this.display();--%>
    <%--    },--%>
    <%--    display:function (){--%>
    <%--        $('#jsp01').text(this.data+'');--%>
    <%--    }--%>
    <%--};--%>
    ////////////////////

    $(function(){
        jsp01.init(${num});
    });
</script>

    <div class="col-sm-8 text-left">
        <div class ="container">
            <h3 id="jsp01">JSP 01</h3>
            <h3>${num}</h3>
            <h3>${cust}</h3>
            <h3>${cust.id}</h3>
            <h3>${cust.name}</h3>
            <h3>${cdate}</h3>
            <%--cust class�� getter�� �־����--%>

            <h3><c:out value="${cust.id}"/></h3>
            <h3><c:out value="${cust.name}"/></h3>
<%--            Cust cust = new Cust("id01","pwd01","<a href=''>K</a>");
                �̸��� ��ũ�� �̻����±� ����ϴ� ���� ����. ��ŷ���� ���--%>

            <h3><fmt:formatDate  value="${cdate}" pattern="yyyy-MM-dd hh:mm:ss"/></h3>

            <%--��ȭ--%>
            <h3><fmt:parseNumber value="${num}" integerOnly="true" type="number"/> : �Ҽ������� ����</h3>
<%--            integerOnly : �Ҽ��� �����°� �ƴ϶� ����ó��--%>
            <h3><fmt:formatNumber value="${num}" type="currency"/> : ��</h3>
            <h3><fmt:formatNumber value="${num}" type="number" pattern="###.###$"/> : �Ҽ���3���� $</h3>
            <h3>${num*2} : num x 2 �������</h3>
            <c:set var="mynum" value="${num*3}"/>
            <h5><c:out value="${mynum}"/> : �������� mynum�� ��Ƽ� ���</h5>
        </div>

    </div>
