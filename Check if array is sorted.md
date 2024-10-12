## Check if array is sorted
Difficulty: EasyAccuracy: 39.37%Submissions: 218K+Points: 2
Given an array arr[], check whether it is sorted in non-decreasing order. Return true if it is sorted otherwise false.

Examples:

Input: arr[] = [10, 20, 30, 40, 50]
Output: true
Explanation: The given array is sorted.
Input: arr[] = [90, 80, 100, 70, 40, 30]
Output: false
Explanation: The given array is not sorted.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size ≤ 106
- 109 ≤ arr[i] ≤ 109

## JAVA Program:
```
class Solution {
    // Function to check whether the array is sorted
    public boolean arraySortedOrNot(List<Integer> arr) {
        // Traverse the array from the second element
        for (int i = 1; i < arr.size(); i++) {
            // If the current element is smaller than the previous element
            if (arr.get(i) < arr.get(i - 1)) {
                return false; // The array is not sorted
            }
        }
        return true; // The array is sorted
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> list1 = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> list2 = Arrays.asList(90, 80, 100, 70, 40, 30);

        System.out.println(sol.arraySortedOrNot(list1)); // true
        System.out.println(sol.arraySortedOrNot(list2)); // false
    }
}

```
## Explanation:
Loop through the list: Starting from the second element (index 1), compare each element with the previous one.

If any element is found to be smaller than its predecessor, the list isn't sorted, and we return false.

Return true if sorted: If the loop completes without finding any unsorted elements, we return true.
