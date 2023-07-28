/*
 * 55. Jump Game - Medium
 * Problem Link: https://leetcode.com/problems/jump-game/
 * 
 * You are given an integer array nums. You are initially positioned at the
 * array's first index, and each element in the array represents your maximum
 * jump length at that position.
 * 
 * Return true if you can reach the last index, or false otherwise.
 * 
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * Constraints:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */

//Beats 24%
// class Solution {
//     public boolean canJump(int[] nums) {
//         if(nums.length <= 1)    return true;
//         if(nums[0] == 0)    return false;
//         int step = nums[0];
//         int maxReach = nums[0];
//         int i=1;
//         while(i<nums.length) {
//             if(i == nums.length-1)  return true;
//             step--;
//             maxReach = Math.max(maxReach, i + nums[i]);
//             if(step == 0){
//                 if(i >= maxReach)   return false;
//                 step = maxReach - i;
//             }
//             i++;
//         }
//         return false;
//     }
// }

//Beats 35%
class Solution {
        public boolean canJump(int[] nums) {
                if (nums.length <= 1)
                        return true;
                if (nums[0] == 0)
                        return false;

                int curEnd = 0;
                int curFarthest = 0;
                int i = 0;
                while (i < nums.length) {
                        if (i == nums.length - 1)
                                return true;
                        curFarthest = Math.max(curFarthest, i + nums[i]);
                        if (i == curEnd) {
                                curEnd = curFarthest;
                                if (i >= curFarthest)
                                        return false;
                        }
                        i++;
                }
                return false;
        }
}