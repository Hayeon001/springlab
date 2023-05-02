<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-8 text-left">
    <div class="container">
        <h3>Map Center</h3>
        <img src="/uimg/${gmarker.img}">
        <h4>${gmarker.md}</h4>
        <h4><a href="${gmarker.target}">${gmarker.title}</a></h4>
    </div>
</div>

<div class="row content">
    <div class="col-sm-6  text-left ">
        <h3>Marker Desc Page</h3>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>IMG</th>
                <th>ITM</th>
                <th>PRICE</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${mlist}">
                <tr>
                    <td><img src="/uimg/${m.imgname}"></td>
                    <td>${m.item}}</td>
                    <td>${m.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>