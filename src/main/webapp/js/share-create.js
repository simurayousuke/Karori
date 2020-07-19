let defaultMealDate = $.formatDate(new Date());
let inputStartDate = $("#input-startDate");
let inputEndDate = $("#input-endDate");
let containerStartDate = $("#container-startDate");
let containerEndDate = $("#container-endDate");
let labelStartDate = $("#label-startDate");

function switchView(type) {
    switch (parseInt(type)) {
        case 0:
            inputStartDate.val("");
            inputEndDate.val("");
            containerStartDate.hide();
            containerEndDate.hide();
            break;
        case 1:
            inputStartDate.val("");
            inputEndDate.val(defaultMealDate);
            labelStartDate.text(__res.startDate);
            containerStartDate.show();
            containerEndDate.show();
            break;
        case 2:
            inputStartDate.val(defaultMealDate);
            inputEndDate.val("");
            labelStartDate.text(__res.date);
            containerStartDate.show();
            containerEndDate.hide();
            break;
    }
}

switchView($("#input-share-type").val());

$(".form-date").datetimepicker(
    {
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        format: "yyyy-mm-dd",
        initialDate: defaultMealDate,
        language: __locale.substring(0, 2)
    });

$("#input-share-type").change((e) => {
    switchView(e.target.value);
});

$("#form-share").submit(function (e) {
    e.preventDefault();
    let button = $("#button-share");
    button.prop("disabled", true);
    let data = $(this).serializeObject();
    switch (data.type) {
        case 0:
            delete data.startDate;
            delete data.endDate;
            break;
        case 1:
            if (!(data.startDate && data.endDate)) {
                $.error(__res.requireMiss);
                button.prop("disabled", false);
                return;
            }
            break;
        case 2:
            delete data.endDate;
            if (!data.startDate) {
                $.error(__res.requireMiss);
                button.prop("disabled", false);
                return;
            }
            break;
    }
    $.post1("/api/v1/share/create", data, function (data) {
        if ("ok" === data.state) {
            $.ok(data.msg, () => {
                console.log(data.token);
                $("#container-form-share").hide();
                $("#result-token").val($.buildShareLink(data.token, null, __locale));
                $("#container-result").show();
            });
        } else {
            button.prop("disabled", false);
            $.error(data.msg);
        }
    }, button);
});