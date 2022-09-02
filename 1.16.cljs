;; Design a procedure that evolves an iterative exponentiation process that uses successive squaring and uses a logarithmic number of steps, as does fast-expt .

;; (Hint: Using the observation that (bn2)2=(b2)n2 keep, along with the exponent n and the base b , an additional state variable a , and define the state transformation in such a way that the product abn is unchanged from state to state. At the beginning of the process a is taken to be 1, and the answer is given by the value of a at the end of the process. In general, the technique of defining an invariant quantity that remains unchanged from state to state is a powerful way to think about the design of iterative algorithms.)

(defn fast-expt-iter [a b n]
  (cond ((= n 0) a)
        ((even? n) (fast-expt-iter a (* b b) (/ n 2)))
        :else 
        (fast-expt-iter (* a b) b (- n 1))))

(fast-expt-iter 1 9 7)