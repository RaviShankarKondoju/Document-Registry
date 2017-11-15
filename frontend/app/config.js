function appConfig($routeProvider) {
    $routeProvider
        .when('/', { template: '<notes></notes>' })
        .when('/info', { template: '<notes></notes>' })
        .otherwise({
            redirectTo: '/'
        })
}