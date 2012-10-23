(ns table-tennis.core.player_model
  (:use [midje.sweet]
        [somnium.congomongo]
        [table-tennis.models.player]))

(mongo! :db "tt-test" :host "127.0.0.1")

(background (before :facts (create-player "Harry" 10)
              :after (destroy! :players {}))
  (fact "create-player-test"
    (((get-player "Harry") :name ) => "Harry")))


(background (before :facts (do
                             (create-player "Harry" 10)
                             (create-player "Herp" 20))
              :after (destroy! :players {}))
  (fact "all-players-get-fetched"
    ((count (all)) => 2)))