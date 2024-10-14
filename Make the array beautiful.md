
# Make the array beautiful
Difficulty: EasyAccuracy: 49.96%Submissions: 53K+Points: 2
## Given an array of negative and non-negative integers. You have to make the array beautiful. An array is beautiful if two adjacent integers, arr[i] and arr[i+1] are either negative or non-negative. And you can do the following operation any number of times until the array becomes beautiful.
## If two adjacent integers are different i.e. one of them is negative and other is non-negative, remove them.
## Return the beautiful array after performing the above operation.

## Note:An empty array is also a beautiful array. There can be many adjacent integers which are different as stated above. So remove different adjacent integers as described above from left to right.

Example 1:

Input: 4 2 -2 1
Output: 4 1
Explanation: As at indices 1 and 2 , 2 and -2 have
different sign, they are removed. And the  the final
array is: 4 1.
Example 2:

Input: 2 -2 1 -1
Output: []
Explanation: As at indices 0 and 1, 2 and -2 have
different sign, so they are removed. Now the array
is 1 -1.Now 1 and -1 are also removed as they have
different sign. So the final array is empty. 
Your Task:
You don't need to read input or print anything. Your task is to complete the function makeBeautiful() which takes an array as an input parameter and returns an array.

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)


Constraints:
1 <= size of the array <= 105
-105 <= arr[i] <= 105

## Approach :

The approach to solve this problem is to use a stack to keep track of the integers in the array.
We can iterate over the array and push each integer onto the stack one by one. 
For each integer, we check if it has a different sign than the integer at the top of the stack.
If it does, we pop the top integer from the stack, since it cannot form a beautiful pair with the new integer. 
If the integer has the same sign as the integer at the top of the stack, we push it onto the stack. We repeat this process until we have iterated over all the integers in the array.

Once we have processed all the integers in the array, the stack will contain only integers with the same sign adjacent to each other.
We can then pop the integers from the stack and append them to a new List in reverse order, to get the beautiful array.

![image](https://github.com/user-attachments/assets/a768b28b-071b-4d7c-87c8-83f916f8a36d)




In above diagram , I have solved for one example using stack  . we push elements 4 and 2 , then we get -2 which is having different sign than 2 which is at the top of the stack .
In this scenario , we pop top item from the stack then we insert 1 because now top of stack is 4 and here both have the same sign .

## Algorithm :

Create an empty stack to store the elements.
Traverse the input ArrayList from left to right and for each element: a. If the stack is empty, push the element onto the stack. b. If the element has a different sign than the top element of the stack, pop the top element from the stack. c. Otherwise, push the element onto the stack.
Pop the elements from the stack and add them to a new ArrayList.
Reverse the order of the elements in the new ArrayList.
Return the new ArrayList.
 

## Time Complexity :

The time complexity of the given solution is O(n), where n is the size of the input ArrayList.

The traversal of the input ArrayList takes O(n) time. For each element of the input ArrayList, there is at most one push operation and one pop operation on the stack, which takes constant time. Therefore, the time complexity of the stack operations is also O(n).

Finally, the reversal of the elements in the output ArrayList takes O(n) time.

Hence, the overall time complexity of the solution is O(n).

 
## Java Code :

public static ArrayList<Integer> makeBeautiful(int[] arr) {
        // code here
         // Create a stack to store the integers
        Stack<Integer> stack = new Stack<>();
        
        // Iterate over the input array
        for(int num : arr) {
            // If the stack is empty, push the integer onto the stack
            if(stack.empty()) {
                stack.push(num);
            } else {
                // If the integer has a different sign than the top of the stack, pop the top element
                if((stack.peek() >= 0 && num < 0) || (stack.peek() < 0 && num >= 0)) {
                    stack.pop();
                } else {
                    // Otherwise, push the integer onto the stack
                    stack.push(num);
                }
            }
        }
        
        // Create a new ArrayList to store the result
        ArrayList<Integer> result = new ArrayList<>();
        
        // Pop the elements from the stack and add them to the result ArrayList
        while(!stack.empty()) {
            result.add(stack.peek());
            stack.pop();
        }
        
        // Reverse the order of the elements in the result ArrayList
        Collections.reverse(result);
        
        // Return the result ArrayList
        return result;
    }
