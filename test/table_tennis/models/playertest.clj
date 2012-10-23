(ns table-tennis.models.playertest
  (:use [clojure.test]
        [somnium.congomongo]
        [table-tennis.models.player]))

  (mongo! :db "tt-test" :host "127.0.0.1")

  (deftest create-player-test
    (create-player "Harry" 10)
    (is (= ((get-player "Harry") :name) "Harry")))

  (deftest all-players-get-fetched
    (destroy! :players {})
    (create-player "Derp" 10)
    (create-player "Herp" 20)
    (is (= (count (all)) 2)))