;; Exercise 1.15: The sine of an angle (specified in radians) can be computed by making use of the approximation 
;; sin
;; x
;; ≈
;; x
;;  if 
;; x
;;  is sufficiently small, and the trigonometric identity

;; sin
;; ;
;; x
;; ;
;; =
;; ;
;; 3
;; ;
;; sin
;; x
;; 3
;; −
;; 4
;; ;
;; sin
;; 3
;; x
;; 3
;; to reduce the size of the argument of sin. (For purposes of this exercise an angle is considered “sufficiently small” if its magnitude is not greater than 0.1 radians.) These ideas are incorporated in the following procedures:

(defn cube [x]
  (* x x x))

(defn p [x]
  (- (* 3 x) (* 4 (cube x))))

(defn sine [angle]
  (if (not (> (abs angle) 0.1))
    angle
    (p (sine (/ angle 3.0)))))

;; How many times is the procedure p applied when (sine 12.15) is evaluated?
;; What is the order of growth in space and number of steps (as a function of a) used by the process generated by the sine procedure when (sine a) is evaluated?

;; 1: 12.15
;; 2: 4.05
;; 3: 1.3499999999999999
;; 4: 0.44999999999999996
;; 5: 0.15
;; 6: 0.049999999999999996
;; -0.39980345741334

(defn sine-count-step [angle step]
  (if (not (> (abs angle) 0.1))
    step
    (sine-count-step (/ angle 3.0) (+ step 1))))

;; a	number of steps
12	        6
120	        8
1200	    10
12000	    12
120000	    14
1200000	    16
12000000	18

;; for every iter, a is divided by 3 = Theata(log(a))

