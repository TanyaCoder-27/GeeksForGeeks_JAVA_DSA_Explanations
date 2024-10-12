# Remove duplicates from sorted Array
Difficulty: EasyAccuracy: 38.18%Submissions: 254K+Points: 2
Given a sorted array arr. Return the size of the modified array which contains only distinct elements.
Note:
1. Don't use set or HashMap to solve the problem.
2. You must return the modified array size only where distinct elements are present and modify the original array such that all the distinct elements come at the beginning of the original array.

Examples :

Input: arr = [2, 2, 2, 2, 2]
Output: [2]
Explanation: After removing all the duplicates only one instance of 2 will remain i.e. [2] so modified array will contains 2 at first position and you should return 1 after modifying the array, the driver code will print the modified array elements.
Input: arr = [1, 2, 4]
Output: [1, 2, 4]
Explation:  As the array does not contain any duplicates so you should return 3.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ ai ≤ 106

## JAVA CODE:
```
import java.util.*;

class Solution {    
    // Function to remove duplicates from the given ArrayList    
    public int remove_duplicate(ArrayList<Integer> list) {        
        if (list.isEmpty()) return 0;
        
        int uniqueIndex = 1;
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i).equals(list.get(i - 1))) {
                list.set(uniqueIndex, list.get(i));
                uniqueIndex++;
            }
        }

        // Truncate the list to contain only unique elements
        while (list.size() > uniqueIndex) {
            list.remove(list.size() - 1);
        }
        
        return uniqueIndex;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5));
        int newSize = sol.remove_duplicate(list);

        for (int i = 0; i < newSize; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}

```
## Explanation:

Check if the list is empty: If the list is empty, there's nothing to do, so we just return 0.

Initialize a unique index: This keeps track of the position where the next unique element will go. We start it at 1 because the first element is always unique.

Loop through the list: Starting from the second element (index 1), we compare each element with the previous one.

If an element is different from the previous one, it means it's unique, so we move it to the position indicated by the uniqueIndex and then increment the uniqueIndex.

Truncate the list: After the loop, we might have some leftover elements at the end of the list that are duplicates. We remove these by reducing the size of the list to uniqueIndex.

Return the size of the modified list: Finally, we return the value of uniqueIndex, which represents the number of unique elements in the list.
