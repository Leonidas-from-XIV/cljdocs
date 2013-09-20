(ns cljdocs.controllers)
;(def phonemvc
;  (.module js/angular "phonemvc" (array)))

(defn ^:export phone-list-ctrl [$scope]
  (set! (.-phones $scope) (clj->js
        [
         {:name "Nexus S"
          :snippet "Fast just got faster with Nexus S."
          :age 0}
         {:name "Motorola XOOM with Wi-Fi"
          :snippet "The Next, Next Generation tablet."
          :age 1}
         {:name "Motorola XOOM"
          :snippet "The Next, Next Generation tablet."
          :age 2}])))


;(.controller phonemvc "PhoneListCtrl" phone-list-ctrl)

;(aset PhoneListCtrl "$inject" (array "$scope" "Phone"))
