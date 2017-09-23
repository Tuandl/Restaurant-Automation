$(document).ready(function () {
    localStorage.clear();
    loadTable();
    updateContext();
    setInterval(loadTable, 1000);
    $(document).on("click", ".select-status > a", function () {
        var id = $(this).parents(".item").find(".content-id").children("span").text();
        var newStatus = $(this).text();
        var status = 0;
        switch (newStatus) {
            case "Available":
                status = 1;
                break;
            case "Order":
                status = 2;
                break;
            case "Dirty":
                status = 4;
                break;
            case "Serving":
                status = 3;
                break;
        }
        $.get("/I2SE.frontend/ChangeTableStatus?tableId=" + id + "&status=" + status, function(){
            loadTable();
        })
    });
})

function updateContext() {
    var count = [0, 0, 0, 0];
    $(".item").each(function (index) {
        $(this).removeClass("available");
        $(this).removeClass("dirty");
        $(this).removeClass("order");
        $(this).removeClass("serving");
        var status = $(this).find(".active").text();
        if (status == 'Available') {
            $(this).addClass("available");
            count[0]++;
        }
        if (status == 'Order') {
            $(this).addClass("order");
            count[1]++;
        }
        if (status == 'Dirty') {
            $(this).addClass("dirty");
            count[2]++;
        }
        if (status == 'Serving') {
            $(this).addClass("serving");
            count[3]++;
        }
        $(this).find(".content-status").children("span").text(status);
    })
    $(".badge").each(function (index) {
        $(this).text(count[index]);
    })
}