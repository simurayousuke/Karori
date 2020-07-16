$("#form-login").submit(function (e) {
    e.preventDefault();
    let data = $(this).serializeObject();
    if (!(data.username && data.password && data.confirm)) {
        $.error(resRequireMiss);
        return;
    }
    if (data.password !== data.confirm) {
        $.error(resPasswordNotSame);
        return;
    }
    $.post1("/api/v1/reg", data, function (data) {
        if ("ok" === data.state) {
            location.href = "/login";
        } else {
            $.error(data.msg);
        }
    });
});
