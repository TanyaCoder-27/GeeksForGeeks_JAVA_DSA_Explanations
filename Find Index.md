# Find Index
Difficulty: EasyAccuracy: 34.99%Submissions: 89K+Points: 2
## Given an unsorted array arr[] of integers and a key which is present in this array. You need to write a program to find the start index( index where the element is first found from left in the array ) and end index( index where the element is first found from right in the array ) return an array of length 2 with elements start index and end index.(0 based indexing is used)

## If the key does not exist in the array then return -1 for both start and end index in this case.

## Examples:

Input: arr[] = [1, 2, 3, 4, 5, 5] , key = 5
Output:  [4, 5]
Explanation: 5 appears first time at index 4 and appears last time at index 5(0 based indexing)
Input: arr = [6, 5, 4, 3, 1, 2] , key = 4
Output: [2, 2]
Explanation: 4 appears first time and last time at index 2.
Input: arr = [7, 8, 6] , key = 2
Output: [-1, -1]
Explanation: Since 2 does not appear in the array, we will return -1 for both the start and end indices..
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1).

## Constraints:
1 ≤ arr.size ≤ 106
1 <= arr[i] , key <= 109

## Java Code:

```
class Solution {
    // Function to find starting and end index
    static int[] findIndex(int arr[], int key) {
        int firstIndex = findFirstIndex(arr, key);
        int lastIndex = findLastIndex(arr, key);
        
        System.out.println("First Index: " + firstIndex); 
        System.out.println("Last Index: " + lastIndex); 

        return new int[]{firstIndex, lastIndex};
    }

    public static int findFirstIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Return -1 if not found
    }

    public static int findLastIndex(int[] arr, int target) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Return -1 if not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4};
        int key = 2;

        int[] indices = findIndex(arr, key);
        System.out.println("Start Index: " + indices[0]);
        System.out.println("End Index: " + indices[1]);
    }
}

```



## What if we have to deal with ArrayList instead of Array?? It's SUPER EASY then 😁

```
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);

        int target = 2;

        int firstIndex = list.indexOf(target); //direct method for finding first index
        int lastIndex = list.lastIndexOf(target); // direct method for finding last index

        System.out.println("First Index: " + firstIndex); // Output: 1
        System.out.println("Last Index: " + lastIndex);   // Output: 3
    }
}


```
## Explanation
indexOf: Returns the index of the first occurrence of the specified element in the list.

lastIndexOf: Returns the index of the last occurrence of the specified element in the list.

These built-in methods are pretty efficient for most uses.
