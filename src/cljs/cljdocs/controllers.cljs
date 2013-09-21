(ns cljdocs.controllers)

(defn ^:export phone-list [$scope $http]
  (-> $http
      (.get "phones/phones.json")
      (.success (fn [data]
                  (set! (.-phones $scope) data))))
  (set! (.-orderProp $scope) "age"))

(defn ^:export phone-detail [$scope $routeParams $http]
  (-> $http
      (.get (str "phones/" (.-phoneId $routeParams) ".json"))
      (.success (fn [data]
                  (set! (.-phone $scope) data)))))
