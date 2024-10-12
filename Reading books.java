/*
Reading books
Difficulty: BasicAccuracy: 62.22%Submissions: 4K+Points: 1
There are some kinds of books. Geek has to choose a book of a particular kind and read it loudly as many times as he can in the given time and earn points. Geek knows that reading a book of kind i once needs arr1i minutes and it will give him arr2i points. Geek has k minutes for reading books. During this time, he can only read a book of a particular kind as many times as he can so as to maximize his points. But he can not pick books of different kinds. Find the maximum points Geek can get. 

Examples:

Input: k = 10, arr1 = [3, 4, 5], arr2 = [4, 4, 5]
Output: 12
Explanation: If Geek picks book of first kind he can read it 3 times, he will get 3*4 = 12 points. If Geek picks book of second kind he can read it 2 times, he will 2*4 = 8 points. If Geek picks book of third kind he can read it 2 times, he will get 2*5 = 10 points. So the maximum possible points which he can earn in those 10 minutes is 12.
Input: k = 12, arr1 = [8, 5], arr2 = [100, 5]
Output: 100
Explanation: If Geek picks book of first kind he can read it 1 times, he will get 100*1 = 100 points. If Geek picks book of second kind he can read it 2 times, he will 5*2 = 10 points. So the maximum possible points which he can earn in those 12 minutes is 100.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ K, arr1i, arr2i ≤ 106
*/

class Solution {
    public int maxPoint(int k, int[] arr1, int[] arr2) {
        int maxPoints = 0;
        
        for (int i = 0; i < arr1.length; i++) {
            int maxReads = k / arr1[i]; // Maximum times book i can be read within k minutes
            int points = maxReads * arr2[i]; // Total points for reading book i maxReads times
            maxPoints = Math.max(maxPoints, points); // Update maxPoints if this book gives more points
        }
        
        return maxPoints;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr1_1 = {3, 4, 5};
        int[] arr2_1 = {4, 4, 5};
        int k1 = 10;
        System.out.println(sol.maxPoint(k1, arr1_1, arr2_1)); // Output: 12

        int[] arr1_2 = {8, 5};
        int[] arr2_2 = {100, 5};
        int k2 = 12;
        System.out.println(sol.maxPoint(k2, arr1_2, arr2_2)); // Output: 100
    }
}

/*
Explanation:

-Initialize maxPoints:

Start with maxPoints as 0 to keep track of the highest points possible.

-Iterate through Books:

For each book i:

Calculate maxReads which is the maximum number of times book i can be read within the given k minutes.

Calculate points for reading book i maxReads times.

Update maxPoints to be the maximum of the current maxPoints and points.

-Return maxPoints:

After iterating through all books, return maxPoints which gives the maximum points Geek can achieve within the given time.

*/
