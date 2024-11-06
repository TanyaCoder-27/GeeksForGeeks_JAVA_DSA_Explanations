/*
Rotate by 90 degree
Difficulty: EasyAccuracy: 56.88%Submissions: 86K+Points: 2
Given a square matrix of size n x n. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space. 

Examples:

Input: matrix[][] = [[1, 2, 3],
                   [4, 5, 6]
                   [7, 8, 9]]
Output: Rotated Matrix:
[3, 6, 9]
[2, 5, 8]
[1, 4, 7]
Input: matrix[][] = [[1, 2],
                   [3, 4]]
Output: Rotated Matrix:
[2, 4]
[1, 3]
Constraints:
1 ≤ n ≤ 102
1 <= matrix[][] <= 103
*/

class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int matrix[][]) {
        int n = matrix.length;  // Initialize n as the length of the matrix

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each column
        for (int i = 0; i < n; i++) {
            int top = 0;
            int bottom = n - 1;
            while (top < bottom) {
                int temp = matrix[top][i];
                matrix[top][i] = matrix[bottom][i];
                matrix[bottom][i] = temp;
                top++;
                bottom--;
            }
        }
    }

    public static void printMatrix(int n, int matrix[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int n = matrix.length;

        System.out.println("Original Matrix:");
        printMatrix(n, matrix);

        rotateby90(matrix);

        System.out.println("Rotated Matrix:");
        printMatrix(n, matrix);
    }
}

/*
Explanation:
Transpose the Matrix:

This is done in the same way as before by swapping elements symmetrically across the main diagonal.

Reverse Each Column:

After transposing the matrix, reverse each column instead of each row.

This achieves the 90-degree anti-clockwise rotation.

Example Walkthrough:
Given matrix:

1 2 3
4 5 6
7 8 9
After Transposition:

1 4 7
2 5 8
3 6 9
After Reversing Each Column:

3 6 9
2 5 8
1 4 7

*/
