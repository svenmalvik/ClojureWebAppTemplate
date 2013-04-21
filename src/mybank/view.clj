
;
; Copyright (c) 2013. - Sven Malvik - sven.malvik.de
;

(ns mybank.view
  (:use
    hiccup.page
    hiccup.element))

(defn index-page []
  (html5
    (include-js "/js/jquery-1.9.1.min.js" "http://code.angularjs.org/1.0.6/angular.min.js" "/js/mybank.js")
    [:html {:ng-app ""}
      [:head]
      [:body
        [:div {:ng-controller "controller"}
          [:form {:novalidate ""}
            [:h1 "Register for Newsletter"]

            [:label "Email:"][:input {:name "email" :type "text" :ng-model "user.email" :required "true"}][:br]
            [:span#response]
            [:button {:ng-click "saveit(user)"} "Save"]
            ]]]]))

