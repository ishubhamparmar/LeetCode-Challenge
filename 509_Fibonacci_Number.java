/*
509. Fibonacci Number
Problem Link: https://leetcode.com/problems/fibonacci-number/
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 
Constraints:
0 <= n <= 30
 */

//Beats 47% | Using Recursion
// class Solution {
//     public int fib(int n) {
//         if(n<=1)
//             return n;
//         return fib(n-1)+fib(n-2);
//     }
// }

//Beats 25% | Using dynamic programming - Memoization | TC- O(N) | SC- O(N) for Recursion Stack + O(N) for array
// class Solution {
//     public int fib(int n) {
//         int [] dp = new int [n+1];
//         Arrays.fill(dp, -1);
//         if(n<=1)
//             return n;
//         if(dp[n]!=-1)   return dp[n];
//         return dp[n] = fib(n-1) + fib(n-2); 
//     }
// }

//Beats 100% | Using for loop | TC: O(N) | SC- O(N) + O(N) 
// class Solution {
//     public int fib(int n) {
//         int [] dp = new int [n+1];
//         Arrays.fill(dp, -1);
//         dp[0] = 0;
//         if(n>=1)
//             dp[1] = 1;
//         for(int i=2; i<=n; i++){
//             dp[i] = dp[i-1] + dp[i-2];
//         }
//         return dp[n];
//     }
// }

//Beats 100% | Using for loop | TC- O(N) | SC- O(N) Eliminating using array
class Solution {
        public int fib(int n) {
                int prev2 = 0;
                int prev = 1;
                if (n == 0)
                        return 0;
                if (n == 1)
                        return 1;
                for (int i = 2; i <= n; i++) {
                        int curi = prev2 + prev;
                        prev2 = prev;
                        prev = curi;
                }
                return prev;
        }
}