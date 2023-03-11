/*
 * 392. Is Subsequence
 * Problem Link: https://leetcode.com/problems/is-subsequence/
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


// Beats 34%
class Solution {
    public boolean isSubsequence(String s, String t) {

    if(s=="")
        return true;
    if(s.length()>t.length())
        return false;
        
        int i=0;
        int j=0;
        while(i<s.length()&&j<t.length())
        {
            if(s.charAt(i)==t.charAt(j))
            {
                i++;
                j++;
            }
            else
                j++;
        }
        if(i==s.length())
            return true;
        
        return false;
 
    }
}
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        if (s.equals(""))
            return true;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(j) == t.charAt(i))
                j++;
            if (j == s.length())
                return true;
        }
        return false;
    }
}