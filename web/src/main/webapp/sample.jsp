<%@ page import="com.yellomobile.commerce.fo.message.FoCodeMessage" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DCOTYPE html>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
</head>
<body>
<%--
<div>
    <div><spring:message code="project.title"/></div>
    <div><%= FoCodeMessage.MSG_000002_등록된_사용자_정보를_찾을수_없습니다_.getMessage() %>
    </div>
    <ul>
        <li><a href="${pageContext.request.contextPath}/contents/manager/contents">컨텐츠목록</a></li>
        <li><a href="${pageContext.request.contextPath}/contents/channel/contentsChannel">컨텐츠채널목록</a></li>
        <li><a href="${pageContext.request.contextPath}/community/article/list">Article list</a></li>
        <li><a href="${pageContext.request.contextPath}/test/fileUploadPage">File Upload Test</a></li>
        <li><a href="${pageContext.request.contextPath}/test/ffmpeg">FFmpeg Encoding</a>(FFmpeg 설치 필요)</li>
    </ul>
--%>
    <div>
        <iframe id="ccplayer" src="${pageContext.request.contextPath}/embed/videojs?t=NNn21T_zQl3mLf27JfEzKh04fz6mnQmtZZzRpg2K5gU" width="740"
                height="410" frameborder="0" allowfullscreen scrolling="no"></iframe>
    </div>
<%--
    <div>
        <spring:eval expression="@codeService.listBy('ENC')" var="codes"/>
        <select>
            <c:forEach items="${codes}" var="each">
                <option value="${each.code}">${each.codeNm}</option>
            </c:forEach>
        </select>
    </div>
    <security:authorize access="hasRole('USER')">
        <div>
            <h2>로그인 정보</h2>
            <security:authentication property="principal"/>
            <form action="${pageContext.request.contextPath}/security/_logout" method="post">
                <security:csrfInput/>${_csrf.parameterName}=${_csrf.token}
                <button type="submit">logout</button>
            </form>
        </div>
    </security:authorize>
</div>
--%>
<br>
<a href="${pageContext.request.contextPath}/embed/videojs?t=NNn21T_zQl3mLf27JfEzKh04fz6mnQmtZZzRpg2K5gU" target="_blank">링크로 동영상 보기</a>
</body>
</html>
