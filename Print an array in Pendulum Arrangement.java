/*
Print an array in Pendulum Arrangement
Difficulty: EasyAccuracy: 41.39%Submissions: 27K+Points: 2
Given an array arr[]. Arrange the elements of the array in a way similar to the to-and-fro movement of a Pendulum.

The minimum element out of the list of integers must come in the center position of the array. If there are even elements, then the minimum element should be moved to (n-1)/2 index (considering that indexes start from 0)
The next number (next to a minimum) in ascending order, goes to the right, and the next to the next number goes to the left of the minimum number and continues like a Pendulum.
As higher numbers are reached, one goes to one side in a to-and-fro manner similar to that of a Pendulum.
Examples:

Input: arr[] = [1, 3, 2, 5, 4]
Output: [5, 3, 1, 2, 4]
Explanation:  The minimum element is 1, so it is moved to the middle. The next higher element 2 is moved to the right of the middle element while the next higher element 3 is moved to the left of the middle element and this process is continued.
Input: arr[] = [11, 12, 31, 14, 5]
Output: [31, 12, 5, 11, 14]
Explanation:  The minimum element is 5, so it is moved to the middle. The next higher element 11 is moved to the right of the middle element while the next higher element 12 is moved to the left of the middle element and this process is continued.
Expected Time Complexity: O(nlog(n))
Expected Auxiliary Space: O(n)

Constraints:
1 <= arr.size() <= 105
0 <= arr[i] <= 105

*/

import java.util.Arrays;

class Solution {
    public int[] pendulumArrangement(int arr[]) {
        Arrays.sort(arr); // Sort the array in ascending order
        
        int n = arr.length;
        int[] result = new int[n];
        
        int mid = (n - 1) / 2; // Middle index
        int left = mid; // Start filling from the middle
        int right = mid + 1; // Next index to the right of middle
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result[left--] = arr[i]; // Fill left side
            } else {
                result[right++] = arr[i]; // Fill right side
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {1, 3, 2, 5, 4};
        System.out.println(Arrays.toString(sol.pendulumArrangement(arr1))); // Expected output: [5, 3, 1, 2, 4]

        int[] arr2 = {11, 12, 31, 14, 5};
        System.out.println(Arrays.toString(sol.pendulumArrangement(arr2))); // Expected output: [31, 12, 5, 11, 14]
    }
}

/*
Explanation:
Sort the Array:

We first sort the array in ascending order using Arrays.sort(arr). This ensures that we can easily pick the minimum and the next higher elements.

Initialize Result Array:

We create an array result of the same length as the input array to store the final pendulum arrangement.

Find Middle Index:

The middle index is calculated as (n - 1) / 2. This is where the minimum element will be placed. For an even number of elements, this index ensures the minimum element is placed at (n - 1) / 2.

Initialize Indices:

We initialize left to start at the middle index and right to be the next index to the right of the middle.
Fill the Result Array:

We iterate through the sorted array. For even indices (0, 2, 4,...), we fill elements to the left side of the middle. For odd indices (1, 3, 5,...), we fill elements to the right side of the middle.

This ensures a to-and-fro movement similar to a pendulum, with the smaller elements closer to the middle and larger elements farther out.

This approach ensures that we have the correct pendulum arrangement in O(nlog(n)) time due to sorting and O(n) auxiliary space for the result array. Give it a try and see the magic happen! 😊🚀

*/
