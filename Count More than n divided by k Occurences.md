# Count More than n/k Occurences
Difficulty: EasyAccuracy: 58.35%Submissions: 113K+Points: 2
Given an array arr of size N and an element k. The task is to find the count of elements in the array that appear more than n/k times.

Example 1:

Input:
N = 8
arr = [3,1,2,2,1,2,3,3]
k = 4
Output: 
2
Explanation: 
In the given array, 3 and 2 are the only elements that appears more than n/k times.
Example 2:

Input:
N = 4
arr = [2,3,3,2]
k = 3
Output: 
2
Explanation: In the given array, 3 and 2 are the only elements that appears more than n/k times. So the count of elements are 2.
Your Task:
The task is to complete the function countOccurence() which returns count of elements with more than n/k times appearance.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
0 <= a[i] <= 109
1 <= k <= N

# Java Code:

```
import java.util.HashMap;

class Solution {
    // Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Building the frequency map
        for (int i : arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        int threshold = n / k;
        int count = 0;

        // Counting elements that appear more than n/k times
        for (int key : freq.keySet()) {
            if (freq.get(key) > threshold) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {3, 1, 2, 2, 1, 2, 3, 3};
        int n = arr.length;
        int k = 4;

        System.out.println("Count of elements more than n/k times: " + sol.countOccurence(arr, n, k)); // Output: 2
    }
}

```

# Explanation:
Frequency Map: The first loop builds a frequency map of elements in the array.

Threshold Calculation: Calculate the threshold n/k.

Count Elements: The second loop counts the elements that appear more than n/k times by checking the frequency map.
