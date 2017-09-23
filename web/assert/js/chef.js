$(document).ready(function(){
    localStorage.clear();
    getCookingFood();
    getTask();
    setInterval(getTask, 1000);
    setInterval(getCookingFood, 1000);
    $("#cooking-table-body").on("click", "button", function(){
        console.log("here");
        var orderId = $(this).parents("tr").children("td:nth-child(2)").text();
        var orderDetailId = $(this).parents("tr").children("td:nth-child(3)").text();
        console.log(orderId + " " + orderDetailId);
        finishCook(orderId, orderDetailId);
    })
    $("#task-table-body").on("click", "button", function(){
        var orderId = $(this).parents("tr").children("td:nth-child(2)").text();
        var orderDetailId = $(this).parents("tr").children("td:nth-child(3)").text();
        console.log(orderId + " " + orderDetailId);
        chooseToCook(orderId, orderDetailId);
    })
})