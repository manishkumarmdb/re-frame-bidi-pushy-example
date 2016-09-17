(ns re-frame-bidi-pushy-example.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]))


(re-frame/reg-sub-raw
 :name
 (fn [db]
   (reaction (:name @db))))

(re-frame/reg-sub-raw
 :active-panel
 (fn [db _]
   (reaction (:active-panel @db))))
