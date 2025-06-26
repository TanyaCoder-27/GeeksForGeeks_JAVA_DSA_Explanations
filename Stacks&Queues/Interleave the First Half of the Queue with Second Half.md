
# 🔁 Interleave the First Half of the Queue with Second Half

**Difficulty:** Medium
**Accuracy:** 62.41%
**Submissions:** 14K+
**Points:** 4
**Average Time:** 20m

---

## 📘 Problem Statement

Given a queue of even size, your task is to rearrange the queue by **interleaving its first half with the second half**.

> Interleaving is the process of mixing two sequences by alternating their elements while preserving their relative order.
> E.g., take one from first half, then one from second half, and repeat.

---

## 🧪 Examples

### Example 1

**Input:**
`q = [2, 4, 3, 1]`
**Output:**
`[2, 3, 4, 1]`
**Explanation:**
We place:

* 1st element of 1st half: `2`
* 1st of 2nd half: `3`
* 2nd of 1st half: `4`
* 2nd of 2nd half: `1`

---

### Example 2

**Input:**
`q = [3, 5]`
**Output:**
`[3, 5]`
**Explanation:**
Queue has only two elements: 1st half is `[3]`, 2nd is `[5]`. No reordering required.

---

## 🔒 Constraints

* `1 <= queue.size() <= 5 * 10⁵`
* `1 <= queue[i] <= 5 * 10⁵`

---

## 🧠 Intuition Behind the Stack-Based Approach

To interleave the halves without losing relative ordering, we’ll use a **stack + queue** combo:

### Steps:

1. Push **first half** into a stack → reverses it.
2. Enqueue stack elements → now the reversed first half is at the rear.
3. Rotate the second half to the rear → bring order back.
4. Push **first half** (again) into the stack → stores in correct order.
5. Alternate one from stack (first half), one from queue (second half).

---

## 💻 Java Implementation

```java
public class Solution {
    public Queue<Integer> rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        int h = n / 2;
        Stack<Integer> stk = new Stack<>();

        // Step 1: Push first half to stack (reverses order)
        for (int i = 0; i < h; i++) {
            stk.push(q.poll());
        }

        // Step 2: Enqueue stack elements back (reversed)
        while (!stk.isEmpty()) {
            q.offer(stk.pop());
        }

        // Step 3: Move second half (original second half) to the back
        for (int i = 0; i < h; i++) {
            q.offer(q.poll());
        }

        // Step 4: Push first half (reversed back to original) into stack
        for (int i = 0; i < h; i++) {
            stk.push(q.poll());
        }

        // Step 5: Interleave stack and queue
        while (!stk.isEmpty()) {
            q.offer(stk.pop());  // First half
            q.offer(q.poll());   // Second half
        }

        return q;
    }
}
```

---

## 🎯 Walkthrough for `[2, 4, 3, 1]`

Initial queue:
`[2, 4, 3, 1]`

1. Stack push: `[2, 4] → [4, 2]`
2. Queue becomes: `[3, 1, 4, 2]`
3. Rotate second half (`[3, 1]`): → `[4, 2, 3, 1]`
4. Stack push: `[4, 2]`
5. Final interleaving:

   * pop `2` → enqueue
   * poll `3` → enqueue
   * pop `4` → enqueue
   * poll `1` → enqueue
     → Final: `[2, 3, 4, 1]` ✅

---

## ⏱️ Time & Space Complexity

* **Time:** O(n)
* **Space:** O(n/2) → Stack used for half the queue

---

