/*

Find length of Loop
Difficulty: EasyAccuracy: 44.26%Submissions: 243K+Points: 2Average Time: 30m
Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, otherwise return 0.



Note: 'c' is the position of the node which is the next pointer of the last node of the linkedlist. If c is 0, then there is no loop.

Examples:

Input: LinkedList: 25->14->19->33->10->21->39->90->58->45, c = 4
Output: 7
Explanation: The loop is from 33 to 45. So length of loop is 33->10->21->39-> 90->58->45 = 7. 
The number 33 is connected to the last node of the linkedlist to form the loop because according to the input the 4th node from the beginning(1 based indexing) 
will be connected to the last node for the loop.
 
Input: LinkedList: 5->4, c = 0
Output: 0
Explanation: There is no loop.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= no. of nodes <= 106
0 <= node.data <=106
0 <= c<= n-1

*/

/*

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

// Function should return the length of the loop in LL.

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // Add your code here.
        Node fast = head, slow = head;
        
        while(fast != null && fast.next != null ){  //null pointer exception if you exchange the order og && conds
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){   //loop detected
                int cnt = 1;    // started counting from ths node
                slow = slow.next;  // for the conveneice of the while condition
                while(slow != fast){    //count until slow again meets fast
                    cnt++;  //already did slow=slow.next above initially, so increamnet cnt
                    slow = slow.next;
                   
                }
                return cnt;
            }
        }
        return 0; //no loop found to start with, so count =0 will be returned
    }
}
