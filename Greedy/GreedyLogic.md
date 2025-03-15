# Characteristics of Greedy Problems

## Greedy Choice Property:
You can make an optimal choice at each step, and that local optimal choice leads to the global optimal solution.

**Example**: In the Activity Selection Problem, selecting the activity that ends the earliest ensures you can fit the maximum number of activities.

## Optimal Substructure:
A problem has an optimal substructure if an optimal solution to the problem can be constructed from the optimal solutions of its subproblems.

**Example**: In the Fractional Knapsack Problem, you can divide items into fractions and maximize profit step by step.

---

## Tips to Identify When to Use Greedy

### Ask These Questions:
- Can I solve this problem by making a series of decisions one at a time?
- Does solving smaller parts of the problem guarantee a solution for the whole?

### Simple Proof Test:
Try proving that making the locally optimal choice won’t mess up the global solution. If you can prove this (or intuitively sense it), Greedy may work.

---

## When Not to Use Greedy
If the problem requires exploring multiple options and “backtracking” to try different combinations, Greedy won't work.

**Example**: Dynamic Programming is better for problems where subproblems overlap and require considering many possible solutions (like Longest Common Subsequence or Matrix Chain Multiplication).

---

## Key Examples of Greedy
Here are some classic problems to keep in mind as you practice:
- Activity Selection Problem
- Fractional Knapsack
- Huffman Encoding
- Minimum Spanning Tree (Prim’s/Kruskal’s)
- Job Sequencing Problem

---

Greedy is like a tool in your problem-solving toolbox—once you recognize its patterns and limitations, you’ll know exactly when to pull it out!

------------------------------------------------------------------------------------------------------------------------------------------------------------

# Jump Game I:
The goal is to determine if you can reach the last index of the array.

- At every position, you evaluate the farthest index you can reach and try to cover as much ground as possible.  
- This approach demonstrates the **Greedy Choice Property**, as you’re making the best possible move at each step.

**How It Works:**  
By tracking the farthest reachable index as you iterate, you’re checking whether the "local optimal decisions" (jumping as far as you can from each position) lead to the "global solution" (reaching the last index).

---

# Jump Game II:
Here, the task is to minimize the number of jumps needed to reach the last index.

- At each position, you decide the optimal jump that covers the most distance while minimizing the total jumps.  
- This is another classic case of the **Greedy Choice Property**, where the local decisions (best possible jump at each step) lead to the global minimum (least number of jumps).

---

# Why Not Other Methods?
Jump Game problems don’t require you to explore multiple possibilities or backtrack (like Dynamic Programming).  
Instead, making a single pass through the array with the **Greedy approach** suffices, saving time and space.

This combination of **local optimal decisions** leading directly to the **global solution** is why Jump Game belongs in the Greedy family.

