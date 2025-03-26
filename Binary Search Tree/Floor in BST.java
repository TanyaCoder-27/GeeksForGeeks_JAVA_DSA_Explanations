/*

Floor in BST
Difficulty: MediumAccuracy: 51.06%Submissions: 101K+Points: 4Average Time: 20m
You are given a BST(Binary Search Tree) with n number of nodes and value x. your task is to find the greatest value node of the BST which is smaller than or equal to x.
Note: when x is smaller than the smallest node of BST then returns -1.

Examples:

Input:
n = 7               2
                     \
                      81
                    /     \
                 42       87
                   \       \
                    66      90
                   /
                 45
x = 87
Output: 87
Explanation: 87 is present in tree so floor will be 87.
Input:
n = 4                     6
                           \
                            8
                          /   \
                        7       9
x = 11
Output: 9
Input:
n = 4                     6
                           \
                            8
                          /   \
                        7       9
x = 5
Output: -1
Constraint:
1 <= Noda data <= 109
1 <= n <= 105

*/

class Solution {
    /**
     * Function to return the floor of a given number in the Binary Search Tree (BST).
     * 
     * Floor(X) is defined as:
     * - The largest value in the BST that is less than or equal to X.
     * - If such a value does not exist (X is smaller than the smallest node), return -1.
     * 
     * @param root - The root node of the BST.
     * @param x - The value for which we need to find the floor.
     * @return The floor value if it exists, otherwise -1.
     */
    public static int floor(Node root, int x) {
        // Initialize the variable to store the floor value.
        int floor = -1;

        // Traverse the BST until the root becomes null (or we've found the floor).
        while (root != null) {
            // If the current node's value matches the key, we have found the floor.
            if (root.data == x) {
                // Return the current node's value as the floor immediately.
                return root.data;
            }
            // If the current node's value is greater than the key:
            else if (root.data > x) {
                // Move to the left subtree, as floor must be among smaller values.
                root = root.left;
            }
            // If the current node's value is less than the key:
            else {
                // Update the floor to the current node's value.
                floor = root.data;
                // Move to the right subtree to potentially find a larger, closer value.
                root = root.right;
            }
        }
        // If no floor value was found during traversal, return -1.
        return floor;
    }
}
