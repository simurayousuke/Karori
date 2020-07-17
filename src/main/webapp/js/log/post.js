$(".form-date").datetimepicker(
    {
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        format: "yyyy-mm-dd"
    });

$("#form-log").submit(function (e) {
    e.preventDefault();
    var button = $("#button-log");
    button.prop("disabled", true);
    let data = $(this).serializeObject();
    if (!(data.mealDate && data.type && data.weight)) {
        $.error(resRequireMiss);
        button.prop("disabled", false);
        return;
    }
    $.post1("/api/v1/log", data, function (data) {
        if ("ok" === data.state) {
            $.ok(data.msg, () => {
                $.jump("/statistic");
            });
        } else {
            button.prop("disabled", false);
            $.error(data.msg);
        }
    }, button);
});