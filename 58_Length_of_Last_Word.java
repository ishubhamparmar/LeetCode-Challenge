/*
 * 58. Length of Last Word
 * Problem Link: https://leetcode.com/problems/length-of-last-word/
 * Given a string s consisting of words and spaces, return the length of the
 * last word in the string.
 * 
 * A word is a maximal
 * substring
 * consisting of non-space characters only.
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * 
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 */
//Beats 47% 
// class Solution {
//     public int lengthOfLastWord(String s) {
//         String res [] = s.split(" ");
//         return res[res.length-1].length();
//     }
// }
//Beats 100%
class Solution {
    public int lengthOfLastWord(String s) {
        int lastIndex = 0;
        int firstIndex = 0;
        if (s.length() == 1 && s.charAt(0) != ' ')
            return 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                lastIndex = i;
                break;
            }
        }
        for (int i = lastIndex; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                firstIndex = i + 1;
                break;
            }
        }
        return lastIndex - firstIndex + 1;
    }
}