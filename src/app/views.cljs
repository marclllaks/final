(ns app.views
  (:require [reagent.core :refer [atom]]))

(def feladatok (atom []))

(defn atom-input [value]
  [:input {:type "text"
           :value @value :placeholder "Ide írj..."
           :on-change #((reset! value (-> % .-target .-value)))}])

(defn mentes [szoveg]
      (swap! feladatok conj {:nev @szoveg :pipa false})
      (reset! szoveg ""))

(defn feladattorol
      [param]
      (reset! feladatok (into [] (concat (subvec @feladatok 0 param)
                                         (subvec @feladatok (inc param))))))

(defn app []
  (let [valtozo (atom "")]
   (fn []
     [:div
      [:h1.title "Final step"]
      [:p
       [:input {:type "text"
                :value @valtozo
                :placeholder "Ide írj..."
                :on-change #(reset! valtozo (-> % .-target .-value))}]
       [:button {:on-click #(when (not (empty? @valtozo)) (mentes valtozo))}
              "Mentés"]]
      [:p "Feladatok száma: " (count @feladatok)]
      (for [i (range (count @feladatok))]
        (let [feladat (nth @feladatok i)]
          [:p {:class [(when (feladat :pipa) "athuzva")]} (feladat :nev)
           [:input {:type "checkbox" :on-click #(swap! feladatok update-in [i :pipa] not) :checked (feladat :pipa)}]
           [:button {:class [(when (not (feladat :pipa)) "hidden")] :on-click #(feladattorol i)} "Törlés"]]))])))
