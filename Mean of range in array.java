/*
Mean of range in array
Difficulty: EasyAccuracy: 44.14%Submissions: 8K+Points: 2
Given an array arr and q queries. Write a program to find the floor value of the mean in the range l to r for each query in a new line.
Queries are given by an array of queries[] of size 2*q. Here queries[2*i] denote l and queries[2*i+1] denote r for i-th query.

Examples:

Input : arr[] = [1, 2, 3, 4, 5] and q[] = [0, 2, 1, 3, 0, 4]
Output : [2, 3, 3]
Explanation: Here we can see that the array of integers is [1, 2, 3, 4, 5]. Query 1: L = 0 and R = 2 Sum = 6 Integer Count = 3 So, Mean is 2
Input : arr[] = [6, 7, 8, 10] and q[] = [0, 3, 1, 2]
Output : [7, 7]
Explanation: Element count is 3 and sum of element from 0 to 3 are 21. So mean is 7.
Expected Time Complexity: O(q + n).
Expected Auxiliary Space: O(n).

Constraints: 
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 103
*/

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findMean(int arr[], int q[]) {
        ArrayList<Integer> result = new ArrayList<>();

        // Iterate through queries
        for (int i = 0; i < q.length; i += 2) {
            int l = q[i];
            int r = q[i + 1];

            // Calculate the sum of elements in the range [l, r]
            int sum = 0;
            for (int j = l; j <= r; j++) {
                sum += arr[j];
            }

            // Calculate the floor of the mean
            int mean = sum / (r - l + 1);
            result.add(mean);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] queries1 = {0, 2, 1, 3, 0, 4};
        System.out.println(sol.findMean(arr1, queries1)); // Output: [2, 3, 3]

        int[] arr2 = {6, 7, 8, 10};
        int[] queries2 = {0, 3, 1, 2};
        System.out.println(sol.findMean(arr2, queries2)); // Output: [7, 7]
    }
}

/*
Explanation:
Initialize Result List:

Create an ArrayList<Integer> to store the results of each query.

Iterate Through Queries:

Use a for loop to iterate through the q array with a step of 2, since each query consists of a pair of indices [l, r].

Calculate Sum of Elements in Range:

For each query, extract the start (l) and end (r) indices.

Use another for loop to calculate the sum of elements in the range [l, r].

Calculate Floor of the Mean:

Compute the mean by dividing the sum by the number of elements in the range (r - l + 1).

Add the floor value of the mean to the result list.

Return Result:

After processing all queries, return the result list containing the floor values of the mean for each query.

This solution efficiently computes the required means for the given queries. 

*/
