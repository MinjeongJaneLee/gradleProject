<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="vcms" uri="http://yellomobile.com/taglib/vcommerce" %>

<!DOCTYPE html>

<head>
    <script type="text/javascript">
        $().ready(function () {

            $('#loginForm').submit(function () {
                if (!$('[name=username]').val().trim()) {
                    $('[name=username]+.warning').show();
                    return false;
                }
                else {
                    $('[name=username]+.warning').hide();
                }

                if (!$('[name=password]').val().trim()) {
                    $('[name=password]+.warning').show();
                    return false;
                }
                else {
                    $('[name=password]+.warning').hide();
                }
            });

            $('#idSave').update();
        });
    </script>
</head>

<body>
<div class="login-wrap">
    <div>
        <a href="${pageContext.request.contextPath}/main"><img
                src="${pageContext.request.contextPath}/resources/images/logo_over.png" alt="V commerce network"></a>
        <div class="login-area failed">
            <p class="tit">로그인</p>
            <!--<p class="admin-sign">V-Commerce 관리자 페이지입니다.</p>--> <!-- bo일시 -->
            <c:if test="${not empty param.error}">
                <p class="fail-sign">${SPRING_SECURITY_LAST_EXCEPTION.message}</p>
            </c:if>
            <form:form class="form-horizontal" role="form" servletRelativeAction="/security/_login" id="loginForm">
                <div class="login-input-area">
                    <input type="text" placeholder="아이디" name="username"
                           value="${vcms:ifBlankStr(SPRING_SECURITY_LAST_USERNAME, vcms:ifBlankStr(vcms:decryptBase64(cookie['idSave'].value), ''))}">
                    <span class="warning" style="display: none;">아이디를 입력해 주세요</span>
                    <input type="password" placeholder="비밀번호" name="password">
                    <span class="warning" style="display: none;">비밀번호를 입력해 주세요</span>
                    <!--<p class="admin-address">담당자 : vcommerce@ysmcorp.com</p>--> <!-- bo일시 -->
                </div>
                <div class="check-area">
                    <span class="form_wrap">
                        <input type="checkbox" name="idSave" id="idSave"
                               <c:if test="${not empty cookie['idSave']}">checked</c:if>>
                        <label for="idSave">아이디저장</label>
                    </span>
                </div>
                <button type="submit" class="general type03">로그인</button>
            </form:form>
        </div>
    </div>
</div>
</body>
