(ns app.views
  (:require [app.state :refer [state]]))


(defn increment []
  (swap! state update-in [:count] inc))

(defn decrement []
  (swap! state update-in [:count] dec))

  (defn atom-input [value]
    [:input {:type "text"
             :value @value :placeholder "Ide írj..."
             :on-change #((reset! value (-> % .-target .-value))(swap! state update-in [:doboz] (constantly 0)))}])


  (defn torles
    [valt]
    (reset! valt "")
    (swap! state update-in [:doboz] (constantly 0))
    (js/alert "Törölve!"))

  (defn elvegezve
    []
    (if (= 1 (get @state :doboz)) (swap! state update-in [:doboz] dec) (swap! state update-in [:doboz] inc)))


(defn app3
  []
  (let [szoveg (reagent.core/atom "foo")]
  [:div [:p "Add meg a feladatot!"]
  [:input {:type "text" :placeholder "Ide írj..." :on-change #(reset! szoveg :value)}]
  ]))



  (defonce valami (atom {:counter 100}))




             (defn app1 []
               (let [val (reagent.core/atom "foo")]
                 (fn []
                   [:div
                    [:p "The value is now: " @val]
                    [:p "Change it here: " [atom-input val]]])))



(defn app2
  []

  [:div
   [:h1.title "Final step"]
   [:div.wrapper
    [:button.btn {:on-click #(decrement)} "-"]
    [:p.counter (+ (get @state :count) (get @valami :counter))]
    [:button.btn {:on-click #(increment)} "+"]
    ]
    [:div [:button.btn {:on-click #(app1)} "Szöveges feladat"]]



    [:div.footer [:a {:href "https://www.notion.so/Clojurescript-Roadmap-e752043530e649f7a7142ae8d671ec15" :target "_blank"} "Roadmap"]" | "[:a {:href "https://cljs.info/cheatsheet" :target "_blank"} "CheatSheet"]]])





    (defn app
      []
      (let [valtozo (reagent.core/atom "")]
      (fn []
      [:div

      [:h1.title "Final step"]
      [:h2.title "1. szöveges feladat"]
      [:p "Hozz létre egy szöveges feladatot!"]
      [:p [atom-input valtozo]]
      [:p.szoveges @valtozo]
      [:p "Elvégezve? " [:input {:type "checkbox" :checked (= 1 (get @state :doboz)) :id "jelolo" :on-click #(elvegezve)}]]
      (if (= 1 (get @state :doboz)) [:button.btn {:on-click #(torles valtozo)} "Törlés"])

      [:div.footer [:a {:href "https://www.notion.so/Clojurescript-Roadmap-e752043530e649f7a7142ae8d671ec15" :target "_blank"} "Roadmap"]" | "[:a {:href "https://cljs.info/cheatsheet" :target "_blank"} "CheatSheet"]]

      ]
      ))
      )
