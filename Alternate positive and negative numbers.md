## Alternate positive and negative numbers
Difficulty: EasyAccuracy: 33.86%Submissions: 207K+Points: 2
Given an unsorted array arr containing both positive and negative numbers. Your task is to rearrange the array and convert it into an array of alternate positive and negative numbers without changing the relative order.

Note:
- Resulting array should start with a positive integer (0 will also be considered as a positive integer).
- If any of the positive or negative integers are exhausted, then add the remaining integers in the answer as it is by maintaining the relative order.
- The array may or may not have equal number of positive and negative integers.

Examples:

Input: arr[] = [9, 4, -2, -1, 5, 0, -5, -3, 2]
Output: 9 -2 4 -1 5 -5 0 -3 2
Explanation: The positive numbers are [9, 4, 5, 0, 2] and the negative integers are [-2, -1, -5, -3]. Since, we need to start with the positive integer first
and then negative integer and so on (by maintaining the relative order as well), hence we will take 9 from the positive set of elements and then
-2 after that 4 and then -1 and so on.
Hence, the output is 9, -2, 4, -1, 5, -5, 0, -3, 2.
Input: arr[] = [-5, -2, 5, 2, 4, 7, 1, 8, 0, -8]
Output: 5 -5 2 -2 4 -8 7 1 8 0
Explanation : The positive numbers are [5, 2, 4, 7, 1, 8, 0] and the negative integers are [-5,-2,-8]. According to the given conditions we will start
from the positive integer 5 and then -5 and so on. After reaching -8 there are no negative elements left, so according to the given rule, we will
add the remaining elements (in this case positive elements are remaining) as it in by maintaining the relative order.
Hence, the output is 5, -5, 2, -2, 4, -8, 7, 1, 8, 0.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ arr.size() ≤ 107
-106 ≤ arr[i] ≤ 107

## JAVA CODE:
```
import java.util.*;

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        
        // Separate the array into positive and negative lists
        for (int i : arr) {
            if (i >= 0) {
                pos.add(i);
            } else {
                neg.add(i);
            }
        }
        
        int index = 0;
        int posIndex = 0, negIndex = 0;
        
        // Rearrange the array by alternating between positive and negative
        while (posIndex < pos.size() && negIndex < neg.size()) {
            arr.set(index++, pos.get(posIndex++));
            arr.set(index++, neg.get(negIndex++));
        }
        
        // If any positive elements are left
        while (posIndex < pos.size()) {
            arr.set(index++, pos.get(posIndex++));
        }
        
        // If any negative elements are left
        while (negIndex < neg.size()) {
            arr.set(index++, neg.get(negIndex++));
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(9, 4, -2, -1, 5, 0, -5, -3, 2));
        sol.rearrange(list);
        
        System.out.println(list);
    }
}

```

## Explanation:
Initialize Lists:

Create two ArrayLists, pos for positive elements (including zero) and neg for negative elements.

Separate Elements:

Traverse the original list arr. For each element:

If the element is greater than or equal to zero, add it to the pos list.

If the element is less than zero, add it to the neg list.

Rearrange Elements:

Initialize index to 0 to keep track of the position in the original list arr.

Use two pointers, posIndex and negIndex, to keep track of positions in the pos and neg lists respectively.

Alternate between the positive and negative lists, setting elements in the original list arr.

While both lists have elements, take one element from pos followed by one from neg, and place them in arr.

Add Remaining Elements:

After exhausting one of the lists, append the remaining elements from the other list to arr.

Main Method:

Create an instance of Solution and initialize an ArrayList with the example data.

Call rearrange(list) to rearrange the list in place.

Print the rearranged list.

Here's how it looks visually:

Given input: 9, 4, -2, -1, 5, 0, -5, -3, 2

Step 1: pos = [9, 4, 5, 0, 2], neg = [-2, -1, -5, -3]

Step 2: Alternating between pos and neg: [9, -2, 4, -1, 5, -5, 0, -3, 2]

Step 3: Final output: [9, -2, 4, -1, 5, -5, 0, -3, 2]
