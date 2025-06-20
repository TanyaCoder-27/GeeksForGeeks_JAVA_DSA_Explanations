/*

Given two strings, determine if they are exactly the same, considering case sensitivity.

Examples:

Input: s1 = "abc" , s1 = "abc" 
Output: YES
Input: s1 = " " , s2 = " "
Output: YES
Input: s1 = "geeks", s2 = "Geeks"
Output: NO
Constraints:
1 ≤ |s1|, |s2| ≤ 105

*/// User function Template for Java
class StringUtils {
    // Function to check if two strings are the same
    public static boolean areStringsSame(String s1, String s2) {
        // code here
        
        /*Because trying to do things like s1.length() or s1.equals(s2)
        when s1 is null would throw a NullPointerException 
        and crash your program.
        */
        if(s1 == null || s2 == null){
            return false;
        }
        
        if(s1.length() != s2.length()){
            return false;
        }
        
        
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
}

