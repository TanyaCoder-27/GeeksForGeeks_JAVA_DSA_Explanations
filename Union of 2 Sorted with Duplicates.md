


# 🧮 Union of Two Sorted Arrays (With Duplicates Removed)

**Difficulty:** Medium  
**Accuracy:** 31.39%  
**Submissions:** 460K+  
**Points:** 4  
**Average Time:** 20 mins

---

## 📘 Problem Statement

You are given two **sorted arrays** `a[]` and `b[]`, which may contain **duplicate elements**. Your task is to return a list of elements in the **union** of these arrays in **sorted order** — with **no duplicates**.

> The union is defined as the set containing **distinct elements** that are present in **either** of the two arrays.

---

## 🧪 Examples

### Example 1

**Input:**

```text
a[] = [1, 2, 3, 4, 5]  
b[] = [1, 2, 3, 6, 7]
````

**Output:**

```text
1 2 3 4 5 6 7
```

---

### Example 2

**Input:**

```text
a[] = [2, 2, 3, 4, 5]  
b[] = [1, 1, 2, 3, 4]
```

**Output:**

```text
1 2 3 4 5
```

---

### Example 3

**Input:**

```text
a[] = [1, 1, 1, 1, 1]  
b[] = [2, 2, 2, 2, 2]
```

**Output:**

```text
1 2
```

---

## 📏 Constraints

* `1 ≤ a.length, b.length ≤ 10⁵`
* `−10⁹ ≤ a[i], b[i] ≤ 10⁹`

---

## ✅ Java Solution

```java
import java.util.*;

class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = a.length, m = b.length;
        int i = 0, j = 0;

        // Traverse both arrays using two pointers
        while (i < n && j < m) {
            // Skip duplicates in a[]
            while (i > 0 && i < n && a[i] == a[i - 1]) i++;
            // Skip duplicates in b[]
            while (j > 0 && j < m && b[j] == b[j - 1]) j++;

            if (i >= n || j >= m) break;

            if (a[i] < b[j]) {
                res.add(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                res.add(b[j]);
                j++;
            } else {
                res.add(a[i]);
                i++;
                j++;
            }
        }

        // Process remaining elements in a[]
        while (i < n) {
            if (i == 0 || a[i] != a[i - 1]) {
                res.add(a[i]);
            }
            i++;
        }

        // Process remaining elements in b[]
        while (j < m) {
            if (j == 0 || b[j] != b[j - 1]) {
                res.add(b[j]);
            }
            j++;
        }

        return res;
    }
}
```

---

## 🧠 Explanation: Handling Duplicates Efficiently

Since both arrays are **sorted**, any duplicates will appear **next to each other**. To maintain uniqueness in the union:

* We **skip** any element that is the **same as the previous one** (`a[i] == a[i - 1]`).
* If `a[i] == b[j]`, we add the value **once** and **advance both pointers**.
* Remaining elements (after one array ends) are handled with the **same logic** for skipping duplicates.

This method mimics the **merge step in Merge Sort**, but with a focus on **eliminating duplicates** as we go.

---

## 🕒 Time and Space Complexity

* **Time Complexity:** O(n + m) — single pass through both arrays.
* **Space Complexity:** O(n + m) in the worst case (all unique).

---

## 🚀 Output Properties

* Sorted ✅
* Unique elements only ✅
* Works efficiently for large inputs ✅

---

> ⭐ *Use this approach when you want to combine two sorted datasets into a unique, sorted result without extra overhead!*

```

---


