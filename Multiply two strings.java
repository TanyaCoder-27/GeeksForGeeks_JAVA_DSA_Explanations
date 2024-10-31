/*

Multiply two strings
Difficulty: MediumAccuracy: 20.06%Submissions: 214K+Points: 4
Given two numbers as strings s1 and s2. Calculate their Product.

Note: The numbers can be negative and You are not allowed to use any built-in function or convert the strings to integers. There can be zeros in the begining of the numbers. You don't need to specify '+' sign in the begining of positive numbers.

Example 1:

Input:
s1 = "0033"
s2 = "2"
Output:
66
Example 2:

Input:
s1 = "11"
s2 = "23"
Output:
253
Your Task: You don't need to read input or print anything. Your task is to complete the function multiplyStrings() which takes two strings s1 and s2 as input and returns their product as a string.

Expected Time Complexity: O(n1* n2)
Expected Auxiliary Space: O(n1 + n2); where n1 and n2 are sizes of strings s1 and s2 respectively.

Constraints:
1 ≤ length of s1 and s2 ≤ 103

*/

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        //code here.
        BigInteger b1 = new BigInteger(s1);
        BigInteger b2 = new BigInteger(s2);
        return (b1.multiply(b2))+"";
    }
}


/*
BigInteger is a class in java.math package that allows for mathematical operations on arbitrarily large integers.

The multiply() method belongs to the BigInteger class in Java, which is part of the java.math package. This class provides operations for arithmetic, comparison, modular arithmetic, and other number-theoretic operations with integers of arbitrary precision.

*/
