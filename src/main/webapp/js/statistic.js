let startX;

let mealStatisticOption = {
    dataSource: {
        cols: [
            {name: 'foodname', label: __res.foodname, width: 250},
            //{name: 'weight', label: resWeight, width: 120, valueType: 'double'},
            {name: 'calorie', label: __res.calorie, width: 120, valueType: 'double'},
            {name: 'protein', label: __res.protein, width: 120, valueType: 'double'},
            {name: 'fat', label: __res.fat, width: 120, valueType: 'double'},
            {name: 'carbohydrate', label: __res.carbohydrate, width: 120, valueType: 'double'},
            {name: 'fid', label: "fid"},
        ],
        array: breakfastData
    },
    valueOperator: {
        double: {
            getter: function (value, cell, dataGrid) {
                return parseFloat(value.toFixed(2));
            }
        }
    },
    configs: {
        C6: {
            style: {
                display: "none",
            },
        },
    },
    states: {
        fixedLeftUntil: 0,
        fixedTopUntil: 0,
    },
    showMessage: false,
    height: 200,
};

mealStatisticOption.dataSource.array = breakfastData;
$('#datagrid-breakfast').datagrid(mealStatisticOption);
mealStatisticOption.dataSource.array = lunchData;
$('#datagrid-lunch').datagrid(mealStatisticOption);
mealStatisticOption.dataSource.array = dinnerData;
$('#datagrid-dinner').datagrid(mealStatisticOption);

$("#datagrid-container-breakfast").on("touchstart", function (e) {
    startX = e.originalEvent.changedTouches[0].pageX;
});

$("#datagrid-container-breakfast").on("touchmove", function (e) {
    e.preventDefault();
    let _d = $("#datagrid-container-breakfast");
    let x = _d.scrollLeft() + (startX - e.originalEvent.changedTouches[0].pageX) * sensitivity;
    _d.scrollLeft(x);
});

$("#datagrid-container-lunch").on("touchstart", function (e) {
    startX = e.originalEvent.changedTouches[0].pageX;
});

$("#datagrid-container-lunch").on("touchmove", function (e) {
    e.preventDefault();
    let _d = $("#datagrid-container-lunch");
    let x = _d.scrollLeft() + (startX - e.originalEvent.changedTouches[0].pageX) * sensitivity;
    _d.scrollLeft(x);
});

$("#datagrid-container-dinner").on("touchstart", function (e) {
    startX = e.originalEvent.changedTouches[0].pageX;
});

$("#datagrid-container-dinner").on("touchmove", function (e) {
    e.preventDefault();
    let _d = $("#datagrid-container-dinner");
    let x = _d.scrollLeft() + (startX - e.originalEvent.changedTouches[0].pageX) * sensitivity;
    _d.scrollLeft(x);
});