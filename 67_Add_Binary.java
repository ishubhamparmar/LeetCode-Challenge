/*
 * 67. Add Binary
 * Problem Link: https://leetcode.com/problems/add-binary/
 * Given two binary strings a and b, return their sum as a binary string.
 * 
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 * Constraints:
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
//Beats 32.61% | O(N)
class Solution {
    public String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int i = 0;
        int carry = 0;
        String res = "";

        while (i < aLength || i < bLength || carry != 0) {
            int j = 0;
            if (i < aLength && a.charAt(aLength - i - 1) == '1') {
                j = 1;
            }
            int k = 0;
            if (i < bLength && b.charAt(bLength - i - 1) == '1') {
                k = 1;
            }
            res = String.valueOf((j + k + carry) % 2) + res;
            carry = (j + k + carry) / 2;
            i++;
        }
        return res;
    }
}