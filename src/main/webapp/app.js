/**
 * Created by MOAB on 14-Jun-17.
 */

 toastr.options = {
       "positionClass": "toast-bottom-right", // toast-top-right / toast-top-left / toast-bottom-right / toast-bottom-left
 }

// Angular Module
var app = angular.module("myApp", [ "ngRoute", "ngCookies" ]);

console.log('----Starting app.js')
app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'view/personList.html',
		controller :'personController'
	}).when('/personList', {
		templateUrl : 'view/personList.html',
	})
	.otherwise({
		redirectTo : '/'
	})
});
