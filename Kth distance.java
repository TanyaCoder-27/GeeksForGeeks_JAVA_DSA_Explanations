/*
Kth distance
Difficulty: EasyAccuracy: 48.69%Submissions: 30K+Points: 2
Given an unsorted array arr and a number k which is smaller than the size of the array. Return true if the array contains any duplicate within k distance throughout the array else false.

Examples:

Input: arr[] = [1, 2, 3, 4, 1, 2, 3, 4] and k = 3
Output: false
Explanation: All duplicates are more than k distance away.
Input: arr[] = [1, 2, 3, 1, 4, 5] and k = 3
Output: true
Explanation: 1 is repeated at distance 3.
Input: arr[] = [6, 8, 4, 1, 8, 5, 7] and k = 3
Output: true
Explanation: 8 is repeated at distance 3.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ k < arr.size()
1 ≤ arr[i] ≤ 105
*/

import java.util.HashSet;

class Solution {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            }
            
            set.add(arr[i]);
            
            // Maintain the sliding window of size k
            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {1, 2, 3, 1, 4, 5};
        int k1 = 3;
        System.out.println(sol.checkDuplicatesWithinK(arr1, k1)); // Output: true

        int[] arr2 = {1, 2, 3, 4, 5};
        int k2 = 3;
        System.out.println(sol.checkDuplicatesWithinK(arr2, k2)); // Output: false
    }
}

/*

Explanation:
HashSet Initialization: Use a HashSet to keep track of elements within the current window of size k.

Loop Through the Array: Iterate through each element in the array.

Check for Duplicates: If the current element is already in the HashSet, return true.

Add Element to Set: Add the current element to the HashSet.

Maintain Sliding Window: If the current index i is greater than or equal to k, remove the element that is k positions behind the current element from the HashSet.

Return Result: If no duplicates are found within the window of size k, return false.

This approach ensures that the sliding window is maintained efficiently, and the entire array is checked for duplicates within the specified distance k.

*/
