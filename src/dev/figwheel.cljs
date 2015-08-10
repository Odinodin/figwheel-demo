(ns dev.figwheel)

(defn reload-hook []
  (fn []

    (print "reloaded")))