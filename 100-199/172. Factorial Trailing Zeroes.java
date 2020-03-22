// find how many 5s in the n! operations(since the amount of 2 is much bigger than 5)
// e.g n = 26, then there should be 5 numbers that smaller than 26 and can be divided by 5 -- 5,10,15,20,25
// however, 25 = 5*5 that is two 5, so f(n) = n/5 + f(n/5) is the final equation

class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;
        while(n>0){
            n /= 5;
            sum += n;
        }
        return sum;
    }
}
