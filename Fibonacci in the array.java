/*
Fibonacci in the array
Difficulty: BasicAccuracy: 36.6%Submissions: 7K+Points: 1
Given an array arr of integers, the task is to count the number of elements of the array which are Fibonacci numbers

Examples:

Input: arr[] = [4, 2, 8, 5, 20, 1, 40, 13, 23]
Output: 5
Explanation: Fibonacci Numbers that are present in array are 2, 8, 5, 1, 13
Input: arr[] = [4, 7, 6, 25]
Output: 0
Explanation: No Fibonacci number in this array.
Expected Time Complexity: O(n*log(maxElement))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105

*/

class Solution {
    public int countFibonacciNumbers(long[] arr) {
        int c=0;
        
        for(long i : arr){
            if(isFib(i)){
                c++;
            }
        }
        return c;
    }
    
    public static boolean isFib(long n){
       
        long a=0,b=1;
        while(b<n){
            long c= a+b;
            a=b;
            b=c;
        }
        return b==n;
    }
}

/*
Explanation:

-countFibonacciNumbers Method:

Initializes a counter c to 0.

Iterates through the array arr.

For each number i in the array, checks if i is a Fibonacci number using the isFib method.

If i is a Fibonacci number, increments the counter c.

Returns the total count of Fibonacci numbers.

-isFib Method:


Uses a loop to generate Fibonacci numbers until the generated number is greater than or equal to n.

The loop generates Fibonacci numbers like this:
a starts at 0 and b starts at 1.
The next Fibonacci number is calculated as the sum of a and b.
a is updated to the current value of b, and b is updated to the new Fibonacci number.

If the generated Fibonacci number equals n, returns true.

Otherwise, returns false.

*/
