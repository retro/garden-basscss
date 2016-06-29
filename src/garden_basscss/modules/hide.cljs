(ns garden-basscss.modules.hide
  (:require [garden-basscss.vars :refer [vars]]
            [garden.units :refer [px]]
            [garden.stylesheet :refer [at-media]]))

(defn breakpoints [] (:breakpoints @vars))
(def display-none! {:display "none !important"})

(defn stylesheet []
  (let [bp (breakpoints)]
    [[:.hide {:position "absolute !important"
              :height (px 1)
              :width (px 1)
              :overflow 'hidden
              :clip "rect(1px, 1px, 1px, 1px)"}]
     (at-media (:xs bp)
               [:.xs-hide display-none!])
     (at-media (:sm-md bp) 
               [:.sm-hide display-none!])
     (at-media (:md-lg bp)
               [:.md-hide display-none!])
     (at-media (:lg bp)
               [:.lg-hide display-none!])
     [:.display-none display-none!]]))
