(ns cljdocs.filters)

(-> js/angular
    (.module "phonecatFilters" [])
    (.filter "checkmark" (fn []
                           (fn [input]
                             (if input "\u2713" "\u2718")))))
