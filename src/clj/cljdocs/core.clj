(ns cljdocs.core
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as response]
            [ring.middleware.json :as json]))

(defroutes app-routes
  ;(GET "/" [] "<p>Hello from compojure</p>")
  (GET "/clojure_core/clojure.core/mod" [] (response/response {:name "mod"}))
  (route/resources "/")
  (route/not-found "Page not found"))

(defn wrap-dir-index [handler]
  (fn [req]
    (handler
     (update-in req [:uri]
                #(if (= "/" %) "/index.html" %)))))

(def handler
  (-> (handler/site app-routes)
      (wrap-dir-index)
      (json/wrap-json-response)))
