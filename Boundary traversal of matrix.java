/*
Boundary traversal of matrix

  You are given a matrix of dimensions n x m. The task is to perform boundary traversal on the matrix in a clockwise manner starting from the first row of the matrix.

Example 1:

Input:
n = 4, m = 4
matrix[][] = {{1, 2, 3, 4},
         {5, 6, 7, 8},
         {9, 10, 11, 12},
         {13, 14, 15,16}}
Output: 1 2 3 4 8 12 16 15 14 13 9 5
Explanation:
The matrix is:
1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16
The boundary traversal is:
1 2 3 4 8 12 16 15 14 13 9 5
Example 2:

Input:
n = 3, m = 4
matrrix[][] = {{12, 11, 10, 9},
         {8, 7, 6, 5},
         {4, 3, 2, 1}}
Output: 12 11 10 9 5 1 2 3 4 8
Your Task:
Complete the function boundaryTraversal() that takes matrix, n and m as input parameters and returns the list of integers that form the boundary traversal of the matrix in a clockwise manner.

Expected Time Complexity: O(N + M)
Expected Auxiliary Space: O(N+M)

Constraints:
1 <= n, m<= 1000
0 <= matrixi <= 1000

*/

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            res.add(matrix[0][i]);
        }
        if (n == 1) {
            return res;
        }
        for (int i = 1; i < n; i++) {
            res.add(matrix[i][m - 1]);
        }
        if (m == 1) {
            return res;
        }
        for (int i = m - 2; i >= 0; i--) {
            res.add(matrix[n - 1][i]);
        }
        for (int i = n - 2; i > 0; i--) {
            res.add(matrix[i][0]);
        }
        return res;
    }
}

/*

Code Explanation:
Class and Function Definition:


class Solution {
    // Function to return list of integers that form the boundary 
    // traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m) {
        ArrayList<Integer> res = new ArrayList<>();
Add the First Row:

        for (int i = 0; i < m; i++) {
            res.add(matrix[0][i]);
        }
        if (n == 1) {
            return res;
        }
This loop adds all elements from the first row of the matrix to the result list res.

If n == 1 (i.e., there is only one row), the function returns the result list res because the matrix has no more rows to process.

Add the Last Column:

        for (int i = 1; i < n; i++) {
            res.add(matrix[i][m - 1]);
        }
        if (m == 1) {
            return res;
        }
This loop adds all elements from the last column of the matrix to the result list res.

If m == 1 (i.e., there is only one column), the function returns the result list res because the matrix has no more columns to process.

Add the Last Row:

        for (int i = m - 2; i >= 0; i--) {
            res.add(matrix[n - 1][i]);
        }
This loop adds all elements from the last row of the matrix (in reverse order) to the result list res.

Add the First Column:

        for (int i = n - 2; i > 0; i--) {
            res.add(matrix[i][0]);
        }
        return res;
    }
}
This loop adds all elements from the first column of the matrix (in reverse order, except the first element) to the result list res.

Summary
The function boundaryTraversal takes a 2D matrix matrix and its dimensions n (number of rows) and m (number of columns) as inputs. It then constructs and returns a list of integers that represent the boundary traversal of the matrix in a clockwise manner. Here's a breakdown of the traversal order:

All elements of the first row (left to right).

All elements of the last column (top to bottom).

All elements of the last row (right to left).

All elements of the first column (bottom to top, excluding the corners already covered).

This approach ensures that the boundary elements are traversed in the correct order while avoiding redundant additions of corner elements.
*/
