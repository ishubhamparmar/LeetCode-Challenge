/*
 * 125. Valid Palindrome
 * Problem Link: https://leetcode.com/problems/valid-palindrome/
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 */

// Beats 15% - Using Pattern to replace spaces and special characters 
// class Solution {
//     public boolean isPalindrome(String s) {
//         s = s.replaceAll("[^a-zA-Z0-9]", "");
//         s = s.toLowerCase();
//         return isp(s);

//     }
//     public boolean isp(String str){
//         int low = 0;
//         int high = str.length()-1;
//         while(low<=high){
//             if(str.charAt(low++)!=str.charAt(high--))   return false;
//         }
//         return true;
//     }
// }

// Beats 97.5%
class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            char charFirst = s.charAt(start);
            char charLast = s.charAt(last);
            if (!Character.isLetterOrDigit(charFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(charLast)) {
                last--;
            } else {
                if (Character.toLowerCase(charFirst) != Character.toLowerCase(charLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}