<%@ page import="org.apache.commons.codec.binary.Base64" %>
<%@ page import="org.apache.commons.codec.binary.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Plyr Player</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/plyr/plyr.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery/jquery.browser.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plyr/plyr.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/utils.min.js"></script>
    <script type="text/javascript">
        $().ready(function () {
            var player = plyr.setup(document.querySelector('.js-player'), {})[0];
            alert(player.source)
        });
    </script>
</head>

<body>
<div id="player" style="width: 100%; height: 100%;">
    <video controls crossorigin
           poster="https://static.tumblr.com/9cf0b8805f41def61fc992fb24d4a08e/v5fcmdz/Gvcnykk4z/tumblr_static_tumblr_static_3uepo46zql2c0sscg04g44gok_640.jpg"></video>
</div>
</html>

<%
    System.out.println(StringUtils.newStringUtf8(Base64.encodeBase64("al!@#!$@!@$sdkf123asd1!flj".getBytes(), true, true)));
%>