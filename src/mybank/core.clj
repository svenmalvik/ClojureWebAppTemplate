
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
    [mybank.view :as view]
    [clojure.java.jdbc :as jdbc]))

(def db {
  :classname "com.mysql.jdbc.Driver"
  :subprotocol "mysql"
  :subname "//localhost:3306/nordea"
  :user "root"
  :password ""})


(defn insert-subscriber [email]
  (jdbc/insert-values
    :subscribers [:email] [email]))

(defn add-subscriber ([email]
 (jdbc/with-connection db
   (jdbc/transaction
     (insert-subscriber email)))))

(defroutes my_routes
  (GET "/" [] (view/index-page))
  (POST "/" [email]
    (add-subscriber email)
    (json/json-str {:response email}))
  (route/resources "/"))

(def app (wrap-params my_routes))