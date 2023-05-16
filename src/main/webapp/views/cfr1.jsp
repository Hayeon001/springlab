<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

</script>
<div class="col-sm-8  text-left ">
    <div class="container">
        <div class="row content">
            <div class="col-sm-10  text-left ">
                <h1>CFR1</h1>
                <h2>${result}</h2>

                <form action="/cfr1impl" method="post" enctype="multipart/form-data" id="cfr1_form" class="form-horizontal well">
                    <%--이미지 보낼땐 enctype --%>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="img">IMAGE:</label>
                        <div class="col-sm-10">
                            <input type="file" name="img" class="form-control" id="img" placeholder="Input img">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button id="cfr1_btn" type="submit" class="btn btn-default">SEND</button>
                            <%--button은 자바스크립트 전송방식.  폼 형태로 보낼땐 submit--%>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>