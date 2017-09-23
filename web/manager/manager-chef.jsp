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
        <script src="${pageContext.request.contextPath}/assert/js/manage-chef.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/manage-chef-ajax-functions.js"></script>
        <title>Restaurant Automation</title>
    </head>
    <body>
        <div class="container">
            <h1>Welcome ${sessionScope.name}! <a href="/I2SE.frontend/Logout" class="btn btn-sm btn-info">Logout</a></h1>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/manager/manager.jsp">Back</a> 
            <br/> 
            <br/> 
            <h3>Chef <span id="chef-id">${requestScope.chefId}</span></h3>
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
                            <th>Order Detail ID</th>
                            <th>Food Id</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody id="order-table-body">
                        <c:forEach var="item" items="${requestScope.result}">
                            <tr>
                                <td></td>
                                <td>${item.code}</td>
                                <td>${item.foodId}</td>
                                <td>${item.quantity}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>
