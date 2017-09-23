<%-- 
    Document   : waiter
    Created on : Jul 6, 2017, 2:55:36 PM
    Author     : TUANDASE62310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/manager.css"/>

        <script src="${pageContext.request.contextPath}/assert/js/jquery-3.2.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/common.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/manager-ajax-functions.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/manager.js"></script>
        <title>Restaurant Automation</title>
    </head>
    <body>
        <div class="container">
            <h1>Welcome ${sessionScope.name}! <a href="/I2SE.frontend/Logout" class="btn btn-sm btn-info">Logout</a></h1>
            <br/>
            <br/>   
            <div class="section">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-xs-4 col-sm-2 col-lg-1 control-label" for="choose-date-start">Date Start</label>
                        <div class="col-xs-8 col-sm-4 col-lg-3">
                            <input type="datetime-local" class="form-control" id="choose-date-start"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 col-sm-2 col-lg-1 control-label" for="choose-date-end">Date End</label>
                        <div class="col-xs-8 col-sm-4 col-lg-3">
                            <input type="datetime-local" class="form-control" id="choose-date-end"/>
                        </div>
                    </div>

                </div>
            </div>
            <br/>
            <div class="section">   
                <div class="row">
                    <div class="col-xs-12 col-md-4 col-lg-3">Income: <span id="income"></span>VNĐ</div>
                    <div class="col-xs-12 col-md-4 col-lg-3">Order Quantity: <span id="order-quantity"></span></div>
                    <div class="col-xs-12 col-md-4 col-lg-6">Average turn around time: <span id="average-turnaround-time"></span> Mins</div>
                </div>
            </div>
            <br/>
            <div class="section">
                <ul class="nav nav-tabs">
                    <li><a data-toggle="tab" href="#waiter">Waiter</a></li>
                    <li><a data-toggle="tab" href="#host">Host</a></li>
                    <li><a data-toggle="tab" href="#busboy">Busboy</a></li>
                    <li><a data-toggle="tab" href="#chef">Chef</a></li>
                    <li><a data-toggle="tab" href="#food">Food</a></li>
                </ul>

                <div class="tab-content">
                    <div id="waiter" class="tab-pane fade in">
                        <div class="options">
                            <div class="form-group">
                                <label class="control-label col-xs-6 col-sm-2" for="waiter-select-display-row">Display rows</label>
                                <div class="col-xs-6 col-sm-4 col-lg-2">
                                    <select class="form-control" id="waiter-select-display-row">
                                        <option>5</option>
                                        <option>10</option>
                                        <option>15</option>
                                        <option>20</option>
                                    </select>
                                </div>
                                <label class="control-label col-xs-6 col-sm-2 col-lg-offset-4 col-lg-1" for="waiter-select-sort">Sort</label>
                                <div class="col-xs-6 col-sm-4 col-lg-3">
                                    <select class="form-control" id="waiter-select-sort">
                                        <option>Ascending</option>
                                        <option selected>Descending</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <table class="table table-hover table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Order Quantity</th>
                                    <th>Total Income</th>
                                    <th>Detail</th>
                                </tr>
                            </thead>
                            <tbody id="waiter-result-body">
                                <tr>
                                    
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div id="host" class="tab-pane fade">
                        <div class="options">
                            <div class="form-group">
                                <label class="control-label col-xs-6 col-sm-2" for="host-select-display-row">Display rows</label>
                                <div class="col-xs-6 col-sm-4 col-lg-2">
                                    <select class="form-control" id="host-select-display-row">
                                        <option>5</option>
                                        <option>10</option>
                                        <option>15</option>
                                        <option>20</option>
                                    </select>
                                </div>
                                <label class="control-label col-xs-6 col-sm-2 col-lg-offset-4 col-lg-1" for="host-select-sort">Sort</label>
                                <div class="col-xs-6 col-sm-4 col-lg-3">
                                    <select class="form-control" id="host-select-sort">
                                        <option>Ascending</option>
                                        <option selected>Descending</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <table class="table table-hover table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Total Greeting</th>
                                </tr>
                            </thead>
                            <tbody id="host-result-body">
                                
                            </tbody>
                        </table>
                    </div>
                    <div id="busboy" class="tab-pane fade">
                        <div class="options">
                            <div class="form-group">
                                <label class="control-label col-xs-6 col-sm-2" for="busboy-select-display-row">Display rows</label>
                                <div class="col-xs-6 col-sm-4 col-lg-2">
                                    <select class="form-control" id="busboy-select-display-row">
                                        <option>5</option>
                                        <option>10</option>
                                        <option>15</option>
                                        <option>20</option>
                                    </select>
                                </div>
                                <label class="control-label col-xs-6 col-sm-2 col-lg-offset-4 col-lg-1" for="busboy-select-sort">Sort</label>
                                <div class="col-xs-6 col-sm-4 col-lg-3">
                                    <select class="form-control" id="busboy-select-sort">
                                        <option>Ascending</option>
                                        <option selected>Descending</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <table class="table table-hover table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Total Cleaned</th>
                                </tr>
                            </thead>
                            <tbody  id="busboy-result-body">
                                <tr>
                                    
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div id="chef" class="tab-pane fade">
                        <div class="options">
                            <div class="form-group">
                                <label class="control-label col-xs-6 col-sm-2" for="chef-select-display-row">Display rows</label>
                                <div class="col-xs-6 col-sm-4 col-lg-2">
                                    <select class="form-control" id="chef-select-display-row">
                                        <option>5</option>
                                        <option>10</option>
                                        <option>15</option>
                                        <option>20</option>
                                    </select>
                                </div>
                                <label class="control-label col-xs-6 col-sm-2 col-lg-offset-4 col-lg-1" for="chef-select-sort">Sort</label>
                                <div class="col-xs-6 col-sm-4 col-lg-3">
                                    <select class="form-control" id="chef-select-sort">
                                        <option>Ascending</option>
                                        <option selected>Descending</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <table class="table table-hover table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Total Cooked</th>
                                    <th>Detail</th>
                                </tr>
                            </thead>
                            <tbody  id="chef-result-body">
                                
                            </tbody>
                        </table>
                    </div>
                    <div id="food" class="tab-pane fade">
                        <div class="options">
                            <div class="form-group">
                                <label class="control-label col-xs-6 col-sm-2" for="food-select-display-row">Display rows</label>
                                <div class="col-xs-6 col-sm-4 col-lg-2">
                                    <select class="form-control" id="food-select-display-row">
                                        <option>5</option>
                                        <option>10</option>
                                        <option>15</option>
                                        <option>20</option>
                                    </select>
                                </div>
                                <label class="control-label col-xs-6 col-sm-2 col-lg-offset-4 col-lg-1" for="food-select-sort">Sort</label>
                                <div class="col-xs-6 col-sm-4 col-lg-3">
                                    <select class="form-control" id="food-select-sort">
                                        <option>Ascending</option>
                                        <option selected>Descending</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <table class="table table-hover table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Total Quantity</th>
                                    <th>Total Income</th>
                                </tr>
                            </thead>
                            <tbody  id="Food-result-body">
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
