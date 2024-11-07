
Rotating an Array
Difficulty: BasicAccuracy: 44.48%Submissions: 115K+Points: 1
Given an array arr[]. The task is to rotate the array by d elements where d ≤ arr.size.

Examples:

Input: arr[] = [-1, -2, -3, 4, 5, 6, 7], d = 2
Output: [-3, 4, 5, 6, 7, -1, -2]
Explanation: 
Rotate by 1: [-2, -3, 4, 5, 6, 7, -1]
Rotate by 2: [-3, 4, 5, 6, 7, -1, -2]
Input: arr[] = [1, 3, 4, 2], d = 3 
Output: [2, 1, 3, 4]
Explanation: After rotating the array three times, the first three elements shift one by one to the right.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size ≤ 106
-109 ≤ arr[i] ≤ 109
0 ≤ d ≤ arr.size

```

import java.util.*;

public class tUf {

    // Function to Reverse the array
    static void reverse(int arr[], int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void leftRotate(int arr[], int n, int d) {

        if (n == 0) return;

        // Get the effective number of rotations:
        d = d % n;

        //step 1:
        reverse(arr, 0, d - 1);

        //step 2:
        reverse(arr, d, n - 1);

        //step 3:
        reverse(arr, 0, n - 1);
    }

    public static void main(String args[]) {
        int n = 7;
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int d = 3;

        System.out.println("Before rotation:");
        for (int i = 0; i < n; i++)
            System.out.print( arr[i] + " ");
        System.out.println();

        leftRotate(arr, n, d);
        System.out.println("After rotation:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}   

```

Optimized Approach(without using any extra space): Using “Reversal Algorithm” 
This is a straightforward method. The steps are as follows:

Step 1: Reverse the subarray with the first d elements (reverse(arr, arr+d)).
Step 2: Reverse the subarray with the last (n-d) elements (reverse(arr+d, arr+n)).
Step 3: Finally reverse the whole array (reverse(arr, arr+n)).
Assume the given array is {1,2,3,4,5,6,7} and d = 3.

![Image](https://static.takeuforward.org/wp/uploads/2023/03/3.jpg)

Time Complexity: O(d)+O(n-d)+O(n) = O(2*n), where n = size of the array, d = the number of rotations. Each term corresponds to each reversal step.

Space Complexity: O(1) since no extra space is required.
