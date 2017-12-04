<%@ page language="java" contentType="text/html; charset=utf-8" isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>V.commerce</title>
    <link href="${pageContext.request.contextPath}/resources/css/default.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/vendor/jquery-ui/jquery-ui.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery-ui/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery-placeholder/jquery.placeholder.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</head>
<body>
<div class="wrap error"><!-- bo일때는 bo Class 추가 -->
    <div class="error-wrap">
        <div class="logo-thumb">
            <img src="${pageContext.request.contextPath}/resources/images/logo_over.png" alt="V commerce network">
        </div>
        <p class="tit">요청하신 페이지를 불러오지 못했습니다.</p>
        <p class="sub-tit">서비스 이용에 불편을 드려 죄송합니다.<br>
            네트워크 연결 문제 등으로 페이지를 확인할 수 없습니다.<br>
            잠시 후, 다시 이용해 주세요.</p>
    </div>
</div>
</body>
</html>