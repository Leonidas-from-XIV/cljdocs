(defproject cljdocs "0.1.0-SNAPSHOT"
  :description "ClojureDocs, updated"
  :url "http://example.com/FIXME"
  :license {:name "GNU Affero General Public License"
            :url "https://www.gnu.org/licenses/agpl-3.0.html"}
  :source-paths ["src/clj"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [ring/ring-json "0.2.0"]
                 [informant "0.1.1"]
                 [org.clojure/clojurescript "0.0-1889"]
                 [net.drib/mrhyde "0.5.3"]]
  :plugins [[lein-cljsbuild "0.3.3"]
            [lein-ring "0.8.7"]]
  :ring {:handler cljdocs.core/handler}
  :cljsbuild {:builds
              [{
                :source-paths ["src/cljs"]
                :compiler {
                           :output-to "resources/public/js/cljdocs.js"
                           :optimizations :whitespace
                           :pretty-print true}}]})
