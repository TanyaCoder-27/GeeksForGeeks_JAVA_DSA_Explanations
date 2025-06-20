/*
Search a Character in a String
Difficulty: EasyAccuracy: 75.52%Submissions: 622+Points: 2Average Time: 5m
Write a program to search for a given character in a string. If the character is found, print the index/position where it first appears in the string. If the character is not found, print -1.

Examples:

Input: s = "geeksforgeeks" , ch = 'k'
Output: 3
Explanation: The character 'k' is present at index 3 and 11 in "geeksforgeeks" , so the first index is 3.
Input: s = "geeksforgeeks" , ch = 'z'
Output: -1
Explanation: The character 'z' is not present in "geeksforgeeks".
Constraints:
1 ≤ |s| ≤ 105
*/

// User function Template for Java
class Solution {
    // Function to search for a character in the string
    public int searchCharacter(String s, char ch) {
        // code here
        if(s.length() == 0) return -1;
        //str.indexOf(ch)  --> you will directly get the answer!
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ch){
                return i;
            }
        }
        
        return -1;
        
    }
}
