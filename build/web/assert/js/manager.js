$(document).ready(function () {
    initValues();
    $("#choose-date-start").change(function () {
        var dateStart = $(this).val();
        var dateEnd = $("#choose-date-end").val();
        getGeneralInformation(dateStart, dateEnd);
        if (dateStart.length != 16 || dateEnd.length != 16) {
            return;
        }
        updateAll(dateStart, dateEnd);
    });
    $("#choose-date-end").change(function () {
        var dateStart = $("#choose-date-start").val();
        var dateEnd = $(this).val();
        getGeneralInformation(dateStart, dateEnd);
        if (dateStart.length != 16 || dateEnd.length != 16) {
            return;
        }
        updateAll(dateStart, dateEnd);
    });
    $("#waiter").find("select").change(function(){
        var dateStart = $("#choose-date-start").val();
        var dateEnd = $("#choose-date-end").val();
        updateWaiter(dateStart, dateEnd);
    });
    $("#host").find("select").change(function(){
        var dateStart = $("#choose-date-start").val();
        var dateEnd = $("#choose-date-end").val();
        updateHost(dateStart, dateEnd);
    });
    $("#busboy").find("select").change(function(){
        var dateStart = $("#choose-date-start").val();
        var dateEnd = $("#choose-date-end").val();
        updateBusboy(dateStart, dateEnd);
    });
    $("#chef").find("select").change(function(){
        var dateStart = $("#choose-date-start").val();
        var dateEnd = $("#choose-date-end").val();
        updateChef(dateStart, dateEnd);
    });
    $("#food").find("select").change(function(){
        var dateStart = $("#choose-date-start").val();
        var dateEnd = $("#choose-date-end").val();
        updateFood(dateStart, dateEnd);
    });
})

function initValues() {
    localStorage.clear();
    var date = new Date();
    date = convertToLocalDate(date);
    $("#choose-date-end").val(date.toISOString().substr(0, 16));
    date = new Date(date.getFullYear() + "-" + (date.getMonth() + 1) + "-" +
            (date.getDate() - 1));
    date = convertToLocalDate(date);
    $("#choose-date-start").val(date.toISOString().substr(0, 16));
    var dateStart = $("#choose-date-start").val();
    var dateEnd = $("#choose-date-end").val();
    getGeneralInformation(dateStart, dateEnd);
    updateAll(dateStart, dateEnd);
}

function updateAll(dateStart, dateEnd) {
    updateWaiter(dateStart, dateEnd);
    updateHost(dateStart, dateEnd);
    updateBusboy(dateStart, dateEnd);
    updateChef(dateStart, dateEnd);
    updateFood(dateStart, dateEnd);
}

function updateWaiter(dateStart, dateEnd) {
    var top = $("#waiter-select-display-row :selected").text();
    var order = $("#waiter-select-sort :selected").text();
    getWaiterActivitiesList(dateStart, dateEnd, top, order);
}

function updateHost(dateStart, dateEnd) {
    var top = $("#host-select-display-row :selected").text();
    var order = $("#host-select-sort :selected").text();
    getHostActivitiesList(dateStart, dateEnd, top, order);
}

function updateChef(dateStart, dateEnd) {
    var top = $("#chef-select-display-row :selected").text();
    var order = $("#chef-select-sort :selected").text();
    getChefActivitiesList(dateStart, dateEnd, top, order);
}

function updateBusboy(dateStart, dateEnd) {
    var top = $("#busboy-select-display-row :selected").text();
    var order = $("#busboy-select-sort :selected").text();
    getBusboyActivitiesList(dateStart, dateEnd, top, order);
}

function updateFood(dateStart, dateEnd) {
    var top = $("#food-select-display-row :selected").text();
    var order = $("#food-select-sort :selected").text();
    getFoodActivitiesList(dateStart, dateEnd, top, order);
}