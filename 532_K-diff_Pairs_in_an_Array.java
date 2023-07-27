/*
 * 532. K-diff Pairs in an Array - Medium
 * Problem Link:https://leetcode.com/problems/k-diff-pairs-in-an-array/
 * 
 * Given an array of integers nums and an integer k, return the number of unique
 * k-diff pairs in the array.
 * 
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are
 * true:
 * 
 * 0 <= i, j < nums.length
 * i != j
 * |nums[i] - nums[j]| == k
 * Notice that |val| denotes the absolute value of val.
 * 
 * Example 1:
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of
 * unique pairs.
 * 
 * Example 2:
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4)
 * and (4, 5).
 * 
 * Example 3:
 * Input: nums = [1,3,1,5,4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * 
 * Constraints:
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 */
//Beats 87.54% | Two pointers approach | O(NlogN)
// class Solution {
//     public int findPairs(int[] nums, int k) {
//         int ans = 0;
//         int i=0;
//         int j=1;
//         Arrays.sort(nums);
//         while(i<nums.length && j<nums.length){
//             if(i==j){
//                     j++;
//             }
//             else if(Math.abs(nums[j] - nums[i]) < k){
//                 j++;
//             }
//             else if(Math.abs(nums[j] - nums[i]) > k){
//                 i++;

//             }
//             else {
//                 ans++;
//                 i++;
//                 j++;
//                 while(j<nums.length && nums[j] == nums[j-1]){
//                     j++;
//                 }
//             }
//         }
//         return ans;
//     }
// }

//Using HashMap | O(N) | Beats 68%
class Solution {
        public int findPairs(int[] nums, int k) {
                int ans = 0;
                int i = 0;
                int j = 1;
                // Arrays.sort(nums);
                HashMap<Integer, Integer> hm = new HashMap<>();
                for (int c = 0; c < nums.length; c++) {
                        if (hm.containsKey(nums[c])) {
                                hm.put(nums[c], hm.get(nums[c]) + 1);
                        } else
                                hm.put(nums[c], 1);
                }
                for (Map.Entry<Integer, Integer> obj : hm.entrySet()) {
                        if ((k == 0 && (int) obj.getValue() > 1)
                                        || (k != 0 && hm.containsKey(k + (int) obj.getKey()))) {
                                ans++;
                        }
                }
                return ans;
        }
}