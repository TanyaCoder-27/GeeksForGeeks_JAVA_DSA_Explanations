/*

Operating an array
Difficulty: EasyAccuracy: 25.06%Submissions: 40K+Points: 2
Given an array arr, complete the following three functions:
searchEle: This function searches for an element x in the array arr. It should return a boolean value - true if the element is found, and false otherwise.
insertEle: This function inserts an element y at index yi in the array. true will be printed if the insertion is done correctly, and false otherwise.
deleteEle: This function deletes the first occurrence of an element z in the array. true will be printed if the deletion is done correctly, and false otherwise.

 Note: 0-based indexing is followed.

Example:

Input: arr[] = [2, 4, 1, 0, 2], x=1, y=2, yi=2, z=0
Ouput: true true true
Explanation: As x=1 is present in the array, so return 1. After inserting y=2 at yi=2th index, the array becomes 2,4,2,1,0,2. After deleting z=0, the array becomes 2,4,2,1,2
Input: arr[] = [17, 15, 8, 9, 12], x=10, y=6, yi=2, z=5
Ouput: false true true
Explanation: As x=10 is not present in the array, so return 0. After inserting y=6 at yi=2th index, the array becomes 17,15,6,8,9,12. As z=5 not present, the arrays stays as 17,15,6,8,9,12.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= arr.size() <= 1500
1 <= x, y, z<= 103
0 <= yi< arr.size()
0 <= arri <= 105

*/

import java.util.List;

class Solution {
    public boolean searchEle(List<Integer> arr, int x) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == x) {
                return true;
            }
        }
        return false;
    }

    public void insertEle(List<Integer> arr, int y, int yi) {
        if (yi >= 0 && yi <= arr.size()) {                //optional
            arr.add(yi, y);
        }
    }

    public void deleteEle(List<Integer> arr, int z) {
        Integer element = z;     // Convert primitive int to Integer(Wrapper Class)object to use remove(Object) ---> Autoboxing!!! ; not by index
        arr.remove(element);
    }
}
