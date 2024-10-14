/*
Sort in specific order
Difficulty: EasyAccuracy: 52.55%Submissions: 40K+Points: 2
Given an array arr[] of positive integers. Your task is to sort them so that the first part of the array contains odd numbers sorted in descending order, and the rest of the portion contains even numbers sorted in ascending order.

Examples:

Input: arr[] = [1, 2, 3, 5, 4, 7, 10]
Output: [7, 5, 3, 1, 2, 4, 10]
Explanation: 7 5 3 1 are odds in descending order and 2 4 10 are evens in ascending order.
Input: arr[] = [0, 4, 5, 3, 7, 2, 1]
Output: [7, 5, 3, 1, 0, 2, 4]
Explanation: 7 5 3 1 are odds in descending order and 0 2 4 are evens in ascending order.
Expected Time Complexity:  O(nlog(n))
Expected Auxiliary Space:  O(1)

Constraints:

1 ≤ arr.size() ≤ 105
0 <= arri <= 1018
*/

class Solution {

    public void sortIt(Long arr[]) {
        ArrayList<Long>li1=new ArrayList<>();
        ArrayList<Long>li2=new ArrayList<>();
        
        for(long i:arr){
            if(i%2==0) li2.add(i);
            else li1.add(i);
        }
        
        Collections.sort(li1);
        Collections.sort(li2);
        
        int k=0;
        for(int i=li1.size()-1;i>=0;i--){
            arr[k++]=li1.get(i);
        }
        for(int i=0;i<li2.size();i++){
            arr[k++]=li2.get(i);
        }
    }
}

/*
Step 1: Separate Odd and Even Numbers

ArrayList<Long> li1 = new ArrayList<>();
ArrayList<Long> li2 = new ArrayList<>();

for (long i : arr) {
    if (i % 2 == 0) {
        li2.add(i); // Add even numbers to li2
    } else {
        li1.add(i); // Add odd numbers to li1
    }
}

Create Two Lists: li1 for odd numbers and li2 for even numbers.
Loop Through Array: For each number in the array, check if it's even or odd.
Even Numbers: Add to li2.
Odd Numbers: Add to li1.

Step 2: Sort the Lists

Collections.sort(li1); // Sort odd numbers in ascending order
Collections.sort(li2); // Sort even numbers in ascending order

Sort li1: This list is sorted in ascending order.
Sort li2: This list is also sorted in ascending order.

Step 3: Refill the Original Array

int k = 0;

// Add odd numbers in descending order
for (int i = li1.size() - 1; i >= 0; i--) {
    arr[k++] = li1.get(i);
}

// Add even numbers in ascending order
for (int i = 0; i < li2.size(); i++) {
    arr[k++] = li2.get(i);
}

Initialize k: A variable to keep track of the index in the original array.
Add Odd Numbers: Loop through li1 in reverse order (to get descending order) and place them in the original array.
Add Even Numbers: Loop through li2 in normal order and place them in the original array.

Summary:

Separate Numbers: Divide the array into odd and even numbers.

Sort Lists: Sort odd numbers in ascending order and even numbers in ascending order.

Merge Back: Place sorted odd numbers in descending order followed by sorted even numbers back into the original array.

This ensures that the array is arranged with odd numbers in descending order followed by even numbers in ascending order.


*/
