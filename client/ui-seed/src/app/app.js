(function() {
    'use strict';
    angular.module('car-tracker', ['ngRoute','angular.filter']);


    angular.module('car-tracker')
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider'];

    function moduleConfig($routeProvider) {
        $routeProvider
            .when('/vehicles', {
                templateUrl: 'app/views/vehicle-list.tmpl.html',
                controller: 'VehicleListController',
                controllerAs: 'vehicleListVm'
            })
            .when('/vehicles/:id', {
                templateUrl: 'app/views/vehicle-detail.tmpl.html',
                controller: 'VehicleDetailController',
                controllerAs: 'vehicleDetailVm'
            })
            .when('/readings', {
                templateUrl: 'app/views/alerts.tmpl.html',
                controller: 'HighAlertListController',
                controllerAs: 'highAlertListVm'
            })
            .when('/readings/:id', {
                templateUrl: 'app/views/alert-list.tmpl.html',
                controller: 'AlertListController',
                controllerAs: 'alertListVm'
            })
            .otherwise({
                redirectTo: '/vehicles'
            });
    }
})();