(ns cljdocs.app)

(-> js/angular
    (.module "cljdocs" ["phonecatFilters" "phonecatServices"])
    (.config ["$routeProvider"
              (fn [$routeProvider]
                (-> $routeProvider
                    (.when "/phones"
                           {:templateUrl "partials/phone-list.html"
                            :controller cljdocs.controllers.phone-list})
                    (.when "/phones/:phoneId"
                           {:templateUrl "partials/phone-detail.html"
                            :controller cljdocs.controllers.phone-detail})
                    (.when "/:project/:namespace"
                           {:templateUrl "partials/namespace-list.html"
                            :controller cljdocs.controllers.namespace-list})
                    (.when "/:project/:namespace/:func"
                           {:templateUrl "partials/function-detail.html"
                            :controller cljdocs.controllers.function-detail})
                    (.otherwise {:redirectTo "/clojure_core/clojure.core"})))]))
