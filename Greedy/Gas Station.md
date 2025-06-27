
---

# ⛽ Gas Station

**Difficulty:** Medium
**Accuracy:** 34.79%
**Submissions:** 202K+
**Points:** 4
**Average Time:** 20m

---

## 🧩 Problem Statement

There are gas stations along a **circular route**. You are given two integer arrays:

* `gas[]` — the amount of gas available at each station
* `cost[]` — the amount of gas required to travel to the next station

You have a car with **an unlimited gas tank** but you start with an **empty tank** at one station.

### Your Task:

Return the **starting gas station index** if it's possible to travel the full circuit **once in clockwise direction**, without running out of gas. Otherwise, return `-1`.

> ✅ If a solution exists, it is guaranteed to be **unique**.

---

## 🧪 Examples

### Example 1:

```text
Input:  gas[] = [4, 5, 7, 4]
        cost[] = [6, 6, 3, 5]

Output: 2
```

**Explanation:**
Start at index 2 (gas = 7):

* Go to station 3 → Remaining gas: 7 - 3 + 4 = 8
* Go to station 0 → Remaining gas: 8 - 5 + 4 = 7
* Go to station 1 → Remaining gas: 7 - 6 + 5 = 6
* Go to station 2 → Remaining gas: 6 - 6 = 0 ✅ Full loop complete

---

### Example 2:

```text
Input:  gas[] = [1, 2, 3, 4, 5]
        cost[] = [3, 4, 5, 1, 2]

Output: 3
```

**Explanation:**
Start at station 3 → \[4, 5, 1, 2, 3]
You successfully complete the entire circuit.

---

### Example 3:

```text
Input:  gas[] = [3, 9]
        cost[] = [7, 6]

Output: -1
```

**Explanation:**
You can’t start at any station and make a full loop.

---

## 🔒 Constraints

* `1 ≤ gas.length, cost.length ≤ 10^6`
* `1 ≤ gas[i], cost[i] ≤ 10^3`

---

## ✅ Intuition

### ❌ Why a naive approach fails:

```java
if (gas[i] > cost[i]) return i;
```

This **only checks local gain**. But you must complete a **global circular tour**. Just one profitable station isn’t enough.

---

## 💡 Correct Strategy: Greedy + Prefix Tracking

We track:

* `total_tank`: total gas gained minus total cost across all stations.
* `curr_tank`: local gas balance from the current `start` station.
* If `curr_tank < 0`, it means we **can’t start** from the current `start`, so we **move to the next station**.

---

## 💻 Java Code

```java
class Solution {
    public int startStation(int[] gas, int[] cost) {
        int total_tank = 0, curr_tank = 0, index = 0;

        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];
            total_tank += gain;
            curr_tank += gain;

            if (curr_tank < 0) {
                index = i + 1;
                curr_tank = 0;
            }
        }

        return total_tank < 0 ? -1 : index;
    }
}
```

---

## 🧠 Why It Works

* If `total gas < total cost` → 🚫 Not possible to finish
* Otherwise → ✅ There must be a valid `start` index
* If at any point `curr_tank` < 0 → we can’t reach the current station from the start

---

## 📊 Time and Space Complexity

| Type             | Complexity             |
| ---------------- | ---------------------- |
| Time Complexity  | O(n)                   |
| Space Complexity | O(1) (no extra memory) |

---

## 🧪 Dry Run Trace: `gas = [4, 5, 7, 4]`, `cost = [6, 6, 3, 5]`

| i | gas\[i] | cost\[i] | gain | curr\_tank | total\_tank | start |
| - | ------- | -------- | ---- | ---------- | ----------- | ----- |
| 0 | 4       | 6        | -2   | -2         | -2          | 1     |
| 1 | 5       | 6        | -1   | -1         | -3          | 2     |
| 2 | 7       | 3        | +4   | +4         | +1          | 2     |
| 3 | 4       | 5        | -1   | +3         | 0           | 2     |

✅ Final `total_tank = 0` → return `start = 2`

---

