## Distinct Adjacent Element
Difficulty: BasicAccuracy: 32.83%Submissions: 4K+Points: 1
Given an array arr[] of integers, the task is to check whether obtaining an array with distinct adjacent elements is possible by swapping two neighboring array elements.

Examples:

Input: arr[] = [1, 1, 2]
Output: true
Explanation: Swapping last 2 elements can result in [1, 2, 1].
Input: arr[] = [7, 7, 7, 7]
Output: false
Explanation: We can't swap to obtain distinct elements in neighbor.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
2 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 105

## JAVA CODE:
```
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean distinctAdjacentElement(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;

        // Calculate frequencies of each element
        for (int i : arr) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(i));
        }

        // If the maximum frequency is greater than half of the array size rounded up
        // It's not possible to make all elements distinct by swapping
        if (maxFreq > (n + 1) / 2) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 1, 2};
        System.out.println(sol.distinctAdjacentElement(arr1)); // Output: true

        int[] arr2 = {7, 7, 7, 7};
        System.out.println(sol.distinctAdjacentElement(arr2)); // Output: false
    }
}

```

## Explanation:
HashMap Initialization:

Use HashMap to track the frequency of each element.

Frequency Calculation:

Iterate through the array, updating the HashMap and keeping track of the maximum frequency encountered.

Check Feasibility:

If the maximum frequency of any element exceeds half the array size rounded up, return false (indicating it's impossible to have distinct adjacent elements by swapping).

Return Result:

Otherwise, return true.

## Other method
```
class Solution {
    public boolean distinctAdjacentElement(int[] arr) {
        int n = arr.length;
        int maxFreq = 0;
        int[] freq = new int[100001]; // Constraint: 1 <= arr[i] <= 10^5
        
        // Calculate frequencies of each element
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
            maxFreq = Math.max(maxFreq, freq[arr[i]]);
        }
        
        // If the maximum frequency is greater than half of the array size rounded up
        // It's not possible to make all elements distinct by swapping
        if (maxFreq > (n + 1) / 2) {
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr1 = {1, 1, 2};
        System.out.println(sol.distinctAdjacentElement(arr1)); // Output: true

        int[] arr2 = {7, 7, 7, 7};
        System.out.println(sol.distinctAdjacentElement(arr2)); // Output: false
    }
}

```
