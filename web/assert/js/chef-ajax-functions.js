function getCookingFood() {
    $.get("/I2SE.frontend/GetCooking", function (cookingList) {
        var oldList = localStorage.getItem("cooking-list");
        if (oldList == JSON.stringify(cookingList)) {
            return;
        }
        $("#cooking-table-body").text("");
        var result = "";
        if (cookingList != 'null'){
            $.each(cookingList, function (index, item) {
                var orderId = item.orderID;
                var orderDetailId = item.orderDetailId;
                var foodName = item.foodName;
                var quantity = item.quantity;
                result = result.concat("<tr>");
                result = result.concat('<td></td>');
                result = result.concat('<td class="hidden">', orderId, '</td>');
                result = result.concat('<td class="hidden">', orderDetailId, '</td>');
                result = result.concat('<td>', foodName, '</td>');
                result = result.concat('<td>', quantity, '</td>');
                result = result.concat('<td><button class="btn btn-success">Done</button></td>');
                result = result.concat("</tr>");
            })
        }
        
        if (result.length == 0) {
            $("#cooking-section").addClass("hidden");
        } else {
            $("#cooking-section").removeClass("hidden");
        }
        $("#cooking-table-body").append(result);
        localStorage.setItem("cooking-list", JSON.stringify(cookingList));
        updateGenNumber();
    })
}


function getTask() {
    $.get("/I2SE.frontend/GetWaitingOrderDetail", function (taskList) {
        var oldList = localStorage.getItem("task-list");
        if (oldList == JSON.stringify(taskList)) {
            return;
        }
        $("#task-table-body").text("");
        var result = "";
        $.each(taskList, function (index, item) {
            var orderId = item.orderId;
//            console.log(orderId);
            var orderDetailId = item.orderDetailId;
//            console.log("orderDetailID = " + orderDetailId);
            var foodName = item.foodName;
//            console.log("Food Name = " + orderDetailId);
            var quantity = item.quantity;
//            console.log("quantity = " + quantity);
            result = result.concat("<tr>");
            result = result.concat('<td></td>');
            result = result.concat('<td class="hidden">', orderId, '</td>');
            result = result.concat('<td class="hidden">', orderDetailId, '</td>');
            result = result.concat('<td>', foodName, '</td>');
            result = result.concat('<td>', quantity, '</td>');
            result = result.concat('<td><button class="btn btn-warning">Accept</button></td>');
            result = result.concat("</tr>");
        })
        if (result.length == 0) {
            $("#task-section").addClass("hidden");
        } else {
            $("#task-section").removeClass("hidden");
        }
        $("#task-table-body").append(result);
        localStorage.setItem("task-list", JSON.stringify(taskList));
        updateGenNumber();
    })
}

//pass parameter: OrderId, OrderDetailCode
function chooseToCook(orderId, orderDetailId) {
    $.get("/I2SE.frontend/ChooseToCook?OrderId=" +
            orderId + "&OrderDetailCode=" + orderDetailId, function () {
                getCookingFood();
                getTask();
            })
}

//pass parameter: OrderId, OrderDetailCode
function finishCook(orderId, orderDetailId) {
    $.get("/I2SE.frontend/DoneCooking?OrderId=" +
            orderId + "&OrderDetailCode=" + orderDetailId, function () {
                getCookingFood();
                getTask();
            })
}