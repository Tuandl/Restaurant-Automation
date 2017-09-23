$(document).ready(function(){
    localStorage.clear();
    getNotifies();
    getServingTable();
    setInterval(getNotifies, 1000);
    setInterval(getServingTable, 1000);
    $("#cooked-food-notify").on("click", "a", function(){
        var orderId = $(this).parents("tr").children("td:nth-child(2)").text();
        var orderDetailId = $(this).parents("tr").children("td:nth-child(3)").text();
        servedFood(orderId, orderDetailId);
    });
    $("#ordering-table-notify").on("click", "a", function(){
        var orderId = $(this).parents("tr").children("td:nth-child(2)").text();
        createOrder(orderId);
        turnTableToServing(orderId);
    })
    $("#search-food-name").on("keyup", function(){
        var tableId = $("#table-select-id :selected").val();
        var searchValue = $("#search-food-name").val();
        if(tableId == null || tableId.length == 0){
            $("#search-result-table").addClass("hidden");
        } else {
            searchFood(tableId, searchValue);
        }
    })
    $("#search-result-table-body").on("click","button", function(){
        var tableId = $("#table-select-id :selected").val();
        var foodId = $(this).parents("tr").children("td:nth-child(2)").text();
        addFood(tableId, foodId);
    })
    $("#table-select-id").click(function(){
        var tableId = $("#table-select-id :selected").val();
        var searchValue = $("#search-food-name").val();
        if(tableId == null || tableId.length == 0){
            $("#search-result-table").addClass("hidden");
        } else {
            searchFood(tableId, searchValue);
        }
    })
})