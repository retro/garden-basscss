(ns garden-basscss.vars
  (:require [garden.units :refer [px rem em]]))

(def vars
  (atom {:border {:width (px 1)
                  :radius (px 3)}
         :breakpoints {:xs {:max-width (em 40)}
                       :sm {:min-width (em 40)}
                       :md {:min-width (em 52)}
                       :lg {:min-width (em 64)}
                       :sm-md {:min-width (em 40)
                               :max-width (em 52)}
                       :md-lg {:min-width (em 52)
                               :max-width (em 64)}}
         :widths {1 (rem 24)
                  2 (rem 32)
                  3 (rem 48)
                  4 (rem 64)}
         :spaces {0 0
                  1 (rem 0.5)
                  2 (rem 1)
                  3 (rem 2)
                  4 (rem 4)}
         :z-indices {1 1
                     2 2
                     3 3
                     4 4}
         :type-scale {1 (rem 2)
                      2 (rem 1.5)
                      3 (rem 1.25)
                      4 (rem 1)
                      5 (rem 0.875)
                      6 (rem 0.75)}
         :typography {:line-heights {1 1
                                     2 1.125
                                     3 1.25
                                     4 1.5}
                      :letter-spacing 1
                      :caps-letter-spacing (em 0.2)
                      :bold-font-weight 'bold}}))
