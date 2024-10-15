/*
Transform the array
Difficulty: EasyAccuracy: 21.59%Submissions: 15K+Points: 2
Given an array arr[] containing integers, zero is considered an invalid number, and the rest of the other numbers are valid. If the two nearest valid numbers are equal, then double the value of the first one and make the second number 0. At last, move all the valid numbers on the left.

Examples:

Input: arr[] = [2, 4, 5, 0, 0, 5, 4, 8, 6, 0, 6, 8]
Output: [2, 4, 10, 4, 8, 12, 8, 0, 0, 0, 0, 0]
Explanation: After performing above given operation we get array as [2, 4, 10, 0, 0, 0, 4, 8, 12, 0, 0, 8], then shifting all zero's to the right, we get resultant array as - [2, 4, 10, 4, 8, 12, 8, 0, 0, 0, 0, 0] 
Input: arr[] = [0, 0]
Output: [0, 0]
Explanation: All elements in the array are invalid .
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ arr.size()≤ 106
1 ≤ arr[i]≤ 106

*/

class Solution {
    public ArrayList<Integer> valid(int arr[]) {
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                if(j>0&&arr[i]==arr[j-1]){
                    arr[j-1] *=2;
                    arr[i]=0;
                }else{
                    arr[j++]=arr[i];
                }
            }
        }
        while(j<arr.length){
            arr[j++]=0;
        }
         ArrayList<Integer> result = new ArrayList<>();
        for (int num : arr) {
            result.add(num);
        }
        
        return result;
    }
} 

/*
Initialization:

An index j is initialized to 0. This index will be used to track the position for non-zero elements in the array.

First Loop (Merging and Compaction):

The loop iterates through each element in the array.

If the current element arr[i] is non-zero:

It checks if there is a previous element (j > 0) and if the current element is equal to the previous element (arr[i] == arr[j-1]).

If they are equal, it doubles the value of the previous element (arr[j-1] *= 2) and sets the current element to zero (arr[i] = 0).

If they are not equal, it moves the current element to the position indicated by j and increments j (arr[j++] = arr[i]).

Second Loop (Filling with Zeros):

After the first loop, the array has merged elements and compacted non-zero elements to the front.

This loop fills the remaining positions in the array with zeros (arr[j++] = 0).

Creating and Filling Result ArrayList:

A new ArrayList named result is created.

The code iterates through the modified array, adding each element to result.

Return Result:

Finally, the result ArrayList is returned, containing the merged and rearranged elements.

This code effectively merges adjacent equal elements, moves all non-zero elements to the front, and fills the remaining positions with zeros in the array. It then transfers these elements to an ArrayList and returns it.

*/
