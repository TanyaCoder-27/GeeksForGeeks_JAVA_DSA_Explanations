/*
Binary String
Difficulty: BasicAccuracy: 53.99%Submissions: 79K+Points: 1Average Time: 20m
Given a binary string S. The task is to count the number of substrings that start and end with 1. For example, if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.

Example 1:

Input:
N = 4
S = 1111
Output: 6
Explanation: There are 6 substrings from
the given string. They are 11, 11, 11,
111, 111, 1111.
Example 2:

Input:
N = 5
S = 01101
Output: 3
Explanation: There 3 substrings from the
given string. They are 11, 101, 1101.
Your Task:
The task is to complete the function binarySubstring() which takes the length of binary string n and a binary string a as input parameter and counts the number of substrings starting and ending with 1 and returns the count.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ |S| ≤ 104

*/

class Solution {
    // Function to count the number of substrings that start and end with 1.
    public static int binarySubstring(int a, String str) {
        // Your code here
        int c=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '1'){
                c++;
            }
        }
        
        return ((c*(c-1))/2);
    }
}


