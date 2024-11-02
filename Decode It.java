/*
Decode It
Difficulty: EasyAccuracy: 33.54%Submissions: 4K+Points: 2
An encoded string S consisting of alphabets(lowercase) and integers(1<=num<=9) is given, the task is to decode it and print the character at the 'K'th position in the string. The pattern in which the strings were encoded were as follows :
original string: jonjonsnowjonjonsnowjonjonsnow
encoded string: jon2snow3

Note: encoded string will always start with an alphabet and end with a number.

Example 1:

Input:
str = "jon2snow3"
k = 8

Output:
n

Explanation:
The given string after decoding it will be 
as such: jonjonsnowjonjonsnowjonjonsnow. 
8th character in the string after decoding is:'n'.
Example 2:

Input:
str = "q3"
k = 3

Output:
q

Explanation:
The given string after decoding it will be
as such: qqq. 3rd character in the string 
after decoding is:'q'.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function decodeIt() which takes the string str and an integer k as input parameters and returns the kth character of the mentioned string.

Expected Time Complexity: O(N), Where N is the size of the original string.
Expected Auxiliary Space: O(N)

Constraints:
2 <= |str| <= 35
1 <= k <= N
*/

class Solution{
    static char decodeIt(String str,int k){
        // Write your code here
        StringBuilder s = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(Character.isLetter(c)){
                s.append(c);
            }else{
                int n  = c - '0';
                String t = s.toString();
                while(n>1){
                    s.append(t);
                    n--;
                    
                }
                
            }
        }
        
        return s.toString().charAt(k-1);
    }
        
}

/*
Overview
This function decodes an encoded string and returns the character at the 'k'th position. The encoded string contains letters and digits, where digits represent the number of times the preceding letters are repeated.

Detailed Explanation
Function Definition:

java
static char decodeIt(String str, int k) {
StringBuilder Initialization:

java
StringBuilder s = new StringBuilder();
StringBuilder is used to efficiently build the decoded string.

Iterate Through the Encoded String:

java
for (int i = 0; i < str.length(); i++) {
    char c = str.charAt(i);
    if (Character.isLetter(c)) {
        s.append(c);
    } else {
        int n = c - '0';
        String t = s.toString();
        while (n > 1) {
            s.append(t);
            n--;
        }
    }
}
The loop iterates through each character of the encoded string str.

Character Check:

If the character is a letter:

java
if (Character.isLetter(c)) {
    s.append(c);
}
If c is a letter, it is directly appended to the StringBuilder.

If the character is a digit:

java
else {
    int n = c - '0';
    String t = s.toString();
    while (n > 1) {
        s.append(t);
        n--;
    }
}
If c is a digit, it represents the number of times the preceding substring should be repeated.

Convert the digit character c to an integer n.

Store the current content of the StringBuilder in a temporary string t.

Append t to the StringBuilder n-1 times (because t is already in the StringBuilder once).

Return the K-th Character:

java
return s.toString().charAt(k - 1);
Convert the StringBuilder to a string.

Return the character at the k-1 position (since k is 1-indexed).

Example
Let's walk through an example with the input str = "jon2snow3" and k = 8:

Initial: s = ""

Iteration:

i = 0, c = 'j': s = "j"

i = 1, c = 'o': s = "jo"

i = 2, c = 'n': s = "jon"

i = 3, c = '2': t = "jon", repeat t once more: s = "jonjon"

i = 4, c = 's': s = "jonjons"

i = 5, c = 'n': s = "jonjonsn"

i = 6, c = 'o': s = "jonjonsno"

i = 7, c = 'w': s = "jonjonsnow"

i = 8, c = '3': t = "jonjonsnow", repeat t twice more: s = "jonjonsnowjonjonsnowjonjonsnow"

The 8th character in "jonjonsnowjonjonsnowjonjonsnow" is 'n'.

This code efficiently decodes the encoded string and retrieves the K-th character. 
*/
