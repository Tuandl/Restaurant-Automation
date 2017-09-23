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
        <script src="${pageContext.request.contextPath}/assert/js/chef-ajax-functions.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/chef.js"></script>
        <title>Restaurant Automation</title>
    </head>
    <body>
        <div class="container">
            <h1>Welcome ${sessionScope.name}! <a href="/I2SE.frontend/Logout" class="btn btn-sm btn-info">Logout</a></h1>
            <div class="section hidden" id="cooking-section">
                <h2>Cooking</h2>
                <table class="table table-striped table-hover" id="task">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th class="hidden">Order ID</th>
                            <th class="hidden">Order Detail ID</th>
                            <th>Name</th>
                            <th>Quantity</th>
                            <th>Done</th>
                        </tr>
                    </thead>
                    <tbody id="cooking-table-body">
                        <tr>
                            <td>1</td>
                            <td class="hidden">Order F001</td>
                            <td class="hidden">F001</td>
                            <td>Mì bó xào</td>
                            <td>2</td>
                            <!--
                            Khi nhấn done, quantity sẽ coi như done 1 món
                            Quantity -= 1;    
                            -->
                            <td><button class="btn btn-success">Done</button></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <br/>
            <br/>
            <!--            <div class="section">
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <label class="control-label col-xs-2" for="table-select-id">Sort</label>
                                    <div class="col-xs-5 col-md-3">
                                        <select class="form-control" id="table-select-id">
                                            <option selected>Time</option>
                                            <option>Name</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
            
                        </div>-->

            <div class="section hidden" id="task-section">
                <h2>Task</h2>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th class="hidden">Order ID</th>
                            <th class="hidden">Order Detai ID</th>
                            <th>Name</th>
                            <th>Quantity</th>
                            <th>Add</th>
                        </tr>
                    </thead>
                    <tbody id="task-table-body">
                        <tr>
                            <td>1</td>
                            <td class="hidden">OR001</td> 
                            <td class="hidden">ODT001</td> 
                            <td>Coca</td>
                            <td>3</td>
                            <td><button class="btn btn-warning">Accept</button></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td class="hidden">F001</td> 
                            <td>Coca</td>
                            <td>3</td>
                            <td><button class="btn btn-info">Add</button></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td class="hidden">F001</td> 
                            <td>Coca</td>
                            <td>3</td>
                            <td><button class="btn btn-info">Add</button></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>
