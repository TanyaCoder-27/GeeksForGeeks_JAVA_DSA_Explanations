### Job Sequencing Problem
- **Difficulty**: Medium  
- **Accuracy**: 34.51%  
- **Submissions**: 283K+  
- **Points**: 4  

You are given three arrays: `id`, `deadline`, and `profit`, where each job is associated with an **ID**, a **deadline**, and a **profit**. Each job takes **1 unit of time** to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.

---

### Your Task:
1. **Find** the maximum number of jobs that can be completed within their deadlines.
2. **Calculate** the total maximum profit earned by completing those jobs.

---

### Examples:

#### Example 1:
- **Input**:  
  `id = [1, 2, 3, 4]`  
  `deadline = [4, 1, 1, 1]`  
  `profit = [20, 1, 40, 30]`  
- **Output**: `[2, 60]`  
- **Explanation**: Job1 and Job3 can be done with maximum profit of `60` (`20 + 40`).

#### Example 2:
- **Input**:  
  `id = [1, 2, 3, 4, 5]`  
  `deadline = [2, 1, 2, 1, 1]`  
  `profit = [100, 19, 27, 25, 15]`  
- **Output**: `[2, 127]`  
- **Explanation**: Job1 and Job3 can be done with maximum profit of `127` (`100 + 27`).

#### Example 3:
- **Input**:  
  `id = [1, 2, 3, 4]`  
  `deadline = [3, 1, 2, 2]`  
  `profit = [50, 10, 20, 30]`  
- **Output**: `[3, 100]`  
- **Explanation**: Job1, Job3, and Job4 can be completed with a maximum profit of `100` (`50 + 20 + 30`).

---

### Constraints:
1. `1 ≤ id.size() == deadline.size() == profit.size() ≤ 10⁵`  
2. `1 ≤ id[i], deadline[i] ≤ id.size()`  
3. `1 ≤ profit ≤ 500`

---

With this problem, the goal is to maximize the profit by choosing jobs within their respective deadlines. If you'd like, I can also explain the algorithm to solve it or provide code for the solution!

```

class Solution {

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        int n = id.length;

        // Create an array of Job objects
        Job[] jobs = new Job[n];     //Job class with default constructor being already initialised in Driver's code
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(id[i], deadline[i], profit[i]);
        }

        // Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find the maximum deadline
        int maxDeadline = 0;
        for (int d : deadline) {
            maxDeadline = Math.max(maxDeadline, d);
        }

        // Create a timeline (slots) for job scheduling
        boolean[] slots = new boolean[maxDeadline];
        Arrays.fill(slots, false);

        // Initialize count of jobs done and total profit
        int jobCount = 0, totalProfit = 0;

        // Iterate over all jobs
        for (Job job : jobs) {
            // Find a free slot for this job (from job.deadline - 1 to 0)
            for (int j = Math.min(job.deadline - 1, maxDeadline - 1); j >= 0; j--) {
                if (!slots[j]) { // If slot is free
                    slots[j] = true; // Mark slot as occupied
                    jobCount++; // Increment job count
                    totalProfit += job.profit; // Add profit
                    break;
                }
            }
        }

        // Prepare the result
        ArrayList<Integer> result = new ArrayList<>();
        result.add(jobCount); // Number of jobs completed
        result.add(totalProfit); // Total profit earned
        return result;
    }
}

```
### Input Handling:
- Converted the `id`, `deadline`, and `profit` arrays into an array of `Job` objects for easier sorting and processing.

---

### Sorting:
- Used `Arrays.sort` with a comparator to sort the jobs by **profit** in descending order.

---

### Timeline Handling:
- Created a boolean array (`slots`) for scheduling jobs up to the maximum deadline.

---

### Output:
- Returned an `ArrayList` with two elements:
  1. The number of jobs scheduled.
  2. The total profit earned.
------------------------------------------------------------------
### Purpose of `Math.min(job.deadline - 1, maxDeadline - 1)`

#### `job.deadline - 1`:
- Array indexing in Java is **zero-based**, while the deadlines provided are typically **1-based** (e.g., deadlines are given as 1, 2, 3…).
- To refer to a valid slot in the `slots` array, we need to subtract **1** from the job's deadline.

#### `maxDeadline - 1`:
- Some jobs might have deadlines that **exceed the maximum timeline** (slots available). In such cases, we don't want to access invalid array indices.
- By taking the minimum of `job.deadline - 1` and `maxDeadline - 1`, we ensure that we only check within the **bounds of the timeline**.

---

### Example Scenario:

#### Input:
Jobs:  
`Job1 (Profit=20, Deadline=2)`  
`Job2 (Profit=15, Deadline=4)`  
`Job3 (Profit=10, Deadline=1)`  

#### Max Deadline:
`maxDeadline = 3` (based on the highest valid deadline).

---

#### Execution:
- **For Job1**:  
  Deadline is 2 → Start checking at `2 - 1 = 1`.
  
- **For Job2**:  
  Deadline is 4 → `4 - 1 = 3` exceeds `maxDeadline - 1 = 2`, so we cap it to 2 using `Math.min`. This ensures we don't go out of bounds.
  
- **For Job3**:  
  Deadline is 1 → Start checking at `1 - 1 = 0`.

---

### Why is it Important?

- This approach prevents **runtime errors** (like `ArrayIndexOutOfBoundsException`).
- It ensures the algorithm can gracefully handle **deadlines larger than the maximum valid slots**, making it robust for a wide range of inputs.


--------------------------------------------

### Time Complexity

#### Sorting the Jobs:
- Sorting the jobs array based on profit takes **O(n log n)**, where `n` is the number of jobs.

#### Finding Free Slots:
- For each job, we check at most **min(deadline, maxDeadline)** slots (starting from its deadline and going backward).
- In the **worst case**, all jobs have deadlines larger than or equal to `maxDeadline`, so we perform **O(n × maxDeadline)** operations for slot allocation.

Thus, the overall time complexity is:  
**O(n log n + n × maxDeadline)**.  
For practical scenarios where `maxDeadline` is small (compared to `n`), the complexity simplifies to approximately **O(n log n)**.

---

### Space Complexity

#### Slot Array:
- A boolean array of size **maxDeadline** is used to track free slots, which takes **O(maxDeadline)** space.

#### Other Storage:
- Variables for tracking the job count and total profit take **O(1)** space.

---

### Summary:
- **Time Complexity**: **O(n log n + n × maxDeadline)** (or **O(n log n)** if `maxDeadline` is small).  
- **Space Complexity**: **O(maxDeadline)**.

