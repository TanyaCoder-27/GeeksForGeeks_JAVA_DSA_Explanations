/*
Minimum sum of two elements from two arrays
Difficulty: BasicAccuracy: 27.77%Submissions: 7K+Points: 1
Given two arrays arr1[] and arr2[] of the same size, find the minimum sum of two elements such that one element is from arr1[] and the other is from arr2[], and they are not at the same index in their respective arrays.

Examples:

Input: arr1[] = [5, 4, 13, 2, 1], arr2[] = [2, 3, 4, 6, 5]
Output: 3
Explanation: The minimum sum is obtained by taking 1 from arr1[] and 2 from arr2[]. The sum is 1 + 2 = 3.
Input: arr1[] = [5, 4, 13, 1], arr2[] = [3, 2, 6, 1]
Output: 3
Explanation: The minimum sum is obtained by taking 1 from arr1[] and 2 from arr2[]. We can't take 1 from arr2[] as it is at the same index.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr1.size() = arr2.size() ≤ 106
1 ≤ arr1[i], arr2[i] ≤ 105
*/
class Solution {
    public int minSum(int[] arr1, int[] arr2) {
        int min1=arr1[0],min2=arr2[0],index1=0,index2=0;
        
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]<min1){
                min1=arr1[i];
                index1=i;
            }
            if(arr2[i]<min2){
                min2 = arr2[i];
                index2=i;
            }
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        if(index1 != index2){
            return min1+min2;
        }
        return Math.min(min1+arr2[1],min2+arr1[1]);
       
    }
}
/*
Explanation:

Step 1: Initialization
The code starts by initializing the variables min1, min2, index1, and index2:
Here, min1 and min2 are set to the first elements of arr1 and arr2 respectively, while index1 and index2 are set to 0, indicating the initial indices.

Step 2: Finding Minimum Elements
The code then iterates through both arrays to find the minimum elements in each and their respective indices:
For arr1: If the current element is smaller than min1, update min1 and index1.
For arr2: If the current element is smaller than min2, update min2 and index2.

Step 3: Sorting Arrays
Next, both arrays are sorted:

Arrays.sort(arr1);
Arrays.sort(arr2);
This ensures that the smallest elements are at the beginning of each array.

Step 4: Minimum Sum Calculation
Finally, the code checks if the minimum elements from both arrays are at different indices:

If they are at different indices, the sum of these minimum elements is returned.

If the minimum elements are at the same index, the code finds the second smallest element from each array and returns the smaller sum:

min1 + arr2[1]: Sum of the smallest element from arr1 and the second smallest element from arr2.

min2 + arr1[1]: Sum of the smallest element from arr2 and the second smallest element from arr1.

In summary, the code calculates the smallest possible sum by considering both the minimum elements and their indices to avoid overlap.

*/
