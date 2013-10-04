(ns cljdocs.services)

(-> js/angular
    (.module "phonecatServices" ["ngResource"])
    (.factory "Phone"
              (fn [$resource]
                ($resource "phones/:phoneId.json" {}
                           {:query {
                                    :method "GET"
                                    :params {:phoneId "phones"}
                                    :isArray true}})))
    (.factory "Function"
              (fn [$resource]
                ($resource "clojure_core/clojure.core/:function" {}
                           {:query {:method "GET"
                                    :params {:function "function"}
                                    :isArray false}})))
    (.factory "Namespace"
              (fn [$resource]
                ($resource "clojure_core/:namespace" {}
                           {:query {:method "GET"
                                    :params {:namespace "namespace"}
                                    :isArray true}}))))
