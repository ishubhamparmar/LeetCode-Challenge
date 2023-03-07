/*
9. Palindrome Number
Problem Link: https://leetcode.com/problems/palindrome-number/


Given an integer x, return true if x is a 
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

*/

class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int rev = 0;
        while(temp!=0 && temp>0){
            rev = rev*10 + temp%10;
            temp/=10;

        }
        if(rev == x)
            return true;
        return false;
    }
}