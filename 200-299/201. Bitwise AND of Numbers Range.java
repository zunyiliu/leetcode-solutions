// solution 1: constant time O(1) solution, bit manipulation
// 1. the range of m and n are between 0 to 2^31-1, we will calculate each bit's 1 or 0, and concatenate all 31 bits into the final number
// 2. we know there're num = n-m+1 numbers from m to n, observe the i-th bit
// 3. for 0-th bit, if num > 1 then 0-th bit must be 0(since there must be at least one 0)
//    for 1-th bit, if num > 2 then 1-th bit must be 0
//    for i-th bit, if num > 2^i, then i-th bit must be 0
// 4. if num < 2^i, we calculate the least number m's i-th bit and most number n's i-th bit, if both of them are not 0 then the i-th bit of result is 1, otherwise is 0
// 5. we do this bit by bit, with a for loop from 0 to 31, then we can joint the final result

// solution 2
// same way as solution 1 but simplified

// solution 3
// simplification of solution 2, observing solution 2, you
// can see that as while(m!=n) then we may judge if(n-m+1<=1 && n%2==1 && m%2==1) result += 1<<i;
// since m!=n then n-m+1 definitely > than 1 thus if(n-m+1<=1 && n%2==1 && m%2==1) result += 1<<i make no sense
// thus variable result makes no sense -> this is just by analysing the plain logic of the code, you can spend few minutes thinking the mind behind that
// and why the few lines of code is correct

// solution 1
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int range = n-m+1;
        int result = 0;
        int gap = 0;
        
        for(int i=0;i<31;i++){
            if(gap==0) gap = 1;
            else gap *= 2;
            if(gap<range) result += 0<<i;
            else{
                if((m>>i)%2==0 || (n>>i)%2==0){
                    result += 0<<i;
                }else{
                    result += 1<<i;
                }
            }
        }
        
        return result;
    }
}

// solution 2
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        int i = 0;
        
        while(m!=n){
            if(n-m+1<=1 && n%2==1 && m%2==1) result += 1<<i;
            m /= 2;
            n /= 2;
            i++;
        }
        
        return result|(m<<i);
    }
}

// solution 3
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        
        while(m!=n){
            m /= 2;
            n /= 2;
            i++;
        }    
        return m<<i;
    }
}
