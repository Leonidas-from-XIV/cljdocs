(ns cljdocs.app)

(-> js/angular
    (.module "cljdocs" [])
    (.config (array "$routeProvider"
                    (fn [$routeProvider]
                      (-> $routeProvider
                          (.when "/phones" {:templateUrl "partials/phone-list.html" :controller cljdocs.controllers.phone-list})
                          (.when "/phones/:phoneId" {:templateUrl "partials/phone-detail.html" :controller cljdocs.controllers.phone-detail})
                          (.otherwise {:redirectTo "/phones"}))))))
