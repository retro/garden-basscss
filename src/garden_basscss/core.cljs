(ns garden-basscss.core
  (:require [garden.core :refer [css]]
            [garden-basscss.modules.align :as align]
            [garden-basscss.modules.border :as border]
            [garden-basscss.modules.flexbox :as flexbox]
            [garden-basscss.modules.grid :as grid]
            [garden-basscss.modules.hide :as hide]
            [garden-basscss.modules.layout :as layout]
            [garden-basscss.modules.margin :as margin]
            [garden-basscss.modules.padding :as padding]
            [garden-basscss.modules.position :as position]
            [garden-basscss.modules.type-scale :as type-scale]
            [garden-basscss.modules.typography :as typography]))

(def stylesheet 
  [align/stylesheet
   border/stylesheet
   flexbox/stylesheet
   grid/stylesheet
   hide/stylesheet
   layout/stylesheet
   margin/stylesheet
   padding/stylesheet
   position/stylesheet
   type-scale/stylesheet
   typography/stylesheet])
