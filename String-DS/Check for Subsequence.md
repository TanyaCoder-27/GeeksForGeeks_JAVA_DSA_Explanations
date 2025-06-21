
# ✅ Check for Subsequence

**Difficulty:** Basic  
**Accuracy:** 36.62%  
**Points:** 1

---

## 🧩 Problem Statement

Given two strings `A` and `B`, check whether `A` is a **subsequence** of `B`.

A subsequence of a string is a new string generated from the original string with **some (or no) characters deleted** without changing the **relative order** of the remaining characters.

---

## 📥 Examples

### Example 1:

```

Input:
A = "AXY"
B = "YADXCP"

Output: 0

Explanation:
'A' appears **after** 'Y' in B, breaking the required order.

```

### Example 2:

```

Input:
A = "gksrek"
B = "geeksforgeeks"

Output: 1

Explanation:
All characters of A appear in B **in the same order**, even if not consecutively.

````

---

## ✅ Expected Time & Space

- **Time Complexity:** `O(N)` (where N is the length of B)
- **Auxiliary Space:** `O(1)`

---

## 🎯 Constraints

- `1 <= |A|, |B| <= 10⁴`

---

## 🧠 Approach

We use **two pointers**:
- One pointer `i` traverses string A
- One pointer `j` traverses string B

At each step:
- If `A[i] == B[j]`, we move `i` (we found the next required character in A)
- Always move `j` (we’re checking through B to find A’s characters in order)

If we finish scanning all characters of A (`i == A.length()`), then A is a subsequence of B.

---

## 💻 Java Code

```java
// User function Template for Java
class Solution {
    boolean isSubSequence(String A, String B) {
        int n = A.length(), m = B.length();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (A.charAt(i) == B.charAt(j)) {
                i++; // move in A only if we found a matching character in B
            }
            j++; // always move in B
        }

        return i == n; // if we’ve seen all characters of A, return true
    }
}
````

---

## 📌 Explanation

Let’s say:

* A = `"abc"`
* B = `"a1b2c3"`

The pointer `i` moves to next character in A **only** if `A[i] == B[j]`.
At the end, if we reached the end of A (`i == A.length()`), it means all characters of A were found **in order** in B.

This is an optimal solution in `O(n)` time and constant space.

---

## 🧪 Dry Run

```
A = "AXY"
B = "YADXCP"

i = 0, j = 0 → A[0] != B[0] → j++
i = 0, j = 1 → A[0] == B[1] = 'A' → i++, j++
i = 1, j = 2 → A[1] == 'X', B[2] == 'D' → not equal → j++
... eventually j reaches end of B and i ≠ A.length()

Result: Not a subsequence → return false (0)
```

