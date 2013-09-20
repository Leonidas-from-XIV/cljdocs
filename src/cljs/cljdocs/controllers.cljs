(ns cljdocs.controllers)
;(def phonemvc
;  (.module js/angular "phonemvc" (array)))

(defn ^:export phone-list-ctrl [$scope $http]
  (.success (.get $http "phones/phones.json")
            (fn [data]
              (set! (.-phones $scope) data)))
  (set! (.-orderProp $scope) "age"))

;(.controller phonemvc "PhoneListCtrl" phone-list-ctrl)

;(aset PhoneListCtrl "$inject" (array "$scope" "Phone"))
