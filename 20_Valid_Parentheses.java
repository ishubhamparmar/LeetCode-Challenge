/*
 * 20. Valid Parentheses
 * Problem Link: https://leetcode.com/problems/valid-parentheses/
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 * Example 1:
 * Input: s = "()"
 * Output: true
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * 
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
//Beats 16% | O()
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                st.push(s.charAt(i));

            else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (st.isEmpty())
                    return false;
                else {
                    if (st.peek() == opposite(s.charAt(i)))
                        st.pop();
                    else
                        return false;
                }

            }

        }
        if (st.isEmpty())
            return true;
        return false;
    }

    char opposite(char c) {
        if (c == ')')
            return '(';
        else if (c == '}')
            return '{';
        return '[';

    }
}