# Ceil The Floor
Difficulty: EasyAccuracy: 43.76%Submissions: 109K+Points: 2
## Given an unsorted array arr[] of integers and an integer x, find the floor and ceiling of x in arr[].

## Floor of x is the largest element which is smaller than or equal to x. Floor of x doesn’t exist if x is smaller than smallest element of arr[].
## Ceil of x is the smallest element which is greater than or equal to x. Ceil of x doesn’t exist if x is greater than greatest element of arr[].

Return an array of integers denoting the [floor, ceil]. Return -1 for floor or ceiling if the floor or ceiling is not present.

## Examples:

Input: x = 7 , arr[] = [5, 6, 8, 9, 6, 5, 5, 6]
Output: 6, 8
Explanation: Floor of 7 is 6 and ceil of 7 is 8.
Input: x = 10 , arr[] = [5, 6, 8, 8, 6, 5, 5, 6]
Output: 8, -1
Explanation: Floor of 10 is 8 but ceil of 10 is not possible.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

## Constraints :
1 ≤ arr.size ≤ 105
1 ≤ arr[i], x ≤ 106


## Java Code:
```
class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        int floor = -1;
        int ceil = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x) {
                floor = Math.max(floor, arr[i]);
            }
            if (arr[i] >= x) {
                ceil = Math.min(ceil, arr[i]);
            }
        }

        if (ceil == Integer.MAX_VALUE) {
            ceil = -1; // Set to -1 if it was not updated
        }

        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {5, 6, 8, 9, 6, 5, 5, 6};
        int x1 = 7;
        int[] result1 = sol.getFloorAndCeil(x1, arr1);
        System.out.println("Floor: " + result1[0] + ", Ceil: " + result1[1]); // Output: 6, 8

        int[] arr2 = {5, 6, 8, 8, 6, 5, 5, 6};
        int x2 = 10;
        int[] result2 = sol.getFloorAndCeil(x2, arr2);
        System.out.println("Floor: " + result2[0] + ", Ceil: " + result2[1]); // Output: 8, -1
    }
}
```

## Explanation:

Floor: We use Math.max to keep track of the largest element less than or equal to x.

Ceil: We use Math.min to keep track of the smallest element greater than or equal to x.

Initialize ceil to a high value initially (e.g., Integer.MAX_VALUE) so that the Math.min operation can work correctly,if ceil is initialized to -1, the Math.min(ceil, arr[i]) will always return -1 because -1 is less than any positive integer in the array.
