/*
Average of Prefix
Difficulty: EasyAccuracy: 49.93%Submissions: 36K+Points: 2
Given an array arr, find the average or mean of the prefix array at every index.

Example 1:

Input: arr[] = [10, 20, 30, 40, 50]
Output: [10, 15, 20, 25, 30] 
Explanation: 10 / 1 = 10, (10 + 20) / 2 = 15, (10 + 20 + 30) / 3 = 20 and so on.
Input: arr[] = [12, 2]
Output: [12, 7] 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size ≤ 105
1 ≤ arr[i] ≤ 106
*/

import java.util.ArrayList;

class Solution {
    // Prints average of a stream of numbers
    public ArrayList<Integer> prefixAvg(ArrayList<Integer> arr) {
        ArrayList<Integer> res = new ArrayList<>();
        long sum = 0; // Use long to avoid overflow

        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            res.add((int) (sum / (i + 1))); // Calculate the average and add to the result
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(10);
        arr1.add(20);
        arr1.add(30);
        arr1.add(40);
        arr1.add(50);
        System.out.println(sol.prefixAvg(arr1)); // Output: [10, 15, 20, 25, 30]

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(12);
        arr2.add(2);
        System.out.println(sol.prefixAvg(arr2)); // Output: [12, 7]
    }
}

/*
Explanation:

-Initialization:
Create an ArrayList named res to store the result.
Use a long variable sum to accumulate the sum of elements (to avoid overflow for large sums).

-Iterate Through the Array:
Loop through each element of the array.
For each element, add its value to sum.
Calculate the average of the prefix up to the current index and add it to res.

-Return the Result:
Return the res array containing the prefix averages.

This approach ensures the expected time complexity of O(N)and auxiliary space of O(1).


*/
