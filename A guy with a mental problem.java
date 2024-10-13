/*
A guy with a mental problem
Difficulty: BasicAccuracy: 54.47%Submissions: 7K+Points: 1
A person needs to reach home by train but compulsively switches trains at every station. If they start with train arr1 at the first station, they will switch to train arr2 at the next station, and then switch back to train arr1 at the following station, and so on. Similarly, if they start with train arr2, they will switch to train arr1 at the next station, and continue alternating.

Given two arrays, arr1 and arr2, where:

arr1[i] represents the time taken by train arr1 at station i.
arr2[i] represents the time taken by train arr2 at station i.
Determine the minimum total time required to reach home starting from either train arr1 or train arr2, with the switching pattern maintained.

Examples:
Input: arr1 = [2, 1, 2], arr2 = [3, 2, 1]
Output: 5
Explanation: Starting with train arr2 yields the minimum total time of 5.
Input: arr1 = [1, 3, 1, 2] arr2 = [2, 2, 3, 1]
Output: 5
Explanation: Starting with train arr1 yields the minimum total time of 5.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints
1 ≤ arr1.size(), arr2.size() ≤ 106
1 ≤ arr1[i], arr2[i] ≤ 106
*/

class Solution {
    public int minTime(int[] arr1, int[] arr2) {
        int s1 = sui(arr1, arr2); // Calculate time starting with arr1
        int s2 = sui(arr2, arr1); // Calculate time starting with arr2
        return Math.min(s1, s2); // Return the minimum of the two possible times
    }

    static int sui(int[] arr1, int[] arr2) {
        int s = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (i % 2 == 0)
                s += arr1[i]; // Add time from arr1 at even index (0, 2, 4, ...)
            else
                s += arr2[i]; // Add time from arr2 at odd index (1, 3, 5, ...)
        }
        return s;
    }
}

/*
Explanation:

minTime Method: This method calculates the minimum time to reach home starting with either arr1 or arr2. It calls the sui method twice: once with arr1 as the starting train, and once with arr2 as the starting train. It then returns the smaller of the two times.

sui Method: This method calculates the total time taken if you start with the first train passed as a parameter and switch at every station.

It initializes a variable s to store the total time.

It loops through each station.

If the station index is even, it adds the time from arr1 to s. If the index is odd, it adds the time from arr2 to s.

Finally, it returns the total time s.

By starting with either train and alternating, the solution ensures both possible routes are considered, and the minimum of the two total times is returned as the result.
*/
