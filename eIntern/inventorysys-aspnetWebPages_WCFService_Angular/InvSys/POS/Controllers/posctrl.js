// JavaScript source code

angular.module('POSApp', [])
.controller('posCtrl', function ($scope) {
    $scope.order = {
        products: [],
        total:0}
    $scope.AddProduct = function(product){
  		$scope.order.products.push(product);
  		$scope.order.total+=product.price;
    }


    $scope.RemoveProduct = function(product){
      	for(var p =0; p<$scope.order.products.length; p++)
    	{
    		if(product.name == $scope.order.products[p].name)
    		{
		    	$scope.order.total-= $scope.order.products[p].price;
	    		$scope.order.products.splice(p,1);	
			    break;
    		}
    	}	
    }
});
