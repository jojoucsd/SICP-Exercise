;Observe that our model of evaluation allows for combinations whose operators are com- pound expressions. Use this observation to describe the behavior of the following function:
(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) ;; if b is positive will be "a+b"
   a
   b))

;in any other case of b is not positive the operation wil lbe "a-b"
;which this really means a + |b| 
