var tableCheckBox = function () {
    var chkBox = $('.table-area tr:not(".disabled") .form_wrap input[type="checkbox"]').siblings('label');
    var checked = 'checked'
    chkBox.bind('click', function () {
        if ($(this).siblings('input[type="checkbox"]').attr('class') === 'allChk') {
            var allInput = $(this).closest('.table-area').find('td .form_wrap');
            if ($(this).closest('.form_wrap').hasClass(checked)) {
                $(this).closest('.form_wrap').removeClass(checked);
                allInput.closest('tr').removeClass(checked).find('.form_wrap').removeClass(checked).find('input[type="checkbox"]').prop(checked, false);
                if (Boolean($(this).siblings('input').attr('disabled'))) $(this).closest('tr').removeClass('disabled');
            } else {
                console.log('$(this) : ', $(this).closest('.form_wrap'))
                $(this).closest('.form_wrap').addClass(checked);
                allInput.closest('tr:not(".disabled")').addClass(checked).find('.form_wrap').addClass(checked).find('input[type="checkbox"]').prop(checked, true);
                if (Boolean($(this).siblings('input').attr('disabled'))) $(this).closest('tr:not(".checked")').addClass('disabled');
            }
        } else {
            if ($(this).closest('.form_wrap').hasClass(checked)) {
                if (Boolean($(this).closest('tr').length)) {
                    $(this).closest('tr').removeClass(checked);
                    if (Boolean($(this).siblings('input').attr('disabled'))) $(this).closest('tr').removeClass('disabled');
                }
                $(this).closest('tr').removeClass(checked);
                $(this).closest('.form_wrap').removeClass(checked);
            } else {
                if (Boolean($(this).closest('tr').length)) {
                    $(this).closest('tr').addClass(checked);
                    if (Boolean($(this).siblings('input').attr('disabled'))) $(this).closest('tr').addClass('disabled');
                }
                $(this).closest('.form_wrap').addClass(checked);
            }
        }
        if ($(this).closest('.table-area').find('tr.checked').length < $(this).closest('.table-area').find('tbody td input').length - $(this).closest('.table-area').find('tr.disabled').length) {
            $(this).closest('.table-area').find('thead .form_wrap').removeClass(checked);
            $(this).closest('.table-area').find('thead .form_wrap input').prop(checked, false);
        } else {
            $(this).closest('.table-area').find('thead .form_wrap').addClass(checked);
            $(this).closest('.table-area').find('thead .form_wrap input').prop(checked, true);
        }


    });
};

var normalCheckBox = function () {
    var chkBox = $('.check-area .form_wrap input[type="checkbox"]').siblings('label');
    var checked = 'checked'
    chkBox.bind('click', function () {
        if ($(this).siblings('input[type="checkbox"]').attr('class') === 'allChk') {
            if ($(this).closest('.form_wrap').hasClass(checked)) {
                $(this).closest('.form_wrap').removeClass(checked);
                $(this).closest('.title').siblings('.cont').find('.form_wrap').removeClass(checked);
                $(this).siblings('input[type="checkbox"]').prop(checked, false);
                $(this).closest('.title').siblings('.cont').find('input[type="checkbox"]').prop(checked, false);
            } else {
                $(this).closest('.form_wrap').addClass(checked);
                $(this).closest('.title').siblings('.cont').find('.form_wrap').addClass(checked);
                $(this).siblings('input[type="checkbox"]').prop(checked, true);
                $(this).closest('.title').siblings('.cont').find('input[type="checkbox"]').prop(checked, true);
            }
        } else {
            if ($(this).closest('.form_wrap').hasClass(checked)) {
                if (Boolean($(this).closest('tr').length)) {
                    $(this).closest('tr').removeClass(checked);
                    if (Boolean($(this).siblings('input').attr('disabled'))) $(this).closest('tr').removeClass('disabled');
                }
                $(this).closest('tr').removeClass(checked);
                $(this).closest('.form_wrap').removeClass(checked);
            } else {
                if (Boolean($(this).closest('tr').length)) {
                    $(this).closest('tr').addClass(checked);
                    if (Boolean($(this).siblings('input').attr('disabled'))) $(this).closest('tr').addClass('disabled');
                }
                $(this).closest('.form_wrap').addClass(checked);
            }
        }
    });
};

