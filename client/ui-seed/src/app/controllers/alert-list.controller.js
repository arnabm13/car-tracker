(function() {
    'use strict';
    angular.module('car-tracker')
        .controller('AlertListController', AlertListController);

    AlertListController.$inject = ['alertService', '$routeParams'];

    function AlertListController(alertService, $routeParams) {
        var alertListVm = this;

        alertService.getById($routeParams.id)
            .then(function (alert){
                alertListVm.alert = alert;
            }, function (error){
                console.log(error);
            });
    }

})();
