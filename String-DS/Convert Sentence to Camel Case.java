/*
Convert Sentence to Camel Case
Difficulty: MediumAccuracy: 37.33%Submissions: 2K+Points: 4
Given a sentence s, your task is to remove all spaces and convert it to Camel Case. In Camel Case, words are joined without spaces, the first word keeps its original case, and each subsequent word starts with an uppercase letter.

Note: It is guaranteed that the sample test cases don't contain leading spaces.

Examples:

Input: s = "i got intern at geeksforgeeks"
Output: "iGotInternAtGeeksforgeeks"
Explanation: All spaces are removed and each word starts with a capital letter, except the first word which retains its original capitalization.
Input: s = "here comes the garden"
Output: "hereComesTheGarden"
Explanation: Spaces are removed and each word after the first is capitalized.
Input: s = "coding is fun"
Output: "codingIsFun"
Explanation: Spaces are removed, the first word retains its original case, and each subsequent word starts with a capital letter.
Constraints:
1 <= s.size() <= 106

The string s contains only lowercase english alphabets and spaces.

*/

// User function Template for Java

class Solution {
    // Function to convert the given string to Camel Case
    public String convertToCamelCase(String s) {
        // code here
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = false;
        for(int i=0;i<s.length();i++){
            
            
            if(s.charAt(i) == ' '){
                capitalizeNext = true;
            }
            
            else if(capitalizeNext == true){
                sb.append(Character.toUpperCase(s.charAt(i)));
                
                capitalizeNext = false;
            }
            
            else{
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}
