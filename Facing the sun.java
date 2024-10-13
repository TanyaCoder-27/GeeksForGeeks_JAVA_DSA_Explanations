/*
Facing the sun
Difficulty: EasyAccuracy: 45.54%Submissions: 83K+Points: 2
Given an array height representing the heights of buildings. You have to count the buildings that will see the sunrise (Assume the sun rises on the side of the array starting point).
Note: The height of the building should be strictly greater than the height of the buildings left in order to see the sun.


Examples :

Input: height = [7, 4, 8, 2, 9]
Output: 3
Explanation: As 7 is the first element, it can see the sunrise. 4 can't see the sunrise as 7 is hiding it. 8 can see. 2 can't see the sunrise. 9 also can see
the sunrise.
Input: height = [2, 3, 4, 5]
Output: 4
Explanation: As 2 is the first element, it can see the sunrise.  3 can see the sunrise as 2 is not hiding it. Same for 4 and 5, they also can see the sunrise.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ height.size() ≤ 106
1 ≤ heighti ≤ 108
*/

class Solution {
    // Returns count buildings that can see sunlight
    public int countBuildings(int[] height) {
        
        int max_ele = height[0];
        int c=1;
        
        for(int i=1;i<=height.length-1;i++){
            if(height[i]>max_ele){
                max_ele = height[i];
                c++;
            }
        }
        return c;
        
    }
}

/*
Explanation:
Step 1: Method Definition
This method countBuildings takes an array of building heights and returns the count of buildings that can see sunlight.

Step 2: Initialize Variables
max_ele is initialized to the height of the first building (height[0]). This keeps track of the tallest building encountered so far.
c is initialized to 1 because the first building can always see sunlight.

Step 3: Loop Through Array
The loop starts from the second building (index 1) and goes through the entire array.

Step 4: Check If Current Building Can See Sunlight
If the current building's height (height[i]) is greater than max_ele, it means this building can see sunlight.
Update max_ele to the current building's height.
Increment c to count this building as one that can see sunlight.

Step 5: Return the Count
Finally, the method returns c, which is the total count of buildings that can see sunlight.

The code initializes the maximum height with the first building's height and starts counting buildings that are taller than any previously encountered buildings. Each time a taller building is found, it updates the maximum height and increments the count. This way, we get the total count of buildings that can see sunlight.


*/
