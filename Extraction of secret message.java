/*
Extraction of secret message
Difficulty: BasicAccuracy: 45.0%Submissions: 4K+Points: 1
You are given an encoded string S of length N. The encoded string is mixed with some number of substring "LIE" and some secret message. You have to extract secret message from it by removing all the "LIE" substrings.
For example - "I AM COOL" is given as "LIEILIEAMLIELIECOOL".

Example 1:

Input: S = "LIEILIEAMLIELIECOOL"
Output: "I AM COOL"
Example 2:

Input: S = "LIELIEALIEBCLIE"
Output: "A BC"
Your Task:  
You don't need to read input or print anything. Your task is to complete the function ExtractMessage() which accepts a string as input parameter and returns a string containing secret message.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 106
String contains only Upper Case Letters.

*/

class Solution 
{ 
    String ExtractMessage(String S) 
    { 
        S = S.replace("LIE", " ").trim();
        
        StringBuilder sb = new StringBuilder();
        
        int flag = 0;
        for(int i=0; i<S.length(); i++){
            char ch = S.charAt(i);
            
            if(ch != ' '){
                sb.append(ch);
                flag = 1;
            }
            else{
                if(flag == 1){
                    sb.append(ch);
                    flag = 0;
                }
            }
        }
        
        return sb.toString();
    }
} 

/*
The goal of the ExtractMessage method is to take a string S, remove certain parts of it, and condense any spaces, effectively extracting a meaningful message.

Code Breakdown
Replace "LIE" with Spaces and Trim:

S = S.replace("LIE", " ").trim();
This line replaces all occurrences of the substring "LIE" with a single space " ".

The trim() method removes any leading and trailing spaces from the string.

Initialize StringBuilder:

StringBuilder sb = new StringBuilder();
A StringBuilder object sb is initialized to build the resulting message efficiently.

Flag Initialization:

java
Copy
int flag = 0;
The flag variable is used to manage spaces between words. It ensures that only one space is added between words.

Iterate Through the String:

for (int i = 0; i < S.length(); i++) {
    char ch = S.charAt(i);
    if (ch != ' ') {
        sb.append(ch);
        flag = 1;
    } else {
        if (flag == 1) {
            sb.append(ch);
            flag = 0;
        }
    }
}
This loop iterates through each character of the string S.

If the character ch is not a space:

Append ch to the StringBuilder.

Set flag to 1, indicating that the last character added was not a space.

If the character ch is a space:

Check if flag is 1 (meaning the last character added was not a space).

If true, append the space to the StringBuilder and set flag to 0. This ensures only a single space is added between words.

-----Return the Resulting String:

return sb.toString();
Convert the StringBuilder to a string and return it as the final extracted message.

Example Walkthrough
Let's consider an example input to see how this works:

Input: "HELLOLIEMYLIEFRIENDLIE"

Step 1: Replace "LIE" with a space.

Result: "HELLO MY FRIEND "

Step 2: Trim the string.

Result: "HELLO MY FRIEND"

Step 3: Iterate through the string and build the message:

Add 'H', 'E', 'L', 'L', 'O' to sb.

Encounter a space, set flag to 0.

Add 'M', 'Y' to sb, encounter another space, set flag to 0.

Add 'F', 'R', 'I', 'E', 'N', 'D' to sb.

Output: "HELLO MY FRIEND"

This code ensures that the message is cleaned up by removing specific substrings and managing spaces efficiently.
*/
