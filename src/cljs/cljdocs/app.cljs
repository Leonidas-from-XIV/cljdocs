(ns cljdocs.app)

(-> js/angular
    (.module "cljdocs" (array))
    (.config (array "$routeProvider"
                    (fn [$routeProvider]
                      (-> $routeProvider
                          (.when "/phones" (clj->js {:templateUrl "partials/phone-list.html" :controller cljdocs.controllers.phone-list}))
                          (.when "/phones/:phoneId" (clj->js {:templateUrl "partials/phone-detail.html" :controller cljdocs.controllers.phone-detail}))
                          (.otherwise (clj->js {:redirectTo "/phones"})))))))
