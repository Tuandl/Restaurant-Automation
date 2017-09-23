<%-- 
    Document   : waiter
    Created on : Jul 6, 2017, 2:55:36 PM
    Author     : TUANDASE62310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/bootstrap.min.css"/>

        <script src="${pageContext.request.contextPath}/assert/js/jquery-3.2.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/common.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/manager-waiter.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/manager-waiter-ajax-functions.js"></script>
        <title>Restaurant Automation</title>
    </head>
    <body>
        <div class="container">
            <h1>Welcome ${sessionScope.name}! <a href="/I2SE.frontend/Logout" class="btn btn-sm btn-info">Logout</a></h1>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/manager/manager.jsp">Back</a> 
            <br/> 
            <br/> 
            <h3>Waiter <span id="waiter-id">${requestScope.waiterId}</span></h3>
            <br/>
            <div class="section">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-xs-4 col-sm-2 col-lg-1 control-label" for="choose-date-start">Date Start</label>
                        <div class="col-xs-8 col-sm-4 col-lg-3">
                            <input type="datetime-local" class="form-control" id="choose-date-start" value="${requestScope.dateStart}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 col-sm-2 col-lg-1 control-label" for="choose-date-end">Date End</label>
                        <div class="col-xs-8 col-sm-4 col-lg-3">
                            <input type="datetime-local" class="form-control" id="choose-date-end" value="${requestScope.dateEnd}"/>
                        </div>
                    </div>

                </div>
            </div>
            <br/> 
            <div class="section">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Order ID</th>
                            <th>Table ID</th>
                            <th>Create time</th>
                            <th>Checkout time</th>
                            <th>Detail</th>
                        </tr>
                    </thead>
                    <tbody id="order-table-body">
                        <c:forEach var="item" items="${requestScope.result}">
                            <tr>
                                <td></td>
                                <td>${item.id}</td>
                                <td>${item.tableId}</td>
                                <td>${item.startTime}</td>
                                <td>${item.endTime}</td>
                                <td><button type="button" class="btn btn-info" 
                                            data-toggle="modal" data-target="#order-detail-modal">Detail</button></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>



        <div id="order-detail-modal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Order ID: <span id="modal-order-id"></span></h4>
                    </div>
                    <div class="modal-body">
                        <table class="table table-hover table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>Order Detail ID</td>
                                    <td>Food ID</td>
                                    <td>Chef ID</td>
                                    <td>Quantity</td>
                                </tr>
                            </thead>
                            <tbody id="modal-order-detail-body">
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>

    </body>
</html>
