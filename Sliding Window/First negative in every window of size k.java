/*
First negative in every window of size k
Difficulty: MediumAccuracy: 48.61%Submissions: 176K+Points: 4Average Time: 15m
Given an array arr[]  and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.

Note: If a window does not contain a negative integer, then return 0 for that window.

Examples:

Input: arr[] = [-8, 2, 3, -6, 10] , k = 2
Output: [-8, 0, -6, -6]
Explanation:
Window {-8, 2}: First negative integer is -8.
Window {2, 3}: No negative integers, output is 0.
Window {3, -6}: First negative integer is -6.
Window {-6, 10}: First negative integer is -6.
Input: arr[] = [12, -1, -7, 8, -15, 30, 16, 28] , k = 3
Output: [-1, -1, -7, -15, -15, 0] 
Explanation:
Window {12, -1, -7}: First negative integer is -1.
Window {-1, -7, 8}: First negative integer is -1.
Window {-7, 8, -15}: First negative integer is -7.
Window {8, -15, 30}: First negative integer is -15.
Window {-15, 30, 16}: First negative integer is -15.
Window {30, 16, 28}: No negative integers, output is 0.
Input: arr[] = [12, 1, 3, 5] , k = 3
Output: [0, 0] 
Explanation:
Window {12, 1, 3}: No negative integers, output is 0.
Window {1, 3, 5}: No negative integers, output is 0.

Constraints:
1 <= arr.size() <= 106
-105 <= arr[i] <= 105
1 <= k <= arr.size()
*/

//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


class Solution {

    static List<Integer> FirstNegativeInteger(int arr[], int k) {
        // write code here
        int n=arr.length;
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<=n-k;i++){
            boolean zero = false;
            for(int j=i;j<i+k;j++){
                if(arr[j]<0){
                    res.add(arr[j]);
                    zero=true;
                    break;
                }
            }
            if(!zero){
                    res.add(0);
                    zero=true;
                }
            }
            
      return res;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            List<Integer> ans = ob.FirstNegativeInteger(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
