<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.cicat.entity.Project" %>
<%--
  Created by IntelliJ IDEA.
  User: lunagao
  Date: 16/7/29
  Time: 上午11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Project p = (Project)request.getAttribute("project"); %>
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
                <li class="active"><a href="/projects">Projects</a></li>
                <li><a href="/setting">Setting</a></li>
            </ul>
        </div>
    </nav>
    <div style="margin-top: 20px">
        <a class="waves-effect waves-light btn" href="/<%=p.getName()%>/<%=p.getPlatform()%>">Back</a>
    </div>
    <h2><%=p.getName()%></h2>
    <div class="center-block" style="width: 96%;">
        <a class="waves-effect waves-light btn">Build</a>
        <a class="waves-effect waves-light btn">History</a>
        <a class="waves-effect waves-light btn" href="/<%=p.getName()%>/<%=p.getPlatform()%>/setting">Setting</a>
        <a class="waves-effect waves-light btn">Stop</a>
        <a class="waves-effect waves-light btn">Delete</a>
    </div>

    <h3>Setting</h3>

    <ul class="collapsible popout" data-collapsible="accordion">
        <li>
            <div class="collapsible-header">Project Setting</div>
            <div class="collapsible-body">
                <p>Project</p>
                <form:form action="updateprojectsetting" method="post" modelAttribute="project" class="center-block" style="width: 90%;">
                    <div class="input-field">
                        <form:input name="name" id="name" type="text" path="name" />
                        <label for="name">Project Name</label>
                    </div>
                    <label>Platform</label>
                    <form:select path="platform" class="browser-default">
                        <form:option value="iOS">iOS</form:option>
                        <form:option value="Android">Android</form:option>
                    </form:select>
                    <br>
                    <br>
                    <button class="waves-effect waves-light btn" type="submit">save</button>
                </form:form>
            </div>
        </li>
        <li>
            <div class="collapsible-header">Source Code</div>
            <div class="collapsible-body">
                <p>Git</p>
                <form:form modelAttribute="project" action="updatesourcecode" method="post" class="center-block" style="width: 90%; margin-bottom: 40px;">

                    <div class="input-field">
                        <form:input placeholder="eg. https://github.com/LunaGao/CiCat.git" id="git_url" name="git_url" type="text" class="validate" path="git_url" />
                        <label for="git_url">Git Url</label>
                    </div>
                    <div class="input-field">
                        <form:input placeholder="eg. master" id="git_branch" name="git_branch" type="text" class="validate" path="git_branch" />
                        <label for="git_branch">Git Branch</label>
                    </div>
                    <div class="input-field">
                        <form:input placeholder="eg. luna" id="git_username" name="git_username" type="text" class="validate" path="git_username"/>
                        <label for="git_username">Login Git User Name</label>
                    </div>
                    <div class="input-field">
                        <form:input placeholder="eg. *****" id="git_password" name="git_password" type="password" class="validate" path="git_password" />
                        <label for="git_password">Login Git User Password</label>
                    </div>
                    <button class="waves-effect waves-light btn" type="submit">Save</button>
                    <a class="waves-effect waves-light btn" href="/<%=p.getName()%>/<%=p.getPlatform()%>/cloneSourceCode">Clone</a>

                </form:form>
            </div>
        </li>
        <li>
            <div class="collapsible-header">Build Setting</div>
            <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
        </li>
        <li>
            <div class="collapsible-header">Execution Time</div>
            <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
        </li>
    </ul>

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
<script src="../../resources/materialize/js/jquery-2.1.4.min.js"></script>
<script src="../../resources/materialize/js/materialize.min.js"></script>
</html>