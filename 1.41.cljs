;; Define a function double that takes a function of one argument as argument and returns a function that applies the original function twice. For example, if inc is a function that adds 1 to its argument, then (double inc) should be a function that adds 2. What value is returned by

;; (((double (double double)) inc) 5) => 21

(defn double-explain [f]
  (fn [x]
    (f (f x))))