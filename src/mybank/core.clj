
;
; Copyright (c) 2013. - Sven Malvik - sven.malvik.de
;

(ns mybank.core
  (:use
    ring.adapter.jetty
    compojure.core
    ring.middleware.params)
  (:require
    [compojure.route :as route]
    [clojure.data.json :as json]
    [mybank.view :as view]))

(defroutes my_routes
  (GET "/" [] (view/index-page))
  (POST "/" [email] (json/json-str {:response email}))
  (route/resources "/"))

(def app (wrap-params my_routes))