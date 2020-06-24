<%--
  Created by IntelliJ IDEA.
  User: z5068
  Date: 2020/6/24
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="author" content="Kodinger">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/my-login.css">
</head>
<body class="my-login-page">
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="brand">
                    <img src="img/logo.jpg">
                </div>
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">Login</h4>
                        <form action="Login" method="POST">

                            <div class="form-group">
                                <label for="email">ID</label>

                                <input id="email" type="text" class="form-control" name="name" value="" required="required" required autofocus>
                            </div>

                            <div class="form-group">
                                <label for="password">Password
                                    <!-- <a href="forgot.html" class="float-right">
                                        Forgot Password?
                                    </a> -->
                                </label>
                                <input id="password" type="password" class="form-control" name="password" required="required"required data-eye>
                            </div>

                            <div class="form-group">
                                <label>
                                    <input type="checkbox" name="remember"> Remember Me
                                </label>
                            </div>

                            <div class="form-group no-margin">
                                <input type="submit" value="submit">
                                <button type="submit" class="btn btn-primary btn-block">
                                    Login
                                </button>
                            </div>
                            <div class="margin-top20 text-center">
                                Don't have an account? <a href="Register.jsp">Create One</a>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="footer">
                    Copyright &copy; MyVersity 2020
                </div>
            </div>
        </div>
    </div>
</section>

<script src="js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/my-login.js"></script>
</body>
</html>
