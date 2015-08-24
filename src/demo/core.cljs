(ns demo.core
  (:require
    [quiescent.core :as q]
    [quiescent.dom :as d]))

(enable-console-print!)

(defonce state (atom [{:name "Apekatt" :age 10}
                  {:name "Giraff" :age 20}]))

(q/defcomponent AnimalTableRow
                [animal]
                (d/tr {}
                      (d/td {} (:name animal))
                      (d/td {} (:age animal))))

(q/defcomponent AnimalTable [animals]
                (d/table
                  {:style {:borderCollapse "collapse"}}
                  (d/thead
                    {:style {:backgroundColor "grey"}}
                    (d/tr
                      {}
                      (d/th {} "Navn")
                      (d/th {} "Alder")))
                  (d/tbody {}
                           (map #(AnimalTableRow %) animals))))

(q/defcomponent Button []
                (d/button {:onClick (fn []
                                      (swap! state #(conj % {:name "Tilfeldig dyr" :age (rand-int 10)})))}
                          "Legg til tilfeldig dyr"))

#_(defn uppercaseName [animal]
  (assoc animal :name (.toUpperCase (:name animal)))  )

(defn render []
  (prn "rendering ... ")
  (q/render
    (d/div {}
           #_(Button)
           #_(AnimalTable @state))
    (.getElementById js/document "main")))

(render)

(add-watch state :watcher
           (fn [_ _ _ _]
             (render)))