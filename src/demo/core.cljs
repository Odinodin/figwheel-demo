(ns demo.core
  (:require
    [quiescent.core :as q]
    [quiescent.dom :as d]))

(enable-console-print!)

(defonce state (atom [{:name "Mr Monkey" :age 5}
                  {:name "Miss Giraffe" :age 20}]))

(q/defcomponent Title [text]
                (d/h1 {} text))

(q/defcomponent AnimalTableRow [animal]
                (d/tr {}
                      (d/td {} (:name animal))
                      (d/td {} (:age animal))))

(q/defcomponent AnimalTable [animals]

                (d/table
                  {:style {:border-collapse "collapse"}}
                  (d/thead
                    {:style {:background-color "grey" }}
                    (d/tr
                      {}
                      (d/th {} "Name")
                      (d/th {} "Age")))
                  (d/tbody {}
                           (map #(AnimalTableRow %) animals))))

(defn render []
  (prn "rendering ... ")
  (q/render
    (d/div {}
           #_(Title "There are animals!")
           #_(AnimalTable @state))
    (.getElementById js/document "main")))

(render)
