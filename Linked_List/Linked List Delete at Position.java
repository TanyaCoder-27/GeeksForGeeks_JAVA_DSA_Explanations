/*
Linked List Delete at Position
Difficulty: EasyAccuracy: 50.06%Submissions: 14K+Points: 2Average Time: 15m
Given a linked list of size n, you have to delete the node at position pos of the linked list and return the new head. The position of initial node is 1.

Example 1:

Input:
LinkedList: 1->2->3->4->5
pos = 4
Output: 1 2 3 5
Example 2:

Input:
LinkedList: 2->5->7->8->99->100
pos = 6
Output: 2 5 7 8 99
Your Task:
The task is to complete the function deleteAtPosition() which takes head reference and pos as argument and returns reference to the new head node, which is then used to display the list. The printing is done automatically by the driver code.

Expected Time Complexity: O(pos).
Expected Auxiliary Space: O(1).

Constraints:
2 <= number of nodes <= 103
1 <= pos <= n
*/

//User function Template for Java


/*
class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = next;
    }
}
*/

class Delete
{
    Node deleteAtPosition(Node head, int pos)
    {
        if (head == null) {
            return null; // If the list is empty, return null.
        }
        
        // If the position is 1, remove the head node
        if (pos == 1) {
            return head.next; // New head is the next node
        }
        
        Node curr = head;
        int count = 1;

        // Traverse the list to find the (pos-1)th node
        while (curr != null && count < pos - 1) {
            curr = curr.next;
            count++;
        }

        // If the (pos-1)th node is null or its next is null, return head (invalid position)
        if (curr == null || curr.next == null) {
            return head;
        }

        // Skip the node at position pos
        curr.next = curr.next.next;
        
        return head; // Return the updated head of the list
    }
}
