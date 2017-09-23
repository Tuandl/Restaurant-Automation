$(document).ready(function () {
    updateGenNumber();
    $("#choose-date-start").change(function(){
        var chefId = $("#chef-id").text();
        var dateStart = $("#choose-date-start").val();
        var dateEnd = $("#choose-date-end").val();
        getChefOrderDetails(chefId, dateStart, dateEnd);
    });
    $("#choose-date-end").change(function(){
        var chefId = $("#chef-id").text();
        var dateStart = $("#choose-date-start").val();
        var dateEnd = $("#choose-date-end").val();
        getChefOrderDetails(chefId, dateStart, dateEnd);
    });
})