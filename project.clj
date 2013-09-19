(defproject cljdocs "0.1.0-SNAPSHOT"
  :description "ClojureDocs, updated"
  :url "http://example.com/FIXME"
  :license {:name "GNU Affero General Public License"
            :url "https://www.gnu.org/licenses/agpl-3.0.html"}
  :source-paths ["src/clj"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1889"]]
  :plugins [[lein-cljsbuild "0.3.3"]]
  :cljsbuild {:builds
              [{
                :source-paths ["src/cljs"]
                :compiler {
                           :output-to "resources/public/js/cljdocs.js"
                           :optimizations :whitespace
                           :pretty-print true}}]})
