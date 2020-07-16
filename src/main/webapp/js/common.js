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

    $.ok = function (msg) {
        $.zui.messager.show(msg, {
            placement: 'center'
        });
    };

    $.error = function (msg) {
        $.msg(msg, 'danger');
    };

    $.msg = function (msg, type) {
        $.zui.messager.show(msg, {
            placement: 'center',
            type: type
        });
    };

    $.post2 = function (url, form, success) {

        let error = function () {
            $.error('#(_res.get("networkError"))');
        };
        $.ajax({
            type: 'post',
            url: url,
            data: form.serializeObject(),
            success: success,
            error: error
        });

    };

})(jQuery);