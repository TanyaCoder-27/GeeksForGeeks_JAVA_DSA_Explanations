## Second Largest
Difficulty: EasyAccuracy: 26.72%Submissions: 738K+Points: 2
## Given an array arr, return the second largest distinct element from an array. If the second largest element doesn't exist then return -1.

Examples:

Input: arr = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.
Input: arr = [10, 10]
Output: -1
Explanation: The largest element of the array is 10 and the second largest element does not exist..
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
2 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105

## JAVA Code:
```
import java.util.Arrays;

class Solution {
    public int getSecondLargest(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        
        // If there are less than 2 elements, return -1
        if (n < 2) return -1;
        
        // Start from the end to find the second largest unique element
        int largest = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < largest) {
                return arr[i];
            }
        }
        
        // If all elements are the same, return -1
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {3, 3, 2, 2, 1};
        int[] arr2 = {4, 4, 4, 4};
        int[] arr3 = {1, 2, 3, 4, 5};
        
        System.out.println(sol.getSecondLargest(arr1)); // Output: 2
        System.out.println(sol.getSecondLargest(arr2)); // Output: -1
        System.out.println(sol.getSecondLargest(arr3)); // Output: 4
    }
}

```

## Explanation:
Check Array Length: If the array has fewer than two elements, return -1.

Find Largest Element: Identify the largest element in the sorted array.

Find Second Largest Unique Element: Traverse backward to find the first unique element smaller than the largest. This ensures we correctly find the second largest even with duplicates.

Edge Case for Duplicates: If all elements are the same, return -1.
