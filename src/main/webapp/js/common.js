let sensitivity = 0.2;
let __cmpKeys = ["calorie", "protein", "fat", "carbohydrate", "sodium", "salt", "cholesterol", "sugar", "vitaminA", "vitaminD", "vitaminE", "vitaminK", "vitaminB1", "vitaminB2", "vitaminB6", "vitaminB12", "vitaminC", "calcium", "iron", "magnesium", "zinc", "potassium"];
let __frictionDigits=2;

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
    $.getPara = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r !== null) {
            return decodeURIComponent(r[2]);
        }
        return "";
    };

    $.addSumRow = function (data) {
        let sum = {};
        __cmpKeys.forEach((key) => {
            sum[key] = 0;
        });
        sum.foodname = __res.total;
        data.forEach((row) => {
            for (let k in row) {
                if (null === row[k]) {
                    row[k] = 0;
                } else if ("number" === typeof row[k]) {
                    sum[k] += parseFloat(row[k].toFixed(__frictionDigits));
                }
            }
        });
        sum.fid = 0;
        sum.weight = 0;
        sum.type = 0;
        if (data) {
            data.push(sum);
        } else {
            data = [sum];
        }
        return data;
    };

    $.post1 = function (url, data, success, button) {
        let error = function () {
            $.error(__res.networkError);
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
            $.error(__res.networkError);
        };
        $.ajax({
            type: 'post',
            url: url,
            data: form.serializeObject(),
            success: success,
            error: error
        });

    };

    $.post3 = function (url, data, success, complete) {
        let error = function () {
            $.error(__res.networkError);
        };
        $.ajax({
            type: 'post',
            url: url,
            data: data,
            success: success,
            error: error,
            complete: complete
        });

    };

    $.jump = function (url) {
        location.href = url;
    };

    $.formatDate = function (date) {
        let dd = date.getDate();
        let mm = date.getMonth() + 1; //January is 0!
        let yyyy = date.getFullYear();
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }
        return yyyy + '-' + mm + '-' + dd;

    }

})(jQuery);

