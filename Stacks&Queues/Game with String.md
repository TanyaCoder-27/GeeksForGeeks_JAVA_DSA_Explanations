

# 🎮 Game with String

**Difficulty:** Medium
**Accuracy:** 53.96%
**Submissions:** 63K+
**Points:** 4
**Average Time:** 15m

---

## 📘 Problem Statement

Given a string `s` consisting of lowercase alphabets and an integer `k`, your task is to find the **minimum possible value** of the string after removing exactly `k` characters.

The value of the string is defined as the **sum of the squares of the frequencies** of each distinct character present in the string.

---

## 🔍 Examples

### Example 1:

**Input:**
`s = "abbccc"`, `k = 2`
**Output:**
`6`
**Explanation:**
We remove two `'c'` → frequencies: a=1, b=2, c=1
→ Value = 1² + 2² + 1² = 6
Or, remove `'b'` and `'c'` once each → a=1, b=1, c=2 → Value = 1² + 1² + 2² = 6

---

### Example 2:

**Input:**
`s = "aaab"`, `k = 2`
**Output:**
`2`
**Explanation:**
Remove two `'a'` → frequencies: a=1, b=1
→ Value = 1² + 1² = 2

---

## 🔒 Constraints

* 0 ≤ k ≤ s.length() ≤ 10⁵

---

## ✅ Intuition

We want to **reduce the sum of squares** of character frequencies.
So removing characters from the **highest frequency letters** helps the most — since squaring penalizes larger numbers more than smaller ones.

---

## ⚙️ Greedy Strategy Using Priority Queue

1. Count the frequency of each character using `int[] freq = new int[26]`
2. Insert all non-zero frequencies into a **max-heap** (`PriorityQueue` with reverse order)
3. Perform `k` removals:

   * Pick the character with the highest frequency
   * Remove one occurrence (decrement by 1)
   * Re-insert into the heap if frequency > 0
4. Finally, sum the **squares** of all remaining frequencies

---

## 💻 Java Implementation

```java
import java.util.*;

public class GameWithString {
    public static int minValue(String s, int k) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Max heap to always pick the highest frequency character
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) pq.add(f);
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int top = pq.poll();
            top--; // Remove one character
            if (top > 0) pq.add(top);
        }

        int result = 0;
        while (!pq.isEmpty()) {
            int f = pq.poll();
            result += f * f;  // Sum of squares
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "abbccc";
        int k = 2;
        System.out.println(minValue(s, k));  // Output: 6
    }
}
```

---

## 🔍 Step-by-Step Example

### For `s = "abbccc"`, `k = 2`

* Initial frequencies:
  `a = 1, b = 2, c = 3`
* Heap = `[3, 2, 1]`

**Step 1:** Remove one `'c'` → c = 2 → Heap = `[2, 2, 1]`
**Step 2:** Remove one `'b'` → b = 1 → Heap = `[2, 1, 1]`

**Final Value:**
2² + 1² + 1² = **6**

---

## ⏱️ Time & Space Complexity

* **Time:** O(n + k log 26) ≈ O(n)
* **Space:** O(1) (since the alphabet is fixed at 26 characters)

---

## 🧠 Optimization Notes

* Use `PriorityQueue<>(Collections.reverseOrder())` for max-heap behavior
* The problem size is limited by 26 characters, so performance is tight
* Using `while (k-- > 0 && !pq.isEmpty())` prevents unnecessary steps

---

