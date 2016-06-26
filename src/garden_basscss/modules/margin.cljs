(ns garden-basscss.modules.margin
  (:require [garden-basscss.vars :refer [vars]]
            [garden-basscss.util :refer [gen-margin-padding]]))

(def spaces (:spaces @vars))

(defn neg [unit]
  (let [mag (:magnitude unit)]
    (assoc unit :magnitude (- mag (* 2 mag)))))

(def stylesheet [(gen-margin-padding :margin)
                 (map (fn [i]
                        [(str ".mxn" i) {:margin-left (neg (get spaces i))
                                         :margin-right (neg (get spaces i))}])
                      (range 1 5))
                 [:.ml-auto {:margin-left 'auto}]
                 [:.mr-auto {:margin-right 'auto}]
                 [:.mx-auto {:margin-left 'auto
                             :margin-right 'auto}]])
