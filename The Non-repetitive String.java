/*
The Non-repetitive String
Difficulty: EasyAccuracy: 39.26%Submissions: 4K+Points: 2
Given a string S, the task is to check if a string is a non-repetitive or not.  A non-repetitive string is defined as a string that does not contain any different character between two same characters

Example 1:

Input: S = "AABBCCCCC"
Output: 1
Explanation: No different character is 
placed between the two same characters.
Example 2:

Input: S = "ABA"
Output: 0
Explanation: B is in between two A's
Your Task:
You don't need to read input or print anything. Your task is to complete the function nonRepetitive() which takes a string S as input and returns the boolean value.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(constant).


Constraints:
1 <= |S| <= 105
S contains upper case English alphabets
*/

class Solution
{
    public boolean nonRepetitive(String S)
    {
        // Your code goes here
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i <= S.length() - 1; i++){
            set.add(S.charAt(i));
        }
        ArrayList<Character> l = new ArrayList<>();
        for(int i = 0; i <= S.length() - 2; i++){
            if(S.charAt(i) != S.charAt(i+1)){
                 l.add(S.charAt(i));
            }
        }
        l.add(S.charAt(S.length() - 1));
        if(l.size() == set.size()){
            return true;
        }
        return false;

    }
}

/*

---HashSet to Store Unique Characters:

HashSet<Character> set = new HashSet<>();
for (int i = 0; i <= S.length() - 1; i++) {
    set.add(S.charAt(i));
}
A HashSet named set is created to store unique characters.

The loop iterates over each character in the string S, adding each character to the set.

Since HashSet only stores unique elements, duplicate characters are automatically discarded.

---ArrayList to Store Non-Adjacent Characters:

ArrayList<Character> l = new ArrayList<>();
for (int i = 0; i <= S.length() - 2; i++) {
    if (S.charAt(i) != S.charAt(i + 1)) {
        l.add(S.charAt(i));
    }
}
l.add(S.charAt(S.length() - 1));
An ArrayList named l is created to store non-adjacent characters.

The loop iterates over each character in the string S up to the second last character.

If the current character S.charAt(i) is not equal to the next character S.charAt(i + 1), it is added to the ArrayList l.

After the loop, the last character of the string S is added to l.

---Compare Sizes:

if (l.size() == set.size()) {
    return true;
}
return false;
If the size of the ArrayList l is equal to the size of the HashSet set, the function returns true.

Otherwise, it returns false.

Example:
Consider the input string S = "aabbcc":

Step 1: Storing unique characters in set.

set = {'a', 'b', 'c'}

Step 2: Storing non-adjacent characters in l.

Loop iterates through S, comparing adjacent characters:

S.charAt(0) != S.charAt(1) (false, both are 'a')

S.charAt(1) != S.charAt(2) (true, 'a' != 'b') → add 'a' to l

S.charAt(2) != S.charAt(3) (false, both are 'b')

S.charAt(3) != S.charAt(4) (true, 'b' != 'c') → add 'b' to l

S.charAt(4) != S.charAt(5) (false, both are 'c')

Add last character 'c' to l

l = ['a', 'b', 'c']

Step 3: Compare sizes:

l.size() = 3

set.size() = 3

Since sizes are equal, the function returns true.
*/
