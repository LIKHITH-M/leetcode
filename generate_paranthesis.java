/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8 */

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    // Backtracking function to generate parentheses combinations
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // If the current combination is a valid one, add it to the result
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Add an opening parenthesis if we have not yet used all opening parentheses
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Add a closing parenthesis if we have fewer closing than opening parentheses
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
/*To solve the problem of generating all combinations of well-formed parentheses for n pairs of parentheses,
 we can use backtracking. The idea is to recursively build the combinations while ensuring that at every step,
  the number of closing parentheses ) does not exceed the number of opening parentheses (.

Approach:
Base Case: When the number of opening and closing parentheses reaches n, add the current combination to the result.
Backtracking:
Keep track of the number of opening and closing parentheses used so far.
You can add an opening parenthesis ( if the count of opening parentheses is less than n.
You can add a closing parenthesis ) if the count of closing parentheses is less than the count of opening parentheses (to ensure the parentheses remain valid).
Plan:
We will maintain a list of results.
Start with an empty string and recursively try to add parentheses until the base case is reached.
Use backtracking to explore all possible combinations. */

/*Explanation:
Function: generateParenthesis(int n)

Initializes a list to store the results (result).
Calls the helper function backtrack to generate combinations.
Helper Function: backtrack(List<String> result, String current, int open, int close, int max)

Parameters:
result: Stores the valid parentheses combinations.
current: Current string of parentheses being built.
open: Number of opening parentheses used so far.
close: Number of closing parentheses used so far.
max: The target number of parentheses pairs (i.e.,n).
Base Case: If the length of the current string is equal to max * 2 (because each pair has 2 parentheses), we add the current string to the result.
Recursive Case:
We can add an opening parenthesis ( if we haven't added all n opening parentheses yet.
We can add a closing parenthesis ) if the number of closing parentheses is less than the number of opening parentheses (to ensure the parentheses remain valid). */