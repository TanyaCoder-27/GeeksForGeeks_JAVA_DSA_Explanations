# 6 problems on Priority Queue or Heap
Note: I have performed all by static implementation to concentrate on Priority Queue concept and not on dynamic. Dynamic is preferrable while writing programs.

# 1. Given array of n integers, construct max PriorityQueue, store n elements of the array into it, delete and print all the elements of the priority queue
```
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxPriorityQueue {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 4};

        // Create a max priority queue
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements to the max priority queue
        for (int num : arr) {
            maxPQ.add(num);
        }

        // Remove and print all elements from the priority queue
        while (!maxPQ.isEmpty()) {
            System.out.println(maxPQ.poll());
        }
    }
}
```
## Explanation:
Max Priority Queue: We use PriorityQueue with Collections.reverseOrder() to create a max priority queue.

Insert Elements: Add each element from the array to the priority queue.

Remove and Print: Poll elements from the priority queue until it's empty.

# 2. Given array of n integers, construct min PriorityQueue, store n elements of the array into it, delete and print all the elements of the priority queue
```
import java.util.PriorityQueue;

public class MinPriorityQueue {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 4};

        // Create a min priority queue
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        // Add all elements to the min priority queue
        for (int num : arr) {
            minPQ.add(num);
        }

        // Remove and print all elements from the priority queue
        while (!minPQ.isEmpty()) {
            System.out.println(minPQ.poll());
        }
    }
}
```

## Explanation:
Min Priority Queue: We use PriorityQueue directly for a min priority queue.

Insert Elements: Add each element from the array to the priority queue.

Remove and Print: Poll elements from the priority queue until it's empty.

# 3. Given array of n integers, find kth largest element in array where k is input using sorting
```
import java.util.Arrays;

public class KthLargestElementSorting {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 4};
        int k = 2;

        // Sort the array
        Arrays.sort(arr);

        // Find the kth largest element
        int kthLargest = arr[arr.length - k];
        System.out.println(kthLargest);
    }
}

```
## Explanation:
Sort the Array: Use Arrays.sort() to sort the array.

Find Kth Largest: The kth largest element is at position arr.length - k.

# 4. Given array of n integers, find kth largest element in array where k is input using max PriorityQueue 
```
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementMaxPQ {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 4};
        int k = 2;

        // Create a max priority queue
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements to the max priority queue
        for (int num : arr) {
            maxPQ.add(num);
        }

        // Poll k times to get the kth largest element
        // k-1 times through the loop
        for (int i = 0; i < k - 1; i++) {
            maxPQ.poll();
        }
        
        System.out.println(maxPQ.poll());  //kth time (last one time) with print statement
    }
}

```
## Explanation:
Max Priority Queue: Create a max priority queue.

Insert Elements: Add elements to the priority queue.

Find Kth Largest: Poll the priority queue k times to get the kth largest element.

# 5. Given array of n integers, find kth smallest element in array where k is input using sorting
```
import java.util.Arrays;

public class KthSmallestElementSorting {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 4};
        int k = 2;

        // Sort the array
        Arrays.sort(arr);

        // Find the kth smallest element
        int kthSmallest = arr[k - 1];
        System.out.println(kthSmallest);
    }
}

```

## Explanation:
Sort the Array: Use Arrays.sort() to sort the array.

Find Kth Smallest: The kth smallest element is at position k - 1.

# 6. Given array of n integers, find kth smallest element in array where k is input using min PriorityQueue
```
import java.util.PriorityQueue;

public class KthSmallestElementMinPQ {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 4};
        int k = 2;

        // Create a min priority queue
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        // Add all elements to the min priority queue
        for (int num : arr) {
            minPQ.add(num);
        }

        // Poll k times to get the kth smallest element
        for (int i = 0; i < k - 1; i++) {
            minPQ.poll();
        }
        System.out.println(minPQ.poll());
    }
}

```
## Explanation:
Min Priority Queue: Create a min priority queue.

Insert Elements: Add elements to the priority queue.

Find Kth Smallest: Poll the priority queue k times to get the kth smallest element.
