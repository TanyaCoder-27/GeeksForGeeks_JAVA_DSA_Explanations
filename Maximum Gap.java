/*
Maximum Gap
Difficulty: EasyAccuracy: 28.99%Submissions: 17K+Points: 2
Given an unsorted array arr[] of positive elements. Your task is to find the maximum difference between the successive elements in its sorted form.
Return 0 if the array contains less than 2 elements.

Examples:

Input: arr[] = [1, 10, 5]
Output: 5
Explanation: The maximum difference between successive elements of array is 5 ie abs(5-10).
Input: arr[] = [1, 10, 2]
Output: 8
Explanation: The maximum difference between successive elements of array is 8 ie abs(2-10).
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106
*/

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    int maxSortedAdjacentDiff(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i : arr) {
            pq.add(i);
        }
        
        int max_diff = Integer.MIN_VALUE;
        int previous = pq.poll();
        
        while (!pq.isEmpty()) {
            int current = pq.poll();
            max_diff = Math.max(max_diff, previous - current);
            previous = current;
        }
        
        return max_diff;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 10, 5, 3, 20, 8};
        System.out.println(sol.maxSortedAdjacentDiff(arr)); // Expected output: 7 (20 - 13 = 7)
    }
}

/*
Explanation:
PriorityQueue Initialization:

We use a PriorityQueue with a reverseOrder comparator to ensure it's a max-heap.

Adding Elements to PriorityQueue:

All elements of the array are added to the PriorityQueue.

Calculate Maximum Difference:

Initialize max_diff to the minimum possible value.

Poll the first element to set previous (the largest element in the array).

Continue polling from the PriorityQueue to get the next largest element (current), compute the difference previous - current, and update max_diff if this difference is larger than the current max_diff.

Update previous to current for the next iteration.

Return Result:

The loop continues until the PriorityQueue is empty, and the maximum difference found is returned.

This code ensures the maximum difference between adjacent elements in the sorted version of the array is found efficiently using a max-heap

*/
