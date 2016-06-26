(ns garden-basscss.modules.position
  (:require [garden-basscss.vars :refer [vars]]
            [garden-basscss.util :refer [gen-list]]))

(def z-indices (:z-indices @vars))

(def stylesheet [(gen-list :position ['relative 'absolute 'fixed])
                 (map (fn [v] [(str "." v "-0") {v 0}]) ['top 'right 'bottom 'left])
                 (map (fn [v] [(str ".z" v) {:z-index (get z-indices v)}]) (range 1 5))])
