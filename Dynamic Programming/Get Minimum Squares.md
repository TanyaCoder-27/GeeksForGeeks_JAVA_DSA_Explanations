

# 🧮 Get Minimum Squares

**Difficulty**: Medium  
**Accuracy**: 45.22%  
**Submissions**: 40K+  
**Points**: 4

---

## 🧩 Problem Statement

Given a number `n`, find the **minimum number of perfect squares** (i.e., square of an integer) that sum up to `n`.

---

### 🔍 Examples

```

Input: n = 100
Output: 1
Explanation: 10 \* 10 = 100

Input: n = 6
Output: 3
Explanation: 1 \* 1 + 1 \* 1 + 2 \* 2 = 6

```

---

### 💡 Constraints

- `1 <= n <= 10⁴`
- **Expected Time Complexity**: `O(n * √n)`
- **Expected Space Complexity**: `O(n)`

---

## 🔧 Intuition & Approach

You want to build the number `n` using **as few perfect square blocks as possible**.

Your building blocks are:
```

1² = 1, 2² = 4, 3² = 9, 4² = 16, ...

```

We use **Dynamic Programming** and build a `dp[]` array where:

```

dp\[i] = minimum number of perfect squares that sum to i

````

---

### 🧠 How dp[] Works

For each number from `1` to `n`:

- Try subtracting each perfect square `j*j` ≤ `i`
- Check what remains: `i - j*j`
- The best option is:  
  `dp[i] = min(dp[i], dp[i - j*j] + 1)`

---

## ✅ Java Code

```java
import java.util.*;

public class PerfectSquares {
    public static int numSquares(int n) {
        int[] dp = new int[n+1];   //from 0 to the given number(last)
		

		    // dp[i]  --> the minimum sum of perfect squares to form number i

		    Arrays.fill(dp,Integer.MAX_VALUE);
		    dp[0] = 0;  //Base case 


		    for(int i=1;i<=n;i++){

			      //for each number i, finding the least sum of perfect squares(j)
			      for(int j = 1; j*j<=i;j++){
				      dp[i] = Math.min(dp[i] , dp[i-j*j]+1);
				
			       }
		    }


		    return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        int result = numSquares(n);
        System.out.println("Least number of perfect squares = " + result);
    }
}
````

---

## 🧱 Example Walkthrough (n = 13)

Perfect squares ≤ 13: `1, 4, 9`

Try:

* `13 - 1 = 12 → dp[12] + 1`
* `13 - 4 = 9 → dp[9] + 1`
* `13 - 9 = 4 → dp[4] + 1`

Take the **minimum** of all → that's `dp[13]`

---

## 🏁 Summary

* You're building up answers using previous results — classic **bottom-up DP**.
* Choose from every perfect square ≤ `i`.
* Simple, efficient, and powerful!

---


