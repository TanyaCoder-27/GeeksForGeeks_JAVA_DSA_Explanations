/*
Stable Binary Sort
  
Given an array arr[] of integers, the task is to partition the array based on even and odd elements. The partition has to be stable, meaning the relative ordering of all even elements must remain the same before and after partitioning, and the same should hold true for all odd elements.

Note: For a binary array (containing only 0s and 1s), this partition process is equivalent to sorting the array.

Examples:

Input: arr[] = [1, 0, 1, 1, 0, 0]
Output: [0 ,0 ,0, 1, 1, 1]
Explanation: All even numbers came before the odd numbers.

Input: arr[] = [1, 2, 3, 4, 5]
Output: [2, 4, 1, 3, 5]
Explanation: All even numbers [2, 4] came before the odd numbers [1, 3, 5], and the relative ordering was also same.

Input: arr[] = [-5, -2, 0, 4, 7, 9]
Output: [-2, 0, 4, -5, 7, 9]
Explanation: All even numbers [-2, 0, 4] came before the odd numbers [-5, 7, 9], and the relative ordering was also same.
*/

import java.util.*;

// put even at front and odd nums are after even nums
class StableBinarySort{
	public static void main(String args[]){
		int[] arr = {2,9,11,-3,-8,45,66};
		int n = arr.length;

		int front = 0;

		for(int i=0;i<n;i++){
			if(arr[i] % 2 == 0){
				
				//put even nums at front
				int temp = arr[i];
				arr[i] = arr[front];
				arr[front] = temp;


				front++;
			}

		}
		System.out.println("After sort:");
		for(int num : arr){
			System.out.println(num);

		}

	}

}

/*
After sort:
2
-8
66
-3
9
45
11


/*
After sort:
2
-8
66
-3
9
45
11



i/p : 1,2,3,4,-4,5
o/p : 
After sort:
2
4
-4
1
3
5

*/
