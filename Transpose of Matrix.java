/*

Transpose of Matrix
Difficulty: EasyAccuracy: 66.5%Submissions: 103K+Points: 2
Write a program to find the transpose of a square matrix of size N*N. Transpose of a matrix is obtained by changing rows to columns and columns to rows.

Examples :

Input: N = 4, mat[][] = [[1, 1, 1, 1], [2, 2, 2, 2], [3, 3, 3, 3], [4, 4, 4, 4]]
Output: [[1, 2, 3, 4] , [1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4]] 
Input: N = 2, mat[][] = [[1, 2],[9, -2]]
Output: [[1, -9], [2, -2]]

Constraints:
1 <= N <= 103
-109 <= mat[i][j] <= 109

*/

class Solution
{
    public void transpose(int n,int a[][])
    {
         for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=a[i][j];/*
                a[i][j]=a[j][i];
                a[j][i]=temp;
            }
         }
    }
}

/*
This code defines a method transpose within a class Solution, which takes an integer n (the size of the matrix) and a 2D array a (the matrix) as inputs and transposes the matrix in place.

Transpose of a Matrix
In linear algebra, the transpose of a matrix is an operator which flips a matrix over its diagonal. In other words, the row and column indices of the matrix are swapped.

Code Explanation
Class and Method Definition:


class Solution {
    public void transpose(int n, int a[][]) {
Outer Loop - Iterate Over Rows:


        for (int i = 0; i < n; i++) {
This loop iterates through the rows of the matrix, starting from the first row (i = 0) to the last row (i = n-1).

Inner Loop - Iterate Over Columns:


            for (int j = i + 1; j < n; j++) {
This loop iterates through the columns, starting from i + 1 to n-1.

By starting from i + 1, it ensures that only the upper triangular part of the matrix (excluding the diagonal) is processed, avoiding redundant swaps.

Swap Elements to Transpose the Matrix:


                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
The value at position a[i][j] is temporarily stored in temp.

The value at position a[j][i] is assigned to a[i][j].

The value stored in temp is then assigned to a[j][i].

This effectively swaps the elements above the diagonal with their corresponding elements below the diagonal.

Closing the Loops and Method:


            }
        }
    }
*/