var depthCheckBox = function () {
    var chkBox = $('.depth-check-area .form_wrap input[type="checkbox"]').siblings('label');
    var checked = 'checked'
    chkBox.bind('click', function () {

        if ($(this).siblings('input[type="checkbox"]').attr('class') === 'allChk') {
            if ($(this).closest('.form_wrap').hasClass(checked)) {
                $(this).closest('.form_wrap').removeClass(checked);
                $(this).closest('.title').siblings('.cont').find('.form_wrap').removeClass(checked).find('input[type="checkbox"]').prop(checked, false);
            } else {
                $(this).closest('.form_wrap').addClass(checked);
                $(this).closest('.title').siblings('.cont').find('.form_wrap').addClass(checked).find('input[type="checkbox"]').prop(checked, true);
            }
        } else {
            if ($(this).closest('li').find('ul').length != 0) {
                if ($(this).closest('.form_wrap').hasClass(checked)) {
                    $(this).closest('.form_wrap').removeClass(checked);
                    $(this).closest('ul').siblings('.form_wrap').removeClass(checked).find('input').prop(checked, false);
                    $(this).closest('li').find('ul .form_wrap').removeClass(checked).find('input').prop(checked, false);
                } else {
                    $(this).closest('.form_wrap').addClass(checked)
                    $(this).closest('ul').siblings('.form_wrap').addClass(checked).find('input').prop(checked, true);
                    $(this).closest('li').find('ul .form_wrap').addClass(checked).find('input').prop(checked, true);
                }
            } else {
                if ($(this).closest('.form_wrap').hasClass(checked)) {
                    $(this).closest('.form_wrap').removeClass(checked)
                    if ($(this).closest('ul').find('.checked').length == 0) {
                        if ($(this).parents('ul').length - 1 == 2) {
                            $(this).closest('.one-depth').children('.form_wrap').removeClass(checked).children('input').prop(checked, false);
                            $(this).closest('.two-depth').children('.form_wrap').removeClass(checked).children('input').prop(checked, false);
                        } else if ($(this).parents('ul').length - 1 == 1) {
                            $(this).closest('.one-depth').children('.form_wrap').removeClass(checked).children('input').prop(checked, false);
                            $(this).closest('.two-depth').children('.form_wrap').removeClass(checked)
                        }
                    }
                } else {
                    $(this).closest('.form_wrap').addClass(checked)
                    if ($(this).parents('ul').length - 1 == 2) {
                        $(this).closest('.one-depth').children('.form_wrap').addClass(checked).children('input').prop(checked, true);
                        $(this).closest('.two-depth').children('.form_wrap').addClass(checked).children('input').prop(checked, true);
                    } else if ($(this).parents('ul').length - 1 == 1) {
                        $(this).closest('.one-depth').children('.form_wrap').addClass(checked).children('input').prop(checked, true);
                        $(this).closest('.two-depth').children('.form_wrap').addClass(checked)
                    }
                }
            }
            if ($(this).closest('.cont').find('.checked').length > 0) {
                $(this).closest('.cont').siblings('.title').find('.form_wrap').addClass(checked).children('input').prop(checked, true)
            } else {
                $(this).closest('.cont').siblings('.title').find('.form_wrap').removeClass(checked).children('input').prop(checked, false);
            }
        }
    });


};


var addressTab = function () {
    $('.address-search-wrap .tab a').bind('click', function () {
        var dataName = $(this).attr('data-name');
        $('.address-search-wrap .tab a').removeClass('on');
        $(this).addClass('on')
        $('.address-cont').hide();
        $('.address-' + dataName).show();
    });
};

var buttonClick = function () {
    $('.form-address button').bind('click', function () {
        $('.layer-pop-wrap.address').show();
    });

    $('.admin-setting').bind('click', function () {
        $('.layer-pop-wrap.admin-group').show();
    });

    $('.date-area button').bind('click', function () {
        $('.date-area button').removeClass('on')
        $(this).addClass('on');
    });
};


var lnbLayer = function () {
    $('.close-btn').bind('click', function () {
        $('.lnb').animate({
            'left': '-240px',
            'paddingRight': '32px'
        }, 500, function () {
            $('.modal-bg').hide();
        })
    });
    $('.menu-open').bind('click', function () {
        $('.lnb').animate({
            'left': '0px',
            'paddingRight': '64px'
        }, 500, function () {
            $('.modal-bg').show();
        });
    });

    $('.lnb li:not(".close") a').bind('click', function () {
        $('.lnb li a').removeClass('on');
        $(this).addClass('on');
    })
};

