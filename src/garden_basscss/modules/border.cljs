(ns garden-basscss.modules.border
  (:require [garden-basscss.vars :refer [vars]]
            [garden-basscss.util :refer [render-trbl]]))

(defn width [] (get-in @vars [:border :width]))
(defn radius [] (get-in @vars [:border :radius]))

(defn gen-border-styles []
  (let [w (width)]
    (map
     (fn [dir]
       (let [dir (if (nil? dir) "" (str "-" dir))]
         [(str ".border" dir) {(str "border" dir "-style") "solid"
                               (str "border" dir "-width") w}]))
     [nil 'top 'right 'bottom 'left])))

(defn gen-rounded-styles []
  (let [r (radius)]
    (map (fn [[dir trbl]]
           [(str ".rounded-" dir) {:border-radius (render-trbl trbl)}])
         [['top [r r 0 0]]
          ['right [0 r r 0]]
          ['bottom [0 0 r r]]
          ['left [r 0 0 r]]])))

(defn stylesheet []
  [(gen-border-styles)
   [:.border-none {:border 0}]
   [:.rounded {:border-radius (radius)}]
   [:.circle {:border-radius "50%"}]
   (gen-rounded-styles)
   [:.not-rounded {:border-radius 0}]])
