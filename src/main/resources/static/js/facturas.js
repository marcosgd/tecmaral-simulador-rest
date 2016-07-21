var app = angular.module('facturas', [ "ngResource" ]);

app.controller('FacturasController', [ '$scope', '$http',
                                     
	function($scope, $http) {
		$scope.getFacturas = function() {
			$http.get('/facturas').success(function(data) {
				$scope.facturas = data;
			});
		}
		
		
} ]);


app.controller('FacturasController', [ '$scope', '$http',
                                    
                                	function($scope, $http) {
                                		$scope.getFacturas = function() {
                                			$http.get('/facturas').success(function(data) {
                                				$scope.facturas = data;
                                			});
                                		}
                                		
                                		
                                } ]);