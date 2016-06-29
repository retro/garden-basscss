(ns garden-basscss.modules.type-scale
  (:require (garden-basscss.vars :refer [vars])))

(defn type-scale [] (:type-scale @vars))

(defn stylesheet []
  (let [t (type-scale)]
    [(map (fn [v] [(str ".h" v) {:font-size (get t v)}]) (range 1 7))]))
