class Solution {
    public int singleNumber(int[] nums) {
        //we need to implement a tree-time counter(base 3) that if a bit appears three time ,it will be zero.
        //#curent  income  ouput
        //# ab      c/c       ab/ab
        //# 00      1/0       01/00
        //# 01      1/0       10/01
        //# 10      1/0       00/10
        // a=~abc+a~b~c;
        // b=~a~bc+~ab~c;
        // a,b,c are both 32-bits number
        // since a OP b is do OP for all corresponding bits in a and b
        // a,b,c can be considered as 1 bit operation (since it works for every bit
        // in a,b,c. And after operations for all bits it works for the whole 32-bits)
        int a = 0;
        int b = 0;
        for(int c:nums){
            int a1 = a;
            a = (~a1&b&c)|(a1&~b&~c);
            b = (~a1&~b&c)|(~a1&b&~c);
        }
        // since every one occurs 3 times except one occurs 1 time, the one occurs 1 time will have truth table "ab"--"01"
        // thus return b or return a|b both work
        return b;
    }
}
