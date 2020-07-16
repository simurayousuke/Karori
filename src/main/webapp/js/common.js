(function ($) {

    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };

    $.ok = function (msg, callback) {
        $.msg(msg, 'success', callback);
    };

    $.error = function (msg, callback) {
        $.msg(msg, 'danger', callback);
    };

    $.msg = function (msg, type, callback) {
        new $.zui.Messager({
            placement: 'center',
            type: type
        }).show(msg, callback);
    };

    $.post1 = function (url, data, success) {
        let error = function () {
            $.error(resNetworkError);
        };
        $.ajax({
            type: 'post',
            url: url,
            data: data,
            success: success,
            error: error
        });

    };

    $.post2 = function (url, form, success) {
        let error = function () {
            $.error(resNetworkError);
        };
        $.ajax({
            type: 'post',
            url: url,
            data: form.serializeObject(),
            success: success,
            error: error
        });

    };

    $.jump = function (url) {
        location.href = url;
    };

})(jQuery);