(ns cljdocs.controllers)

(defn ^:export phone-list [$scope Phone]
  (set! (.-phones $scope) (.query Phone))
  (set! (.-orderProp $scope) "age"))

(defn ^:export phone-detail [$scope $routeParams Phone]
  (set! (.-phone $scope) (.get Phone {:phoneId (.-phoneId $routeParams)}
                               (fn [phone]
                                 (set! (.-mainImageUrl $scope)
                                       (aget (.-images Phone) 0)))))
  (set! (.-setImage $scope)
        (fn [imageUrl]
          (set! (.-mainImageUrl $scope) imageUrl))))

(defn ^:export function-detail [$scope $routeParams Function]
  (set! (.-func $scope) (.get Function {:function (.-func $routeParams)})))

(defn ^:export namespace-list [$scope $routeParams Namespace]
  (.log js/console (.query Namespace {:namespace (.-namespace $routeParams)}))
  (set! (.-functions $scope) (.query Namespace {:namespace (.-namespace $routeParams)})))
