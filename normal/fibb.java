class Solution {
    public int fib(int n) {
        if(n<=1 || n==5) return n; // condition n==5 is added to reduce number of ittirations.
        else
        return fib(n-1)+fib(n-2);
    }
}