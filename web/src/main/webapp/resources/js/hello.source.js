(function () {
    console.log('hello');

    var dialog = function () {
        window.open('http://naver.com', '');
    };

    dialog();
    setTimeout(dialog, 1000);
})();
