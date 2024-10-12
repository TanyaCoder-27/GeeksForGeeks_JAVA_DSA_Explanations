# Index of an Extra Element
Difficulty: EasyAccuracy: 41.77%Submissions: 152K+Points: 2
## You have given two sorted arrays arr1[] & arr2[] of distinct elements. The first array has one element extra added in between. Return the index of the extra element.

Note: 0-based indexing is followed.

## Examples

Input: n = 7, arr1[] = {2,4,6,8,9,10,12}, arr2[] = {2,4,6,8,10,12}
Output: 4
Explanation: In the first array, 9 is extra added and it's index is 4.
Input: n = 6, arr1[] = {3,5,7,8,11,13}, arr2[] = {3,5,7,11,13}
Output: 3
Explanation: In the first array, 8 is extra and it's index is 3.
Expected Time Complexity: O(log n).
Expected Auxiliary Space: O(1).

## Constraints:
1<=n<=105
1<=arr1[i],arr2[i]<=106

## JAVA Code:
```
class Solution {
    public int findExtra(int n, int arr1[], int arr2[]) {
        // Iterate through both arrays
        for (int i = 0; i < arr2.length; i++) {
            if (arr1[i] != arr2[i]) {
                return i;
            }
        }
        // If no discrepancy is found, the extra element is at the end of arr1
        return arr1.length - 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 5};
        int n = arr1.length;

        int index = sol.findExtra(n, arr1, arr2);
        System.out.println("Index of extra element: " + index); // Output: 3
    }
}

```
## Explanation:
Iterate through both arrays: Compare each element in arr1 and arr2. As soon as a discrepancy is found, return that index.

If no discrepancy is found: The extra element is at the end of arr1.

This approach ensures O(n) time complexity and correctly identifies the index of the extra element.
