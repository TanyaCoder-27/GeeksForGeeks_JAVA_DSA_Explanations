
# ✅ Check if All Levels of Two Trees Are Anagrams

**Difficulty:** Medium
**Accuracy:** 56.88%
**Submissions:** 22K+
**Points:** 4

---

## 🧩 Problem Statement

Given two binary trees with the same number of nodes, check whether **each corresponding level** of both trees is an **anagram** of the other.

---

## 🧪 Examples

### Example 1:

```
Tree 1:
Level 0: 1
Level 1: 3, 2
Level 2: 5, 4

Tree 2:
Level 0: 1
Level 1: 2, 3
Level 2: 4, 5

Output: 1
Explanation: All levels are anagrams of each other.
```

---

### Example 2:

```
Tree 1:
Level 0: 1
Level 1: 2, 3
Level 2: 5, 4

Tree 2:
Level 0: 1
Level 1: 2, 4
Level 2: 5, 3

Output: 0
Explanation: Level 1 and Level 2 are not anagrams.
```

---

## 📥 Your Task

You don’t need to read input or print anything.
Implement the function:

```java
public static boolean areAnagrams(Node root1, Node root2)
```

Return `true` if all levels of the two trees are anagrams, otherwise return `false`.

---

## 🧠 Approach

* Perform **level-order traversal (BFS)** on both trees.
* For each level, track the **frequency of node values** using two `HashMap`s.
* At every level, compare the two maps. If they’re not equal → return false.

---

## 💻 Java Code

```java
class Solution {
    public static boolean areAnagrams(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();
            if (size1 != size2) return false;

            Map<Integer, Integer> freq1 = new HashMap<>();
            Map<Integer, Integer> freq2 = new HashMap<>();

            for (int i = 0; i < size1; i++) {
                Node n1 = q1.poll();
                Node n2 = q2.poll();

                freq1.put(n1.data, freq1.getOrDefault(n1.data, 0) + 1);
                freq2.put(n2.data, freq2.getOrDefault(n2.data, 0) + 1);

                if (n1.left != null) q1.add(n1.left);
                if (n1.right != null) q1.add(n1.right);
                if (n2.left != null) q2.add(n2.left);
                if (n2.right != null) q2.add(n2.right);
            }

            if (!freq1.equals(freq2)) return false;
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}
```

---

## ⏱️ Time & Space Complexity

| Operation        | Complexity |
| ---------------- | ---------- |
| Time Complexity  | O(N log N) |
| Space Complexity | O(N)       |

> N = total number of nodes in either tree

---

## 🧠 Tip: What Does “Anagram by Level” Mean?

At each level of both trees:

* The **set of values** must be the same
* The **count of each value** must be the same
* Order does **not** matter!

---

