(function() {
    'use strict';
    angular.module('car-tracker')
        .controller('VehicleDetailController', VehicleDetailController);

    VehicleDetailController.$inject = ['vehicleService', '$routeParams'];

    function VehicleDetailController(vehicleService, $routeParams) {
        var vehicleDetailVm = this;

        vehicleService.getById($routeParams.id)
            .then(function (vehicle){
                vehicleDetailVm.vehicle = vehicle;
            }, function (error){
                console.log(error);
            });
    }

})();