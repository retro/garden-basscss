(ns garden-basscss.modules.padding
  (:require [garden-basscss.vars :refer [vars]]
            [garden-basscss.util :refer [gen-margin-padding]]))

(defn stylesheet [] [(gen-margin-padding :padding)])
