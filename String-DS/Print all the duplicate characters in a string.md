
## Print all the duplicate characters in a string
Last Updated : 12 Jun, 2025
Given a string s, the task is to identify all characters that appear more than once and print each as a list containing the character and its count.

## Examples:

Input: s = "geeksforgeeks"
Output: ['e', 4], ['g', 2], ['k', 2], ['s', 2]
Explanation: Characters e, g, k, and s appear more than once. Their counts are shown in order of first occurrence.

Input: s = "programming"
Output: ['r', 2], ['g', 2], ['m', 2]
Explanation: Only r, g, and m are duplicates. Output lists them with their counts.

Input: s = "mississippi"
Output: ['i', 4], ['s', 4], ['p', 2]
Explanation: Characters i, s, and p have multiple occurrences. The output reflects that with count and order preserved.


## JAVA CODE:
```
import java.util.*;


class PrintDuplicates{
	public static void main(String args[]){
		String s = "geeksforgeeks";
		

		HashMap<Character,Integer> freq = new HashMap<>();
		

		for(char ch : s.toCharArray()){

			freq.put(ch,freq.getOrDefault(ch,0)+1);

		}


		for(Character key : freq.keySet()){

			if(freq.get(key) > 1){      //Print only duplicates

			System.out.println("Character: "+key+" Frequency: "+freq.get(key));
		
			}

		}

	}

}
```
---

## 🧭 Quick Revision on  keySet() and entrySet()

### 🔑 `keySet()`
Returns a `Set` containing **all the keys** in the `HashMap`.

```java
HashMap<String, Integer> map = new HashMap<>();
for (String key : map.keySet()) {
    System.out.println("Key: " + key + ", Value: " + map.get(key));
}


/*
Character: s Frequency: 2
Character: e Frequency: 4
Character: g Frequency: 2
Character: k Frequency: 2
*/
```

💡 Use this when:
- You just want to loop through keys
- You're okay using `get(key)` to fetch the value

---

### 🧩 `entrySet()`
Returns a `Set` of `Map.Entry<K, V>` — this includes both **key and value pairs**.

```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
}
```

💡 Use this when:
- You need both key and value
- It’s slightly more efficient than `keySet()` + `get()`

---

## 🧠 How to Remember the Difference

### 🔑 `keySet()` → Think:
> “Give me **just** the keys. I’ll grab the values myself.”

It’s like a keyring. You have to open each drawer (`map.get(key)`) yourself.

---

### 🧩 `entrySet()` → Think:
> “Give me the **whole drawer** — key + value.”

Each entry is a little package. You don’t need to make extra trips.

---






