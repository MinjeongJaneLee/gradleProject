;(function ($) {
    $.extend($.fn, {
        update: function () {
            return this.each(function () {
                this.type == 'checkbox' && $(this).closest('.form_wrap').toggleClass('checked', this.checked);
            });
        }
    });
})(jQuery);