
/*
Chocolate Station
Difficulty: EasyAccuracy: 47.13%Submissions: 10K+Points: 2
Geek has an array arr, where arr[i] (1-based indexing) denotes the number of chocolates corresponding to each station. When he moves from station i to station i+1 he gets arr[i] - arr[i+1] chocolates for free, if this number is negative, he loses that many chocolates also.
He can only move from station i to station i+1 if he has a non-negative number of chocolates with him.
Given the cost of one chocolate Rs. price. Find the minimum cost incurred in reaching the last station from the first station (station 1).
Note: Initially Geek has 0 chocolates.

Examples:

Input: arr[] = [1, 2, 3], price = 10
Output:  30
Explanation: 
To reach the first station from the starting point, we need to buy 1 chocolate,To reach station 2 form station 1, we get arr[1] - arr[2] = -1 chocolates i.e. we lose 1 chocolate. 
Hence, we need to buy 1 chocolate.Similarly, we need to buy 1 chocolate to reach station 3 from station 2.
Hence, total cost incurred = (1+1+1)*10 = 30
Input: arr[] = [10, 6, 11, 4, 7, 1], price = 5
Output: 55
Explanation: 
To reach to the first station from starting
point he need to buy 10 chocolates. 
Chocolates Bought = 10,Chocolates balance = 0
On reaching second station he will get (10-6)= 4 chocolates.
Chocolates Bought= 10 , Chocolates balance = 4.
To reach to 3 station , he has to buy (6- 11) = 5 chocolates.But he has 4 chocolates as balance. So the chocolates he need to buy is (5 -4 ) =1;
Chocolates Bought= 11 , Chocolates balance = 0.
On reaching station 4 , he will get (11 - 4)= 7 chocolates.
Chocolates Bought= 11 , Chocolates balance = 7.
To reach to 5 station , he has to buy (4- 7)= 3 chocolates. But he has 7 chocolates as balance .
Chocolates Bought= 11 , Chocolates balance = 4.
To reach to 6 station , he will get (7- 1) = 6 chocolates. 
Chocolates Bought= 11 , Chocolates balance = 10.
Therefore, total chocolates he has to buy is 11.
Hence, Amount=11*5=55.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 103
1 ≤ price ≤ 10
*/
class Solution {
    public long getChocolateCost(int[] arr, int price) {
       long max = arr[0];
        for(long x : arr){
            max = (x > max) ? x : max;
        }
        return max*price;
    }
}

/*
Explanation:
The given solution focuses on finding the maximum value in the array arr and then multiplying this maximum value by the price per chocolate to get the total cost.

Here's why this approach works:

Initial Setup:

long max = arr[0];
This initializes max to the first element of the array, assuming it's the maximum value initially.

Finding the Maximum Value:

for(long x : arr) {
    max = (x > max) ? x : max;
}
This loop iterates through each element x in the array.

It updates max to the current element x if x is greater than the current max.

Calculating the Total Cost:
return max * price;
After finding the maximum value in the array, it multiplies this value by the price per chocolate to get the total cost.

Why This Works:
Initial Chocolate Requirement: The maximum number in the array represents the highest number of chocolates Geek needs at any station to move forward. Since he starts with 0 chocolates and can lose chocolates when moving between stations, ensuring he has at least this many chocolates will cover all possible losses.

Coverage for All Stations: By buying the maximum number of chocolates once, he ensures he can travel through all stations without needing additional purchases.

Thus, finding the maximum value in the array ensures Geek has enough chocolates to cover any losses and reach the end without needing additional purchases, resulting in the minimum total cost.
*/
