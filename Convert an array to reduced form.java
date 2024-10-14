/*
Convert an array to reduced form
Difficulty: EasyAccuracy: 54.74%Submissions: 46K+Points: 2
Given an array with N distinct elements, convert the given array to a reduced form where all elements are in range from 0 to N-1. The order of elements is same, i.e., 0 is placed in place of smallest element, 1 is placed for second smallest element, and N-1 is placed for the largest element.

Note: You don't have to return anything. You just have to change the given array.

Example 1:

Input:
N = 3
Arr[] = {10, 40, 20}
Output: 0 2 1
Explanation: 10 is the least element so it
is replaced by 0. 40 is the largest
element so it is replaced by 3-1 = 2. And
20 is the 2nd smallest element so it is
replaced by 1.
Example 2:

Input:
N = 5
Arr[] = {5, 10, 40, 30, 20}
Output: 0 1 4 3 2
Explanation: As 5 is smallest element,
it's replaced by 0. Then 10 is 2nd
smallest element, so it's replaced by 1.
Then 20 is 3rd smallest element, so it's
replaced by 2. And so on.
Your Task:
You don't need to read input or print anything. Your task is to complete the function convert() which takes the array of integers arr and n as parameters and makes changes in the given array.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 106
*/

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    void convert(int[] arr, int n) {
        // Step 1: Create a copy of the array and sort it
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // Step 2: Create a hashmap to map each element to its reduced form
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sortedArr[i], i);
        }

        // Step 3: Replace each element in the original array with its reduced form
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr1 = {10, 40, 20};
        sol.convert(arr1, arr1.length);
        System.out.println(Arrays.toString(arr1)); // Output: [0, 2, 1]

        int[] arr2 = {5, 10, 40, 30, 20};
        sol.convert(arr2, arr2.length);
        System.out.println(Arrays.toString(arr2)); // Output: [0, 1, 4, 3, 2]
    }
}

/*
Step-by-Step Explanation:
---Clone and Sort the Array:

int[] sortedArr = arr.clone();
Arrays.sort(sortedArr);

Clone: Make a copy of the original array to sortedArr so that the original array remains unchanged.
Sort: Sort sortedArr to get the elements in ascending order.

---Create a Mapping of Original to Reduced Form:

HashMap<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < n; i++) {
    map.put(sortedArr[i], i);
}

HashMap: Use a HashMap to store the mapping from each element to its reduced form.
Store: As you iterate through sortedArr, map each element to its index in the sorted array. This index represents the reduced form.

---Replace Elements in Original Array:

for (int i = 0; i < n; i++) {
    arr[i] = map.get(arr[i]);
}

Loop Through Original Array: For each element in the original array, replace it with its reduced form by looking up its value in the map.

Why These Steps:
Clone and Sort: Cloning preserves the original order for comparison, and sorting arranges the elements to determine their rank.

HashMap for Mapping: Efficiently maps elements to their ranks in the sorted array.

Replace in Original: Ensures the reduced form replaces the original values directly in the array.

This approach runs in O(Nlog(N))due to the sorting step and uses O(N) space for the HashMap.

*/
