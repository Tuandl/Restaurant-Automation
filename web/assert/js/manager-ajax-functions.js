function getWaiterActivitiesList(dateStart, dateEnd, displayRow, sort){
    var parameter = "?top=" + displayRow + "&" +
            "dateStart=" + dateStart + "&" + 
            "dateEnd=" + dateEnd + "&" + 
            "order=" + sort;
    $.get("/I2SE.frontend/GetWaiterRankList" + parameter, function (waiterList) {
        var old = localStorage.getItem("waiter-activities-list");
        if(old == JSON.stringify(waiterList)){
            return;
        }
        var result = "";
        var $table = $("#waiter").find("tbody");
        $table.text("");
        $.each(waiterList, function(index, item){
            result = result.concat("<tr>");
            result = result.concat("<td></td>");
            result = result.concat("<td>",item.id,"</td>");
            result = result.concat("<td>",item.name,"</td>");
            result = result.concat("<td>",item.cntOrder,"</td>");
            if(item.income)
            result = result.concat("<td>",convertIntToMoney(item.income),"</td>");
            else 
                result = result.concat("<td>0</td>")
            result = result.concat('<td><a href="/I2SE.frontend/ManagerWaiter?waiterid=',item.id,
                    "&dateStart=",dateStart,
                    "&dateEnd=",dateEnd,
                    '" class="btn btn-info">Detail</a></td>');
            result = result.concat("</tr>");
        })
        localStorage.setItem(JSON.stringify(waiterList), "waiter-activities-list");
        $table.append(result);
        updateGenNumber();
    })
}

function getHostActivitiesList(dateStart, dateEnd, displayRow, sort){
    var parameter = "?top=" + displayRow + "&" +
            "dateStart=" + dateStart + "&" + 
            "dateEnd=" + dateEnd + "&" + 
            "order=" + sort;
    $.get("/I2SE.frontend/GetHostRankList" + parameter, function (hostList) {
        var old = localStorage.getItem("host-activities-list");
        if(old == JSON.stringify(hostList)){
            return;
        }
        var result = "";
        var $table = $("#host").find("tbody");
        $table.text("");
        $.each(hostList, function(index, item){
            result = result.concat("<tr>");
            result = result.concat("<td></td>");
            result = result.concat("<td>",item.id,"</td>");
            result = result.concat("<td>",item.name,"</td>");
            result = result.concat("<td>",item.action,"</td>");
            result = result.concat("</tr>");
        })
        localStorage.setItem(JSON.stringify(hostList), "host-activities-list");
        $table.append(result);
        updateGenNumber();
    })
}

function getBusboyActivitiesList(dateStart, dateEnd, displayRow, sort){
    var parameter = "?top=" + displayRow + "&" +
            "dateStart=" + dateStart + "&" + 
            "dateEnd=" + dateEnd + "&" + 
            "order=" + sort;
    $.get("/I2SE.frontend/GetBusboyRankList" + parameter, function (busboyList) {
        var old = localStorage.getItem("busboy-activities-list");
        if(old == JSON.stringify(busboyList)){
            return;
        }
        var result = "";
        var $table = $("#busboy").find("tbody");
        $table.text("");
        $.each(busboyList, function(index, item){
            result = result.concat("<tr>");
            result = result.concat("<td></td>");
            result = result.concat("<td>",item.id,"</td>");
            result = result.concat("<td>",item.name,"</td>");
            result = result.concat("<td>",item.action,"</td>");
            result = result.concat("</tr>");
        })
        localStorage.setItem(JSON.stringify(busboyList), "busboy-activities-list");
        $table.append(result);
        updateGenNumber();
    })
}

function getChefActivitiesList(dateStart, dateEnd, displayRow, sort){
    var parameter = "?top=" + displayRow + "&" +
            "dateStart=" + dateStart + "&" + 
            "dateEnd=" + dateEnd + "&" + 
            "order=" + sort;
    $.get("/I2SE.frontend/GetChefRankList" + parameter, function (chefList) {
        var old = localStorage.getItem("chef-activities-list");
        if(old == JSON.stringify(chefList)){
            return;
        }
        var result = "";
        var $table = $("#chef").find("tbody");
        $table.text("");
        $.each(chefList, function(index, item){
            result = result.concat("<tr>");
            result = result.concat("<td></td>");
            result = result.concat("<td>",item.id,"</td>");
            result = result.concat("<td>",item.name,"</td>");
            result = result.concat("<td>",item.action,"</td>");
            result = result.concat('<td><a href="/I2SE.frontend/ManagerChef?chefId=',item.id,
                    "&dateStart=",dateStart,
                    "&dateEnd=",dateEnd,
                    '" class="btn btn-info">Detail</a></td>');
            result = result.concat("</tr>");
        })
        localStorage.setItem(JSON.stringify(chefList), "chef-activities-list");
        $table.append(result);
        updateGenNumber();
    })
}

function getFoodActivitiesList(dateStart, dateEnd, displayRow, sort){
    var parameter = "?top=" + displayRow + "&" +
            "dateStart=" + dateStart + "&" + 
            "dateEnd=" + dateEnd + "&" + 
            "order=" + sort;
    $.get("/I2SE.frontend/GetFoodRankList" + parameter, function (foodList) {
        var old = localStorage.getItem("food-activities-list");
        if(old == JSON.stringify(foodList)){
            return;
        }
        var result = "";
        var $table = $("#food").find("tbody");
        $table.text("");
        $.each(foodList, function(index, item){
            result = result.concat("<tr>");
            result = result.concat("<td></td>");
            result = result.concat("<td>",item.id,"</td>");
            result = result.concat("<td>",item.name,"</td>");
            result = result.concat("<td>",convertIntToMoney(item.price),"</td>");
            result = result.concat("<td>",item.quantity,"</td>");
            result = result.concat("<td>",convertIntToMoney(item.income),"</td>");
            result = result.concat("</tr>");
        })
        localStorage.setItem(JSON.stringify(foodList), "food-activities-list");
        $table.append(result);
        updateGenNumber();
    })
}

function getGeneralInformation(dateStart, dateEnd){
    var parameter = "?dateStart=" + dateStart + "&" + 
            "dateEnd=" + dateEnd;
    $.get("/I2SE.frontend/GetGeneralInfo" + parameter, function (info) {
        $("#income").text(convertIntToMoney(info.income));
        $("#order-quantity").text(info.count);
        $("#average-turnaround-time").text((parseFloat(info.avgTime)/60.0).toFixed(2));
    })
}