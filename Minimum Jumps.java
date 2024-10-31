/*

Minimum Jumps
Difficulty: MediumAccuracy: 11.91%Submissions: 899K+Points: 4
Given an array arr[] of non-negative integers. Each array element represents the maximum length of the jumps that can be made forward from that element. This means if arr[i] = x, then we can jump any distance y such that y ≤ x. Find the minimum number of jumps to reach the end of the array starting from the first element. If an element is 0, then you cannot move through that element.

Note:  Return -1 if you can't reach the end of the array.

Examples : 

Input: arr[] = [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
Output: 3 
Explanation: First jump from 1st element to 2nd element with value 3. From here we jump to 5th element with value 9, and from here we will jump to the last. 
Input: arr = [1, 4, 3, 2, 6, 7]
Output: 2 
Explanation: First we jump from the 1st to 2nd element and then jump to the last element.
Input: arr = [0, 10, 20]
Output: -1
Explanation: We cannot go anywhere from the 1st element.
Constraints:
2 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 105

*/

class Solution {
    static int minJumps(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        
        if (arr[0] == 0) {
            return -1;
        }
        
        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;
        
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) {
                return jumps;
            }
            
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;
            
            if (steps == 0) {
                jumps++;
                
                if (i >= maxReach) {
                    return -1;
                }
                
                steps = maxReach - i;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] arr2 = {1, 4, 3, 2, 6, 7};
        int[] arr3 = {0, 10, 20};
        
        System.out.println(minJumps(arr1)); // Output: 3
        System.out.println(minJumps(arr2)); // Output: 2
        System.out.println(minJumps(arr3)); // Output: -1
    }
}


/*





*/
