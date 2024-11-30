class Solution {
    public int myAtoi(String s) {
          // Step 1: Ignore leading whitespace
        s = s.trim();
        
        // Step 2: Check for sign
        int sign = 1;
        int index = 0;
        int n = s.length();
        
        if (index < n) {
            if (s.charAt(index) == '-') {
                sign = -1;
                index++;
            } else if (s.charAt(index) == '+') {
                index++;
            }
        }
        
        // Step 3: Convert the number
        int result = 0;
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            // Step 4: Check for overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }
        
        return sign * result;
    }
}