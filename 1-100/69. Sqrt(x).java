// solution 1: newton's method maybe? just binary search
// solution 2: few lines

//solution 1
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

//solution 2
class Solution {
    public int mySqrt(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
}
