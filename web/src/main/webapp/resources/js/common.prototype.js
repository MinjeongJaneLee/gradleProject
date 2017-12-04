/**
 * 만들어 내는 클래스
 */
var Generator = function () {
};
Generator.uuid = function () {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
        return r.toString(16);
    });
}

/**
 * 날짜를 문자열로 변경 ex ) (new Date("2008-12-31")).format("yyyy.MM.dd")
 */
Date.prototype.format = function (f) {
    if (!this.valueOf()) return '';

    var weekName = ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'];
    var weekNameShort = ['일', '월', '화', '수', '목', '금', '토'];
    var d = this;
    var h;
    return f.replace(/(yyyy|yy|HF|QQ|MM|dd|ww|E|HH|hh|mm|ss|a\/p)/gi, function ($1) {
        switch ($1) {
            case 'yyyy':
                return d.getFullYear();
            case 'yy':
                return (d.getFullYear() % 1000).zf(2);
            case 'HF':
                return d.getHalf().zf(2);
            case 'QQ':
                return d.getQuarter().zf(2);
            case 'MM':
                return (d.getMonth() + 1).zf(2);
            case 'dd':
                return d.getDate().zf(2);
            case 'ww':
                return d.getWeek().zf(2);
            case 'E':
                return weekName[d.getDay()];
            case 'e':
                return weekNameShort[d.getDay()];
            case 'HH':
                return d.getHours().zf(2);
            case 'hh':
                return ((h = d.getHours() % 12) ? h : 12).zf(2);
            case 'mm':
                return d.getMinutes().zf(2);
            case 'ss':
                return d.getSeconds().zf(2);
            case 'a/p':
                return d.getHours() < 12 ? '오전' : '오후';
            default:
                return $1;
        }
    });
};

/**
 * Date에 연도를 더함
 */
Date.prototype.addYears = function (v) {
    this.setFullYear(this.getFullYear() + v);
    return this;
};

/**
 * Date에 월을 더함
 */
Date.prototype.addMonths = function (v) {
    this.setMonth(this.getMonth() + v);
    return this;
};

/**
 * Date에 일을 더함
 */
Date.prototype.addDays = function (v) {
    this.setDate(this.getDate() + v);
    return this;
};

/**
 * Date에 시간을 더함
 */
Date.prototype.addHours = function (v) {
    this.setHours(this.getHours() + v);
    return this;
};

/**
 * Date에 분을 더함
 */
Date.prototype.addMinutes = function (v) {
    this.setMinutes(this.getMinutes() + v);
    return this;
};

/**
 * Date에 초를 더함
 */
Date.prototype.addSeconds = function (v) {
    this.setSeconds(this.getSeconds() + v);
    return this;
};


/**
 * 날짜 까지 짜름
 */
Date.prototype.trunc = function () {
    this.setTime(Math.trunc(this.getTime() / ((24 * 60 * 60) * 1000)) * ((24 * 60 * 60) * 1000));
    return this;
};

/**
 * 문자 수 만큼 반복
 */
String.prototype.repeat = function (len) {
    var s = '', i = 0;
    while (i++ < len) {
        s += this;
    }
    return s;
};

/**
 * HTML 제거
 */
String.prototype.escapeHTML = function () {
    return this.replace(/\</g, '&lt;').replace(/\>/g, '&gt');
};

/**
 * 숫자 앞에 문자0을 채움
 */
String.prototype.zf = function (len) {
    return '0'.repeat(len - this.length) + this;
};

/**
 * message등을 표시할 때 format을 사용할 수 있도록 지원함.
 */
String.prototype.format = function () {
    var tokenCount = arguments.length;
    var s = this;
    for (var token = 0; token < tokenCount; token++) {
        s = s.replace(new RegExp('\\{' + token + '\\}', 'gi'), arguments[token]);
    }
    return s;
};

String.prototype.replaceAll = function (str1, str2) {
    var temp_str = this.trim();
    temp_str = temp_str.replace(eval("/" + str1 + "/gi"), str2);
    return temp_str;
}
;
/**
 * 날짜 형태를 날짜로 변경
 */
String.prototype.parseDate = function (f) {
    var v = this;
    var y, m, d;
    f.replace(/(yyyy|yy|HF|QQ|MM|dd|ww|E|HH|hh|mm|ss|a\/)/gi, function ($1, o, s) {
        switch ($1) {
            case 'yyyy':
                y = v.substr(s, 4);
            case 'MM':
                m = v.substr(s, 2);
            case 'dd':
                d = v.substr(s, 2);
            default:
                break;
        }
        return $1;
    });
    return new Date(y, m - 1, d);
};

/**
 * 금액 3자리마다 콤마
 */
String.prototype.numberWithCommas = Number.prototype.numberWithCommas = function () {
    return this.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
};

/**
 * 문자열에서 숫자만 찾아서 숫자로 바꿔 줌
 */
String.prototype.toInt = function () {
    return Number(this.replace(/[^\d]/g, ''));
};


String.prototype.toFloat = function () {
    return Number(this.replace(/[^\d\.]/g, ''));
};

/**
 * 숫자 앞에 문자 0 채움
 */
Number.prototype.zf = function (len) {
    return this.toString().zf(len);
};


/**
 * 숫자를 날자로 변경
 */
Number.prototype.formatDate = function (pattern) {
    return new Date(this).format(pattern);
};


/**
 * 배열의 합을 구합
 */
Array.prototype.inject = function (callback, init) {
    var s = init,
        i = 0;
    while (i < this.length) {
        s = callback.call(null, s, this[i]);
        i++;
    }
    return s;
};


/**
 * 입력된 start..end 부분의 배열을 반환
 */
Array.range = function (start /* or count */, end) {
    var arr = [];
    if (!end) {
        end = start - 1;
        start = 0;
    }
    for (var i = start; i <= end; ++i) {
        arr.push(i);
    }
    return arr;
};
