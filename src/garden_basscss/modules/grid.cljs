(ns garden-basscss.modules.grid
  (:require [garden-basscss.vars :refer [vars]]
            [garden.stylesheet :refer [at-media]]))

(def breakpoints (:breakpoints @vars))

(defn gen-widths [bp-name]
  (let [widths (range 1 13)
        max-width 12]
    (map (fn [width]
           (let [val (if (= width max-width) "100%" (str "calc(" width "/12 * 100%)"))]
             [(str "." bp-name "-col-" width) {:width val}]))
         widths)))

(defn gen-grid [bp]
  (let [bp-name (name bp)
        breakpoint (bp breakpoints)]
    (at-media breakpoint
              [(str "." bp-name "-col"){:float 'left
                                     :box-sizing 'border-box}]
              [(str "." bp-name "-col-right") {:float 'right
                                            :box-sizing 'border-box}]
              (gen-widths bp-name))))

(def stylesheet [(gen-grid :sm)
                 (gen-grid :md)
                 (gen-grid :lg)])
