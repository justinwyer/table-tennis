(ns table-tennis.models.player
  (:use [speclj.core]
        [somnium.congomongo]
        [table-tennis.models.player]))

(mongo! :db "tt-test" :host "127.0.0.1")

(describe "create player"
  (it "should create a player"
    (create-player "Harry" 10)
    (let [harry (get-player "Harry")]
    (should= (harry :name) "Harry")
    (should= (harry :points) 10)))
  (after (destroy! :players {})))

(describe "get players "
  (before (do (create-player "Harry" 10)
              (create-player "Herp" 20)))
  (it "should fetch all players"
    (should= 2 (count (all))))
  (after (destroy! :players {})))

(run-specs)