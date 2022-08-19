;; The good-enough? test used in computing square roots will not be very effective for finding the square roots of very small numbers. Also, in real computers, arithmetic operations are almost always performed with limited precision. This makes our test inadequate for very large numbers. Explain these statements, with examples showing how the test fails for small and large numbers. An alternative strategy for implementing good-enough? is to watch how guess changes from one iteration to the next and to stop when the change is a very small fraction of the guess.

;; Design a square-root function that uses this kind of end test.

;; Does this work better for small and large numbers?

After running tests and different use case

larget numbers, the computation will get timeout or doesn't finish

(sqrt 12345679012345667)
> timeout / not finish

small numbers, the result is inaccurate and not round up

(sqrt 0.000000000123)
> 0.031250013107186406

(defn square [x] (* x x))

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

;; <--- --->

(defn good-enough? [prev-guess guess]
 (< (abs (/ (- guess prev-guess) guess)) 0.00000000001))

(defn sqrt-iter [guess x]
  (if (good-enough? guess (improve guess x))
    guess
    (sqrt-iter (improve guess x) x)))

(defn sqrt [x] (sqrt-iter 1.0 x))