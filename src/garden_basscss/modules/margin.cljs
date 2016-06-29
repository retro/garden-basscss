(ns garden-basscss.modules.margin
  (:require [garden-basscss.vars :refer [vars]]
            [garden-basscss.util :refer [gen-margin-padding]]))

(defn spaces [] (:spaces @vars))

(defn neg [unit]
  (let [mag (:magnitude unit)]
    (assoc unit :magnitude (- mag (* 2 mag)))))

(defn stylesheet []
  (let [s (spaces)]
    [(gen-margin-padding :margin)
     (map (fn [i]
            [(str ".mxn" i) {:margin-left (neg (get s i))
                             :margin-right (neg (get s i))}])
          (range 1 5))
     [:.ml-auto {:margin-left 'auto}]
     [:.mr-auto {:margin-right 'auto}]
     [:.mx-auto {:margin-left 'auto
                 :margin-right 'auto}]]))
