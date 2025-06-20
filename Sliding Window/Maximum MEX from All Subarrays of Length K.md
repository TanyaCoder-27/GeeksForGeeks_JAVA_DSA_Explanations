
# 🚀 Maximum MEX from All Subarrays of Length K

**Difficulty:** Medium  
**Last Updated:** 31 Oct, 2023

---

## 🧩 Problem Statement

Given an array `arr[]` consisting of **N distinct integers** and an integer **K**, the task is to **find the maximum MEX** from all subarrays of length **K**.

📌 **MEX** = the smallest **positive** integer **not** present in the array/subarray.

---

## 📚 Examples

### Example 1:
```

Input: arr\[] = {3, 2, 1, 4}, K = 2
Output: 3

Explanation:
Subarrays of size 2 → {3, 2}, {2, 1}, {1, 4}

* MEX({3, 2}) = 1
* MEX({2, 1}) = 3
* MEX({1, 4}) = 2
  Max MEX = 3 ✅

```

---

### Example 2:
```

Input: arr\[] = {6, 1, 3, 2, 4}, K = 3
Output: 4

Explanation:
Subarrays of size 3 → {6, 1, 3}, {1, 3, 2}, {3, 2, 4}

* MEX({6, 1, 3}) = 2
* MEX({1, 3, 2}) = 4
* MEX({3, 2, 4}) = 1
  Max MEX = 4 ✅

````

---

## 🧠 Intuition

- You need to find the **smallest positive integer not in a window of size K**.
- Use a **TreeSet** to store all candidates from `1` to `N+1`.
- As you slide the window, remove elements that are present in the window.
- The **first value in TreeSet** is the **MEX** of that window.
- Track the **maximum** such MEX across all windows.

---

## 🛠️ Java Code (with TreeSet + Sliding Window)

```java
import java.util.*;

class MaxMex {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = sc.nextInt();

        System.out.println("Enter array:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter window size:");
        int k = sc.nextInt();

        int res = maxMEX(arr, n, k);
        System.out.println("Result: " + res);
    }

    private static int maxMEX(int[] arr, int n, int k) {
        TreeSet<Integer> ts = new TreeSet<>();

        for (int i = 1; i <= n + 1; i++) {
            ts.add(i);
        }

        int i = 0, j = 0;
        int mex = 0, maxMex = Integer.MIN_VALUE;

        while (j < n) {
            if (ts.contains(arr[j])) {
                ts.remove(arr[j]);
            }

            int windowSize = j - i + 1;

            if (windowSize < k) {
                j++;
            } else if (windowSize == k) {
                mex = ts.pollFirst(); // current window's MEX
                maxMex = Math.max(maxMex, mex);
                ts.add(arr[i]); // restore the element that's sliding out
                i++;
                j++;
            }
        }

        return maxMex;
    }
}
````

---

## 🧪 Sample Input/Output

```
Input:
Enter size of array:
5
Enter array:
6 1 3 2 4
Enter window size:
3

Output:
Result: 4
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** O(N log N)
  → Due to `TreeSet` operations inside sliding window loop

* **Space Complexity:** O(N)
  → TreeSet stores up to `N+1` elements

---

## ✅ Summary

* Use TreeSet to track what's missing (for MEX).
* Use a sliding window to efficiently evaluate all subarrays of size K.
* Poll the smallest element not present → that's your current MEX.
* Track the maximum MEX among all windows.

---

```


Let’s zero in on this line:

```java
s.add(arr[i]);
```

### 💡 What it Does
This line adds **one element only** — the value at index `i` — back into the `TreeSet`.

---

### 🧠 Why Are We Adding Just One Element?

This line appears right before we slide the window forward. Here's what’s happening:

1. We're working with a **sliding window of size `k`**
2. `arr[i]` is the **element that is about to leave** the window
3. Earlier, when `arr[i]` **entered** the window, we had removed it from the `TreeSet` (because it was now “present”)
4. Now that it's **leaving**, it's no longer present — so we re-add it to the set, because it's **missing again**

---

### 🔍 Example Walkthrough

Say:

```java
arr = [6, 1, 3, 2, 4];
k = 3;
```

We start with window `[6, 1, 3]`  
- When this window forms, we remove 6, 1, 3 from the set  
- Let's say `i = 0` → `arr[i] = 6`  
- Now the window slides to `[1, 3, 2]`  
  - So 6 **leaves** the window  
  - Before sliding, we do `s.add(arr[i]) → s.add(6);`

Result:
- We’ve **restored** 6 back into the set so the next subarray (which doesn’t have 6) can correctly treat it as “missing” again

---

### 🧾 Summary

- `s.add(arr[i])` adds back **one** number: the element that's sliding out of the window
- It's part of the cleanup/reset step while maintaining the correct set of **missing values** per window










