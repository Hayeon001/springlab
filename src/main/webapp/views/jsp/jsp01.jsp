<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--c 가 jstl을 쓰겠다는 의미--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script>
    ////////////////////
    //index0421.js로 이동
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
            <%--cust class에 getter가 있어야함--%>

            <h3><c:out value="${cust.id}"/></h3>
            <h3><c:out value="${cust.name}"/></h3>
<%--            Cust cust = new Cust("id01","pwd01","<a href=''>K</a>");
                이름에 링크나 이상한태그 사용하는 것을 방지. 해킹공격 방어--%>

            <h3><fmt:formatDate  value="${cdate}" pattern="yyyy-MM-dd hh:mm:ss"/></h3>

            <%--통화--%>
            <h3><fmt:parseNumber value="${num}" integerOnly="true" type="number"/> : 소수점이하 숨김</h3>
<%--            integerOnly : 소숫점 버리는게 아니라 숨김처리--%>
            <h3><fmt:formatNumber value="${num}" type="currency"/> : ￦</h3>
            <h3><fmt:formatNumber value="${num}" type="number" pattern="###.###$"/> : 소숫점3까지 $</h3>
            <h3>${num*2} : num x 2 산술연산</h3>
            <c:set var="mynum" value="${num*3}"/>
            <h5><c:out value="${mynum}"/> : 산술결과를 mynum에 담아서 출력</h5>
        </div>

    </div>
