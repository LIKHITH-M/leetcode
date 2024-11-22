#lang racket

;; Definition for a binary tree node.
(struct TreeNode (val left right))

(define (has-path-sum root target-sum)
  (cond
    [(null? root) #f]
    [(and (null? (TreeNode-left root)) 
          (null? (TreeNode-right root)) 
          (= (TreeNode-val root) target-sum)) #t]
    [else 
     (let ([new-target-sum (- target-sum (TreeNode-val root))])
       (or (has-path-sum (TreeNode-left root) new-target-sum)
           (has-path-sum (TreeNode-right root) new-target-sum)))]))
