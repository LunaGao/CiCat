<%--
  Created by IntelliJ IDEA.
  User: lunagao
  Date: 16/7/20
  Time: 下午7:22
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
    <h6>Welcome, ${name}. <a href="logout">Logout</a></h6>
    <nav>
        <div class="nav-wrapper">
            <a class="brand-logo" style="padding-left: 20px;">Ci Cat</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li class="active"><a>Dashboard</a></li>
                <li><a href="projects">Projects</a></li>
                <li><a href="setting">Setting</a></li>
            </ul>
        </div>
    </nav>
    <div class="center-block" style="width: 90%;">
        <canvas id="canvas"></canvas>
    </div>
    <div class="center-block" style="width: 96%;">
        <div class="card blue-grey darken-1">
            <div class="card-content white-text">
                <img src="../resources/img/icon_android.png" alt="android" style="height: 20px;width: 20px;"/>
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
                <img src="../resources/img/icon_ios.png" alt="iOS" style="height: 20px;width: 20px;"/>
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

<script src="../resources/chart/js/Chart.js"></script>
<script>
    var MONTHS = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

    var randomScalingFactor = function () {
        return Math.round(Math.random() * 1000);
    };
    var randomColorFactor = function () {
        return Math.round(Math.random() * 255);
    };
    var randomColor = function () {
        return 'rgba(' + randomColorFactor() + ',' + randomColorFactor() + ',' + randomColorFactor() + ',.7)';
    };

    var barChartData = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [{
            label: 'Project 1',
            backgroundColor: "rgba(41,128,185,0.5)",
            data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
        }, {
            label: 'Hooplook-Android',
            backgroundColor: "rgba(192,57,43,0.5)",
            data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
        }, {
            label: 'Hooplook-iOS',
            backgroundColor: "rgba(39,174,96,0.5)",
            data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
        }]

    };

    window.onload = function () {
        var ctx = document.getElementById("canvas").getContext("2d");
        window.myBar = new Chart(ctx, {
            type: 'bar',
            data: barChartData,
            options: {
                // Elements options apply to all of the options unless overridden in a dataset
                // In this case, we are setting the border of each bar to be 2px wide and green
                elements: {
                    rectangle: {
                        borderWidth: 2,
                        borderColor: 'rgb(255, 255, 255)',
                        borderSkipped: 'bottom'
                    }
                },
                responsive: true,
                legend: {
                    position: 'top',
                },
                title: {
                    display: true,
                    text: 'Project build times'
                }
            }
        });

    };
</script>
</html>
