/*
Matrix Interchange - Java
Difficulty: EasyAccuracy: 65.87%Submissions: 23K+Points: 2
Working with 2D arrays is quite important. Here we will do swapping of column in a 2D array. You are given a matrix M or r rows and c columns. You need to swap the first column with the last column.

Example:

Input:
3 4
1 2 3 4
4 3 2 1
6 7 8 9

Output:
4 2 3 1
1 3 2 4
9 7 8 6
Your Task:
Since this is a function problem, you don't need to take any input. Just complete the provided function interchange(int, int , int ) that take matrix, rows and columns as parameters.

Constraints:
1 <= r,c <= 100
*/

class Geeks{
    
    static void interchange(int a[][],int r, int c){
        
        
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(j==0)      //first column
                {
                    int temp = a[i][j];       // j as 0 means first col
                    a[i][j] = a[i][c-1];      // c-1 means last col
                    a[i][c-1] = temp;
                }
            }
        } 
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
