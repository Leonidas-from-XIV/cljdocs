(ns cljdocs.controllers)

(defn ^:export phone-list [$scope $http]
  (-> $http
      (.get "phones/phones.json")
      (.success (fn [data]
                  (set! (.-phones $scope) data))))
  (set! (.-orderProp $scope) "age"))

(defn ^:export phone-detail [$scope $routeParams]
  (set! (.-phoneId $scope) (.-phoneId $routeParams)))
