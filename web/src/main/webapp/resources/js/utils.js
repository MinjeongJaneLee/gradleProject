function throttle(fn, threshhold, scope) {
    threshhold || (threshhold = 250);
    var last, deferTimer;
    return function () {
        var context = scope || this;

        var now = +new Date,
            args = arguments;
        if (last && now < last + threshhold) {
            // hold on to it
            clearTimeout(deferTimer);
            deferTimer = setTimeout(function () {
                last = now;
                fn.apply(context, args);
            }, threshhold);
        } else {
            last = now;
            fn.apply(context, args);
        }
    };
};

var deviceType = !!$.browser.mobile ? 'mobile' : !!$.browser.desktop ? 'desktop' : 'others';
var osType = !!$.browser.mobile ? (!!$.browser.android ? 'android' : (!!$.browser.isiPhone ? 'iphone' : 'others')) : '';
var COOKIE_ID = 'cid';


function randomStr(m) {
    var m = m || 20; s = '', r = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    for (var i=0; i < m; i++) { s += r.charAt(Math.floor(Math.random()*r.length)); }
    return s;
}

function getCid() {
    var cid = Cookies.get(COOKIE_ID);
    if (!cid) {
        cid = randomStr();
        Cookies.set(COOKIE_ID, cid, 365);
    }
    return cid;
}
