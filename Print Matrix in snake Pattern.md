
Print Matrix in snake Pattern
Difficulty: EasyAccuracy: 68.08%Submissions: 73K+Points: 2
Given a matrix of size N x N. Print the elements of the matrix in the snake like pattern depicted below.

![image](https://contribute.geeksforgeeks.org/wp-content/uploads/snake-pattern.jpg)

Examples :

Input: N = 3, matrix[][] = [[45, 48, 54], [21, 89, 87], [70, 78, 15]]
Output: 45 48 54 87 89 21 70 78 15 
Explanation: Printing it in snake pattern will lead to the output as 45 48 54 87 89 21 70 78 15.
Input: N = 2, matrix[][] = [[1, 2], [3, 4]]
Output: 1 2 4 3 
Explanation: Printing it in snake pattern will give output as 1 2 4 3.
Constraints:
1 <= N <= 103
1 <= mat[i][j] <= 109

```
class Solution
{
    //Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][])
    {
        // code here 
        ArrayList<Integer> a=new ArrayList<>();
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((i+2)%2==0){
                    a.add(matrix[i][j]);
                }
                else
                {
                    a.add(matrix[i][n-j-1]);
                }
            }
        }
        return a;
    }
}


```


Detailed Explanation
Class and Method Definition:


class Solution {
    // Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        ArrayList<Integer> a = new ArrayList<>();
        int n = matrix.length;
Outer Loop - Iterate Over Rows:


        for (int i = 0; i < n; i++) {
The loop iterates through each row of the matrix, starting from the first row (i = 0) to the last row (i = n-1).

Inner Loop - Iterate Over Columns:


            for (int j = 0; j < n; j++) {
                if ((i + 2) % 2 == 0) {
                    a.add(matrix[i][j]);
                } else {
                    a.add(matrix[i][n - j - 1]);
                }
            }
        }
The inner loop iterates through each column in the current row.

Condition Check:

if ((i + 2) % 2 == 0): This condition is used to determine the direction of traversal within the row.

When i is even, elements are added in the order they appear (matrix[i][j]).

When i is odd, elements are added in reverse order (matrix[i][n - j - 1]).

Return the Result List:

        return a;
    }
}
Example Walkthrough:
Given matrix:

1 2 3
4 5 6
7 8 9
First Row (i = 0):

(0 + 2) % 2 == 0 is true.

Add elements in order: 1, 2, 3.

Second Row (i = 1):

(1 + 2) % 2 == 0 is false.

Add elements in reverse order: 6, 5, 4.

Third Row (i = 2):

(2 + 2) % 2 == 0 is true.

Add elements in order: 7, 8, 9.

Final result list:

[1, 2, 3, 6, 5, 4, 7, 8, 9]
Summary:
The snakePattern method iterates through the matrix row by row. For even-indexed rows, it adds elements from left to right. For odd-indexed rows, it adds elements from right to left. This creates a snake-like traversal pattern through the matrix.
