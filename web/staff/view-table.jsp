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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/view-table.css"/>

        <script src="${pageContext.request.contextPath}/assert/js/jquery-3.2.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/view-table.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/view-table-ajax.js"></script>
        <script src="${pageContext.request.contextPath}/assert/js/common.js"></script>
        <title>Restaurant Automation</title>
    </head>
    <body>
        <div class="container">
            <h1>Welcome ${sessionScope.name}! <a href="/I2SE.frontend/Logout" class="btn btn-sm btn-info">Logout</a></h1>
            <div class="section overview" style="padding-top: 10px;">
                <div class="row">
                    <div class="col-xs-4 col-sm-2 col-md-1">Available <span class="badge available"></span></div>
                    <div class="col-xs-4 col-sm-2 col-lg-1">Order <span class="badge order"></span></div>
                    <div class="col-xs-4 col-sm-2 col-lg-1">Dirty <span class="badge dirty"></span></div>
                    <div class="col-xs-4 col-sm-2">Serving <span class="badge serving"></span></div>
                </div>
            </div>
            <br/>
            <br/>
            <div class="form-horizontal">
                <label class="control-label col-xs-2 col-sm-offset-1 col-lg-offset-2" for="select-table-id">Sort</label>
                <div class="col-xs-8 col-sm-6 col-lg-4">
                    <select class="form-control" style="width: 90%;" id="priority">
                        <option selected>Name</option>
                        <option>Available</option>
                        <option>Dirty</option>
                    </select>
                </div>
            </div>
            <br/>   
            <br/>
            <br/>
            <div class="section table-list row">
                <!--start table-->
                <div class="col-xs-12 col-sm-6 col-lg-4">
                    <div class="item">
                        <!--return properties here-->
                        <div class="content-id hidden">
                            ID: <span class="text-uppercase">T001</span>
                        </div>
                        <!--return properties here-->
                        <div class="content-name">
                            Name: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-status">
                            Status: <span class="content-status text-capitalize">Available</span>
                        </div>
                        <!--return properties here-->
                        <div class="select-status btn-group">
                            <a href="#" class="btn btn-primary active" >Available</a>
                            <a href="#" class="btn btn-primary">Order</a>
                            <a href="#" class="btn btn-primary">Dirty</a>
                            <a href="#" class="btn btn-primary">Serving</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-lg-4">
                    <div class="item">
                        <div class="content-name hidden">
                            ID: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-name">
                            Name: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-status">
                            Status: <span class="content-status text-capitalize">Available</span>
                        </div>
                        <div class="btn-group">
                            <a href="#" class="btn btn-primary" >Available</a>
                            <a href="#" class="btn btn-primary">Order</a>
                            <a href="#" class="btn btn-primary active">Dirty</a>
                            <a href="#" class="btn btn-primary">Serving</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-lg-4">
                    <div class="item">
                        <div class="content-name hidden">
                            ID: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-name">
                            Name: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-status">
                            Status: <span class="content-status text-capitalize">Available</span>
                        </div>
                        <div class="btn-group">
                            <a href="#" class="btn btn-primary" >Available</a>
                            <a href="#" class="btn btn-primary active">Order</a>
                            <a href="#" class="btn btn-primary">Dirty</a>
                            <a href="#" class="btn btn-primary">Serving</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-lg-4">
                    <div class="item">
                        <div class="content-name hidden">
                            ID: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-name">
                            Name: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-status">
                            Status: <span class="content-status text-capitalize">Available</span>
                        </div>
                        <div class="btn-group">
                            <a href="#" class="btn btn-primary" >Available</a>
                            <a href="#" class="btn btn-primary">Order</a>
                            <a href="#" class="btn btn-primary">Dirty</a>
                            <a href="#" class="btn btn-primary active">Serving</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-lg-4">
                    <div class="item">
                        <div class="content-name hidden">
                            ID: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-name">
                            Name: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-status">
                            Status: <span class="content-status text-capitalize">Available</span>
                        </div>
                        <div class="btn-group">
                            <a href="#" class="btn btn-primary active" >Available</a>
                            <a href="#" class="btn btn-primary">Order</a>
                            <a href="#" class="btn btn-primary">Dirty</a>
                            <a href="#" class="btn btn-primary">Serving</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-lg-4">
                    <div class="item">
                        <div class="content-name hidden">
                            ID: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-name">
                            Name: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-status">
                            Status: <span class="content-status text-capitalize">Available</span>
                        </div>
                        <div class="btn-group">
                            <a href="#" class="btn btn-primary" >Available</a>
                            <a href="#" class="btn btn-primary">Order</a>
                            <a href="#" class="btn btn-primary active">Dirty</a>
                            <a href="#" class="btn btn-primary">Serving</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-lg-4">
                    <div class="item">
                        <div class="content-name hidden">
                            ID: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-name">
                            Name: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-status">
                            Status: <span class="content-status text-capitalize">Available</span>
                        </div>
                        <div class="btn-group">
                            <a href="#" class="btn btn-primary" >Available</a>
                            <a href="#" class="btn btn-primary active">Order</a>
                            <a href="#" class="btn btn-primary">Dirty</a>
                            <a href="#" class="btn btn-primary">Serving</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-lg-4">
                    <div class="item">
                        <div class="content-name hidden">
                            ID: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-name">
                            Name: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-status">
                            Status: <span class="content-status text-capitalize">Available</span>
                        </div>
                        <div class="btn-group">
                            <a href="#" class="btn btn-primary" >Available</a>
                            <a href="#" class="btn btn-primary">Order</a>
                            <a href="#" class="btn btn-primary">Dirty</a>
                            <a href="#" class="btn btn-primary active">Serving</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-lg-4">
                    <div class="item">
                        <div class="content-name hidden">
                            ID: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-name">
                            Name: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-status">
                            Status: <span class="content-status text-capitalize">Available</span>
                        </div>
                        <div class="btn-group">
                            <a href="#" class="btn btn-primary active" >Available</a>
                            <a href="#" class="btn btn-primary">Order</a>
                            <a href="#" class="btn btn-primary">Dirty</a>
                            <a href="#" class="btn btn-primary">Serving</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-lg-4">
                    <div class="item">
                        <div class="content-name hidden">
                            ID: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-name">
                            Name: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-status">
                            Status: <span class="content-status text-capitalize">Available</span>
                        </div>
                        <div class="btn-group">
                            <a href="#" class="btn btn-primary" >Available</a>
                            <a href="#" class="btn btn-primary">Order</a>
                            <a href="#" class="btn btn-primary active">Dirty</a>
                            <a href="#" class="btn btn-primary">Serving</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-lg-4">
                    <div class="item">
                        <div class="content-name hidden">
                            ID: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-name">
                            Name: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-status">
                            Status: <span class="content-status text-capitalize">Available</span>
                        </div>
                        <div class="btn-group">
                            <a href="#" class="btn btn-primary" >Available</a>
                            <a href="#" class="btn btn-primary active">Order</a>
                            <a href="#" class="btn btn-primary">Dirty</a>
                            <a href="#" class="btn btn-primary">Serving</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-lg-4">
                    <div class="item">
                        <div class="content-name hidden">
                            ID: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-name">
                            Name: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-status">
                            Status: <span class="content-status text-capitalize">Available</span>
                        </div>
                        <div class="btn-group">
                            <a href="#" class="btn btn-primary" >Available</a>
                            <a href="#" class="btn btn-primary">Order</a>
                            <a href="#" class="btn btn-primary">Dirty</a>
                            <a href="#" class="btn btn-primary active">Serving</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-lg-4">
                    <div class="item">
                        <div class="content-name hidden">
                            ID: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-name">
                            Name: <span class="text-uppercase">T001</span>
                        </div>
                        <div class="content-status">
                            Status: <span class="content-status text-capitalize">Available</span>
                        </div>
                        <div class="btn-group">
                            <a href="#" class="btn btn-primary active" >Available</a>
                            <a href="#" class="btn btn-primary">Order</a>
                            <a href="#" class="btn btn-primary">Dirty</a>
                            <a href="#" class="btn btn-primary">Serving</a>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </body>
</html>
