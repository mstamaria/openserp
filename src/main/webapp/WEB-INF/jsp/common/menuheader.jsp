
<div class="container">
  <div ng-controller="headerController">
    <div class="navbar">
      <div class="navbar-inner">
        <a class="brand" href="#">Test</a>
        <ul class="nav" role="navigation">
          <li class="dropdown">
            <a class="dropdown-toggle">
              Admin<b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
              <li ng-repeat="menu in menuItems">
                <a href="{{menu.url}}">{{menu.name}}</a>
              </li>
            </ul>
          </li>
          <li class="dropdown">
            <a class="dropdown-toggle">
              Menu2<b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
              <li ng-repeat="choice in items">
                <a>{{choice}}</a>
              </li>
            </ul>
          </li>
        </ul>
        <ul class="nav pull-right">
          <li>
            <a href="j_spring_security_logout"><i class="icon-off"></i>Logout ${username}</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</div>
