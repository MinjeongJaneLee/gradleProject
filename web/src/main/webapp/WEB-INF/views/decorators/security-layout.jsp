<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html xmlns:sitemesh="http://www.sitemesh.org/schema/sitemesh-config">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><spring:message code="project.title"/>::<sitemesh:write property="title"/></title>
    <title>ttt</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico?v=1">
    <link href="${pageContext.request.contextPath}/resources/css/default.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/common.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/vendor/jquery-ui/jquery-ui.min.css" rel="stylesheet">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/vendor/jquery-ui/jquery-ui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/vendor/jquery-placeholder/jquery.placeholder.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/js/common.prototype.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.plugins.min.js"></script>

    <sitemesh:write property="head"/>
</head>

<body>
<div class="wrap"><!-- bo일때는 bo Class 추가 -->
    <sitemesh:write property="body"/>
</div>
</body>
</html>
