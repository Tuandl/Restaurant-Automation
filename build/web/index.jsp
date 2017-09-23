<%-- 
    Document   : index
    Created on : Jul 6, 2017, 2:33:19 PM
    Author     : TUANDASE62310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="assert/css/bootstrap.min.css">
        <script src="assert/js/jquery-3.2.1.min.js"></script>
        <script src="assert/js/bootstrap.min.js"></script>
        <title>Login</title>
    </head>
    <body>
        <div class="container text-center">
            <br/>
            <br/>
            <br/>
            <h1 class="h1">Restaurant Automation</h1>
            <br/>
            <br/>
            <form class="form-horizontal" action="login" method="POST">
                <div class="form-group">
                    <label class="control-label col-xs-offset-1 col-md-offset-2 col-xs-3" for="usernameID">Username:</label>
                    <div class="col-xs-7 col-sm-6 col-md-3">
                        <input type="text" class="form-control" name="username" id="usernameID"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-offset-1 col-md-offset-2 col-xs-3" for="passwordID">Password:</label>
                    <div class="col-xs-7 col-sm-6 col-md-3">
                        <input type="password" class="form-control" name="password" id="passwordID"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-offset-1 col-md-offset-2 col-xs-3"></div>
                    <div class="col-xs-2 col-md-1">   
                        <input type="submit" value="Login" class="btn btn-success"/>
                    </div>
                </div>
            </form>
        </div>

    </body>
</html>
