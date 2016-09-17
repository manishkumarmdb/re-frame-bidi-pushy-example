(ns re-frame-bidi-pushy-example.views
  (:require [re-frame.core :as re-frame]
            [re-frame-bidi-pushy-example.db]
            [re-frame-bidi-pushy-example.handlers]
            [re-frame-bidi-pushy-example.subs]
            [re-frame-bidi-pushy-example.routes :as routes]))

(defn home-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div (str "Hello from " @name ". This is the Home Page.")
       [:div [:a {:href (routes/url-for :about)} "go to About Page"]]])))

(defn about-panel []
  (fn []
    [:div "This is the About Page."
     [:div [:a {:href (routes/url-for :home)} "go to Home Page"]]]))


(defmulti panels identity)
(defmethod panels :home-panel [] [home-panel])
(defmethod panels :about-panel [] [about-panel])
(defmethod panels :default [] [:div "This is default route"])


(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [panels @active-panel])))
