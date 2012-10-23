(ns table-tennis.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "table-tennis"]
               (include-css "/css/bootstrap.css")]
              [:body
               [:div#wrapper
                content]]))
