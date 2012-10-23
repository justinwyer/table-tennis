(ns table-tennis.views.welcome
  (:require [table-tennis.views.common :as common])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to table-tennis"]))

(defpage "/tt" []
         (common/layout
           [:h1 "Yay table tennis"]))