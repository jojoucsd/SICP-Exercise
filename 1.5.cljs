;Ben Bitdiddle has invented a test to determine whether the interpreter he is faced with is using applicative-order evaluation or normal-order evaluation. He defines the following two procedures:

(defn p []
  (p))

(defn testing [x y]
  (if (= x 0)
    0
    y))

(testing 0 (p))

;What behavior will Ben observe with an interpreter that uses applicative-order evaluation?

;function p defines a function that evaluates to itself and applicative-order evalutaion will evaluate the 
;arguments and then apply

;so for function testing will eval 0 then try to eval (p) and apply testing to the values of the eval of the two
;parameters

; 0 will eval to intger 0
; (p) will eval to (p), which remains as (p) 
; which in this case will be an infinite loop 

;; Applicative-Order Evaluation
;; Applicative-order evaluation means that a function’s arguments are evaluated before the function is applied. In other words, with applicative-order evaluation, internal reductions are applied first, and only after all internal reductions are complete, the left-most redex is reduced. More formally, we evaluate the left-most redex free of any internal redexes.

;; The most noticeable effect of applicative-order evaluation is that recursive functions may not terminate. For example, if an argument to a function must be evaluated before calling the function, and if that argument is recursive, the function will never terminate.

;; To illustrate the differences between normal and applicative order reduction, let’s walk through a few examples.

;; -----------------------------------------------------------

;; Normal-Order Evaluation
;; Normal-order evaluation of a lambda expression is the repeated application of the leftmost reducible function application. In other words, normal order evaluation is the strategy that always reduces the left-most outer-most redex first. You can think about normal-order evaluation as traversing the lambda expression and evaluating every function you find before evaluating any function arguments.

;; The most noticeable effect of using normal-order evaluation is that, since we evaluate the leftmost function first, arguments to that function are not evaluated. If those arguments are themselves functions, we may pass unevaluated functions as function arguments. Speaking in terms of lambda calculus, an expression with an unevaluated function application as argument will replace all bound variables with the unevaluated function application.

;What behavior will he observe with an interpreter that uses normal-order evaluation?

; the interpreter will fully expan and then reduce the interpreter will not eval the operands until their values
; are actually needed.
(testing 0 (p)) 
(if (= 0 0) ; this is true
  0 (p))

;since (= 0 0) is true (p) will not be eval and the result will be just int 0