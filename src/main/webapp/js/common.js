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
        $.msg(msg, "", callback);
    };

    $.error = function (msg, callback) {
        $.msg(msg, "", callback);
    };


    $.msg = function (msg, type, callback) {
        bootbox.alert({
            size: "small",
            message: msg,
            callback: callback
        });
    };

    $.tip = function (msg, type, callback) {
        new $.zui.Messager({
            placement: 'center',
            type: type
        }).show(msg, callback);
    };

    $.confirm = function (msg, buttonOK, buttonCancel, callback) {
        bootbox.confirm({
            size: "small",
            message: msg,
            buttons: {
                confirm: {
                    label: buttonOK
                },
                cancel: {
                    label: buttonCancel
                }
            },
            callback: callback
        });
    };

    $.prompt = function (title, inputType, callback) {
        bootbox.prompt({
            title: title,
            inputType: inputType,
            callback: callback
        });
    };

    /**
     * @return {string}
     */
    $.getPara = function GetQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r !== null) {
            return decodeURIComponent(r[2]);
        }
        return "";
    };

    $.post1 = function (url, data, success, button) {
        let error = function () {
            $.error(resNetworkError);
            if (button)
                button.prop("disabled", false);
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