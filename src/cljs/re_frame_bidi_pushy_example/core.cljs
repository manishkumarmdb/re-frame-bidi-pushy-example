(ns re-frame-bidi-pushy-example.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [devtools.core :as devtools]
            [re-frame-bidi-pushy-example.handlers]
            [re-frame-bidi-pushy-example.subs]
            [re-frame-bidi-pushy-example.routes :as routes]
            [re-frame-bidi-pushy-example.views :as views]
            [re-frame-bidi-pushy-example.config :as config]))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")
    (devtools/install!)))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (routes/app-routes)
  (mount-root))
