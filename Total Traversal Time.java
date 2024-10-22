/*
Total Traversal Time
Difficulty: EasyAccuracy: 50.0%Submissions: 33K+Points: 2
Given two arrays arr[ ] and penalty[ ], each of size n.
All elements in arr[ ] are in the range of 1 to n. You have to traverse arr[ ] from start to end while following the given conditions.

If element has never occured before, it takes 1 second to move a step ahead.
If element has occured before, it will take penalty[arr[i]] seconds to move a step. Here i is the index of current element with 1-based indexing.
Find the total time taken to traverse through the array.

Example 1:

Input:
n = 4
arr[ ] = {1, 2, 3, 3}
penalty[ ] = {1, 2, 3, 4}
Output: 5
Explanation:


For i = 1, traversal time = 0 second since this is the start point.  
For i = 2, traversal time = 1 second 
For i = 3, traversal time = 1 second 
For i = 4, traversal time = penalty[arr[4]]  = penalty[3] = 3
Total = 0+1+1+3 = 5 
Example 2:

Input:
n = 8
arr = {6, 6, 1, 8, 1, 1, 3, 1}
time ={8, 4, 1, 5, 2, 8, 9, 3}
Output:
35
Explanation:

Your Task:
You don't need to read input or print anything. Your task is to complete the function totalTime() which takes three input parameters n, arr[ ], penalty[ ] and returns the total time taken to traverse through the array. 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 10^5
1 <= arr[i] <= n
1 <= time[i] <= 10^5

*/

import java.util.HashSet;

class Solution {
    public static long totalTime(int n, int arr[], int penalty[]) {
        HashSet<Integer> visited = new HashSet<>();
        long totalTime = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.contains(arr[i])) {
                totalTime += 1;
                visited.add(arr[i]);
            } else {
                totalTime += penalty[arr[i] - 1];
            }
        }
        
        return totalTime - 1; // Subtracting the initial 0th step
    }

    public static void main(String[] args) {
        int n1 = 4;
        int[] arr1 = {1, 2, 3, 3};
        int[] penalty1 = {1, 2, 3, 4};
        System.out.println(totalTime(n1, arr1, penalty1)); // Output: 5

        int n2 = 8;
        int[] arr2 = {6, 6, 1, 8, 1, 1, 3, 1};
        int[] penalty2 = {8, 4, 1, 5, 2, 8, 9, 3};
        System.out.println(totalTime(n2, arr2, penalty2)); // Output: 35
    }
}

/*
Initialization of Variables:

A HashSet named visited is created to keep track of the elements we've encountered.

The variable totalTime is initialized to zero.

Loop Through Elements:

We iterate through each element of the array arr using a for loop.

Check if Element is Visited:

For each element arr[i], we check if it exists in the visited set.

If the element has not been visited before (!visited.contains(arr[i])), we:

Add 1 second to the totalTime because encountering a new element takes 1 second.

Add the element to the visited set.

If the element has been visited before, we:

Add the penalty time (penalty[arr[i] - 1]) to totalTime.

Adjustment for Initial Position:

Since moving from the initial position to the first element should not count, we subtract 1 from totalTime at the end.

Return Total Time:

The final totalTime is then returned as the result.

Here's how the process looks with your example input:

Input: arr = {1, 2, 3, 3}, penalty = {1, 2, 3, 4}

Traversal:

For i = 1 (arr[0] = 1): It's the start point, so totalTime += 1.

For i = 2 (arr[1] = 2): Not visited, so totalTime += 1 (totalTime now 2).

For i = 3 (arr[2] = 3): Not visited, so totalTime += 1 (totalTime now 3).

For i = 4 (arr[3] = 3): Visited, so totalTime += penalty[3-1] = 3 (totalTime now 6).

Subtract Initial 0: totalTime = 6 - 1 = 5
*/
