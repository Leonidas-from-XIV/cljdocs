(ns cljdocs.services)

(-> js/angular
    (.module "phonecatServices" ["ngResource"])
    (.factory "Phone"
              (fn [$resource]
                ($resource "phones/:phoneId.json" {}
                           {:query {
                                    :method "GET"
                                    :params {:phoneId "phones"}
                                    :isArray true}}))))
