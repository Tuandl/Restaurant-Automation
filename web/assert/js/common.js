function updateGenNumber(){
    $("table").each(function () {
        var table = $(this);
        var index = 1;
        if (table.find("th:first").text() == "#") {
            table.find("tbody").find("tr").each(function(){
                $(this).find("td:first").text(index);
                index++;
            })
        }
    })
}



function convertMoneyToInt(money) {
    var res = 0, tmp = 1;
    for (var i = money.length - 1; i >= 0; i--) {
        if (money.charAt(i) == '.')
            continue;
        res = res + parseInt(money.charAt(i)) * tmp;
        tmp *= 10;
    }
    return res;
}

function convertIntToMoney(int) {
    var res = "";
    var count = 0;
    while (int > 0) {
        if (count % 3 == 0 && count > 0) {
            res = ".".concat(res);
        }
        res = parseInt(int % 10).toString().concat(res);
        int /= 10;
        int = parseInt(int);
        count++;
    }
    return res;
}

function convertToLocalDate(date){
    return new Date(date.getTime() - date.getTimezoneOffset()*60*1000);
}

function convertToGMTDate(date){
    return new Date(date.getTime() + date.getTimezoneOffset()*60*1000);
}