/*
Gift distribution according to preference
Difficulty: EasyAccuracy: 52.62%Submissions: 1K+Points: 2
Geek wants to distribute gifts to N students. He buys N gifts and asks his students to make a list of gifts arranged in order of their preference. Each student has a unique rank based on their performance in Geek's class. The gifts are distributed based on a student's rank and gift preference. The list submitted by a student with a better rank is given more importance. Find what gift each student gets. 


Example 1:

Input:
N = 3
Arr[][] = { {Preference list of student 1},
            {Preference list of student 2},
            {Preference list of student 3},}
        = {{1, 3, 2}, {2, 1, 3}, {3, 1, 2}}
Output: 1 2 3
Explanation: According to the gift preference 
of child with rank 1, he gets gift 1. Rank 2 
prefers gift 2 and gets that. Rank 3 prefers 
gift 3 and gets that.

Example 2:

Input:
N = 3
Arr[][] = { {Preference list of student 1},
            {Preference list of student 2},
            {Preference list of student 3},}
        = {{1, 2, 3}, {3, 2, 1}, {1, 2, 3}}
Output: 1 3 2
Explanation: According to the gift preference 
of child with rank 1, he gets gift 1. Rank 2 
prefers gift 3 and gets that. Rank 3 prefers 
gift 1 but that was given to student with rank 1. 
Second on his list is gift 2 so he gets that.

Your Task:
You don't need to read input or print anything. Your task is to complete the function distributeGift() which takes the 2D array of integers arr and n as input parameters and returns an array of integers of size N denoting the gift that each student got in order of their ranks.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 103
Preference of each child is a permutation [1, N]

*/

class Solution {
    public int[] distributeGift(int[][] arr, int n) {
        int[] gifts = new int[n];
        boolean[] taken = new boolean[n + 1]; // Tracks if a gift is already taken

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!taken[arr[i][j]]) {
                    gifts[i] = arr[i][j];
                    taken[arr[i][j]] = true;
                    break;
                }
            }
        }
        return gifts;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr1 = {{1, 3, 2}, {2, 1, 3}, {3, 1, 2}};
        int[][] arr2 = {{1, 2, 3}, {3, 2, 1}, {1, 2, 3}};
        
        int[] result1 = solution.distributeGift(arr1, 3);
        for (int gift : result1) {
            System.out.print(gift + " ");
        }
        System.out.println();

        int[] result2 = solution.distributeGift(arr2, 3);
        for (int gift : result2) {
            System.out.print(gift + " ");
        }
    }
}

/*
Explanation:
Input Handling: The function distributeGift takes a 2D array arr (preference lists of students) and an integer n (number of students).

Tracking Gifts: An array gifts is created to store the gift each student will get, and a boolean array taken keeps track of which gifts are already taken.

Distribution Logic: Iterate through each student based on their rank. For each student, iterate through their preference list and assign the first available gift that hasn't been taken yet.

Output: Return the gifts array containing the gift each student gets in the order of their ranks.

Constraints:
Time Complexity: O(N^2) since there are nested loops iterating over the preference lists.

Auxiliary Space: O(1) since the space used by the taken array is constant relative to the problem constraints.

NOTE:
The taken array is of size n+1 because we are dealing with gift preferences numbered from 1 to n. Using n+1 ensures that we have an index available for each possible gift number without running into an index out of bounds error.

For example, if n is 3, the possible gift numbers are 1, 2, and 3. The taken array needs to track the status of all these gift numbers, so we need an array of size 4 (n+1), where index 0 is unused.

*/
