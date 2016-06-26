(ns garden-basscss.modules.type-scale
  (:require (garden-basscss.vars :refer [vars])))

(def type-scale (:type-scale @vars))

(def stylesheet [(map (fn [v] [(str ".h" v) {:font-size (get type-scale v)}]) (range 1 7))])
