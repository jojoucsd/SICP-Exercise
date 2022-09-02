;; If f is a numerical function and n is a positive integer, then we can form the nth repeated application of f , which is defined to be the function whose value at x is

;; f(f(…(f(x))…))
;; For example, if f is the function x→x+1 then the nth repeated application of f is the function x→x+n
;; If f is the operation of squaring a number, then the nth repeated application of f is the function

;; x→x2n
;; Write a function that takes as inputs a function that computes f and a positive integer n and returns the function that computes the nth repeated application of f . Your function should be able to be used as follows:


(defn square [x] (* x x))

(defn compose [f g]
  (fn [x]
     (f (g x))))

(defn repeated [f n]
  (if (= n 1) f
      (compose f (repeated f (- n 1)))))

((repeated square 2) 5) => 625