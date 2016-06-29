(ns garden-basscss.modules.flexbox
  (:require [garden-basscss.vars :refer [vars]]
            [garden.stylesheet :refer [at-media]]))

(defn breakpoints [] (:breakpoints @vars))

(defn add-prefix [val]
  (let [val (str val)]
    (case val
      "start" "flex-start"
      "end" "flex-end"
      "between" "space-between"
      "around" "space-around"
      val)))

(defn gen-items-self [type]
  (map (fn [val]
         [(str "." type "-" val) {(str "align-" type) (add-prefix val)}])
       ['start 'end 'center 'baseline 'stretch]))

(defn gen-justify-content [type]
  (let [classes ['start 'end 'center 'between 'around]]
    (map (fn [val]
           (let [prop (if (= type "justify") type "align")]
             [(str "." type "-" val) {(str prop "-content") (add-prefix val)}]))
         (if (= type "content")
           (conj classes 'stretch)
           classes))))

(defn stylesheet []
  (let [bp (breakpoints)]
    [[:.flex {:display 'flex}]
     (at-media (:sm bp)
               [:.sm-flex {:display 'flex}])
     (at-media (:md bp)
               [:.md-flex {:display 'flex}])
     (at-media (:lg bp)
               [:.lg-flex {:display 'flex}])
     [:.flex-column {:flex-direction 'column}]
     [:.flex-wrap {:flex-wrap 'wrap}]
     (gen-items-self "items")
     (gen-items-self "self")
     (gen-justify-content "justify")
     (gen-justify-content "content")
     [:.flex-auto {:flex "1 1 auto"
                   :min-width 0
                   :min-height 0}]
     [:.flex-none {:flex "none"}]
     [:.order-0 {:order 0}]
     [:.order-1 {:order 1}]
     [:.order-2 {:order 2}]
     [:.order-last {:order 99999}]]))
