/*
Even and odd elements at even and odd positions
Difficulty: EasyAccuracy: 26.56%Submissions: 16K+Points: 2
Given an array arr[], the task is to arrange the array such that odd elements occupy the odd positions and even elements occupy the even positions. The order of elements must remain the same. Consider zero-based indexing. After printing according to conditions, if remaining, print the remaining elements as it is.

Examples:

Input: arr[] = [1, 2, 3, 4, 5, 6]
Output: [2, 1, 4, 3, 6, 5]
Explanation: Even elements are at even position and odd elements are at odd position keeping the order maintained.
Input:  arr[] = [3, 7, 4, 1]
Output: [4, 3, 7, 1]
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
2 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤arr.size()
*/

import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> arrangeOddAndEven(int arr[]) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        // Separate even and odd numbers
        for (int i : arr) {
            if (i % 2 == 0) {
                even.add(i);
            } else {
                odd.add(i);
            }
        }

        // Add elements from even and odd lists alternately to result
        int i = 0, j = 0;
        while (i < even.size() && j < odd.size()) {
            res.add(even.get(i++));
            res.add(odd.get(j++));
        }

        // Add remaining elements from even list if any
        while (i < even.size()) {
            res.add(even.get(i++));
        }

        // Add remaining elements from odd list if any
        while (j < odd.size()) {
            res.add(odd.get(j++));
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2, 7, 4, 6, 5, 3, 1};
        ArrayList<Integer> result = sol.arrangeOddAndEven(arr);
        System.out.println(result); // Expected output: [2, 7, 4, 5, 6, 3, 1]
    }
}

/*
Explanation:
Separate Even and Odd Numbers:

The first loop separates the numbers into even and odd lists.

Add Elements Alternately:

The while loop alternates between adding elements from even and odd lists to the res list.

Handle Remaining Elements:

After the first while loop, two additional while loops add any remaining elements from the even and odd lists to res.

*/
