<%--
  Created by IntelliJ IDEA.
  User: lunagao
  Date: 16/7/20
  Time: 下午4:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" %>
<html>
    <head>
        <title>Ci Cat</title>
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="../resources/materialize/css/materialize.min.css" media="screen,projection"/>
    </head>
    <body>
        <div class="container">
            <br />
            <h3>Welcome to
                <span class="blue-text text-darken-2">C</span><span class="purple-text text-darken-2">i</span>
                <span class="red-text text-darken-2">C</span><span class="orange-text text-darken-2">a</span><span class="green-text text-darken-2">t</span>
            </h3>
            <br />
            <br />
            <form action="login" method="post">
                <div class="row">
                    <div class="col s3"></div>
                    <div class="col s6">
                        <div class="input-field">
                            <input name="name" id="name" type="text" class="validate">
                            <label for="name">Name</label>
                        </div>
                        <div class="input-field">
                            <input name="password" id="password" type="password" class="validate">
                            <label for="password">Password</label>
                        </div>
                    </div>
                    <div class="col s3"></div>
                </div>
                <button class="btn waves-effect waves-light btn-large" type="submit" name="action">Login
                </button>
            </form>
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
    <script src="../resources/materialize/js/jquery-2.1.4.min.js"></script>
    <script src="../resources/materialize/js/materialize.min.js"></script>
    <script>
        <% if ( !"".equals((String)request.getAttribute("error")) ) { %>
        Materialize.toast('${error}', 3000, 'rounded');
        <% } %>
    </script>
</html>
