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
    <link type="text/css" rel="stylesheet" href="../resources/materialize/css/materialize.min.css" media="screen,projection"/>
</head>
<body>
<div class="container">
    <h6>Welcome, ${name}. <a href="logout">Logout</a></h6>
    <nav>
        <div class="nav-wrapper">
            <a class="brand-logo" style="padding-left: 20px;">Ci Cat</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="dashboard">Dashboard</a></li>
                <li><a href="projects">Projects</a></li>
                <li class="active"><a>Setting</a></li>
            </ul>
        </div>
    </nav>
    <h4>Global Setting</h4>
    <br />
    <div class="center-block" style="width: 90%;">
        <div class="input-field col s6">
            <input placeholder="eg. /usr/local/bin   (if your Git already set in PATH, you can not set this)" id="first_name" type="text" class="validate">
            <label for="first_name">Git path location</label>
        </div>

        <div div class="row">
            <div class="col s1">
                <a class="waves-effect waves-light btn">Save</a>
            </div>
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
<script src="../resources/materialize/js/jquery-2.1.4.min.js"></script>
<script src="../resources/materialize/js/materialize.min.js"></script>
</html>