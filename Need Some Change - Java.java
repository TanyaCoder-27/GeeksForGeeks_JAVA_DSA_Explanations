/*
Need Some Change - Java
Difficulty: EasyAccuracy: 25.97%Submissions: 19K+Points: 2
Now, as you're familiar with operating on arrays, let's do an intricate task. Here, we'll do a swapping of array elements. Given an array arr. The task is to swap every ith element of the array with (i+2)th element.

Examples:

Input: arr[] = [1, 2, 3, 4, 5]
Output: [3, 4, 5, 2, 1]
Explanation: Swapping 1 and 3, makes the array 3 2 1 4 5. Now, swapping 2 and 4, makes the array 3 4 1 2 5. Again, swapping 1 and 5, makes the array 3 4 5 2 1.
Input: arr[] = [2, 4]
Output: [2, 4]
Explanation: There will be no swapping happen.
Expected Time Complexity: O(n)
Expected Auxilary Space: O(1)

Constraints:
1 <= arr.size() <= 106
1 <= arr[i] <= 106
*/

class Solution {
    static void swapElements(int[] arr) {

        for(int i=0;i<arr.length-2;i++){
            int temp = arr[i];
            arr[i]=arr[i+2];
            arr[i+2]=temp;
        }
    }
}
