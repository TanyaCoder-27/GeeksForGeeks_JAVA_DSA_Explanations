/*
Minimum Integer
Difficulty: EasyAccuracy: 47.05%Submissions: 64K+Points: 2
You are given an array A of size N. Let us denote S as the sum of all integers present in the array. Among all integers present in the array, find the minimum integer X such that S ≤ N*X.

Example 1:

Input:
N = 3,
A = { 1, 3, 2}
Output:
2
Explanation:
Sum of integers in the array is 6.
since 6 ≤ 3*2, therefore 2 is the answer.
Example 2:

Input:
N = 1,
A = { 3 }
Output:
3
Explanation:
3 is the only possible answer
Your Task:
The task is to complete the function minimumInteger() which takes an integer N and an integer array A as input parameters and returns the minimum integer which satisfies the condition.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤  N ≤ 105
1 ≤  Ai ≤ 109
*/

class Solution {
    public static int minimumInteger(int N, int[] A) {
        long S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i];
        }

        int minX = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (S <= (long) N * A[i]) {
                minX = Math.min(minX, A[i]);
            }
        }

        return minX;
    }
}

/*
Explanation:
-Calculate Sum 

Here, we're initializing a long variable 
S to zero. We then loop through each element in the array A and add it to S
This gives us the total sum of all elements in A.

-Find Minimum Valid X

We start by initializing minX to the largest possible integer value.
We then loop through each element in Aagain.

For each element A[i], we check if S is less than or equal to N×A[i].This condition ensures that the sum of the elements S doesn't exceed the total of N×X.

If the condition is satisfied, we update minX to the minimum value between the current minX and A[i].

Return Result:
Finally, we return the smallest valid integer X that satisfies the condition.

Why Use long?
We use long for the variable S
to handle potential overflow issues. In Java, an int has a maximum value of 2,147,483,647, which might not be enough to store the sum of elements if the array is large and contains large values.
By using long, we ensure that the sum can be accurately calculated without exceeding the maximum value limit. This way, the calculation remains precise and avoids overflow errors.

*/
