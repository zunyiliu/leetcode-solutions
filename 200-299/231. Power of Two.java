class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n<=0) return false;
        int lowbitOfn = n & (~n+1);
        
        return lowbitOfn == n;
    }
}
