/*
Predict the Column
Difficulty: EasyAccuracy: 43.32%Submissions: 77K+Points: 2
Given a matrix(2D array) M of size N*N consisting of 0s and 1s only. The task is to find the column with maximum number of 0s. If more than one column exists, print the one which comes first. If the maximum number of 0s is 0 then return -1.

Example:

Input:
N = 3
M[][] = {{0, 0, 0},
          {1, 0, 1},
          {0, 1, 1}}
Output:
0
Explanation:
0th column (0-based indexing) is having 2 zeros which is maximum among all columns and comes first.
Your Task:
Your task is to complete the function columnWithMaxZero() which should return the column number with the maximum number of zeros. 

Expected Time Complexity: O(N * N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 103
0 <= A[i][j] <= 1
*/

class Solution {
    int columnWithMaxZeros(int arr[][], int N) {
        int max_count = 0, c = -1;

        for (int j = 0; j < N; j++) { // Iterate through columns
            int count = 0;
            for (int i = 0; i < N; i++) { // Iterate through rows
                if (arr[i][j] == 0) {
                    count++;
                }
            }
            if (count > max_count) {
                max_count = count;
                c = j;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = { 
            { 1, 0, 1 }, 
            { 0, 1, 0 }, 
            { 0, 0, 0 } 
        };
        int N = 3;
        System.out.println(sol.columnWithMaxZeros(arr, N)); // Output should be the column index with the maximum zeros
    }
}

/*
Goal of the Program:
The program aims to find the column in a 2D array (matrix) that contains the maximum number of zeros. If there are multiple columns with the same number of zeros, it returns the first one.

Explanation of the Program:
Step 1: Method Definition
max_count: This variable keeps track of the maximum number of zeros found in any column.
c: This variable stores the index of the column with the maximum number of zeros. It's initialized to -1 (meaning no column found yet).

Step 2: Loop Through Columns
The outer loop iterates over each column (j from 0 to N-1).
count: This variable keeps track of the number of zeros in the current column.

Step 3: Loop Through Rows for Each Column
The inner loop iterates over each row within the current column (i from 0 to N-1).
If an element in the current column is zero (arr[i][j] == 0), count is incremented.

Step 4: Update Maximum Zero Count and Column Index
After counting zeros in the current column, the code checks if this count is greater than the previously recorded max_count.
If it is, max_count is updated to this new count, and c is updated to the current column index j.

Step 5: Return the Result
After the loops finish, the method returns c, which is the index of the column with the maximum number of zeros.

Summary:
Initialization: Set up variables to track the maximum zero count and the column index.

Column Loop: Iterate over each column.

Row Loop: For each column, iterate over each row to count zeros.

Update Check: Update the maximum zero count and column index if the current column has more zeros.

Return: Return the index of the column with the most zeros.

*/
