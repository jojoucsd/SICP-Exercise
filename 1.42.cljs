;; Let f and g be two one-argument functions.

;; The composition of f and g, denoted f∘g is defined to be the function

;; x→f (g (x))
;; Define a function compose that implements composition.
(defn compose [f g]
  (fn [x]
    (f (g x))))
(defn square [x]
  (* x x))

;; ((compose square inc) 6) => 49



