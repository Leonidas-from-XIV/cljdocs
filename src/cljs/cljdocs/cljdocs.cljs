(ns cljdocs.cljdocs
  (:require [mrhyde.core :as mrhyde]))

;; make ClojureScript data structures accessible to JS
(mrhyde/bootstrap)
