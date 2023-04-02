/*
 * 976. Largest Perimeter Triangle
 * Problem Link: https://leetcode.com/problems/largest-perimeter-triangle/
 * Given an integer array nums, return the largest perimeter of a triangle with
 * a non-zero area, formed from three of these lengths. If it is impossible to
 * form any triangle of a non-zero area, return 0.
 * Example 1:
 * Input: nums = [2,1,2]
 * Output: 5
 * Explanation: You can form a triangle with three side lengths: 1, 2, and 2.
 * Example 2:
 * Input: nums = [1,2,1,10]
 * Output: 0
 * Explanation:
 * You cannot use the side lengths 1, 1, and 2 to form a triangle.
 * You cannot use the side lengths 1, 1, and 10 to form a triangle.
 * You cannot use the side lengths 1, 2, and 10 to form a triangle.
 * As we cannot use any three side lengths to form a triangle of non-zero area,
 * we return 0.
 * Constraints:
 * 3 <= nums.length <= 104
 * 1 <= nums[i] <= 106
 */
//Beats 7% | O(NlogN)
// class Solution {
//     public int largestPerimeter(int[] nums) {
//         int maxPerimeter = 0;
//         Arrays.sort(nums);
//         for(int i=nums.length-1; i>=2; i--){
//             if(checkTriangle(nums[i], nums[i-1], nums[i-2])){
//                 maxPerimeter = Math.max(maxPerimeter, nums[i] + nums[i-1] + nums[i-2]);
//             }
//         }
//         return maxPerimeter;

//     }
//     boolean checkTriangle(int x, int y, int z){
//         if( (x+y)>z && (z+y)>x && (x+z)>y ) return true;
//         return false;
//     }
// }

//Beats 99.58% | Almost same approach
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }

        }

        return 0;
    }
}