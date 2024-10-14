/*
Greater on right side
Difficulty: EasyAccuracy: 58.34%Submissions: 42K+Points: 2
You are given an array arr. Replace every element with the next greatest element (the greatest element on its right side) in the array. Note: There is no element next to the last element, so replace it with -1.

Example:

Input: arr[] = [16, 17, 4, 3, 5, 2]
Output: [17, 5, 5, 5, 2, -1]
Explanation: For 16 the greatest element 
on its right is 17. For 17 it's 5. 
For 4 it's 5. For 3 it's 5. For 5 it's 2. 
For 2 it's -1(no element to its right). 
Input: arr[] = [2, 3, 1, 9]
Output: [9, 9, 9, -1]
Explanation: For each element except 9 the
greatest element on its right is 9.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= arr.size() <= 105
1 <= arr[i]<= 106
*/

import java.util.ArrayList;
import java.util.Arrays;

class Solution {    
    static ArrayList<Integer> nextGreatest(int arr[]) {        
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) {
            result.add(0); // Initialize the result list with zeros
        }
        
        // Initialize the last element to -1 since there's no element to its right
        int maxFromRight = -1;

        // Start from the last element and move to the left
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];
            result.set(i, maxFromRight); // Set the current element to the max value from the right
            if (current > maxFromRight) {
                maxFromRight = current; // Update the max value from the right if current is greater
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {16, 17, 4, 3, 5, 2};
        ArrayList<Integer> result = sol.nextGreatest(arr);
        System.out.println(result); // Output: [17, 5, 5, 5, 2, -1]
    }
}

/*
Step-by-Step Explanation:

---Initialize the Result List:

ArrayList<Integer> result = new ArrayList<>(n);
for (int i = 0; i < n; i++) {
    result.add(0); // Initialize the result list with zeros
}

We create an ArrayList named result with the same size as the input array arr.
We initialize this list with zeros to ensure it has the correct size and can be updated later.

---Initialize the Last Element:

int maxFromRight = -1;

We initialize a variable maxFromRight to -1. This variable will keep track of the maximum value to the right of the current element as we iterate through the array.

---Loop to Update Elements:

for (int i = n - 1; i >= 0; i--) {
    int current = arr[i];
    result.set(i, maxFromRight); // Set the current element to the max value from the right
    if (current > maxFromRight) {
        maxFromRight = current; // Update the max value from the right if current is greater
    }
}

Start from the Last Element: We start the loop from the last element of the array (i = n - 1) and move towards the first element (i = 0).
Current Element: For each iteration, we store the current element in a variable current.
Set the Result: We set the current position in the result list to maxFromRight. This means we are replacing the current element with the maximum value found to its right.
Update maxFromRight: If the current element is greater than maxFromRight, we update maxFromRight to the current element. This ensures that maxFromRight always holds the maximum value to the right of the current element.

---Return the Result:
return result;
Finally, we return the result list, which now contains the next greatest elements for each position in the original

*/
