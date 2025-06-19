# 🌼 Intersection of Two Sorted Arrays (with Duplicates)

**Difficulty**: Easy  
**Accuracy**: 31.8%  
**Average Time**: 10 mins  
**Points**: 2  

---

## 📘 Problem Statement

You're given two **sorted arrays** `a[]` and `b[]` (possibly with duplicate elements).  
You need to **return a list of all distinct elements** that appear in **both arrays**, in sorted order.

---

### 📥 Examples

#### Example 1:
```
Input: a = [1, 2, 3, 4, 5], b = [1, 2, 3, 6, 7]
Output: 1 2 3
```

#### Example 2:
```
Input: a = [2, 2, 3, 4, 5], b = [1, 1, 2, 3, 4]
Output: 2 3 4
```

#### Example 3:
```
Input: a = [1, 1, 1, 1], b = [2, 2, 2, 2]
Output: []
```

---

## 🎯 Constraints

- `1 <= a.length, b.length <= 10^5`
- `-10^9 <= a[i], b[i] <= 10^9`

---

## 🧠 Intuition (Bedtime Coder Edition 🌙✨😴✨*)

### 🧵 Is this like Merge Sort?

**Sort of — same spirit, different intention.**

In Merge Sort, you're merging *everything*.  
In this problem, you're **selectively merging only the shared values**, once.

| Feature              | Merge Sort Merge Phase        | Intersection of Two Arrays        |
|----------------------|-------------------------------|------------------------------------|
| Purpose             | Combine sorted halves          | Find distinct shared elements      |
| Pointers Used       | Two (left and right)           | Two (`i`, `j`)                     |
| Action When Equal   | Add both                       | Add once (if not already added)    |
| Move When Unequal   | Move smaller forward           | Same                               |
| Result              | Full array                     | Only distinct shared values        |

---

## 👣 Step-by-Step (Peaceful Two-Pointer Walk)

Picture two sorted gardens 🌿 and two friends (pointers) walking through them.  
They collect only the **flowers that appear in both gardens**, but just **once** 🌸.

Here's the plan:

1. Use two pointers `i` and `j` to walk through `a[]` and `b[]`.
2. If `a[i] == b[j]`, and this is a **new element**, add it to the result.
3. If `a[i] < b[j]`, move `i++` (move ahead in `a[]`).
4. If `a[i] > b[j]`, move `j++` (move ahead in `b[]`).
5. Skip duplicates in `a[]` to prevent repeated intersection values.

---

## 🧪 Dry Run

### Input:
```java
a = [2, 2, 3, 4, 5]
b = [1, 1, 2, 3, 4]
```

| Step | a[i] | b[j] | Action         | Result        |
|------|------|------|----------------|---------------|
| 1    | 2    | 1    | j++            | []            |
| 2    | 2    | 1    | j++            | []            |
| 3    | 2    | 2    | Match → add 2  | [2]           |
| 4    | 2    | 3    | Skip duplicate | [2]           |
| 5    | 3    | 3    | Match → add 3  | [2, 3]        |
| 6    | 4    | 4    | Match → add 4  | [2, 3, 4]     |

✅ Final output: `[2, 3, 4]`

---

## 💻 Java Code (Two Pointer Merge Style)

```java
import java.util.ArrayList;

class Solution {
    // Function to find the intersection of two arrays
    public ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            // Skip duplicates in 'a'
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }

            if (a[i] == b[j]) {
                result.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
```

---

## 😴 TL;DR Summary

- Use **two pointers** for two sorted arrays.
- Compare and move forward accordingly.
- If equal and distinct, **add to result**.
- **Skip duplicates** to avoid repetitions.

---
