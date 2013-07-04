angular.module('home', [ 'ui.bootstrap' ]);

function headerController($scope) {

	$scope.menuItems = [ {
		name:"User Creation",
		url:"user/list"
	} ];

	$scope.items = [ "User Creation", "And another choice for you.",
			"but wait! A third!" ];
}
