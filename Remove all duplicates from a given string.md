# Remove all duplicates from a given string
Difficulty: EasyAccuracy: 58.68%Submissions: 99K+Points: 2
## Given a string str which may contain lowercase and uppercase characters. The task is to remove all duplicate characters from the string and find the resultant string. The order of remaining characters in the output should be same as in the original string.

## Example 1:

Input:
str = "geEksforGEeks"
Output: 
"geEksforG"
Explanation: 
After removing duplicate characters such as E, e, k, s, we have string as "geEksforG".
## Example 2:

Input:
str = "HaPpyNewYear"
Output: 
"HaPpyNewYr"
Explanation: 
After removing duplicate characters such as e, a, we have string as "HaPpyNewYr".
Your Task:
Complete the function removeDuplicates() which takes a string str, as input parameters and returns a string denoting the answer. You don't have to print answer or take inputs.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

## Constraints:
1 ≤ N ≤ 105
String contains uppercase and lowercase english letters.

## Java Code:
```
class Solution {
    String removeDuplicates(String str) {
        StringBuilder res = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (res.indexOf(String.valueOf(c)) == -1) {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = "programming";
        System.out.println(sol.removeDuplicates(str)); // Output: progamin
    }
}

```

## Explanation:
StringBuilder: Using StringBuilder instead of String to build the result makes it more efficient.

indexOf: The indexOf method of StringBuilder checks for the character's existence in the result string, returning -1 if not found.

toCharArray: Converts the string to a char array for easy iteration.
