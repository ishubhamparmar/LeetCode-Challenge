/*
 * 45. Jump Game II - Medium
 * Problem Link: https://leetcode.com/problems/jump-game-ii/
 * 
 * You are given a 0-indexed array of integers nums of length n. You are
 * initially positioned at nums[0].
 * 
 * Each element nums[i] represents the maximum length of a forward jump from
 * index i. In other words, if you are at nums[i], you can jump to any nums[i +
 * j] where:
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are
 * generated such that you can reach nums[n - 1].
 * 
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
 * step from index 0 to 1, then 3 steps to the last index.
 * 
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * 
 * Constraints:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 */

//Beats 41%
// class Solution {
//     public int jump(int[] nums) {
//         if(nums.length<=1)  return 0;
//         int step = nums[0];
//         int maxReach = nums[0];
//         int jump = 1;
//         int i = 1;
//         while(i < nums.length){
//             if(i==nums.length-1)    return jump;
//             maxReach = Math.max(maxReach, i+nums[i]);
//             step--;
//             if(step == 0){
//                 jump++;
//                 step = maxReach - i;
//             }
//             i++;
//         }
//         return jump;
//     }
// }

//Beats 99% | Greedy
class Solution {
        public int jump(int[] nums) {
                int jumps = 0, endCur = 0, maxCur = 0;
                for (int i = 0; i < nums.length - 1; i++) {
                        maxCur = Math.max(maxCur, i + nums[i]);
                        if (i == endCur) {
                                jumps++;
                                endCur = maxCur;
                        }
                }
                return jumps;
        }
}