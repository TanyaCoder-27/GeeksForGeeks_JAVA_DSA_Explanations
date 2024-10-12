## First Repeating Element
Difficulty: EasyAccuracy: 32.57%Submissions: 263K+Points: 2
Given an array arr[], find the first repeating element. The element should occur more than once and the index of its first occurrence should be the smallest.

Note:- The position you return should be according to 1-based indexing. 

Examples:

Input: arr[] = [1, 5, 3, 4, 3, 5, 6]
Output: 2
Explanation: 5 appears twice and its first appearance is at index 2 which is less than 3 whose first the occurring index is 3.
Input: arr[] = [1, 2, 3, 4]
Output: -1
Explanation: All elements appear only once so answer is -1.
Expected Time Complexity: O(n)
Expected Auxilliary Space: O(n)

Constraints:
1 <= arr.size <= 106
0 <= arr[i]<= 106

## JAVA CODE:
```
import java.util.*;

class Solution {    
    // Function to return the position of the first repeating element.    
    public static int firstRepeated(int[] arr) {        
        LinkedHashMap<Integer, Integer> freq = new LinkedHashMap<>();
        
        for (int i : arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        for (int j : freq.keySet()) {
            if (freq.get(j) > 1) {
                return getIndex(arr, j) + 1;
            }
        }

        return -1; // Return -1 if no repeating element is found
    }
    
    // Helper function to get the index of an element
    private static int getIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1; // Return -1 if element is not found, though this won't happen in this context
    }
}

```
