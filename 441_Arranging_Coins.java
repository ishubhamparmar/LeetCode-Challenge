/*
 * 441. Arranging Coins
 * Problem Link: https://leetcode.com/problems/arranging-coins/
 * You have n coins and you want to build a staircase with these coins. The
 * staircase consists of k rows where the ith row has exactly i coins. The last
 * row of the staircase may be incomplete.
 * Given the integer n, return the number of complete rows of the staircase you
 * will build.
 * Example 1:
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4th row is incomplete, we return 3.
 */

//Beats 41.83% | Brute Force
// class Solution {
//     public int arrangeCoins(int n) {
//         int k = 0;
//         int i = 1;
//         while(n>=0){
//             k++;
//             n = n - i;
//             i++;
//         }
//         return k-1;
//     }
// }

//Can be done using Binary Search.

// Using math | Beats 100% | n = [k(k+1)]/2 so finding the value of K using quadratic equation.
class Solution {
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }
}