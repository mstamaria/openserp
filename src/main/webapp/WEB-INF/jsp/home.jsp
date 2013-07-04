<!DOCTYPE html>
<html lang="en" ng-app="home">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Centex School Records System</title>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.5/angular.js"></script>
    <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.4.0.js"></script>
    <script src="resources/js/homecontroller.js"></script>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <div ng-controller="headerController">
      <div class="navbar">
        <div class="navbar-inner">
          <a class="brand" href="#">Test</a>
          <ul class="nav" role="navigation">
            <li class="dropdown">
              <a class="dropdown-toggle">Admin<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li ng-repeat="choice in items">
                  <a>{{choice}}</a>
                </li>
              </ul>
            </li>
            <li class="dropdown">
              <a class="dropdown-toggle">Menu2<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li ng-repeat="choice in items">
                  <a>{{choice}}</a>
                </li>
              </ul>
            </li>
          </ul>
          <ul class="nav pull-right">
          <li>
          <a href="j_spring_security_logout"><i class="icon-off"></i>Logout</a>
          
          </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</body>
</html>