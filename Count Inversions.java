/*
Count Inversions
Difficulty: MediumAccuracy: 16.93%Submissions: 566K+Points: 4
Given an array of integers. Find the Inversion Count in the array.  Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 104

*/

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSortAndCount(arr, temp, 0, n - 1);
    }

    // Helper function to use merge sort and count inversions
    static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int mid, invCount = 0;
        if (left < right) {
            mid = (left + right) / 2;
            
            invCount += mergeSortAndCount(arr, temp, left, mid);
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);
            
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return invCount;
    }

    // Merge two subarrays and count inversions
    static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;    // Starting index for left subarray
        int j = mid + 1; // Starting index for right subarray
        int k = left;    // Starting index to be sorted
        int invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid + 1) - i; // Count inversions
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] arr1 = {2, 4, 1, 3, 5};
        System.out.println(solution.inversionCount(arr1));  // Output: 3

        // Example 2
        int[] arr2 = {3, 1, 2};
        System.out.println(solution.inversionCount(arr2));  // Output: 2

        // Example 3
        int[] arr3 = {1, 20, 6, 4, 5};
        System.out.println(solution.inversionCount(arr3));  // Output: 5
    }
}

/*
Explanation:
---Merge Sort:

We use a modified version of the merge sort algorithm to sort the array while counting inversions whereas if we use nested loop it takes O(n^2), which is inefficient

mergeSortAndCount recursively splits the array and counts inversions in each half.

mergeAndCount merges the sorted halves and counts the cross-inversions.

---Count Inversions:

During the merge process, when an element from the right subarray is placed before an element from the left subarray, it indicates an inversion.

The number of such inversions is added to the inversion count.

---Time Complexity:

The time complexity is O(n log n), making it efficient for large input sizes.

This optimized solution should help you pass all the test cases within the expected time limits.


*/
