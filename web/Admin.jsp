<%--
  Created by IntelliJ IDEA.
  User: z5068
  Date: 2020/6/23
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@page import="dao.CoursesDao" %>
<%@ page import="dao.imp.CoursesDaoImp" %>
<%@ page import="bean.Courses" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        #customers,#customerss,#customersss
        {
            font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
            width:100%;
            border-collapse:collapse;
        }
        #customers td, #customers th,#customerss td,#customerss th,#customersss th,#customersss td
        {
            font-size:1em;
            border:1px solid #98bf21;
            padding:3px 7px 2px 7px;
        }
        #customers th,#customerss th,#customersss th
        {
            font-size:1.1em;
            text-align:left;
            padding-top:5px;
            padding-bottom:4px;
            background-color:#55ACEE;
            color:#ffffff;
        }
    </style>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <!-- site metas -->
    <title>About</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- owl carousel style -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/owl.carousel.min.css" />
    <!-- bootstrap css -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
    <!-- style css -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/style.css">
    <!-- Responsive-->
    <link rel="stylesheet" href="<%=basePath%>/css/responsive.css">
    <!-- fevicon -->
    <link rel="icon" href="<%=basePath%>/images/fevicon.png" type="image/gif" />
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="<%=basePath%>/css/jquery.mCustomScrollbar.min.css">
    <!-- Tweaks for older IEs-->
    <link rel="stylesheet" href="<%=basePath%>/css/font-awesome.css">
    <!-- fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700|Poppins:400,700&display=swap" rel="stylesheet">
    <!-- owl stylesheets -->
    <link rel="stylesheet" href="<%=basePath%>/css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=basePath%>/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jquery.fancybox.min.css" media="screen">
</head>
<body>
<!--header section start -->
<div class="header_section">
    <div class="header_bg">
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="logo" href="index.html">MyVersity</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about.jsp">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Course.jsp">Course</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Content.jsp">Contnt Us</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">Login out</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</div>
<!--header section end -->
<!-- about section start -->
<div class="news_section layout_padding">

    <div class="container">
        <h1 class="news_taital">welcome Admin</h1>
        <p class="news_text">You can add, delete and modify courses</p>
        <div class="news_section_2">
            <div class="row">
                <table id="customers">
                    <tr>
                        <th>ID</th>
                        <th>Course_Name</th>
                        <th>Category</th>
                        <th>Table_Of_Content</th>
                        <th>Course_Fees</th>
                        <th>Operation</th>
                    </tr>
                    <%
                        CoursesDao u= new CoursesDaoImp();
                        List<Courses> u1 = u.getUserAll();
                        for(Courses courses:u1)
                        {%>
                    <tr>
                        <td><%=courses.getId()%></td>
                        <td><%=courses.getName()%></td>
                        <td><%=courses.getCategory()%></td>
                        <td><%=courses.getTable_of_content()%></td>
                        <td><%=courses.getFees()%></td>
                        <td><a href="CoursesDelete?id=<%=courses.getId()%>">Delete</a></td>
                    </tr>
                    <%}%>
                    <br>
                    <br>
                </table>
                <!-- <div class="col-md-6">
                   <div class="news_taital_box">
                      <p class="date_text">01 Jan 2020</p>
                      <h4 class="make_text">Make it Simple</h4>
                      <p class="lorem_text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation</p>
                      <p class="post_text">Post By : Casinal</p>
                   </div>
                </div>
                <div class="col-md-6">
                   <img src="images/img-6.png" class="image_6" style="width:100%">
                   <h6 class="plus_text">+</h6>
                </div> -->
            </div>
            <div class="row">
                <table id="customerss">
                    <tr>
                        <th>ID</th>
                        <th>Course_Name</th>
                        <th>Category</th>
                        <th>Table_Of_Content</th>
                        <th>Course_Fees</th>
                        <th>Operation</th>
                    </tr>
                    <form action="CoursesUpdate" method="post">
                        <tr>
                            <td><input type="text" required="required" name="id"></td>
                            <td><input type="text" required="required" name="name"></td>
                            <td><input type="text" required="required" name="category"></td>
                            <td><input type="text" required="required" name="table_of_content"></td>
                            <td><input type="text" required="required" name="course_fees"></td>
                            <td><input type="submit" value="update"></td>

                        </tr>

                    </form>
                    <br>
                    <br>
                </table>
            </div>
            <div class="row">
                <table id="customersss">
                    <tr>
                        <th>ID</th>
                        <th>Course_Name</th>
                        <th>Category</th>
                        <th>Table_Of_Content</th>
                        <th>Course_Fees</th>
                        <th>Operation</th>
                    </tr>
                    <form action="CoursesADD" method="post">
                        <tr>
                            <td><input type="text" required="required" name="id"></td>
                            <td><input type="text" required="required" name="name"></td>
                            <td><input type="text" required="required" name="category"></td>
                            <td><input type="text" required="required" name="table_of_content"></td>
                            <td><input type="text" required="required" name="course_fees"></td>
                            <td><input type="submit" value="ADD"></td>

                        </tr>

                    </form>
                </table>
                <br>
                <br>
            </div>
            <div class="row">

                <br>
                <br>
            </div>
        </div>
    </div>
</div>
<!-- about section end -->
<!-- footer section start -->
<div class="footer_section layout_padding">
    <div class="container">
        <div class="subscribe_bt"><a href="#">Subscribe</a></div>
        <input type="text" class="email_text" placeholder="Enter Your Email" name="Enter Your Email">
        <div class="footer_section_2">
            <div class="row">
                <div class="col-lg-3 margin_top">
                    <div class="call_text"><a href="#"><img src="images/call-icon1.png"><span class="padding_left_15">Call Now +01 9876543210</span></a></div>
                    <div class="call_text"><a href="#"><img src="images/mail-icon1.png"><span class="padding_left_15">MyVersity@gmail.com</span></a></div>
                </div>
                <div class="col-lg-3">
                    <div class="information_main">
                        <h4 class="information_text">Information</h4>
                        <p class="many_text">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="information_main">
                        <h4 class="information_text">Helpful Links</h4>
                        <div class="footer_menu">
                            <ul>
                                <li><a href="index.jsp">Home</a></li>
                                <li><a href="about.jsp">About</a></li>
                                <li><a href="Course.jsp">Course</a></li>
                                <li><a href="ContentUs.jsp">Content Us</a></li>
                                <li><a href="Login.jsp">Login</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="information_main">
                        <div class="footer_logo"><a href="index.jsp">MyVersity</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- footer section end -->
<!-- copyright section start -->
<div class="copyright_section">
    <div class="container">
        <p class="copyright_text">Copyright &copy; 2020.MyVersity All rights reserved.</p>
    </div>
    <!-- copyright section end -->
    <!-- Javascript files-->
    <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/popper.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.0.0.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/plugin.js"></script>
    <!-- sidebar -->
    <script type="text/javascript" src="<%=basePath%>js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/custom.js"></script>
    <!-- javascript -->
    <script type="text/javascript" src="<%=basePath%>js/owl.carousel.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery.fancybox.min.js"></script>
</body>
</html>

