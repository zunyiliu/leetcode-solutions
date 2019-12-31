class Solution {
    public int mySqrt(int x) {
        long start = 1;
        long end = x;
        while(true){
            long mid = (start+end)/2;
            if(mid*mid==x) return (int)mid;
            if(mid*mid<x && (mid+1)*(mid+1)>x) return (int)mid;
            if(mid*mid<x) start = mid+1;
            else end = mid-1;
        }
    }
}
