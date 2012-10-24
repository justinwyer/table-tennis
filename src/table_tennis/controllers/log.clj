(ns table-tennis.controllers.log)

(declare points-adjustment)

(defn expected-win? [winner loser]
  (cond (>= (winner :points) (loser :points)) true
        :else false))

(defn unexpected-win? [winner loser]
  (cond (< (winner :points) (loser :points)) true
    :else false))

(defn adjust-points [winner loser]
  (cond (expected-win? winner loser)
    (fn [winner loser]
      (assoc winner :points
        (+ winner :points
          (points-adjustment (- winner :points loser :points))))
      [winner loser])))

(defn points-adjustments [difference]
  (cond
   (>= difference 500)
   {:expected-win 1
    :unexpected-win 50
    :expected-loss 0
    :unexpected-loss -26}
   (>= difference 400)
   {:expected-win 1
    :unexpected-win 40
    :expected-loss 0
    :unexpected-loss -20}
   (>= difference 300)
   {:expected-win 2
    :unexpected-win 30
    :expected-loss -1
    :unexpected-loss -16}
   (>= difference 200)
   {:expected-win 3
    :unexpected-win 22
    :expected-loss -2
    :unexpected-loss -12}
   (>= difference 150)
   {:expected-win 4
    :unexpected-win 17
    :expected-loss -2
    :unexpected-loss -10}
   (>= difference 100)
   {:expected-win 5
    :unexpected-win 14
    :expected-loss -3
    :unexpected-loss -8}
   (>= difference 50)
   {:expected-win 6
    :unexpected-win 11
    :expected-loss -3
    :unexpected-loss -6}
   (>= difference 25)
   {:expected-win 7
    :unexpected-win 9
    :expected-loss -4
    :unexpected-loss -4}
   :else
   {:expected-win 8
    :unexpected-win 8
    :expected-loss -4
    :unexpected-loss -4}))