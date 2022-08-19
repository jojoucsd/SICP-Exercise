;; Alyssa P. Hacker doesn’t see why if needs to be provided as a special form. “Why can’t I just define it as an ordinary function in terms of cond ?” she asks. Alyssa’s friend Eva Lu Ator claims this can indeed be done, and she defines a new version of if :

(defn new-if [predicate then-clause else-clause]
  (cond predicate then-clause
        :else else-clause))
;; Eva demonstrates the program for Alyssa:

> (new-if (= 2 3) 0 5)
5

> (new-if (= 1 1) 0 5)
0
;; Delighted, Alyssa uses new-if to rewrite the squareroot program:

(defn sqrt-iter [guess x]
  (new-if (good-enough? guess x)
          guess
          (recur (improve guess x) x)))
;; What happens when Alyssa attempts to use this to compute square roots? Explain.

Solution: since (new-if) is a function, each parameters subexpressions will be eval before procedure is appied.

(new-if (good-enough? guess x)
        guess 
        (sqrt-iter (improve guess x) x))

in this case the predicate and the two alternatives will always be eval / call by (good-enough? guess x) is eval to.
And the 2nd alternative is calling the function itself recursively, the function will be stuck in and infinite loop.
