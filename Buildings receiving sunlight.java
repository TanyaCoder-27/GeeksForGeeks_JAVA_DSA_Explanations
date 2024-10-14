/*
Buildings receiving sunlight
Difficulty: EasyAccuracy: 40.46%Submissions: 25K+Points: 2
Given the array arr[] of heights of certain buildings that lie adjacent to each other, Sunlight starts falling from the left side of the buildings. If there is a building of a certain height, all the buildings to the right side of it having lesser heights cannot see the sun. The task is to find the total number of buildings that receive sunlight.

Examples:

Input: arr[] = [6, 2, 8, 4, 11, 13]
Output: 4
Explanation: Only buildings of height 6, 8, 11 and 13 can see the sun, hence output is 4.
Input: arr[] = [2, 5, 1, 8, 3]
Output: 3
Explanation: Only buildings of height 2, 5 and 8 can see the sun, hence output is 3.
Input: arr[] = [3, 4, 1, 0, 6, 2, 3]
Output: 3
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arri ≤ 105

*/

class Solution {

    public static int longest(int arr[]) {
        //h = arr[0]
        //buildings that can see the sun -> greater than or equal to h -> return count
        int count = 1; //arr[0] is included in the count
        
        int h = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=h){    //buildings to the right side of it having lesser heights cannot see the sun.
                count++;
                h=arr[i];
            }
        }
        return count;
    }
}
