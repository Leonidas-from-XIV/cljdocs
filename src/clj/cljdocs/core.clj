(ns cljdocs.core
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as response]
            [ring.middleware.json :as json]
            [informant.core :refer [inform]]))

(defn lookup-fn [function]
  (let [full-name (str "clojure.core/" function)
        sym (symbol full-name)
        info (inform sym)
        ;; convert namespace to string for JSON output
        json (assoc info :ns (str (:ns info)))]
    json))

(defn list-ns [namespace]
  (let [sym (symbol namespace)]
    (try
      (keys (ns-publics sym))
      ;; namespace unknown? return empty vector
      (catch Exception e []))))

(defroutes app-routes
  ;(GET "/" [] "<p>Hello from compojure</p>")
  (GET "/clojure_core/:namespace" [namespace]
       (response/response (list-ns namespace)))
  (GET "/clojure_core/clojure.core/:function" [function]
       (response/response (lookup-fn function)))
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
