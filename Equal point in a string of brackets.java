/*
Equal point in a string of brackets
Difficulty: EasyAccuracy: 40.8%Submissions: 20K+Points: 2
Given a string str of opening and closing brackets '(' and ')' only. The task is to find an equal point. An equal point is an index (0-based) such that the number of closing brackets on the right from that point must be equal to the number of opening brackets before that point.

Examples:

Input: str = "(())))("
Output: 4
Explanation: After index 4, string splits into (())) and )(. Number of opening brackets in the first part is equal to number of closing brackets in the second part.
Input : str = "))"
Output: 2
Explanation: As after 2nd position i.e. )) and "empty" string will be split into these two parts: So, in this number of opening brackets i.e. 0 in the first part is equal to number of closing brackets in the second part i.e. also 0.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ str.size() ≤ 106
str consists of only '(' and ')' brackets.
*/

class Solution {
    public long countSub(String str) {
        long c  =0;
        for(int i =0;i<str.length();i++){
            if(str.charAt(i)==')'){
                c++;
            }  
         }
         return c;
    }
} 

/*
This method counts the number of closing parentheses ')' in a given string and returns the count as a long integer. 😊
*/
