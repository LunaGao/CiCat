<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: lunagao
  Date: 16/7/21
  Time: 下午2:25
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Ci Cat</title>
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="../../resources/materialize/css/materialize.min.css" media="screen,projection"/>
</head>
<body>
<div class="container">
    <h6>Welcome, ${name}. <a href="logout">Logout</a></h6>
    <nav>
        <div class="nav-wrapper">
            <a class="brand-logo" style="padding-left: 20px;">Ci Cat</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="/dashboard">Dashboard</a></li>
                <li><a href="/projects">Projects</a></li>
                <li><a href="/setting">Setting</a></li>
            </ul>
        </div>
    </nav>
    <div style="margin-top: 20px">
        <a class="waves-effect waves-light btn" href="/projects">Cancel</a>
    </div>
    <br>
    <from:form action="createResult" method="post" modelAttribute="project" class="center-block" style="width: 90%;">
        <div class="input-field">
            <from:input name="name" id="name" type="text" path="name" />
            <label for="name">Project Name</label>
        </div>
        <label>Platform</label>
        <from:select path="platform" class="browser-default">
            <from:option value="iOS">iOS</from:option>
            <from:option value="Android">Android</from:option>
        </from:select>
        <br>
        <br>
        <button class="btn waves-effect waves-light btn-large" type="submit" name="action">Create</button>
    </from:form>
</div>

<footer class="page-footer" style="position: fixed;bottom:0; width: 100%;">
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
<script src="../../resources/materialize/js/jquery-2.1.4.min.js"></script>
<script src="../../resources/materialize/js/materialize.min.js"></script>
<script>
    <% if ( !"".equals((String)request.getAttribute("error")) ) { %>
    Materialize.toast('${error}', 3000, 'rounded');
    <% } %>
</script>
</html>