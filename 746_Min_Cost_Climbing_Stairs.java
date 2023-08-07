/*
 * 746. Min Cost Climbing Stairs - Easy
 * You are given an integer array cost where cost[i] is the cost of ith step on
 * a staircase. Once you pay the cost, you can either climb one or two steps.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * 
 * Return the minimum cost to reach the top of the floor.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 * 
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 * 
 * 
 * Constraints:
 * 
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
//Recursion - TLE
// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n =  cost.length;
//         int ans = Math.min(solve(cost, n-1), solve(cost, n-2));
//         return ans;
//     }

//     public int solve(int cost[], int n) {
//         if(n == 0) {
//             return cost[0];
//         }
//         if(n==1) {
//             return cost[1];
//         }
//         int ans = cost[n] + Math.min(solve(cost, n-1), solve(cost, n-2));
//         return ans;
//     }
// }

//DP | Beats 56%
class Solution {
        public int minCostClimbingStairs(int[] cost) {
                int n = cost.length;
                int[] dp = new int[n + 1];
                Arrays.fill(dp, -1);
                dp[n] = Math.min(solve(cost, n - 1, dp), solve(cost, n - 2, dp));
                return dp[n];
        }

        public int solve(int cost[], int n, int[] dp) {
                if (n == 0) {
                        return cost[0];
                }
                if (n == 1) {
                        return cost[1];
                }

                if (dp[n] != -1)
                        return dp[n];
                dp[n] = cost[n] + Math.min(solve(cost, n - 1, dp), solve(cost, n - 2, dp));
                return dp[n];
        }
}