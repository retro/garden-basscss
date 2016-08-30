(ns garden-basscss.util
  (:require [garden-basscss.vars :refer [vars]]
            [garden.util :refer [space-join]]
            [garden.units :refer [unit?]]))

(defn spaces [] (:spaces @vars))

(defn gen-margin-padding [type]
  (let [s (spaces)
        prop (name type)
        prefix (first prop)]
    (map (fn [[key val]]
           [[(str "." prefix key) {prop val}]
            (map (fn [dir]
                   (let [dir-prefix (first (str dir))]
                     [(str "." prefix dir-prefix key) {(str prop "-" dir) val}]))
                 ['top 'right 'bottom 'left])
            [(str "." prefix "x" key) {(str prop "-left") val
                                       (str prop "-right") val}]
            [(str "." prefix "y" key) {(str prop "-top") val
                                       (str prop "-bottom") val}]]) s)))

(defn render-trbl [trbl]
  (space-join
   (map (fn [val]
          (if (unit? val)
            (let [{:keys [magnitude unit]} val]
              (str magnitude (name unit)))
            (str val))) trbl)))

(defn gen-list
  ([type vals] (gen-list type vals false))
  ([type vals include-prefix?]
   (map (fn [v] [(str "." (when include-prefix? (str (name type) "-")) v) {type v}]) vals)))
