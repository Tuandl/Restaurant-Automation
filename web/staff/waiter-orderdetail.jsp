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
        <script src="${pageContext.request.contextPath}/assert/js/waiter-orderdetail.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/common.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/waiter-ajax-functions.js"></script>
        <title>Restaurant Automation</title>
    </head>
    <body>
        <div class="container">
            <h1>Welcome ${sessionScope.name}! <a href="/I2SE.frontend/Logout" class="btn btn-sm btn-info">Logout</a></h1>
            <a class="btn btn-primary" href="/I2SE.frontend/staff/waiter.jsp">Back</a> 
            <br/> 
            <br/> 
            <h3>Table: <span id="table-id">${requestScope.tableId}</span></h3>
            <h3>Order ID: <span id="order-id">${requestScope.orderId}</span></h3>
            <div class="section">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th class="hidden">Food Id</th>
                            <th>Pending</th>
                            <th>Processing</th>
                            <th class="hidden">Price One</th>
                            <th>Price</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody id="order-table">
                        <c:forEach var="item" items="${requestScope.bill}">
                            <tr>
                                <td></td>
                                <td>${item.name}</td>
                                <td class="hidden">${item.id}</td>
                                <td id="pending-count">${item.pending}</td>
                                <td id="served-count">${item.served}</td>
                                <td class="order-detail-price-one hidden">${item.price}</td>
                                <td class="order-detail-price"></td>
                                <td><button class="btn btn-info" data-toggle="tooltip" 
                                            title="Cant delete any more">Delete</button></td>
                            </tr>
                        </c:forEach>
                        <!--Last row-->
                        <tr>
                            <td class="hidden"></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Total</td>
                            <td class="order-detail-price-total"></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>

                <form class="col-xs-offset-6 col-sm-offset-9" action="CheckOut">
                    <input type="hidden" name="orderId" value="${requestScope.orderId}"/>
                    <button type="submit" class="btn btn-lg btn-danger" id="print-bill"
                       data-toggle="tooltip" title="Cant print bill when we still have pending food">Print Bill</button>
                </form>
                <br/>
            </div>
        </div>

    </body>
</html>
