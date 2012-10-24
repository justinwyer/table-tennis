(ns table-tennis.controllers.log
  (:use [speclj.core]
        [somnium.congomongo]
        [table-tennis.controllers.log]))

(describe "point adjustments"
  (it "should know the point adjustment if the point difference is 500 or greater"
    (should= {:expected-win 1
              :unexpected-win 50
              :expected-loss 0
              :unexpected-loss -26} (points-adjustments 550)))
  (it "should know the point adjustment if the point difference is between 400 and 499"
    (should= {:expected-win 1
              :unexpected-win 40
              :expected-loss 0
              :unexpected-loss -20} (points-adjustments 476)))
  (it "should know the point adjustment if the point difference is between 300 and 399"
    (should= {:expected-win 2
              :unexpected-win 30
              :expected-loss -1
              :unexpected-loss -16} (points-adjustments 343)))
  (it "should know the point adjustment if the point difference is between 200 and 299"
    (should= {:expected-win 3
              :unexpected-win 22
              :expected-loss -2
              :unexpected-loss -12} (points-adjustments 222)))
  (it "should know the point adjustment if the point difference is between 150 and 199"
    (should= {:expected-win 4
              :unexpected-win 17
              :expected-loss -2
              :unexpected-loss -10} (points-adjustments 169)))
  (it "should know the point adjustment if the point difference is between 100 and 149"
    (should= {:expected-win 5
              :unexpected-win 14
              :expected-loss -3
              :unexpected-loss -8} (points-adjustments 115)))
  (it "should know the point adjustment if the point difference is between 50 and 99"
    (should= {:expected-win 6
              :unexpected-win 11
              :expected-loss -3
              :unexpected-loss -6} (points-adjustments 62)))
  (it "should know the point adjustment if the point difference is between 25 and 49"
    (should= {:expected-win 7
              :unexpected-win 9
              :expected-loss -4
              :unexpected-loss -4} (points-adjustments 34)))
  (it "should know the point adjustment if the point difference is between 0 and 24"
    (should= {:expected-win 8
              :unexpected-win 8
              :expected-loss -4
              :unexpected-loss -4} (points-adjustments 15))))

(describe "expected or unexpected win"
  (it "should know a win is expected"
    (should= (expected-win? {:name "Herp" :points 1270} {:name "Derp" :points 943}) true))
  (it "should know a win is unexpected"
    (should= (unexpected-win? {:name "Derp" :points 943} {:name "Herp" :points 1270}) true)))

(describe "adjust points"
    (it "should know how to adjust points for the winner"
      (let [[winner loser] (adjust-points {:name "Winner" :points 1270} {:name "Loser" :points 943})]
      (should= 1273 (winner :points)))))

(run-specs)
