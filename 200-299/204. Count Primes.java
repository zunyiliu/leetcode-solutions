// use memorization, an boolean array that records all numbers smaller than n, where array[x] == false means x is not a prime, vice versa
// start from i = 2, we can know all numbers i*j(j is not a integer) are not prime
// make sure i*j shoud smaller than n, and be careful for edge case while i^2 is outrangede of Integer.MAX_VALUE -> this will incur i*j = a negative value that is smaller than n

class Solution {
    public int countPrimes(int n) {
        boolean dp[] = new boolean[n];
        int count = 0;
        
        for(int i=2;i<n;i++){
            if(!dp[i]){
                
                count++;
                if(i>=Math.sqrt(Integer.MAX_VALUE) )continue;
                
                for(int j=i;i*j<n;j++){
                    dp[i*j] = true;
                }
            }
        }
        
        return count;
    }
}
