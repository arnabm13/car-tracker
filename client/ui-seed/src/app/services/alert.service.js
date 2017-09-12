(function() {
    'use strict';
    angular.module('car-tracker')
        .service('alertService', alertService);

    alertService.$inject = ['$q', '$http','CONFIG'];

    function alertService($q, $http,CONFIG) {
        var self = this;

        self.get = getAlerts;
        self.getById = getAlertById;

        function getAlerts() {
            return $http.get(CONFIG.API_HOST+'/readings')
                .then(successFn, errorFn);
        }

        function getAlertById(id) {
            return $http.get(CONFIG.API_HOST+'/readings/' + id)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(error) {
            return $q.reject(error);
        }
    }
})();
