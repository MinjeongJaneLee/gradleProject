<%@ page language="java" contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="1000;url=${pageContext.request.contextPath}/main">
    <script type="text/javascript">
        setTimeout(function () {
            window.location.href = '${pageContext.request.contextPath}/main';
        }, 2500);
    </script>
    <title></title>
</head>
