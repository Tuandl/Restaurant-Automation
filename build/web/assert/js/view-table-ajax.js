function loadTable() {
    var priority;
    priority = $("#priority :selected").text();
    $.get("/I2SE.frontend/LoadTable?priority=" + priority, function (newTables) {
        var oldTables = localStorage.getItem("table-list");
        console.log(oldTables);
        console.log(JSON.stringify(newTables));
        if(oldTables == JSON.stringify(newTables)){
            return;
        }
        console.log("update");
        var $table = $(".table-list");
        $table.text("");
        $.each(newTables, function(index, item){
            var status = item.status;
            var tmp = '<div class="col-xs-12 col-sm-6 col-lg-4">';
            tmp = tmp.concat('<div class="item">');
            tmp = tmp.concat('<div class="content-id hidden">');
            tmp = tmp.concat('ID: <span class="text-uppercase">' + item.id + '</span>');
            tmp = tmp.concat('</div>');
            tmp = tmp.concat('<div class="content-name">');
            tmp = tmp.concat('Name: <span class="text-uppercase">' + item.name + '</span>');
            tmp = tmp.concat('</div>');
            tmp = tmp.concat('<div class="content-status">');
            tmp = tmp.concat('Status: <span class="content-status text-capitalize"></span>');
            tmp = tmp.concat('</div>');
            tmp = tmp.concat('<div class="select-status btn-group">');
            tmp = tmp.concat('<a class="btn btn-primary');
            if(status==1) tmp = tmp.concat(' active"');
            else tmp = tmp.concat('"');
            tmp = tmp.concat('>Available</a>');
            tmp = tmp.concat('<a class="btn btn-primary');
            if(status==2) tmp = tmp.concat(' active"');
            else tmp = tmp.concat('"');
            tmp = tmp.concat('>Order</a>');
            tmp = tmp.concat('<a class="btn btn-primary');
            if(status==4) tmp = tmp.concat(' active"');
            else tmp = tmp.concat('"');
            tmp = tmp.concat('>Dirty</a>');
            tmp = tmp.concat('<a class="btn btn-primary');
            if(status==3) tmp = tmp.concat(' active"');
            else tmp = tmp.concat('"');
            tmp = tmp.concat('>Serving</a>');
            tmp = tmp.concat('</div>');
            tmp = tmp.concat('</div>'); 
            tmp = tmp.concat('</div>');
            $table.append(tmp);
        })
        updateContext();
        localStorage.setItem("table-list", JSON.stringify(newTables));
    })
}