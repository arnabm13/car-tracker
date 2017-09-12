(function() {
    'use strict';
    angular.module('car-tracker')
        .controller('HighAlertListController', HighAlertListController);

    HighAlertListController.$inject = ['alertService'];

    function HighAlertListController(alertService) {
        var highAlertListVm = this;
        highAlertListVm.sorter={
            sortBy:'length',
            sortOrder:true
        }

        alertService.get()
            .then(function(alerts){
                highAlertListVm.alerts = alerts;
            }, function (error){
                console.log(error);
            });
    }

})();