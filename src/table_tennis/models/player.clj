(ns table-tennis.models.player
  (:use somnium.congomongo))

(defn all []
  (fetch :players))

(defn create-player [name, points]
  (insert! :players
    {:name name :points points}))

(defn get-player [name]
  (fetch-one :players
    :where {:name name}))

