

````markdown
# 🧮 Min Cost to Make Size 1

**Difficulty:** Easy  
**Accuracy:** 73.72%  
**Submissions:** 1K+  
**Points:** 2  

---

## 📘 Problem Statement

Given an array `arr[]`, you need to **reduce the size of the array to one**.  

You are allowed to select any **pair of integers** and remove the **larger** one. This operation decreases the array size by 1.  
The **cost** of this operation is equal to the value of the **smaller** integer in the pair.

Your task is to find the **minimum total cost** of operations needed to reduce the array into a single element.

---

## 🧩 Examples

### Example 1
**Input:**  
`arr = [4, 3, 2]`  
**Output:**  
`4`  
**Explanation:**  
- Choose (4, 2) → remove 4 → cost = 2  
- New array = [2, 3]  
- Choose (2, 3) → remove 3 → cost = 2  
- **Total cost = 2 + 2 = 4**

---

### Example 2
**Input:**  
`arr = [3, 4]`  
**Output:**  
`3`  
**Explanation:**  
- Choose (3, 4) → remove 4 → cost = 3

---

### Example 3
**Input:**  
`arr = [1]`  
**Output:**  
`0`  
**Explanation:**  
- Already size 1 → no operation needed

---

## ✅ Constraints

- `1 <= arr.length <= 10^5`  
- `1 <= arr[i] <= 10^4`

---

## 💡 Approach

To minimize the total cost:
- Always **keep the minimum element** as long as possible.
- Cost will be incurred by the **smaller element in every operation**.
- So, to minimize the total cost, **keep removing the largest element using the smallest element**.

Thus, the **total cost = (n - 1) × min(arr)**

---

## 🧪 Sample Code (Python)

```python
def min_cost_to_one(arr):
    if len(arr) <= 1:
        return 0
    return (len(arr) - 1) * min(arr)

# Example usage:
print(min_cost_to_one([4, 3, 2]))  # Output: 4
print(min_cost_to_one([3, 4]))     # Output: 3
print(min_cost_to_one([1]))        # Output: 0
````

---

## 📁 Tags

* Greedy
* Arrays
* Minimum Cost

```

Here's the same content beautifully converted into a **Markdown-friendly format** for easy pasting into GitHub or documentation:

````markdown
# 🧠 Greedy + Math Insight: Min Cost to Make Size 1

This one's a neat blend of **greedy strategy and math intuition**—let’s unpack it together.

---

## 🧩 Problem Breakdown

You're allowed to:
- Pick **any two elements** from the array
- **Remove the larger**, and **pay the smaller** as cost
- Repeat until only **one element remains**

🎯 **Goal:** Minimize the **total cost**

---

## 🔥 Core Insight

If you look closely:
- The **larger elements will eventually get removed** one by one
- Each removal costs the **smaller one** in the pair

To keep the cost **low**, you should always:
👉 **Pay using the smallest element available** every time.

---

### 🤔 Why?

Let `minVal = minimum element in the array`.

For every operation:
- Pair any element `x` with `minVal`
- Remove `x` (as it's larger)
- Pay cost = `minVal`

Repeat until only `minVal` remains.

---

## 🧠 Strategy

1. Find `minVal = minimum element in the array`
2. Total operations needed = `n - 1` (to reduce array to size 1)
3. 🧾 **Total cost = (n - 1) * minVal**

---

## ✅ Optimized Java Code

```java
class Solution {
    public int cost(int[] arr) {
        if (arr.length <= 1) return 0;

        int minVal = Integer.MAX_VALUE;

        for (int num : arr) {
            minVal = Math.min(minVal, num);
        }

        return (arr.length - 1) * minVal;
    }
}
````

---

## ⚙️ Time & Space Complexity

| Complexity | Value |
| ---------- | ----- |
| Time       | O(n)  |
| Space      | O(1)  |

---

## 🧪 Example Walkthrough

### Input:

`arr = [4, 3, 2]`

### Steps:

* `minVal = 2`
* Size = 3 → Needs 2 operations
* Cost = `2 * 2 = 4` ✅

---




