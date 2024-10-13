/*
Find The Sequence
Difficulty: BasicAccuracy: 37.48%Submissions: 6K+Points: 1
Adobe is weak in the concepts of string. He is given a number N and has to find N terms of that series. The series is 1, 2, 5, 8,15. . . 

Example 1:

Input:
N = 8
Output:
1 2 5 8 15 28 51 94
Explanation:
For N = 8, series comes out to be:
1 2 5 8 15 28 51 94
Example 2:

Input:
N = 3
Output:
1 2 5 
Explanation:
For N = 3, series comes out to be:
1 2 5 
Your Task:  
You don't need to read input or print anything. Your task is to complete the function printSeries() which takes an integer N as input parameter and return the list of the first N term of the series.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 50
*/

class Solution{
    static ArrayList<Long> printSeries(int N){
       
        ArrayList<Long> ans = new ArrayList<>();
        ans.add((long)1);
        ans.add((long)2);
        ans.add((long)5);
        
        
        long sum = 0;

        for(int i=3; i<N; i++){
            int j =i-3;
            while(j<i){
                sum += ans.get(j++);
            }
            ans.add(sum);
            sum =0;
        }
        return ans;
    }
}

/*
Explanation:

Step 1: Initialize the List and Base Cases
Creates an ArrayList named ans to store the series.
Adds the first three terms of the series: 1, 2, and 5.

Step 2: Initialize sum Variable
Initializes a variable sum to 0, which will be used to calculate each new term in the series.

Step 3: Generate the Series
Loop from 3 to N: Starts from the 4th term (i = 3) and goes up to the Nth term.

Inner Loop:
Initializes j to i - 3, which effectively means starting from three positions back.
Adds the values of the last three terms to sum.
Adds the sum to the ans list as the new term.
Resets sum to 0 for the next iteration.

Step 4: Return the List
Returns the list ans containing the first N terms of the series.

Simply,
The first three terms of the series are manually added to the list.

For each subsequent term, the code calculates the sum of the three preceding terms and adds this sum to the list.

This process continues until the list contains N terms.

In summary, this code creates a list of the first N terms in a sequence where each term (from the 4th term onward) is the sum of the previous three terms. 
*/
