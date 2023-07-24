/*
 * 238. Product of Array Except Self | Medium
 * Problem Link: https://leetcode.com/problems/product-of-array-except-self/
 * 
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The
 * output array does not count as extra space for space complexity analysis.)
 */
//Beats 100% | O(N)
//Getting left multiplication, right multiplication and multiplying this both to get the result.
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int ans[] = new int[nums.length];
//         int flag = 1;
//         for (int i = 0; i < nums.length; i++) {
//             ans[i] = flag;
//             flag = flag * nums[i];
//         }
//         flag = 1;
//         for (int i = nums.length - 1; i >= 0; i--) {
//             ans[i] = ans[i] * flag;
//             flag *= nums[i];
//         }
//         return ans;
//     }
// }

//Alternate Method | O(N) | Beats 100%
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] preProduct = new int[nums.length];
        int[] sufProduct = new int[nums.length];
        int pro = 1;
        for (int i = 0; i < nums.length; i++) {
            preProduct[i] = pro;
            pro = pro * nums[i];
        }
        pro = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            sufProduct[i] = pro;
            pro = pro * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = preProduct[i] * sufProduct[i];
        }
        return res;
    }
}
