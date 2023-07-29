/*
 * 744. Find Smallest Letter Greater Than Target - Easy
 * Problem Link:
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * You are given an array of characters letters that is sorted in non-decreasing
 * order, and a character target. There are at least two different characters in
 * letters.
 * 
 * Return the smallest character in letters that is lexicographically greater
 * than target. If such a character does not exist, return the first character
 * in letters.
 * 
 * Example 1:
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * Explanation: The smallest character that is lexicographically greater than
 * 'a' in letters is 'c'.
 * 
 * Example 2:
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * Explanation: The smallest character that is lexicographically greater than
 * 'c' in letters is 'f'.
 * 
 * Example 3:
 * Input: letters = ["x","x","y","y"], target = "z"
 * Output: "x"
 * Explanation: There are no characters in letters that is lexicographically
 * greater than 'z' so we return letters[0].
 * 
 * Constraints:
 * 2 <= letters.length <= 104
 * letters[i] is a lowercase English letter.
 * letters is sorted in non-decreasing order.
 * letters contains at least two different characters.
 * target is a lowercase English letter. *
 */

//Beats 100% | Binary Search | O(logN)
class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
                if (target >= letters[letters.length - 1])
                        return letters[0];
                int low = 0;
                int high = letters.length - 1;
                while (low < high) {
                        int mid = low + (high - low) / 2;
                        if (letters[mid] > target) {
                                high = mid;
                        } else if (letters[mid] < target) {
                                low = mid + 1;
                        } else {
                                while (letters[mid] == letters[mid + 1]) {
                                        mid++;
                                }
                                return letters[mid + 1];
                        }
                }
                return letters[low];
        }
}