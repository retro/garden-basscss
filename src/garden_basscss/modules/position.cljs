(ns garden-basscss.modules.position
  (:require [garden-basscss.vars :refer [vars]]
            [garden-basscss.util :refer [gen-list]]))

(defn z-indices [] (:z-indices @vars))

(defn stylesheet [] 
  (let [z (z-indices)]
    [(gen-list :position ['relative 'absolute 'fixed])
     (map (fn [v] [(str "." v "-0") {v 0}]) ['top 'right 'bottom 'left])
     (map (fn [v] [(str ".z" v) {:z-index (get z v)}]) (range 1 5))]))
