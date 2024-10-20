/*

Tracks
Difficulty: EasyAccuracy: 21.48%Submissions: 4K+Points: 2
You are given an array arr[] representing the heights of pillars on a track. The track is considered valid if it satisfies the following conditions:

1)There is a constant, non-zero difference between the heights of consecutive pillars.

2)The height of the middle pillar must be exactly 1.

3)The number of pillars on both sides of the middle pillar must be equal, and the heights of the corresponding pillars on each side must be identical.

Return true if the track is valid, otherwise, return false.

Examples:

Input: arr[] = [2, 1, 2]
Output: true
Explanation: The track is valid because it has a constant height difference of 1, the middle pillar is 1, and both sides of the middle pillar have an equal number of identical height pillars.
Input: arr[] = [4, 3, 2, 3, 4]
Output: false
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
3 <= arr.size()<= 106
1 <= arr[i] <= 106

*/

class Solution {

    public boolean ValidTrack(int[] arr) {
        int n = arr.length;
        int mid = n%2==1&&arr[n/2]!=1? 0:1;
        if(mid==0) return false;
        
        int l = 0, r = n-1, p1 = Integer.MAX_VALUE, p2 = Integer.MAX_VALUE;
        
        while(l<r){
            if(arr[r]!=arr[l]){
                return false;
            }
            if(p1!=Integer.MAX_VALUE&&p1-arr[l]==0) return false;
            if(p2!=Integer.MAX_VALUE&&p2-arr[r]==0) return false;
            p1 = arr[l];
            p2 = arr[r];
            l++;
            r--;
            
        }
        return true;
    }
}

/*
Initial Check:

First, you check if the length of the array is odd and if the middle element is not 1. If both conditions are true, you immediately return false, meaning the track is invalid.

Setting Up:

You set up two pointers: one starting from the beginning (l) and one from the end (r) of the array. You also have two variables (p1 and p2) to keep track of the previous elements as you move inward.

Symmetry Check:

You then enter a loop where you check if the elements at the two pointers (l and r) are the same. If they are not, you return false.

Adjacent Duplicate Check:

You also check if the current element is the same as the previous element you stored. If it is, you return false. This is to ensure there are no duplicate adjacent elements.

Update and Move Inward:

If both checks pass, you update the previous elements to the current elements and move the pointers inward (increment l and decrement r).

Final Check:

If you successfully move through the array without returning false, you return true, indicating the track is valid.

Basically, the code is checking if the array is symmetric, doesn't have duplicate adjacent elements, and, for odd-length arrays, ensures the middle element is 1.

*/
