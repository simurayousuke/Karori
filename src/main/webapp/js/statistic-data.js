let breakfastData = [], lunchData = [], dinnerData = [];
let breakfastSum = [], lunchSum = [], dinnerSum = [];
let daySum = [];
let __sync = 0;
let _totalCalculated;
let _targetValues = {};

function getDate() {
    let reg = new RegExp("/[0-9]{4}-[0-9]{2}-[0-9]{2}$");
    let ret = reg.exec(location.href);
    if (ret) {
        return ret[0].substring(1);
    }
    ret = $.getPara("date");
    if (ret) {
        return ret;
    }
    return $.formatDate(new Date());
}
let dateStatistic = getDate();

function getSumRow(data) {
    return data[data.length - 1];
}

function getDaySum(bs, ls, ds) {
    let sum = {};
    for (let k in bs) {
        if ("number" === typeof bs[k]) {
            sum[k] = bs[k];
        }
    }
    for (let k in ls) {
        if ("number" === typeof ls[k]) {
            sum[k] += ls[k];
        }
    }
    for (let k in ds) {
        if ("number" === typeof ds[k]) {
            sum[k] += ds[k];
        }
    }
    sum.foodname = __res.total;
    return sum;
}

function _callback(data) {
    if (data)
        $.addSumRow(data);
    if (++__sync > 3) {
        initDatagrid();
        breakfastSum = getSumRow(breakfastData);
        lunchSum = getSumRow(lunchData);
        dinnerSum = getSumRow(dinnerData);
        daySum = getDaySum(breakfastSum, lunchSum, dinnerSum);
        _totalCalculated = daySum.protein * 4 + daySum.fat * 9 + daySum.carbohydrate * 4;
        initChart();
        $("#main-statistic").removeClass("loading");
    }
}

function initBreakfastData() {
    $.post4("/api/v1/statistic/dateAndType", {date: dateStatistic, type: 1}, (data) => {
        breakfastData = data;
        _callback(breakfastData);
    }, () => {
        $.error(__res.networkError, () => {
            initBreakfastData();
        });
    });
}

function initLunchData() {
    $.post4("/api/v1/statistic/dateAndType", {date: dateStatistic, type: 2}, (data) => {
        lunchData = data;
        _callback(lunchData);
    }, () => {
        $.error(__res.networkError, () => {
            initLunchData();
        });
    });
}

function initDinnerData() {
    $.post4("/api/v1/statistic/dateAndType", {date: dateStatistic, type: 3}, (data) => {
        dinnerData = data;
        _callback(dinnerData);
    }, () => {
        $.error(__res.networkError, () => {
            initDinnerData();
        });
    });
}

function initTargetData() {
    $.post4("/api/v1/target/fetch", {}, (data) => {
        _targetValues = data;
        _callback(null);
    }, () => {
        $.error(__res.networkError, () => {
            initTargetData();
        });
    });
}

function initData() {
    initBreakfastData();
    initLunchData();
    initDinnerData();
    initTargetData();
}

