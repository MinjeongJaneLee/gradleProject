<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>VCN Player</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico?v=1">
    <link href="${pageContext.request.contextPath}/resources/css/default.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/videojs/video-js.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/videojs/videojs-brand.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/videojs/videojs-errors.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/common.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.browser.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/js.cookie.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/utils.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/videojs/video.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/videojs/videojs-brand.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/videojs/videojs-errors.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/videojs/dash.all.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/videojs/videojs-dash.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/videojs/videojs-contrib-hls.min.js"></script>
</head>

<body>
<div class="video-area">
    <video id="my-video" class="video-js" controls preload="none" width="100%" height="410"
           poster="" data-setup='{"customControlsOnMobile":true}' playsinline>
        <p class="vjs-no-js">
            To view this video please enable JavaScript, and consider upgrading to a web browser that
            <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
        </p>
    </video>
    <div class="commerce-number">
        <p>제휴문의</p>
        <span class="commerce-mail">pg_agency@yellomobile.com</span>
        <span class="commerce-num">02-591-2667</span>
    </div>
    <div class="commerce-logo">
        <img src="/resources/images/logo_player-small.png" alt="V">
    </div>
</div>
<script type="text/javascript">
    var player = videojs('my-video');

    var commerceMail = $('.commerce-number span.commerce-mail').text();
    var commerceNum = $('.commerce-number span.commerce-num').text();

    function errorSend(codeVal, message) {
        if(codeVal == undefined || codeVal == '' || codeVal == null);
        else {
            player.error({code: codeVal, dismiss: false, message: message || ""});  // dismiss - ok, x 버튼 노출 y/n
            player.currentTime(0);
            player.pause();
        }
    }

    function commerceNumber() {
        $('.commerce-number').toggle();
    }

    /* bi수정 관련 분기처리 추가 */
    var filter = "win16|win32|win64|mac|macintel";
    if( navigator.platform ) {
        if( filter.indexOf(navigator.platform.toLowerCase()) < 0 ){  // 모바일
            $('.commerce-logo').show();
            $('video').bind('touchstart',function () {
                if($(this).parent('#my-video').attr('class').indexOf('vjs-paused') == -1 ) player.pause();
                else player.play();
            });
        } else {  // 웹
            player.brand({
                image: "/resources/images/logo_player.png",
                title: "V-Commerce Network",
                destination:"javascript:;", // bi수정
                destinationTarget: "_top",
                brandClick: "commerceNumber(commerceMail,commerceNum)"
            });
        }
    }

    $().ready(function () {
        $('.video-area').attr('oncontextmenu','return false'); // 우클릭방지
        var commerceText =  'VCN서비스 제휴문의\n이메일 : '+commerceMail+'\n전화 : '+commerceNum;
        $('.commerce-logo').bind('click',function(){
            player.pause();
            alert(commerceText);
        });
        player.errors(); // 초기화
        player.errors.extend({
            transmitStop: {
//                headline: 'My custom "foo" error', // error.js 에서 headline 삭제
                type: 'PLAYER_ERR_TRANSMIT',
                message: '사용자의 요청에 의해 <br>영상 전송이 중단되었습니다.'
            }
        });

        var referer = encodeURIComponent(document.referrer);
        console.log('referer --->', referer);

        $.ajax({
            url: '${retrieveUrl}',
            data: { r: referer }
        })
        .then(function(result) {
            if (result.success) {

                player.poster(result.data.poster);

                var vods = result.data.sources;

                if ($.browser.mobile) {
                    if (!videojs.Hls.isSupported()) {
                        player.src(vods.hls);
                    } else {
                        player.src(vods.mp4);
                    }
                } else if ($.browser.msie) {
                    player.src(vods.mp4);
                } else if ($.browser.safari) {
                    player.src(vods.hls);
                } else {
                    player.src(vods.mpd);
                }
                player.one('canplay', function(e) {
                    this.play();
                });

            } else {
                errorSend('transmitStop', result.message);
            }

        })
        .done(function(e, data) {
        })
        .fail(function(e, data) {
        })
        .always(function() {
        });

    });
</script>
</body>
</html>