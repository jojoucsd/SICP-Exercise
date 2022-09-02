;; The numbers at the edge of the triangle are all 1, and each number inside the triangle is the sum of the two numbers above it. Write a procedure that computes elements of Pascal’s triangle by means of a recursive process.

         1
       1   1 
     1   2   1
   1   3   3   1
 1   4   6   4   1

;; The solution is easier to see if you change slightly the tabulation:
       
1
1   1
1   2   1
1   3   3   1
1   4   6   4   1

(defn pascal
  [row col]
  (cond ((= row 1) 1)
        ((or (= col 1) (= col row)) 1)
        :else (+ (pascal (- row 1) (- col 1))
                 (pascal (- row 1) col)))) 

(defn column-iter [n i]
  (prn (pascal n i))
  (prn " ")
  (if (= i n)
    (newline)
    (column-iter n (+ i 1))))

(defn display-pascal-row
  [n]
  (column-iter n 1))

(defn display-pascal-iter [n i]
  (display-pascal-row i)
  (if (= i n )
    (newline)
    (display-pascal-iter n (+ i 1))))

(defn display-pascal [n]
  (display-pascal-iter n 1))

(display-pascal 10)

1
1  1
1  2  1
1  3  3  1
1  4  6  4  1
1  5  10  10  5  1
1  6  15  20  15  6  1
1  7  21  35  35  21  7  1
1  8  28  56  70  56  28  8  1
1  9  36  84  126  126  84  36  9  1