(ns garden-basscss.modules.layout
  (:require [garden-basscss.vars :refer [vars]]
            [garden-basscss.util :refer [gen-list]]))

(defn widths [] (:widths @vars))

(defn stylesheet [] [(gen-list :display ['inline 'block 'inline-block 'table 'table-cell])
                     (gen-list :overflow ['hidden 'scroll 'auto] true)
                     [:.clearfix
                      [:&:before :&:after {:content "\" \""
                                           :display 'table}]
                      [:&:after {:clear 'both}]]
                     (gen-list :float ['left 'right])
                     [:.fit {:max-width "100%"}]
                     (map (fn [v] [(str ".max-width-" v) {:max-width (get (widths) v)}]) (range 1 5))
                     [:.border-box {:box-sizing 'border-box}]])
