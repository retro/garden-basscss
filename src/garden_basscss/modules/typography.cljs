(ns garden-basscss.modules.typography
  (:require [garden-basscss.vars :refer [vars]]))

(def typography (:typography @vars))
(def line-heights (:line-heights typography))

(defn gen-align []
  (map (fn [dir]
         (let [dir (str dir)
               class (case dir
                       "left" "left-align"
                       "right" "right-align"
                       dir)]
           [(str "." class) {:text-align dir}])) ['left 'center 'right 'justify]))

(def stylesheet [[:.font-family-inherit {:font-family 'inherit}]
                 [:.font-size-inherit {:font-size 'inherit}]
                 [:.text-decoration-none {:text-decoration 'none}]
                 [:.bold {:font-weight [(:bold-font-weight typography) 'bold]}]
                 [:.regular {:font-weight 'normal}]
                 [:.italic {:font-style 'italic}]
                 [:.caps {:text-transform 'uppercase
                          :letter-spacing (:caps-letter-spacing typography)}]
                 (gen-align)
                 [:.nowrap {:white-space 'nowrap}]
                 [:.break-word {:word-wrap 'break-word}]
                 (map (fn [v] [(str ".line-height-" v) {:line-height (get line-heights v)}]) (range 1 5))
                 [:.list-style-none {:list-style 'none}]
                 [:.underline {:text-decoration 'underline}]
                 [:.truncate {:max-width "100%"
                              :overflow 'hidden
                              :text-overflow 'ellipsis
                              :white-space 'nowrap}]
                 [:.list-reset {:list-style 'none
                                :padding-left 0}]])
