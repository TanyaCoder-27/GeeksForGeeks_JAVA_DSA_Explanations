/*
Maximum number of zeroes
Difficulty: EasyAccuracy: 14.3%Submissions: 25K+Points: 2
Given an array arr[] of integers, the task is to find the number that has the maximum number of zeroes. If there are no zeroes then print -1.

Note: If there are multiple numbers with the same (max) number of zeroes then print the Maximum number among them.

Examples:

Input: arr[] = [10, 20, 3000, 9999, 200]
Output: 3000
Explanation: 3000 contains 3 zero's in it.
Input: arr[] = [1, 2, 3, 4]
Output: -1
Explanation: No zero is present.
Expected Time Complexity: O(n*log10(max(arr[i])). 
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ arr.size() ≤ 105
1 < arr[i] < 10100
*/

//Method:1 [DON'T USE THIS IN GEEKSFORFEEKS PLATFORM]
class Solution {
    //import java.util.*; ---only imported ArrayList in the driver code of GFG, so don't use this code in GFG  ***ALWAYS SEE THE DRIVER CODE ONCE BEFORE WRITING THE CODE INORDER TO CHECK WHETHER YOUR DATA STRUCTURE IS IMPORTED OR NOT***
    public String maxZero(ArrayList<String> arr) {
        //arr -> each element -> each digit check to count no of zeros
        //return number with maximum no of zeros
        
        HashMap<String,Integer> freq = new HashMap<>();
        ArrayList<String> same = new ArrayList<>();
        for(String st : arr){
            freq.put(st,countZeros(st));
        }
        
        int max_freq = Collections.max(freq.values());
        for(String st : freq.keySet()){
            if(freq.get(st)==max_freq){
                same.add(st);
            }
        }
        
        return Collections.max(same);
    }
    
    public static int countZeros(String s){
        int c=0;
        boolean flag= false;
        for(char ch:s.toCharArray()){
            if(ch=='0'){
                flag=true;
                c++;
            }
        }
        if(!flag) return -1;
        return c;
    }
}


//Method:2
class Solution {
    //import java.util.*;
    public String maxZero(ArrayList<String> arr) {
        //arr -> each element -> each digit check to count no of zeros
        //return string with maximum no of zeros
        
        String res = "";
        int count = 0, max = 0;
        for(String s: arr){
           
            for(char c: s.toCharArray()){
                if(c=='0'){
                    count++;
                }
               
            }
           
            if (count > 0 && (count > max || (count >= max && s.length() > res.length()) ||
                (count >= max && s.length() == res.length() && res.compareTo(s)<0))) {
                
                max = count;
                res = s;
            }
            count = 0;
           
        }
        return max>0?res:"-1";
        
    }
}

/* method2 explanation:
---Class and Method Definition:

class Solution {
    public String maxZero(ArrayList<String> arr) {
You’ve defined a class Solution and a method maxZero which takes an ArrayList of strings as input.

---Initialize Variables:

String res = "";
int count = 0, max = 0;
res is a string that will eventually hold the result, the string with the maximum number of zeros.
count tracks the number of zeros in the current string.
max stores the maximum number of zeros found so far across all strings.

---Iterate Through the List:

for (String s : arr) {
    for (char c : s.toCharArray()) {
        if (c == '0') {
            count++;
        }
    }
This outer loop iterates through each string in the arr list.
The inner loop converts each string to a character array and iterates through each character.
For each character that is '0', increment the count.

---Check and Update the Result:

if (count > 0 && (count > max || 
    (count >= max && s.length() > res.length()) || 
    (count >= max && s.length() == res.length() && res.compareTo(s) < 0))) {
    
    max = count;
    res = s;
}
count = 0;
---Conditions to Update res:

Check if count is greater than zero and one of the following:
count is greater than max.
count is equal to max and the current string s is longer than res.
count is equal to max, the lengths are equal, and res is lexicographically smaller than s.

---If any of these conditions are true:

Update max to count.
Update res to the current string s.
Reset count to zero for the next string.

---Return the Result:

return max > 0 ? res : "-1";
}
}
Finally, check if max is greater than zero.
If so, return res which holds the string with the maximum number of zeros.
If not, return "-1", indicating no strings contained zeros.

*/
