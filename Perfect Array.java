/*
Perfect Array
Difficulty: BasicAccuracy: 32.97%Submissions: 7K+Points: 1
Given an array arr[] of non-negative integers, determine whether the array is perfect. An array is considered perfect if it first strictly increases, then remains constant, and finally strictly decreases. Any of these three parts can be empty.

Examples:
Input: arr[] = [1, 8, 8, 8, 3, 2]
Output: true
Explanation: The array [1, 8, 8, 8, 3, 2] first increases in the range [0, 1], stays constant in the range [1, 3], and then decreases in the range [3, 4]. Thus, the array is perfect.
Input: arr[] = [1, 1, 2, 2, 1]
Output: false
Explanation: The array does not follow the required pattern of strictly increasing, constant, and then strictly decreasing.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 108
*/
class Solution {
    public boolean isPerfect(int[] arr) {
        int i=1,n=arr.length;
        while(i<n && arr[i]>arr[i-1]){
            i+=1;
        }
        while(i<n && arr[i]==arr[i-1]){
            i+=1;
        }
        while(i<n && arr[i]<arr[i-1]){
            i+=1;
        }
        if(i==n){
            return true;
        }
        return false;
    }
}

/*
Step 1: Initialization

int i = 1, n = arr.length;
i is initialized to 1, representing the current index in the array.
n is initialized to the length of the array arr.

Step 2: Ascending Phase

while (i < n && arr[i] > arr[i - 1]) {
    i += 1;
}
This loop runs as long as i is less than n and the current element arr[i] is greater than the previous element arr[i - 1].
This represents an ascending phase where the array values are increasing.

Step 3: Plateau Phase

while (i < n && arr[i] == arr[i - 1]) {
    i += 1;
}
This loop runs as long as i is less than n and the current element arr[i] is equal to the previous element arr[i - 1].
This represents a plateau phase where the array values are constant.

Step 4: Descending Phase

while (i < n && arr[i] < arr[i - 1]) {
    i += 1;
}
This loop runs as long as i is less than n and the current element arr[i] is less than the previous element arr[i - 1].
This represents a descending phase where the array values are decreasing.

Step 5: Check for Perfection

if (i == n) {
    return true;
}
return false;
After the loops, if i has reached the length of the array (n), it means the entire array follows the pattern of ascending, plateau, then descending. In this case, return true.

Otherwise, return false.

This code checks if the given array arr forms a "perfect" sequence by increasing, potentially having a constant plateau, and then decreasing. If the whole array follows this pattern, it returns true; otherwise, it returns false.

*/
