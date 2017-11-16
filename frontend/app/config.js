function appConfig($routeProvider) {
    $routeProvider
        .when('/', { template: '<notes></notes>' })
        .when('/headerlist', { template: '<notes></notes>' })
        .otherwise({
            redirectTo: '/'
        })
}