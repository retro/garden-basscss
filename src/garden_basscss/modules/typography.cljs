(ns garden-basscss.modules.typography
  (:require [garden-basscss.vars :refer [vars]]))

(defn typography [] (:typography @vars))
(defn line-heights [] (:line-heights (typography)))

(defn gen-align []
  (map (fn [dir]
         (let [dir (str dir)
               class (case dir
                       "left" "left-align"
                       "right" "right-align"
                       dir)]
           [(str "." class) {:text-align dir}])) ['left 'center 'right 'justify]))

(defn gen-font-weights []
  (map (fn [fw]
         [(str ".fw-" (* 100 fw)) {:font-weight (str (* 100 fw))}]) (range 1 10)))

(defn stylesheet []
  (let [t (typography)
        lh (line-heights)]
    [[:.font-family-inherit {:font-family 'inherit}]
     [:.font-size-inherit {:font-size 'inherit}]
     [:.text-decoration-none {:text-decoration 'none}]
     [:.bold {:font-weight [(:bold-font-weight t)]}]
     [:.regular {:font-weight 'normal}]
     [:.italic {:font-style 'italic}]
     [:.caps {:text-transform 'uppercase
              :letter-spacing (:caps-letter-spacing t)}]
     (gen-align)
     (gen-font-weights)
     [:.nowrap {:white-space 'nowrap}]
     [:.break-word {:word-wrap 'break-word}]
     (map (fn [v] [(str ".line-height-" v) {:line-height (get lh v)}]) (range 1 5))
     [:.list-style-none {:list-style 'none}]
     [:.underline {:text-decoration 'underline}]
     [:.truncate {:max-width "100%"
                  :overflow 'hidden
                  :text-overflow 'ellipsis
                  :white-space 'nowrap}]
     [:.list-reset {:list-style 'none
                    :padding-left 0}]]))
