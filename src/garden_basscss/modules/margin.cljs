(ns garden-basscss.modules.margin
  (:require [garden-basscss.vars :refer [vars]]
            [garden-basscss.util :refer [gen-margin-padding]]))

(defn spaces [] (:spaces @vars))

(defn neg [unit]
  (if (= unit 0)
    0
    (let [mag (:magnitude unit)]
      (assoc unit :magnitude (- mag (* 2 mag))))))

(defn stylesheet []
  (let [s (spaces)] 
    [(gen-margin-padding :margin)
     (map (fn [[key val]]
            [(str ".mxn" key) {:margin-left (neg val)
                               :margin-right (neg val)}])
          s)
     [:.ml-auto {:margin-left 'auto}]
     [:.mr-auto {:margin-right 'auto}]
     [:.mx-auto {:margin-left 'auto
                 :margin-right 'auto}]]))
