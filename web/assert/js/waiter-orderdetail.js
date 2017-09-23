$(document).ready(function () {
    $(".order-detail-price").each(function () {
        var sum = parseInt($(this).siblings("#pending-count").text()) +
                parseInt($(this).siblings("#served-count").text());
        sum *= parseInt($(this).siblings(".order-detail-price-one").text());
        $(this).text(convertIntToMoney(sum));

    })

    var total = 0;
    $(".order-detail-price").each(function () {
        total += convertMoneyToInt($(this).text());
    })
    $(".order-detail-price-total").text(convertIntToMoney(total));
    $("#order-table").on("click", "button", function () {
        var tableId = $("#table-id").text();
        var foodId = $(this).parents("tr").children("td:nth-child(3)").text();
        deleteFood(tableId, foodId);
    })
    canDelete();
    canPrintBill();
    $('[data-toggle="tooltip"]').tooltip();
})

function canPrintBill() {
    var pendingCount = 0;
    $("[id=pending-count]").each(function () {
        pendingCount += parseInt($(this).text());
    })
    if (pendingCount > 0) {
        $("#print-bill").attr("disabled", "true");
    } else {
        $("#print-bill").attr("data-toggle", "");
        $("#print-bill").attr("title", "");
    }
}

function canDelete() {
    $("#order-table").children("tr").each(function () {
        var pending = $(this).children("#pending-count").text();
        if (pending == '0') {
            $(this).find("button").attr("disabled", "true");
        } else {
            $(this).find("button").attr("data-toggle", "");
        }
    })
}