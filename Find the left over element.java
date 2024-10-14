/*
Find the left over element
Difficulty: EasyAccuracy: 46.94%Submissions: 43K+Points: 2
Given an array arr, the size is reduced by 1 element at each step. In the first step, the maximum element would be removed, while in the second step, the minimum element of the remaining array would be removed, in the third step again the maximum, and so on. Continue this till the array contains only one element. And find the final element remaining in the array.

Examples:

Input:arr[] = [7, 8, 3, 4, 2, 9, 5]
Ouput: 5
Explanation:In first step '9' would be removed, in 2nd step '2' will be removed, in third step '8' will be removed and so on. So the last remaining element would be '5'.  
Input:arr[] = [8, 1, 2, 9, 4, 3, 7, 5]
Ouput: 4
Explanation: In first step '9' would be removed, in 2nd step '1' will be removed, in third step '8' will be removed and so on. So the last remaining element would be '4'. 
Expected Time Complexity: O(n log(n))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 106
*/

class Solution {
    public static int leftElement(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        boolean removeMax = true; // Start by removing the maximum element
        int left = 0, right = n - 1; // Use two pointers to track the boundaries

        while (left < right) {
            if (removeMax) {
                right--; // Remove the max element
            } else {
                left++; // Remove the min element
            }
            removeMax = !removeMax; // Alternate between removing max and min
        }

        // The last remaining element
        return arr[left];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr1 = {7, 8, 3, 4, 2, 9, 5};
        System.out.println(sol.leftElement(arr1)); // Output: 5

        int[] arr2 = {8, 1, 2, 9, 4, 3, 7, 5};
        System.out.println(sol.leftElement(arr2)); // Output: 4
    }
}

/*
Explanation:
---Sort the Array:
Arrays.sort(arr);  This sorts the array in ascending order.

---Initialize Variables:
boolean removeMax = true;
int left = 0, right = n - 1;

removeMax: A boolean variable to alternate between removing the maximum and minimum elements.
left: Pointer to the start of the array.
right: Pointer to the end of the array.

---Loop to Remove Elements:

while (left < right) {      //left == right means only one element is present in the array.
    if (removeMax) {
        right--;            // Remove the max element
    } else {
        left++;            // Remove the min element
    }
    removeMax = !removeMax; // Alternate between removing max and min
}
In each iteration, check whether to remove the maximum or minimum element based on the removeMax flag.
Adjust the left or right pointers accordingly.
Alternate the removeMax flag.

---Return the Last Remaining Element:
return arr[left];
After the loop, left and right pointers converge on the last remaining element in the array.

This method ensures that the algorithm runs efficiently with a time complexity of O(nlog⁡n)due to sorting and O(1)auxiliary space.  🚀

*/
