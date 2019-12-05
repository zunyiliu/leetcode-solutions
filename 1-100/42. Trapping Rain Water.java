//solution1: brute force
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        for(int i=1;i<height.length;i++){
            int l_height = 0;
            int r_height = 0;
            for(int l=i-1;l>=0;l--){
                l_height = Math.max(l_height,height[l]);
            }
            for(int r=i+1;r<height.length;r++){
                r_height = Math.max(r_height,height[r]);
            }
            if(height[i]<Math.min(r_height,l_height))
            sum+=Math.min(r_height,l_height)-height[i];
        }
        return sum;
    }
}
