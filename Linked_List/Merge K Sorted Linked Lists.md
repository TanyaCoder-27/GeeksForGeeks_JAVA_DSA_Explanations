
# 🔗 Merge K Sorted Linked Lists

**Difficulty:** Medium
**Accuracy:** 57.01%
**Submissions:** 108K+
**Points:** 4
**Average Time:** 60m

---

## 🧠 Problem Statement

Given an array `arr[]` of `n` sorted linked lists of different sizes, merge them into a single sorted linked list and return the **head** of the merged list.

---

## 🧪 Examples

### Example 1:

**Input:**
`arr[] = [1 → 2 → 3, 4 → 5, 5 → 6, 7 → 8]`
**Output:**
`1 → 2 → 3 → 4 → 5 → 5 → 6 → 7 → 8`

**Explanation:**
The array has 4 sorted linked lists. After merging, the combined sorted list is as shown above.

---

### Example 2:

**Input:**
`arr[] = [1 → 3, 8, 4 → 5 → 6]`
**Output:**
`1 → 3 → 4 → 5 → 6 → 8`

---

## 🔒 Constraints

* `1 <= total number of nodes <= 10^5`
* `1 <= node->data <= 10^3`

---

## 💻 Java Code

```java
/* Definition for linked list node */
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

// Merge K sorted linked lists
class Solution {
    Node mergeKLists(List<Node> arr) {
        // Min-heap to get the smallest element from current heads
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Add head of all lists to the heap
        for (Node node : arr) {
            if (node != null) {
                pq.add(node);
            }
        }

        // Dummy node to form the result list
        Node dummy = new Node(0);
        Node tail = dummy;

        // Extract min from heap and add next node from that list
        while (!pq.isEmpty()) {
            Node minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }
}
```

---

## 🧠 Intuition Behind the Code

We’re given **K sorted linked lists**, and we need to merge them efficiently.

---

### 📌 Idea

Since each list is already sorted, the best approach is to **always pick the smallest node** from the current list heads.

To do that efficiently, we use a **Min Heap (PriorityQueue)**.

---

### ⚙️ Step-by-Step Strategy

1. **Push the head node** of each list into the Min Heap.
2. **Extract the smallest** node and append it to the result list.
3. If the extracted node has a `.next`, push that into the heap.
4. Repeat until the heap is empty.

---

### ✅ Why It Works

* Always processes the smallest node among all current candidates.
* Maintains sorted order naturally.
* Efficient due to heap operations:

  * `O(log K)` per insertion/deletion.
  * Total: `O(N log K)` where `N` is total nodes.

---

## 📊 Time & Space Complexity

* **Time Complexity:** `O(N log K)`
  (N = total number of nodes, K = number of lists)
* **Space Complexity:** `O(K)` for heap storage

---

## 🎴 Real-World Analogy

Imagine you have 3 sorted piles of cards. Each turn, you look at the top card from each pile and pick the smallest one. That’s exactly what the **Min Heap** is doing for you — automating the selection of the next smallest card!

---

