<%--
  Created by IntelliJ IDEA.
  User: lunagao
  Date: 16/7/21
  Time: 下午2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ci Cat</title>
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="../res/materialize/css/materialize.min.css" media="screen,projection"/>
</head>
<body>
<div class="container">
    <h6>Welcome, ${name}. <a href="logout">Logout</a></h6>
    <nav>
        <div class="nav-wrapper">
            <a class="brand-logo" style="padding-left: 20px;">Ci Cat</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a>Dashboard</a></li>
                <li class="active"><a>Projects</a></li>
                <li><a>Setting</a></li>
            </ul>
        </div>
    </nav>
    <div class="center-block" style="width: 96%;">
        <div class="card blue-grey darken-1">
            <div class="card-content white-text">
                <img src="../res/img/icon_android.png" alt="android" style="height: 20px;width: 20px;"/>
                <span class="card-title">Hooplook-Android</span>
                <p>
                    Success (Build 10) 2016/7/20 20:36:33
                </p>
                <p>
                    Failure (Build 9) 2016/7/20 20:36:33
                </p>
            </div>
            <div class="card-action">
                <a href="#">Build</a>
                <a href="#">More</a>
            </div>
        </div>
        <div class="card blue-grey darken-1">
            <div class="card-content white-text">
                <img src="../res/img/icon_ios.png" alt="iOS" style="height: 20px;width: 20px;"/>
                <span class="card-title">Hooplook-iOS</span>
                <p>
                    Success (Build 10) 2016/7/20 20:36:33
                </p>
                <p>
                    Failure (Build 9) 2016/7/20 20:36:33
                </p>
            </div>
            <div class="card-action">
                <a href="#">Build</a>
                <a href="#">More</a>
            </div>
        </div>
    </div>

    <div div class="row">
        <div class="col s1">
            <a class="waves-effect waves-light btn">Create</a>
        </div>
    </div>
</div>

<footer class="page-footer">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">Ci Cat</h5>
                <p class="grey-text text-lighten-4">Easy to make CI</p>
            </div>
            <div class="col l4 offset-l2 s12">
                <h5 class="white-text">UI Design By</h5>
                <ul>
                    <li><a class="grey-text text-lighten-3" href="http://materializecss.com/">Materialize</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            © 2016 Luna Gao
            <a class="grey-text text-lighten-4 right" href="http://weibo.com/maomishen">@ Luna Gao</a>
        </div>
    </div>
</footer>
</body>
<script src="../res/materialize/js/jquery-2.1.4.min.js"></script>
<script src="../res/materialize/js/materialize.min.js"></script>
</html>