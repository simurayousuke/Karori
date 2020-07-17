var startX;

var mealStatisticOption = {
    dataSource: {
        cols: [
            {name: 'foodname', label: resFoodName, width: 250},
            //{name: 'weight', label: resWeight, width: 120, valueType: 'double'},
            {name: 'calorie', label: resCalorie, width: 120, valueType: 'double'},
            {name: 'protein', label: resProtein, width: 120, valueType: 'double'},
            {name: 'fat', label: resFat, width: 120, valueType: 'double'},
            {name: 'carbohydrate', label: resCarbohydrate, width: 120, valueType: 'double'},
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

$(".datagrid-container").on("touchstart", function (e) {
    startX = e.originalEvent.changedTouches[0].pageX;
});

$(".datagrid-container").on("touchmove", function (e) {
    e.preventDefault();
    //todo check functional
    let _d = this;
    let x = _d.scrollLeft() + (startX - e.originalEvent.changedTouches[0].pageX) * sensitivity;
    _d.scrollLeft(x);
});
