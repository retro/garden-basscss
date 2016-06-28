(ns garden-basscss.modules.border
  (:require [garden-basscss.vars :refer [vars]]
            [garden-basscss.util :refer [render-trbl]]))

(def v-width (get-in @vars [:border :width]))
(def v-radius (get-in @vars [:border :radius]))

(defn gen-border-styles []
  (map
   (fn [dir]
     (let [dir (if (nil? dir) "" (str "-" dir))]
       [(str ".border" dir) {(str "border" dir "-style") "solid"
                             (str "border" dir "-width") v-width}]))
   [nil 'top 'right 'bottom 'left]))

(defn gen-rounded-styles []
  (map (fn [[dir trbl]]
         [(str ".rounded-" dir) {:border-radius (render-trbl trbl)}])
       [['top [v-radius v-radius 0 0]]
        ['right [0 v-radius v-radius 0]]
        ['bottom [0 0 v-radius v-radius]]
        ['left [v-radius 0 0 v-radius]]]))

(def stylesheet
  [(gen-border-styles)
   [:.border-none {:border 0}]
   [:.rounded {:border-radius v-radius}]
   [:.circle {:border-radius "50%"}]
   (gen-rounded-styles)
   [:.not-rounded {:border-radius 0}]])
