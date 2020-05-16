(ns app.state
  (:require [reagent.core :refer [atom]]))

(defonce state (atom {:count 0 :szoveg "foas" :doboz 0}))
