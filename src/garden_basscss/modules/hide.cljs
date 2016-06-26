(ns garden-basscss.modules.hide
  (:require [garden-basscss.vars :refer [vars]]
            [garden.units :refer [px]]
            [garden.stylesheet :refer [at-media]]))

(def breakpoints (:breakpoints @vars))
(def display-none! {:display "none !important"})

(def stylesheet [[:.hide {:position "absolute !important"
                          :height (px 1)
                          :width (px 1)
                          :overflow 'hidden
                          :clip "rect(1px, 1px, 1px, 1px)"}]
                 (at-media (:xs breakpoints)
                           [:.xs-hide display-none!])
                 (at-media (:sm-md breakpoints) 
                           [:.sm-hide display-none!])
                 (at-media (:md-lg breakpoints)
                           [:.md-hide display-none!])
                 (at-media (:lg breakpoints)
                           [:.lg-hide display-none!])
                 [:.display-none display-none!]])
