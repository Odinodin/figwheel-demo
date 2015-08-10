(defproject figwheel-demo "0.1.0-SNAPSHOT"
            :description "Figwheel demo"
            :dependencies [[org.clojure/clojure "1.7.0"]
                           [org.clojure/clojurescript "1.7.48"]
                           [figwheel "0.3.7"]
                           [quiescent "0.2.0-RC2"]]
            :plugins [[lein-cljsbuild "1.0.6"]
                      [lein-figwheel "0.3.7"]]

            :jvm-opts ["-Xmx1G"]

            :cljsbuild {
                        :builds [{:id           "dev"
                                  :source-paths ["src/demo" "src/dev"]
                                  ;; Enable figwheel
                                  :figwheel {:on-jsload "dev.figwheel/reload-hook"}

                                  :compiler     {:main "demo.core"
                                                 :asset-path "js/out"
                                                 :output-to     "resources/public/js/main.js"
                                                 :output-dir    "resources/public/js/out"
                                                 :optimizations :none
                                                 :source-map    true
                                                :pretty-print  true}}


                                 ]}

            :figwheel {
                       :http-server-root "public"           ;; default and assumes "resources"
                       :server-port      2000               ;; default
                       :css-dirs         ["resources/public/css"] ;; watch and update CSS

                       :nrepl-port 2222})
