<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html xmlns:sitemesh="http://www.sitemesh.org/schema/sitemesh-config">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><spring:message code="project.title"/>::<sitemesh:write property="title"/></title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico?v=1">
    <link href="${pageContext.request.contextPath}/resources/css/default.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/common.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/vendor/jquery-ui/jquery-ui.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery-ui/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery-placeholder/jquery.placeholder.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.prototype.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.plugins.min.js"></script>

    <c:if test="${not empty message}">
        <script type="text/javascript">
            $().ready(function () {
                alert('${message}');
            });
        </script>
    </c:if>
    <sitemesh:write property="head"/>
    <style>
        body[data-menu=contents] ul .menu-contents a,
        body[data-menu=channel] ul .menu-channel a {
            color: #27b2c4;
        }
    </style>
</head>
<body data-menu="<sitemesh:write property='body.data-menu-code'/>">
<div class="wrap"><!-- bo일때는 bo Class 추가 -->
    <div class="modal-bg"></div>
    <sitemesh:write property="div.contents-sub"/>
    <header>
        <security:authentication property="principal.object" var="member"/>
        <div class="header">
            <div class="logo">
                <span class="menu-open">메뉴 열기</span>
                <h1><img src="${pageContext.request.contextPath}/resources/images/logo_detail.png" alt="V commerce network"></h1>
            </div>
            <div>
                <ul>
                    <li><p>${member.mbrNm}님 안녕하세요!</p></li>
                    <!--<li><a href="#!">관리자그룹명</a></li>-->
                    <li class="login-out">
                        <form id="logoutForm" action="${pageContext.request.contextPath}/security/_logout" method="post">
                            <a href="#!">로그아웃</a><security:csrfInput/></form>
                        <script type="text/javascript">$('#logoutForm a').click(function () {
                            $(this).closest('form').submit();
                        });</script>
                    </li>
                </ul>
            </div>
        </div>
    </header>

    <section>
        <div class="contents">
            <div class="bg-layer"></div>
            <div class="lnb">
                <div class="close-btn">메뉴 닫기</div>
                <ul>
                    <li class="menu-contents"><a href="/contents/manager/contents">구매 콘텐츠 관리</a></li>
                    <li class="menu-channel"><a href="/contents/channel/contentsChannel">콘텐츠 노출채널 설정</a></li>
                    <li class="close"><a href="javascript:alert('현재 오픈 예정인 기능입니다.');">통계 (오픈예정)</a></li>
                    <li class="manual"><a href="${pageContext.request.contextPath}/resources/manual/VCommerceNetwork_Manual.pdf">메뉴얼 다운로드</a>
                    </li>

                    <li class="close"><a href="javascript:alert('현재 개발 예정인 기능입니다.');">제작의뢰 내역</a></li>
                    <li class="close"><a href="javascript:alert('현재 개발 예정인 기능입니다.');">비즈머니 관리</a>
                        <ul>
                            <li><a href="javascript:alert('현재 개발 예정인 기능입니다.');">충전하기</a></li>
                            <li><a href="javascript:alert('현재 개발 예정인 기능입니다.');">자동충전 관리</a></li>
                            <li><a href="javascript:alert('현재 개발 예정인 기능입니다.');">예산설정</a></li>
                        </ul>
                    </li>
                    <li class="close"><a href="javascript:alert('현재 개발 예정인 기능입니다.');">고객센터 문의하기</a></li>
                    <!-- bo lnb 3뎁스 예시 -->
                    <!--
                    <li><a href="#!">컨텐츠관리</a>
                        <ul>
                            <li><a href="#!">컨텐츠 등록</a>
                                <ul>
                                    <li><a href="#!">단일등록</a></li>
                                </ul>
                            </li>
                            <li><a href="#!">컨텐츠 통합관리</a></li>
                        </ul>
                    </li>
                    -->
                </ul>
            </div>

            <sitemesh:write property="body"/>

        </div>
    </section>

    <footer>
        <div class="footer">
            <div class="logo">
                <img src="${pageContext.request.contextPath}/resources/images/logo_footer.png" alt="V commerce network">
            </div>
            <div class="commerce-info-area">
                <ul>
                    <li>(주)옐로모바일</li>
                    <li><span>대표</span>이상혁</li>
                    <li><span>사업자 등록번호</span>114-87-03078</li>
                </ul>
                <ul>
                    <li><span>주소</span>서울시 강남구 도산대로 139 J-TOWER 4층 A동</li>
                    <li><span>제휴문의</span>pg_agency@yellomobile.com</li>
                    <li><span>고객센터</span>cs_coocha@yellomobile.com</li>
                    <li><span>전화</span>02-591-1667</li>
                </ul>
                <p>Copyright©Yellomobile. All Rights Reserved.</p>
            </div>
        </div>
    </footer>
</div>
</body>
</html>
