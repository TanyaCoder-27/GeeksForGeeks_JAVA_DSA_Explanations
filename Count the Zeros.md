# Count the Zeros
Difficulty: EasyAccuracy: 68.08%Submissions: 112K+Points: 2
## Given an array arr of only 0's and 1's. The array is sorted in such a manner that all the 1's are placed first and then they are followed by all the 0's. Find the count of all the 0's.

## Examples:

Input: arr[] = [1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0]
Output: 3
Explanation: There are 3 0's in the given array.
Input: arr[] = [0, 0, 0, 0, 0]
Output: 5
Explanation: There are 5 0's in the array.
Expected Time Complexity: O(logn)
Expected Space Complexity: O(1)

## Constraints:
1 <= arr.size <= 105
0 <= arr[i] <= 1

## Java Code:

```
class Solution {
    int countZeroes(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Binary search for the first occurrence of 0
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == 0) {
                right = mid - 1; // Narrow down to the left side
            } else {
                left = mid + 1; // Narrow down to the right side
            }
        }

        // left now points to the first 0 or out of bounds
        return arr.length - left;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println("Count of zeros: " + sol.countZeroes(arr1)); // Output: 3

        int[] arr2 = {0, 0, 0, 0, 0};
        System.out.println("Count of zeros: " + sol.countZeroes(arr2)); // Output: 5

        int[] arr3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Count of zeros: " + sol.countZeroes(arr3)); // Output: 0
    }
}

```

## Explanation:
Binary Search: This is used to find the first occurrence of 0 in the sorted array.

Initialize left and right: Point to the start and end of the array.

Adjust left and right: Based on the value at mid:

If arr[mid] == 0, narrow the search to the left side (right = mid - 1).

If arr[mid] == 1, narrow the search to the right side (left = mid + 1).

Count Zeros: After the loop, left points to the first 0 (or out of bounds if there are no 0s). The count of 0s is the difference between the array length and left.

This approach ensures O(logn) time complexity and O(1) space complexity. 
