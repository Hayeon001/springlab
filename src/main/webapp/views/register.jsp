<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="col-sm-8 text-left">
    <div class="container" style="width: 70%">
        <h1>Register Page</h1><br/><br/>

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
            <label class="control-label col-sm-2" for="name">Name: </label>
            <div class="col-sm-10">
                <input type="text" name="name" class="form-control" id="name" placeholder="이름을 입력하세요">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Register</button>
            </div>
        </div>



<%--        --%>
<%--        --%>
    </div>
</div>