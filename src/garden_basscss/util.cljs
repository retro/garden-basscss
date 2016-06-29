(ns garden-basscss.util
  (:require [garden-basscss.vars :refer [vars]]
            [garden.util :refer [space-join]]
            [garden.units :refer [unit?]]))

(defn spaces [] (:spaces @vars))

(defn gen-margin-padding [type]
  (let [r (range 0 5)
        prop (name type)
        prefix (first prop)
        s (spaces)]
    (map (fn [i]
           (let [val (get s i)]
             [[(str "." prefix i) {prop val}]
              (map (fn [dir]
                     (let [dir-prefix (first (str dir))]
                       [(str "." prefix dir-prefix i) {(str prop "-" dir) val}]))
                   ['top 'right 'bottom 'left])
              [(str "." prefix "x" i) {(str prop "-left") val
                                       (str prop "-right") val}]
              [(str "." prefix "y" i) {(str prop "-top") val
                                       (str prop "-bottom") val}]])) r)))

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