var datePicker = function () {
    var dateFormat = "mm/dd/yy",
        from = $("#from")
            .datepicker({
                defaultDate: "new Date()",
                changeMonth: true,
                numberOfMonths: 1,
                dateFormat: 'yy-mm-dd'
            })
            .on("change", function () {
                to.datepicker("option", "minDate", getDate(this));
            }),
        to = $("#to").datepicker({
            defaultDate: new Date(),
            changeMonth: true,
            numberOfMonths: 1,
            dateFormat: 'yy-mm-dd'
        })
            .on("change", function () {
                from.datepicker("option", "maxDate", getDate(this));
            });

    function getDate(element) {
        var date;
        try {
            date = $.datepicker.parseDate(dateFormat, element.value);
        } catch (error) {
            date = null;
        }

        return date;
    }
};


var scrollTable = function (id) {
    var tableWidthSum = 0;
    var agent = navigator.userAgent.toLowerCase();

    for (var i = 0; i < $('#' + id + ' colgroup col').length; i++) {
        if (agent.indexOf("msie") != -1 || agent.indexOf("trident") != -1) {
            tableWidthSum += Number($('#' + id + ' colgroup col').eq(i).attr('width'));
        } else {
            tableWidthSum += Number($('#' + id + ' colgroup col').eq(i).attr('width').slice(0, -2));
        }
    }
    $('#' + id + ' table').css({
        'width': tableWidthSum + 'px'
    })
};

var detailLayer = function () {
    $('.layer-close-btn,.modal-bg').bind('click', function () {
        $(this).closest('.detail-bg,.layer-pop-wrap').hide();
    });

    $('.pop-close').bind('click', function () {
        window.close();
    });

    $('.question').bind('click', function () {
        if ($(this).attr('class').indexOf('url') > -1) $('.question-layer,.question-wrap.url').show();
        else $('.question-layer,.question-wrap.source').show();
        $('.mask-bg').show();
    });

    $('.question-close-btn').bind('click', function () {
        $('.question-layer,.question-wrap,.mask-bg').hide();
    });
};

var buttonActive = {
    load: function (a) {
        if ($('.table-area.list-table table').find('.form_wrap.checked').length > 0) $('.button-area').removeClass('default');
        else $('.button-area').addClass('default');
    },
    click: function () {
        $('.table-area.list-table table label').bind('click', function () {
            if ($(this).closest('table').find('.form_wrap.checked').length > 0) $('.button-area').removeClass('default');
            else $('.button-area').addClass('default');
        })
    }
};

var mainScroll = function () {

}

$(function () {
    tableCheckBox();
    normalCheckBox();
    depthCheckBox();
    datePicker();
    lnbLayer();
    detailLayer();
    addressTab();
    buttonClick();
    $('select').parent().uiSelect();
    $('input, textarea').placeholder({customClass: 'my-placeholder'});
});


