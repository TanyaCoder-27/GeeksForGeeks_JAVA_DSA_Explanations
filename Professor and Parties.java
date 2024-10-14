/*
Professor and Parties
Difficulty: EasyAccuracy: 37.94%Submissions: 24K+Points: 2
A professor attended a party and classified it into two categories based on the colors of the robes. If all party members are wearing different colored robes, represented by positive integers in the array arr[], then it is a girl's only party. If there is at least one duplicate color, it is a boy's party. Determine the type of party by returning “true” if it’s a boy’s party, otherwise, return “false”.

Examples:

Input: arr[] = [1, 2, 3, 4, 7]
Output: false
Explanation: All the colors are unique so it's a GIRLS party.
Input: arr[] = [1, 3, 2, 4, 5, 1]
Output: true
Explanation: There are two colors 1. So it's a BOYS party.


Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints
1 ≤ arr.size() ≤ 106
1 ≤ arri ≤ 109
*/

class Solution {

    public static String PartyType(int arr[]) {
        //different colors -> +ve integers ->girls party
        //atleast one duplicate color i.e., atleast one duplicate number -> boys party
        Set<Integer> uniq = new HashSet<>();   
        int tot =arr.length, uni = 0;
        for(int i : arr){
            if(!uniq.contains(i)){
                uni++;
                uniq.add(i);
            }
        }
        if(tot == uni){        //simply total count(array length) and unique elements count are same means no duplicate -> girls party!
            return "false";
        }
        return "true";
    }
}
