//1. two pointers starting from left and right, merge them and record the max value
// brute force also works, naive method not mentioned here
class Solution {
    public int maxArea(int[] height) {
        int l = 0,r = height.length-1;
        int max = 0;
        
        while(l<r){
            int temp = Math.min(height[l],height[r])*(r-l);
            max = Math.max(max,temp);
            if(height[l]>height[r]){
                r--;
            }else{
                l++;
            }
        }
        return max;
    }
}
