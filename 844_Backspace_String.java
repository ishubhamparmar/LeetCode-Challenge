/*
 * 844. Backspace String Compare | Easy
 * Given two strings s and t, return true if they are equal when both are typed
 * into empty text editors. '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * Example 1:
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 * 
 * Constraints:
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 * 
 * Follow up: Can you solve it in O(n) time and O(1) space?
 */

// Beats 27% | O(N) | Using Stack
// class Solution {
//     public boolean backspaceCompare(String s, String t) {
//         Stack<Character> st1 = new Stack<>();
//         Stack<Character> st2 = new Stack<>();
//         int n = 0;
//         while(n<s.length()) {
//             if(Character.isLetter(s.charAt(n))) {
//                 st1.push(s.charAt(n));
//             }
//             if(!st1.isEmpty() && s.charAt(n)=='#') {
//                 st1.pop();
//             }
//             n++;
//         }
//         int k = 0;
//         while(k<t.length()) {
//             if(Character.isLetter(t.charAt(k))) {
//                 st2.push(t.charAt(k));
//             }
//             if(!st2.isEmpty() && t.charAt(k)=='#') {
//                 st2.pop();
//             }
//             k++;
//         }

//         while(!st1.isEmpty() && !st2.isEmpty()) {
//             if(st1.pop() != st2.pop())  return false;
//         }

//         if(!st1.isEmpty() || !st2.isEmpty()) {
//             return false;
//         }
//     return true;
//     }
// }

//O(N) | Beats 86% | Using StringBuilder
// class Solution {
//     public boolean backspaceCompare(String S, String T) {
//         return sb(S).equals(sb(T));
//     }

//     private String sb(String str) {
//         StringBuilder sbr = new StringBuilder();

//         for (char c : str.toCharArray()) {

//             if (c != '#') {
//                 sbr.append(c);
//             } else if (sbr.length() != 0) {
//                 sbr.deleteCharAt(sbr.length() - 1);
//             }
//         }
//         return sbr.toString();
//     }
// }

//Using stack | Beats 62%
class Solution {
        public boolean backspaceCompare(String S, String T) {
                return stackSolution(S).equals(stackSolution(T));
        }

        private String stackSolution(String str) {
                Stack<Character> stack = new Stack<Character>();

                for (char c : str.toCharArray()) {

                        if (c != '#') {
                                stack.push(c);

                        } else if (!stack.isEmpty()) {
                                stack.pop();
                        }
                }
                return stack.toString();
        }
}