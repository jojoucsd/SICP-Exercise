;Recursive 

(defn f-recursive [n]
  (if (< n 3)
    n
    (+ (f-recursive (- n 1))
       (* 2 (f-recursive (- n 2)))
       (* 3 (f-recursive (- n 3))))))

;Iterative

(defn f-iter [n]
  (defn f-loop [n-1 n-2 n-3 nth]
    (if (= n nth)
      n-1 
      (f-loop (+ n-1 (* 2 n-2) (* 3 n-3)) n-1 n-2 (+ 1 nth))))
  (if (< n 3)
    n
    (f-loop 2 1 0 2)))