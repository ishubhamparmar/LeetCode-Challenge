/*
 * 75. Sort Colors
 * Problem Link:https://leetcode.com/problems/sort-colors/
 * Given an array nums with n objects colored red, white, or blue, sort them
 * in-place so that objects of the same color are adjacent, with the colors in
 * the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and
 * blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Constraints:
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * 
 * Follow up: Could you come up with a one-pass algorithm using only constant
 * extra space?
 */
//Beats 100% | O(N)
class Solution {
        public void sortColors(int[] nums) {
                int countZero = 0;
                int countOne = 0;
                int countTwo = 0;
                for (int i : nums) {
                        if (i == 0)
                                countZero++;
                        else if (i == 1)
                                countOne++;
                        else
                                countTwo++;
                }
                for (int i = 0; i < countZero; i++) {
                        nums[i] = 0;
                }
                for (int i = countZero; i < countOne + countZero; i++) {
                        nums[i] = 1;
                }
                for (int i = countOne + countZero; i < countZero + countOne + countTwo; i++) {
                        nums[i] = 2;
                }
        }
}