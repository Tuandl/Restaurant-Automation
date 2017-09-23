function getOrderDetail(orderId){
    var parameter = "?orderId=" + orderId;
    $.get("/I2SE.frontend/GetOrderDetails" + parameter, function (orderDetailList) {
        var old = localStorage.getItem("order-detail-list");
        if(old == JSON.stringify(orderDetailList)){
            return;
        }
        var result = "";
        var $table = $("#modal-order-detail-body");
        $table.text("");
        $.each(orderDetailList, function(index, item){
            result = result.concat("<tr>");
            result = result.concat("<td></td>");
            result = result.concat("<td>",item.code,"</td>");
            result = result.concat("<td>",item.foodId,"</td>");
            result = result.concat("<td>",item.chefId,"</td>");
            result = result.concat("<td>",item.quantity,"</td>");
            result = result.concat("</tr>");
        })
        localStorage.setItem(JSON.stringify(orderDetailList), "order-detail-list");
        $table.append(result);
        updateGenNumber();
    })
}

function getOrders(waiterId, dateStart, dateEnd){
    var parameter = "?waiterid=" + waiterId +
            "&dateStart=" + dateStart +
            "&dateEnd=" + dateEnd;
    $.get("/I2SE.frontend/ManagerWaiterJson" + parameter, function (orderDetailList) {
        var old = localStorage.getItem("order-list");
        if(old == JSON.stringify(orderDetailList)){
            return;
        }
        var result = "";
        var $table = $("#order-table-body");
        $table.text("");
        $.each(orderDetailList, function(index, item){
            result = result.concat("<tr>");
            result = result.concat("<td></td>");
            result = result.concat("<td>",item.id,"</td>");
            result = result.concat("<td>",item.tableId,"</td>");
            result = result.concat("<td>",item.startTime,"</td>");
            result = result.concat("<td>",item.endTime,"</td>");
            result = result.concat('<td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#order-detail-modal">Detail</button></td>');
            result = result.concat("</tr>");
        })
        localStorage.setItem(JSON.stringify(orderDetailList), "order-list");
        $table.append(result);
        updateGenNumber();
    })
}