/*

Winner of an election
Difficulty: EasyAccuracy: 53.75%Submissions: 92K+Points: 2
Given an array of n names arr of candidates in an election, where each name is a string of lowercase characters. A candidate name in the array represents a vote casted to the candidate. Print the name of the candidate that received the maximum count of votes. If there is a draw between two candidates, then print lexicographically smaller name.

Examples :

Input: n = 13
arr[] = {john,johnny,jackie,johnny,john,jackie,jamie,jamie,john,johnny,jamie,johnny,john}
Output: john 4
Explanation: john has 4 votes casted for him, but so does johnny. john is lexicographically smaller, so we print john and the votes he received.
Input: n = 3
arr[] = {andy,blake,clark}
Output: Andy 1
Explanation: All the candidates get 1 votes each. We print andy as it is lexicographically smaller.
Your Task:
You only need to complete the function winner() that takes an array of strings arr, and length of arr n as parameters and returns an array of string of length 2. First element of the array should be the name of the candidate and second element should be the number of votes that candidate got in string format.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 105
1 <= |arri| <= 105

*/

class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        TreeMap<String,Integer> map=new TreeMap<>();                              
        
        for(String s:arr)
        {
            map.put(s,map.getOrDefault(s,0)+1);
        }
        
        String ans="";
        
        int max=Integer.MIN_VALUE;
        
        for(String s:map.keySet())
        {
            int t=map.get(s);
            if(t>max)
            {
                max=t;
                ans=s;
            }
        }
        
        String res[]={ans,String.valueOf(max)};
        return res;
    }
}

/*

Explanation:
---Class and Function Definition:

The class Solution contains a static method winner that returns an array of strings. This array consists of the name of the candidate with the maximum votes and the number of votes received.

---TreeMap Initialization:

TreeMap<String,Integer> map=new TreeMap<>();
A TreeMap named map is initialized to store the candidate names as keys and their vote counts as values. TreeMap is used because it maintains the keys in sorted order.

---Counting Votes:

for(String s:arr) {
    map.put(s,map.getOrDefault(s,0)+1);
}
This loop iterates through the array arr containing candidate names.

For each candidate name s, it updates the vote count in the map. If the candidate name is not already in the map, it initializes the count to 0 and then increments it by 1.

---Finding the Candidate with Maximum Votes:

String ans="";
int max=Integer.MIN_VALUE;
for(String s:map.keySet()) {
    int t=map.get(s);
    if(t>max) {
        max=t;
        ans=s;
    }
}
This part initializes ans to an empty string to hold the name of the candidate with the maximum votes.

max is initialized to the minimum possible integer value.

The loop iterates through the keys (candidate names) in the map.

For each candidate name s, it retrieves the vote count t.

If t is greater than the current max, it updates max to t and ans to s.

---Returning the Result:

String res[]={ans,String.valueOf(max)};
return res;
The result array res is created with two elements: the candidate name with the maximum votes (ans) and the maximum votes converted to a string (String.valueOf(max)).

The method returns this result array.
*/
