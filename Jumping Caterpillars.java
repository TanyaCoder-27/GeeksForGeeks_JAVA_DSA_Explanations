/*
Jumping Caterpillars
Difficulty: EasyAccuracy: 22.73%Submissions: 19K+Points: 2
Given n leaves numbered from 1 to n. A caterpillar at leaf 1. The array contains the jump power of the caterpillar.  The caterpillar jumps from leaf to leaf in multiples of arr[j],  j is specific to the caterpillar. Whenever a caterpillar reaches a leaf, it eats it a little bit. You have to find out how many leaves are left uneaten after all caterpillars have reached the end. Each caterpillar has its own jump factor denoted by arr[j], and each caterpillar starts at leaf number 1.

Examples:

Input: n = 10, arr[] = [2, 3, 5] 
Output: 2
Explanation: The leaves eaten by the first caterpillar are (2, 4, 6, 8, 10). The leaves eaten by the second caterpilllar are (3, 6, 9). The leaves eaten by the third caterpilllar are (5, 10). Ultimately, the uneaten leaves are 1, 7 and their number is 2.
Input: n = 5, arr[] = [2] 
Output: 3
Explanation: The leave eaten are (2,4). The leaves (1,3,5) are uneaten.
Expected Time Complexity: O(n*arr.size).
Expected Auxiliary Space: O(n).

Constraints:
1 ≤ arr.size() ≤ 103
1 ≤ arr[i] ≤ 104
*/

import java.util.*;

class Solution {
    public int uneatenLeaves(int[] arr, int n) {
        // Set to store all multiples of elements in arr up to n
        Set<Integer> mul = new HashSet<>();
        
        // Add all multiples of each element in arr to the set
        for (int i : arr) {
            for (int j = 1; j * i <= n; j++) {
                mul.add(i * j);
            }
        }
        
        // Calculate the number of uneaten leaves
        int uneatenCount = n - mul.size();

        return uneatenCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2, 3, 4};
        int n = 10;
        System.out.println(sol.uneatenLeaves(arr, n)); // Expected output: 2 (Leaves 1 and 5 are uneaten)
    }
}

/*
Explanation:
Initialization:

Set<Integer> mul: This set will store all multiples of the numbers in the array arr up to n. Using a set ensures that each multiple is only stored once.

Adding Multiples to the Set:

The outer loop iterates over each element i in arr.

The inner loop calculates multiples of i (i*j) and adds them to the mul set.

The condition j * i <= n ensures we only consider multiples that are less than or equal to n.

Calculating Uneaten Leaves:

The uneaten leaves are the total leaves (n) minus the number of leaves in the mul set.

The expression n - mul.size() computes the number of leaves that are not in the mul set (i.e., uneaten leaves).

Returning the Result:

The method returns the count of uneaten leaves.

This code efficiently calculates the number of uneaten leaves by using a set to keep track of all the multiples and then computing the difference between the total leaves and the multiples

*/
