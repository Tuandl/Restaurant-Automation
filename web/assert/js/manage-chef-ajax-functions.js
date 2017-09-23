function getChefOrderDetails(chefId, dateStart, dateEnd){
    var parameter = "?chefId=" + chefId +
            "&dateStart=" + dateStart +
            "&dateEnd=" + dateEnd;
    $.get("/I2SE.frontend/ManagerChefJson" + parameter, function (orderDetailList) {
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
            result = result.concat("<td>",item.code,"</td>");
            result = result.concat("<td>",item.foodId,"</td>");
            result = result.concat("<td>",item.quantity,"</td>");
            result = result.concat("</tr>");
        })
        localStorage.setItem(JSON.stringify(orderDetailList), "order-list");
        $table.append(result);
        updateGenNumber();
    })
}