<%@ tag language="java" body-content="empty" display-name="page" pageEncoding="utf-8" %>
<%@ attribute name="pageObject" required="true" rtexprvalue="true" type="java.lang.Object" %>
<%@ attribute name="requestUrl" required="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="vcms" uri="http://yellomobile.com/taglib/vcommerce" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${empty requestUrl}">
    <c:set var="requestUrl" value="${vcms:ifBlankStr(requestScope['javax.servlet.forward.request_uri'], '/')}"/>
</c:if>
<c:set var="makeParams" value="${vcms:makeParametersExcludePagination(paramValues)}"/>
<div style="display: none;">
    ${requestUrl}
    ${pageObject}
    ${vcms:makeParametersExcludePagination(paramValues)}
</div>

<div class="page_wrap">
    <div class="page">
        <a href="${requestUrl}?page=1&${makeParams}" class="pg first"><span>첫페이지</span></a>
        <a href="${requestUrl}?page=${vcms:max(pageObject.pageNum - pageObject.navigatePages, 1)}&${makeParams}"
           class="pg prev"><span>이전페이지</span></a>
        <c:forEach items="${pageObject.navigatepageNums}" var="n">
            <a href="${requestUrl}?page=${n}&${makeParams}"
               class='<c:if test="${n eq pageObject.pageNum}">hvtc on</c:if><c:if test="${n ne pageObject.pageNum}">hvtc</c:if>'>${n}</a>
        </c:forEach>
        <a href="${requestUrl}?page=${vcms:min(pageObject.pages, pageObject.pageNum + pageObject.navigatePages)}&${makeParams}"
           class="pg next"><span>다음페이지</span></a>
        <a href="${requestUrl}?page=${pageObject.pages}&${makeParams}" class="pg last"><span>마지막페이지</span></a>
    </div>
</div>
