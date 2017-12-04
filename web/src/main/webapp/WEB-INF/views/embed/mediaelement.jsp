<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>MediaElement Player</title>
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/mediaelement/mediaelementplayer.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery/jquery.browser.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/mediaelement/mediaelement-and-player.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/utils.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/commerce-player.min.js"></script>
    <script type="text/javascript">
        $().ready(function () {
            console.log('ready');

            $('#player video')/*.append($('<source>').attr({
             src: 'http://10.0.4.22:1935/vod/_define_/d1/d2/d3/d4/smil:test.smil/manifest.mpd',
             type: 'application/dash+xml',
             }))*/.mediaelementplayer({
                stretching: 'auto',
                success: function (player, node) {
                    console.log(player.rendererName);
                },
            });//.attr({src: 'http://10.0.4.22:1935/vod/_define_/d1/d2/d3/d4/smil:test.smil/manifest.mpd'})
        });
    </script>
</head>
<body>

<div id="player" style="width: 100%; height: 100%;">
    <video width="320" height="240" class="mejs__player" preload="none" controls playsinline webkit-playsinline>
        <%--<source type="application/dash+xml" src="http://10.0.4.22:1935/vod/_define_/d1/d2/d3/d4/smil:test.smil/manifest.mpd">--%>
        <source type="application/dash+xml" src="http://10.0.4.22:1935/vod/_define_/d1/d2/d3/d4/smil:test.smil/manifest.mpd">
    </video>
</div>

</body>
</html>
