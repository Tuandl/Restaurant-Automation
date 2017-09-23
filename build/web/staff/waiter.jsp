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

        <script src="${pageContext.request.contextPath}/assert/js/jquery-3.2.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/common.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/waiter-ajax-functions.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/waiter.js"></script>
        <title>Restaurant Automation</title>
    </head>
    <body>
        <div class="container">
            <h1>Welcome ${sessionScope.name}! <a href="/I2SE.frontend/Logout" class="btn btn-sm btn-info">Logout</a></h1>
            <div class="section" id="cooked-food">
                <h4>Cooked Food</h4>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th class="hidden">Order ID</th>
                            <th class="hidden">Order Detail ID</th>
                            <th>Table</th>
                            <th>Food</th>
                            <th>Quantity</th>
                            <th>Done</th>
                        </tr>
                    </thead>
                    <tbody id="cooked-food-notify">
                        <tr>
                            <td>3</td>
                            <td class="hidden">T00112</td>
                            <td class="hidden">T001</td>
                            <td>T001</td>
                            <td>F001</td>
                            <td>5</td>
                            <td><a class="btn btn-success done-cookedFood">Done</a></td>
                        </tr>

                    </tbody>
                </table>
            </div>
            <div class="section" id="ordering-table">
                <h4>Ordering Table</h4>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th class="hidden">Table ID</th>
                            <th>Table Name</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody id="ordering-table-notify">
                        <tr>
                            <td>1</td>
                            <td class="hidden">T001</td>
                            <td>Table 1</td>
                            <td><a class="btn btn-danger create-order">Accept</a></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <br/>
            <br/>
            <div class="section">
                <h4>Add Order Detail</h4>
                <form class="form-horizontal" action="/I2SE.frontend/CreateBill">
                    <div class="form-group">
                        <label class="control-label col-xs-2" for="table-select-id">Table</label>
                        <div class="col-xs-5 col-md-3">
                            <select class="form-control" id="table-select-id" name="tableId">
                                
                            </select>
                        </div>   
                        <div class="col-xs-5 col-sm-3 col-md-2">
                            <button type="submit" class="form-control btn btn-info hidden" id="open-order-detail">Order Detail</button>
                        </div>
                    </div>
                </form>

            </div>

            <div class="section">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-xs-2" for="search-food-name">Search</label>
                        <div class="col-xs-8 col-md-4 col-lg-3">
                            <input class="form-control" name="search" id="search-food-name"/>
                        </div>
                    </div>
                </div>

                <table class="table table-striped table-hover hidden" id="search-result-table">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th class="hidden">Food ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Add</th>
                        </tr>
                    </thead>
                    <tbody id="search-result-table-body">
                        <tr>
                            <td>1</td>
                            <td class="hidden">F001</td>
                            <td>Coca</td>
                            <td>10.000</td>
                            <td>0</td>
                            <td><button class="btn btn-info" id="add-food">Add</button></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
