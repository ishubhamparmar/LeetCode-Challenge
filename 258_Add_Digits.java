/*
 * 258. Add Digits
 * Problem Link: https://leetcode.com/problems/add-digits/
 * Given an integer num, repeatedly add all its digits until the result has only
 * one digit, and return it.
 * 
 * Example 1:
 * 
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 */

// class Solution {
//     public int addDigits(int num) {
//         int sum = 0;
//         while(num > 9){
//         while(num>0){
//             sum += num%10;
//             num  = num/10;
//         }
//         num = sum;
//         sum = 0;
//         }
//         return num;
//     }
// }

//O(1) Solution

class Solution {
    public int addDigits(int num) {
        if (num == 0)
            return 0;
        return num % 9 == 0 ? 9 : num % 9;
    }
}
