;;Define a function that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.

(defn square 
  [x] 
  (* x x))

(defn sum-square 
  [x y] 
  (+ (square x)(square y)))

(defn sum-of-larger-squares [x y z]
  (cond (and (<= x y) (<= x z)) (sum-square y z)
        (and (<= y x) (<= y z)) (sum-square x z)
        :else (sum-square x y)))

;; solution 2
(defn sum-square-largest 
  [x y z]
  (cond (and (< x y) (< x z)) (+ (* y y) (* z z))
        :else (sum-square-largest y z x)))

(sum-of-larger-squares 10 10 10)

(sum-of-larger-squares 1 10 10)

(sum-of-larger-squares 1 10 10)