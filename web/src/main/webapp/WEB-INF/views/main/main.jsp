<%@ page language="java" contentType="text/html; utf-8" pageEncoding="UTF-8" %>
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
<div class="wrap">
    <div class="main-header-wrap">
        <div class="main-header">
            <a href="#"><h1>Vcommercenwetwork</h1></a>
            <ul>
                <li class="menu"><a href="javascript:;" data-name="section02">서비스소개</a></li>
                <li class="menu"><a href="javascript:;" data-name="section04">서비스 제공 형태</a></li>
                <li class="menu"><a href="javascript:;" data-name="section05">제휴문의</a></li>
                <li><a href="javascript:goLogin();">로그인</a></li>
            </ul>
        </div>
    </div>
    <div class="main-container">
        <section id="section01">
            <div class="dim-bg"></div>
            <div class="tit-info">
                <p class="tit">맞춤형 비디오 커머스 <br>호스팅 플랫폼</p>
                <p class="sub-tit">V.Commerce Network</p>
                <p class="sub-txt">판매하시는 상품을 더욱 입체적으로 소개하실 수 있도록<br>
                    상품에 대한 영상을 제작해드리고 상품페이지에서 재생되도록 호스팅 기능까지 제공해드립니다.</p>
            </div>
        </section>
        <section id="section02">
            <div>
                <p class="tit">VCN 서비스 프로세스</p>
                <img src="./resources/images/index/section02_bg.png" alt="">
            </div>
        </section>
        <section id="section03">
            <div>
                <p class="tit">VCN 서비스 도입 장점</p>
                <ul class="list-area">
                    <li>전문 영상 제작팀을 통해 수준 높은 상품 영상을 제작해 드립니다.</li>
                    <li>운영하시는 쇼핑몰 및 오픈마켓에 제작된 상품 영상을 손쉽게 등록하실 수 있습니다.</li>
                    <li>채널별 / 상품별 영상 사용 통계를 제공하여 구매전환을 향상시킬 수 있습니다.</li>
                </ul>
                <div class="img-area">
                    <img src="./resources/images/index/section03_01_bg.png" alt="">
                    <img src="./resources/images/index/section03_02_bg.png" alt="">
                </div>
            </div>
        </section>
        <section id="section04">
            <div>
                <p class="tit">서비스 제공 형태</p>
                <div class="table-box">
                    <div>
                        <p class="sub-tit">상품 상세페이지 내, 플레이어 제공</p>
                        <p class="sub-txt">html 의 copy &amp; paste로 손쉽게 영상을<br>
                            등록하고 상품 상세페이지 내에 플레이어를<br>
                            제공합니다.</p>
                    </div>
                    <div>
                        <img src="./resources/images/index/section04_01_bg.png" alt="">
                    </div>
                </div>

                <div class="table-box">
                    <div>
                        <p class="sub-tit">새창 형태 플레이어 링크 제공</p>
                        <p class="sub-txt">상품 상세페이지 내에 영상 링크 단순 등록으로<br>
                            새창 형태의 플레이어를 제공합니다.</p>
                    </div>
                    <div>
                        <img src="./resources/images/index/section04_02_bg.png" alt="">
                    </div>
                </div>

                <div class="table-box">
                    <div>
                        <p class="sub-tit">영상 사용 통계 제공</p>
                        <p class="sub-txt">채널별로 재생된 영상의 사용형태를 한눈에<br>
                            확인할 수 있습니다.</p>
                    </div>
                    <div>
                        <img src="./resources/images/index/section04_03_bg.png" alt="">
                    </div>
                </div>

                <div class="table-box">
                    <div>
                        <p class="sub-tit">맞춤형 상품영상 구매 서비스</p>
                        <p class="sub-txt">원하는 영상을 키워드 및 카테고리로 검색하여<br>
                            실시간으로 구매 후, 적용할 수 있습니다.</p>
                        <span class="label">추후 제공 예정</span>
                    </div>
                    <div>
                        <img src="./resources/images/index/section04_04_bg.png" alt="">
                    </div>
                </div>
            </div>
        </section>
        <section id="section05">
            <div>
                <p class="tit">VCN 서비스가 궁금하시면 언제든 문의주세요</p>
                <ul class="inquiry">
                    <li><a href="mailto:pg_agency@yellomobile.com">pg_agency@yellomobile.com</a></li>
                    <li><a href="tel:02-591-1667">02-591-1667</a></li>
                </ul>
            </div>
        </section>
        <footer>
            <div class="footer">
                <div class="logo">
                    <img src="./resources/images/logo_footer.png" alt="V commerce network">
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
</div>
<!-- 170929 수정 -->
<script>
    $(document).ready(function () {
        $(window).bind('load, scroll', function () {
            if ($(this).scrollTop() > 655) $('.main-header-wrap').addClass('scrolled');
            else $('.main-header-wrap').removeClass('scrolled');
            if ($(this).scrollTop() > 655 && $(this).scrollTop() < $('#section04').offset().top - 104) {
                $('.main-header ul li').removeClass('on');
                $('.main-header ul li:first-child').addClass('on');
            } else if ($(this).scrollTop() >= $('#section04').offset().top - 104 && $(this).scrollTop() < 3526) {
                $('.main-header ul li').removeClass('on');
                $('.main-header ul li:nth-child(2)').addClass('on');
            } else if ($(this).scrollTop() >= 3526) {
                $('.main-header ul li').removeClass('on');
                $('.main-header ul li:nth-child(3)').addClass('on');
            } else {
                $('.main-header ul li').removeClass('on');
            }
        });
        $('.main-header li.menu a').bind('click', function () {
            var _this = $(this);
            $('body,html').stop().animate({
                scrollTop: $('#' + $(this).attr('data-name')).offset().top - 104 + 'px'
            }, 500, function () {
                $('.main-header li').removeClass('on');
                _this.parent('li').addClass('on');
            });
        });
    })

    function goLogin() {
        window.location.href = '${pageContext.request.contextPath}/security/login';
    }
</script>
</body>
</html>
