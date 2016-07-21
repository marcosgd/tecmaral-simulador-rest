$scope.apiDownload = function(){
    var config = {
        method: 'GET',
        url: "/facturas/downloads",
        headers: {
            'Accept': 'application/pdf'
        }
    };
    $http(config)
        .success(function(res){
            console.log(res);
        })
        .error(function(res){});
};