/* 커스텀 셀렉트 박스 */
var isIE7 = (navigator.userAgent.toLowerCase().indexOf("msie 7.") != -1);
(function ($) {
    'use strict';

    /* select */
    var selectTransform = function () {
        this.cnSelect = "cui-select";
        this.cnTextSelected = "cui-select-inner";
        this.cnOptionWrap = "cui-select-options";
        this.cnOptionItem = "cui-select-option";
        this.cnOpen = "cui-select-open";
        this.cnText = "cui-select-t";
        this.cnIcon = "cui-select-i";
        this.cnDisabled = "disabled";
        this.cnSelected = "selected";
        this.cnNoborder = "noborder";
        this.defaultOptionSize = 10;
    };

    selectTransform.prototype = {
        markup: function (obj, index) {

            var _this = this,
                $obj = obj,
                $p = $obj.parent()
                    .css("position", "relative"),
                z = parseInt($p.css("z-index")),
                w = $p.outerWidth(),
                h = $p.outerHeight(),
                $options = $obj.find("option"),
                _selectedText = $obj.find("option:selected").text(),
                _size = $obj.find("option").length,
                _maxSize = _this.defaultOptionSize;

            if ($obj.siblings("." + _this.cnSelect)) {
                $obj.siblings("." + _this.cnSelect).remove();
            }

            var $containerSelect = $("<span />")
                    .addClass(_this.cnSelect)
                    .css({
                        width: w - 2 + "px",
                        height: h - 2 + "px"
                    })
                    .attr("id", "ui-select" + index)
                    .appendTo($p),
                $textSelected = $("<span />")
                    .addClass(_this.cnTextSelected)
                    .appendTo($containerSelect)
                    .css({
                        height: h - 2 + "px",
                        lineHeight: h - 1 + "px"
                    }),
                $textInner = $("<span />")
                    .addClass(_this.cnText)
                    .text(_selectedText)
                    .appendTo($textSelected),
                $ico = $("<span />")
                    .addClass(_this.cnIcon)
                    .appendTo($textSelected),
                $listWrap = $("<span />")
                    .addClass(_this.cnOptionWrap)
                    .css("top", h - 1 + "px")

                    .appendTo($containerSelect);

            if (z) {
                var nowZ = z;
            } else {
                var nowZ = 1;
            }

            $listWrap.css("z-index", nowZ + 20);

            $obj.css({
                position: "absolute",
                left: w * -1 + "px",
                top: h * -1 + "px",
                opacity: 0,
                visibility: "hidden"
            });

            if ($obj.prop("disabled")) {
                $containerSelect.addClass(_this.cnDisabled);
            }

            if ($obj.data("size")) {
                _maxSize = $obj.data("size");
            }
            if ($obj.data("border") == false) {
                $containerSelect.addClass(_this.cnNoborder);
            }
            if ($obj.data("scroll") != false) {
                if (_size > _maxSize) {
                    var _h = _maxSize * 20;

                    $listWrap.addClass("nano")
                        .css("height", _h + "px")
                        .append($("<div class=\"nano-content\" style=\"height:" + _h + "px;\"/>"));
                    $listWrap = $listWrap.find(".nano-content");
                }
            }

            for (var i = 0; i < $options.length; i++) {
                var $opt = $options.eq(i),
                    $i = $("<span />")
                        .addClass(_this.cnOptionItem)
                        .text($opt.text())
                        .data("value", $opt.attr("value"))
                        .appendTo($listWrap)
                        .on("mousedown", function (event) {
                            event.preventDefault();
                            _this.optionSelect($(this), _this, nowZ);
                        });
                if ($opt.prop("selected")) {
                    $i.addClass("selected");
                }
            }
            // if($listWrap.hasClass("nano")){
            //     $listWrap.nanoScroller();
            // }

            _this.eventToggle($textSelected, nowZ, $p);
        },
        optionSelect: function ($obj, _this, nowZ) {
            var text = $obj.text(),
                value = $obj.data("value");

            $obj.parents("." + _this.cnSelect)
                .find("." + _this.cnText)
                .text(text)
                .data("value", value);

            _this.closeSelect(nowZ);

            $obj.parents("." + _this.cnSelect).siblings("select")
                .find("option").eq($obj.index())
                .prop("selected", true)
                .change();
        },
        closeSelect: function (z) {
            var _this = this;
            $("." + _this.cnSelect).removeClass(_this.cnOpen).css("z-index", z + 1);
            $("." + _this.cnSelect).parent().css("z-index", z);
        },
        eventToggle: function ($t, z, $p) {
            var _this = this;
            $t.on("click", function () {
                var $parent = $(this).parents("." + _this.cnSelect);
                if ($parent.hasClass(_this.cnDisabled)) return false;

                var index = $p.find("option:selected").index();
                $p.find("." + _this.cnOptionItem).removeClass(_this.cnSelected);
                $p.find("." + _this.cnOptionItem).eq(index).addClass(_this.cnSelected);

                if ($parent.hasClass(_this.cnOpen)) {
                    $parent.removeClass(_this.cnOpen);
                    $p.find("." + _this.cnSelect).css("z-index", z + 1);
                    $p.css("z-index", z);
                } else {
                    _this.closeSelect(z);
                    $parent.addClass(_this.cnOpen);
                    $p.find("." + _this.cnSelect).css("z-index", z + 11);
                    $p.css("z-index", z + 10);

                    //IE7 ����
                    if (isIE7) {

                        if ($(".delivery_info").length > 0 || $(".popup-leave").length > 0) {
                            $(this).parents().eq(8).css("z-index", z + 1);
                            $(this).parents().eq(8).siblings().css("z-index", z);
                        }


                        if ($(".section-join").length > 0 || $(".section-login").length > 0) {
                            $(this).parents().eq(3).css("z-index", z + 1);
                            $(this).parents().eq(3).siblings().css("z-index", z);
                        }
                    }
                }

                // $(".nano").nanoScroller();

                $(document).on("mousedown", function (event) {
                    var $target = $(event.target);
                    if (!$target.parents().hasClass(_this.cnSelect)) {
                        _this.closeSelect(z);
                    }
                });
            });
        },
        init: function (obj) {
            var _this = this,
                $s = $(obj).find("select");

            $s.each(function (index) {
                if ($(this).data("ui") != false) {
                    _this.markup($(this), index);
                }
            });
        }
    };

    $.fn.uiSelect = function (obj, options) {
        if (this.length === 0) {
            return this;
        }

        return this.each(function () {
            $.uiSelect.init(this);
        });
    };
    $.uiSelect = new selectTransform();
})(jQuery);
