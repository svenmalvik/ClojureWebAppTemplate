
/*
 * Copyright (c) 2013. - Sven Malvik - sven.malvik.de
 */

function controller($scope, $http) {
    $scope.url = 'http://localhost:3000/';

    $scope.saveit = function() {
        var transform = function(data){return $.param(data);}

        $http.post($scope.url, $scope.user, {
            headers: { 'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'},
                       'transformRequest' : transform})
            .success(function(data, status) {
                $('#response').text(data.response);
            })
            .error(function(data, status) {
                $('#response').text("Request failed");
            });
    }
}