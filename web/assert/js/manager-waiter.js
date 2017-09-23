$(document).ready(function(){
    updateGenNumber();
    $("#order-table-body").on("click", "button", function(){
        var orderId = $(this).parents("tr").children("td:nth-child(2)").text();
        getOrderDetail(orderId);
    })
    $("#choose-date-start").change(function(){
        var waiterId = $("#waiter-id").text();
        var dateStart = $("#choose-date-start").val();
        var dateEnd = $("#choose-date-end").val();
        getOrders(waiterId, dateStart, dateEnd);
    });
    $("#choose-date-end").change(function(){
        var waiterId = $("#waiter-id").text();
        var dateStart = $("#choose-date-start").val();
        var dateEnd = $("#choose-date-end").val();
        getOrders(waiterId, dateStart, dateEnd);
    });
})