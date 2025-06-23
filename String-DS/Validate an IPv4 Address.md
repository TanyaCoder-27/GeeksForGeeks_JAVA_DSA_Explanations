
# ✅ Validate an IPv4 Address

**Difficulty:** Medium  
**Accuracy:** 11.22%  
**Submissions:** 292K+  
**Points:** 4  
**Average Time:** 20m

---

## 🧩 Problem Statement

You are given a string `s` in the form of an IPv4 address.  
Your task is to validate the IPv4 address:  

- If it is valid, return `true`  
- Otherwise, return `false`

IPv4 addresses are canonically represented in **dot-decimal** notation, which consists of **four decimal numbers**, each ranging from `0` to `255`, separated by dots.

**Valid Format:**  
```

x1.x2.x3.x4 where 0 <= x1, x2, x3, x4 <= 255

```

⚠️ **Leading zeroes are NOT allowed**, except for the number `"0"`.

---

## 📥 Examples

### Example 1:
```

Input: s = "222.111.111.111"
Output: true
Explanation: All 4 segments are in valid range (0–255) and format.

```

### Example 2:
```

Input: s = "5555..555"
Output: false
Explanation: Invalid structure — missing blocks.

```

### Example 3:
```

Input: s = "0.0.0.255"
Output: true

````

---

## 🎯 Constraints

- `1 <= |s| <= 15`

---

## ✅ Java Implementation

```java
public class IPValidator {

    public static boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.");
        
        if (parts.length != 4) return false;

        for (String part : parts) {
            // Empty part check
            if (part.length() == 0) return false;

            // Must be all digits
            for (char ch : part.toCharArray()) {
                if (!Character.isDigit(ch)) return false;
            }

            // Leading zero check (except single "0")
            if (part.length() > 1 && part.charAt(0) == '0') return false;

            // Range check
            int value = Integer.parseInt(part);
            if (value < 0 || value > 255) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] testIPs = {
            "128.0.0.1",
            "125.16.100.1",
            "125.512.100.1",
            "125.512.100.abc"
        };
        
        for (String ip : testIPs) {
            System.out.println("IP: " + ip + " → " + (isValidIPv4(ip) ? "Valid" : "Invalid"));
        }
    }
}
````

---

## 🧠 Explanation

We:

* Split the string using `split("\\.")`
* Check:

  * Each part is non-empty
  * All characters are digits
  * No leading zeroes (except "0")
  * Number lies between 0–255

If **any check fails**, return `false`.
If **all checks pass**, return `true`.

---

## ⏱️ Time and Space Complexity

* **Time:** `O(1)` – since there are exactly 4 parts.
* **Space:** `O(1)` – uses fixed variables only.

---

## 🔄 Sample Output

```
IP: 128.0.0.1 → Valid
IP: 125.16.100.1 → Valid
IP: 125.512.100.1 → Invalid
IP: 125.512.100.abc → Invalid
```

