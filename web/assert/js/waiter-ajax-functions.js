function getNotifies() {
    $.get("/I2SE.frontend/NotifyFood", function (newCookedFood) {
        var oldCookedFood = localStorage.getItem("cooked-food");
        if (oldCookedFood == JSON.stringify(newCookedFood)) {
            getOrderNotifies();
            return;
        }
        $("#cooked-food-notify").text("");
        var notify = "";
        $.each(newCookedFood, function (index, item) {
            notify = notify.concat("<tr>");
            notify = notify.concat("<td></td>");
            notify = notify.concat('<td class="hidden">', item.orderID, '</td>');
            notify = notify.concat('<td class="hidden">', item.orderDetailId, '</td>');
            notify = notify.concat("<td>", item.tableId, "</td>");
            notify = notify.concat('<td>', item.foodName, "</td>");
            notify = notify.concat('<td>', item.quantity, "</td>");
            notify = notify.concat('<td><a class="btn btn-success done-cookedFood">Done</a></td>');
            notify = notify.concat("</tr>");
        })
        if (notify.length == 0) {
            $("#cooked-food").addClass("hidden");
        } else {
            $("#cooked-food").removeClass("hidden");
        }
        $("#cooked-food-notify").append(notify);
        localStorage.setItem("cooked-food", JSON.stringify(newCookedFood));
        getOrderNotifies();
    })
}

///I2SE.frontend/NotifyOrderingTable
function getOrderNotifies() {
    $.get("/I2SE.frontend/NotifyOrderingTable", function (newOrderNotifies) {
        var oldOrderNotifies = localStorage.getItem("ordering-list");
        if (oldOrderNotifies == JSON.stringify(newOrderNotifies)) {
            return;
        }
        $("#ordering-table-notify").text("");
        var notify = "";
        $.each(newOrderNotifies, function (index, item) {
            notify = notify.concat("<tr>");
            notify = notify.concat("<td></td>");
            notify = notify.concat('<td class="hidden">', item.id, '</td>');
            notify = notify.concat("<td>", item.name, "</td>");
            notify = notify.concat('<td><a class="btn btn-danger create-order">Accept</a></td>');
            notify = notify.concat("</tr>");
        })
        if (notify.length == 0) {
            $("#ordering-table").addClass("hidden");
        } else {
            $("#ordering-table").removeClass("hidden");
        }
        $("#ordering-table-notify").append(notify);
        localStorage.setItem("ordering-list", JSON.stringify(newOrderNotifies));
        updateGenNumber();
    })
}

function getServingTable() {
    $.get("/I2SE.frontend/LoadTable?priority=", function (tables) {
        var oldTables = localStorage.getItem("old-table-serving");
//        console.log(1);
        if (oldTables == JSON.stringify(tables)) {
            return;
        }
        $("#table-select-id").text("");
        var tmp = "";
        $.each(tables, function (index, item) {
            if (item.status == 3) {
                tmp = tmp.concat('<option value="', item.id, '">');
                tmp = tmp.concat(item.name);
                tmp = tmp.concat("</option>");
            }
        })
        if (tmp.length == 0) {
            $("#open-order-detail").addClass("hidden");
        } else {
            $("#open-order-detail").removeClass("hidden");
        }
        $("#table-select-id").append(tmp);
        searchFood(localStorage.getItem("last-search-tableid"),
                localStorage.getItem("last-search-searchvalue"));
        localStorage.setItem("old-table-serving", JSON.stringify(tables));
        var tableId = $("#table-select-id :selected").val();
        var searchValue = $("#search-food-name").val();
        if(tableId == null || tableId.length == 0){
            $("#search-result-table").addClass("hidden");
        } else {
            searchFood(tableId, searchValue);
        }
    })
}

function servedFood(orderId, orderDetailId) {
    $.get("/I2SE.frontend/ServeFood?OrderId=" + orderId
            + "&OrderDetailId=" + orderDetailId, function () {
                getNotifies();
            });
}

function createOrder(tableId) {
//    tableID
    $.get("/I2SE.frontend/CreateOrder?tableID=" + tableId);
}

function turnTableToServing(tableId) {
    $.get("/I2SE.frontend/ChangeTableStatus?tableId=" + tableId + "&status=3", function () {
        getNotifies();
        getServingTable();
    })
}

function searchFood(tableId, searchValue) {
    localStorage.setItem("last-search-tableid", tableId);
    localStorage.setItem("last-search-searchvalue", searchValue);
    $.get("/I2SE.frontend/SearchFood?tableId=" + tableId + "&search=" + searchValue, function (listFood) {
        var oldSearchResult = localStorage.getItem("search-result-table");
        if(JSON.stringify(oldSearchResult) == JSON.stringify(listFood)){
            return;
        }
        $("#search-result-table-body").text("");
        var result = "";
        $.each(listFood, function (index, item) {
            var id = item.id;
            var name = item.name;
            var price = item.price;
            var served = item.served;
            var pending = item.pending;
            var quantity = served + pending;
            result = result.concat("<tr>");
            result = result.concat("<td></td>");
            result = result.concat('<td class="hidden">', id, '</td>');
            result = result.concat('<td>', name, '</td>');
            result = result.concat('<td>', convertIntToMoney(price), '</td>');
            result = result.concat('<td>', quantity, '</td>');
            result = result.concat('<td><button class="btn btn-info" id="add-food">Add</button></td>');
            result = result.concat("</tr>");
        })
        if (result.length == 0) {
            $("#search-result-table").addClass("hidden");
        } else {
            $("#search-result-table").removeClass("hidden");
        }
        $("#search-result-table-body").append(result);
        updateGenNumber();
        localStorage.setItem("search-result-table", listFood);
    })
}

function addFood(tableId, foodId) {
    $.get("/I2SE.frontend/AddOrderDetail?tableId=" + tableId
            + "&foodId=" + foodId, function () {
                searchFood(localStorage.getItem("last-search-tableid"),
                        localStorage.getItem("last-search-searchvalue"));
            });
}

function deleteFood(tableId, foodId) {
    $.get("/I2SE.frontend/DeleteOrderDetail?tableId=" + tableId
            + "&foodId=" + foodId, function () {
                location.reload(true);
            });
}