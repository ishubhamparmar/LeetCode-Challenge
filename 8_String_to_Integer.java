/*
 * 
 * 8. String to Integer (atoi) - Medium
 * Problem Link: https://leetcode.com/problems/string-to-integer-atoi/
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit
 * signed integer (similar to C/C++'s atoi function).
 * 
 * The algorithm for myAtoi(string s) is as follows:
 * 
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-'
 * or '+'. Read this character in if it is either. This determines if the final
 * result is negative or positive respectively. Assume the result is positive if
 * neither is present.
 * Read in next the characters until the next non-digit character or the end of
 * the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no
 * digits were read, then the integer is 0. Change the sign as necessary (from
 * step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
 * then clamp the integer so that it remains in the range. Specifically,
 * integers less than -231 should be clamped to -231, and integers greater than
 * 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 * 
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of
 * the string after the digits.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the
 * current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 * ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 * ^
 * Step 3: "42" ("42" is read in)
 * ^
 * The parsed integer is 42.
 * Since 42 is in the range [-231, 231 - 1], the final result is 42.
 * 
 */

//Beats 61%
class Solution {
    public int myAtoi(String s) {
        if (s == null)
            return 0;
        int sign = 1;
        s = s.trim();
        long res = 0;
        if (s.length() == 0)
            return 0;
        if (s.charAt(0) == '-')
            sign = -1;

        int i = (s.charAt(0) == '-' || s.charAt(0) == '+') ? 1 : 0;
        while (i < s.length()) {
            if (!Character.isDigit(s.charAt(i)))
                break;
            res = res * 10 + s.charAt(i) - '0';
            if (sign == -1 && -1 * res < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if (sign == 1 && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            i++;
        }

        return (int) (res * sign);
    }
}