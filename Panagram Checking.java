/*
Panagram Checking
Difficulty: EasyAccuracy: 61.34%Submissions: 80K+Points: 2
Given a string s check if it is "Panagram" or not.

A "Panagram" is a sentence containing every letter in the English Alphabet.

Example 1:

Input:
s = "Bawds jog, flick quartz, vex nymph"
Output: 
1
Explanation: 
In the given input, there
are all the letters of the English
alphabet. Hence, the output is 1.
Example 2:

Input:
s = "sdfs"
Output: 
0
Explanation: 
In the given input, there
aren't all the letters present in the
English alphabet. Hence, the output
is 0.
Your Task:
You do not have to take any input or print anything. You need to complete the function checkPangram() that takes a string as a parameter and returns true if the string is a Panagram, or else it returns false.

Expected Time Complexity: O( |s| )
Expected Auxiliary Space: O(1)
|s| denotes the length of the input string.

Constraints:
1 ≤ |s| ≤ 104
Both Uppercase & Lowercase are considerable --write a java program on it
*/

import java.util.HashSet;

class Solution {
    public boolean checkPangram(String s) {
        HashSet<Character> set = new HashSet<>();
        
        // Convert the string to lowercase and iterate through each character
        for (char c : s.toLowerCase().toCharArray()) {
            // Check if character is alphabetic and add to set
            if (c >= 'a' && c <= 'z') {
                set.add(c);
            }
        }
        
        // Check if the set contains all 26 letters of the alphabet
        return set.size() == 26;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "Bawds jog, flick quartz, vex nymph";
        System.out.println(sol.checkPangram(s1)); // Expected Output: true

        String s2 = "sdfs";
        System.out.println(sol.checkPangram(s2)); // Expected Output: false
    }
}

/*
Explanation:
HashSet Initialization:

A HashSet<Character> is used to store unique alphabetic characters from the input string.

Iterate Through Characters:

Convert the string to lowercase to handle both uppercase and lowercase letters.

Iterate through each character and add it to the set if it is an alphabetic character ('a' to 'z').

Check Pangram:

If the set contains 26 unique alphabetic characters, return true, indicating that the string is a pangram.

Otherwise, return false
*/
