<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="col-sm-8 text-left">
        <div class ="container">
            <h3>JSP 02</h3>

            <%--rcust�� null�� �ƴϸ� ${rcust.id} ���--%>
            <c:if test="${rcust != null}">
                <h4>${rcust.id}</h4>

                <%--id01�̸� �ݼ��� �����̶�� ���--%>
                <c:if test="${rcust.id == 'id01'}">
                    <h4>�ݼ��� ����</h4>
                </c:if>
            </c:if>

            <!-- JSTL if else-->
<%--        <c:choose>--%>
<%--            <c:when test=""></c:when>--%>
<%--            <c:when test=""></c:when>--%>
<%--            <c:otherwise></c:otherwise>--%>
<%--        </c:choose>--%>
            <c:choose>
                <c:when test="${num==3}">
                    <h3>Num is 3</h3>
                </c:when>
                <c:when test="${num==2}">
                    <h3>Num is 2</h3>
                </c:when>
                <c:otherwise>
                    <h3>Num is 1</h3>
                </c:otherwise>
            </c:choose>

            <h4>End Page</h4>
        </div>

    </div>
