/*
Modify the Array
Difficulty: EasyAccuracy: 29.5%Submissions: 39K+Points: 2
Given an array arr. Return the modified array in such a way that if the current and next numbers are valid numbers and are equal then double the current number value and replace the next number with 0. After the modification, rearrange the array such that all 0's are shifted to the end.

Note:

Assume ‘0’ as the invalid number and all others as a valid number.
Modify on the given array arr itself.
The sequence of the valid numbers is present in the same order.
Example:

Input: arr[] = [2, 2, 0, 4, 0, 8] 
Output: [4, 4, 8, 0, 0, 0] 
Explanation: At index 0 and 1 both the elements are the same. So, we will change the element at index 0 to 4 and the element at index 1 is 0 then we will shift all the zeros to the end of the array. So, the array will become [4, 4, 8, 0, 0, 0].
Input: arr[] = [0, 2, 2, 2, 0, 6, 6, 0, 0, 8] 
Output: [4, 2, 12, 8, 0, 0, 0, 0, 0, 0]
Explanation: At index 5 and 6 both the elements are the same. So, we will change the element at index 5 to 12 and the element at index 6 is 0. We will change the element at index 1 to 4 and the element at index 2 is 0. Then we shift all the zeros to the end of the array. So, array will become [4, 2, 12, 8, 0, 0, 0, 0, 0, 0].
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 106
*/
import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        int n = arr.length;

        // Step 1: Double current value and set next to 0 if current == next
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != 0 && arr[i] == arr[i + 1]) {
                arr[i] *= 2;
                arr[i + 1] = 0;
                i++; // Skip the next element as it's now 0
            }
        }

        // Step 2: Shift all 0s to the end
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }
        while (index < n) {
            arr[index++] = 0;
        }

        // Convert array to ArrayList
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr1[] = {2, 2, 0, 4, 0, 8};
        ArrayList<Integer> result1 = sol.modifyAndRearrangeArr(arr1);
        System.out.println(result1);

        int arr2[] = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8};
        ArrayList<Integer> result2 = sol.modifyAndRearrangeArr(arr2);
        System.out.println(result2);
    }
}

/*
---Import Statements:

import java.util.ArrayList;
This imports the ArrayList class, which allows us to create dynamic arrays that can grow and shrink in size.

---Class and Method Definition:

class Solution {    
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
You define a class Solution with a static method modifyAndRearrangeArr which takes an array of integers as input and returns an ArrayList of integers.

---Modifying Elements:

int n = arr.length;
for (int i = 0; i < n - 1; i++) {            
    if (arr[i] != 0 && arr[i] == arr[i + 1]) {                
        arr[i] *= 2;                
        arr[i + 1] = 0;                
        i++; // Skip the next element as it's now 0            
    }        
}
The length of the array n is stored.

The for loop iterates through the array from the start to the second-to-last element.

--Inside the loop:

It checks if the current element is not 0 and is equal to the next element.

If they are equal, the current element’s value is doubled, and the next element is set to 0.

The loop variable i is incremented by 1 to skip over the next element since it has been set to 0.

---Shifting 0s to the End:

int index = 0;
for (int i = 0; i < n; i++) {            
    if (arr[i] != 0) {                
        arr[index++] = arr[i];            
    }        
}        
while (index < n) {            
    arr[index++] = 0;        
}

An index variable is initialized to keep track of the position where the next non-zero element should be placed.

The first for loop iterates through the array and moves all non-zero elements to the front.

The while loop fills the remaining positions in the array with 0's.

---Converting to ArrayList:

ArrayList<Integer> res = new ArrayList<>();
for (int i = 0; i < n; i++) {            
    res.add(arr[i]);        
}
return res;
An ArrayList named res is created.

A for loop iterates through the modified array and adds each element to the ArrayList.

The ArrayList is then returned.

---Main Method:

public static void main(String[] args) {
    Solution sol = new Solution();

    int arr1[] = {2, 2, 0, 4, 0, 8};
    ArrayList<Integer> result1 = sol.modifyAndRearrangeArr(arr1);
    System.out.println(result1);

    int arr2[] = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8};
    ArrayList<Integer> result2 = sol.modifyAndRearrangeArr(arr2);
    System.out.println(result2);
}
The main method creates an instance of the Solution class.

Two example arrays are defined (arr1 and arr2).

The modifyAndRearrangeArr method is called with each array, and the results are printed.

This code modifies the array by doubling the value of elements that are equal to their next element, setting the next element to 0, and then moving all 0's to the end.
Finally, it returns the modified array as an ArrayList

*/
