//basic idea: For each height[i], calculate the max right wall and max left wall, the shorter wall between left& right is the 
//limit water that index i can hold, loop all height[] and sum up the total amount of water
//solution1: brute force
//solution2: dynamic programming, same same solution1, but record left_max and right_max in arrays so it wouldn't be calculated every time
//solution3: use two pointers left and right, move them towards middle, track the highest wall on each side thus calculating
//the water can be held for each index while left and right are moving toward
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

//solution 2 dynamic programming
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int [] lmax = new int[height.length];
        int [] rmax = new int[height.length];
        int l = 0;
        int r = 0;
        for(int i=0;i<height.length;i++){
            l = Math.max(l,height[i]);
            lmax[i] = l;
            r = Math.max(r,height[height.length-i-1]);
            rmax[height.length-i-1] = r;
        }
        for(int i=1;i<height.length-1;i++){
            int wall = Math.min(lmax[i-1],rmax[i+1]);
            if(wall>height[i]){
                sum+=wall-height[i];
            }
        }
        return sum;
    }
}
//solution 3:
class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length-1;
        int lmax = 0, rmax = 0;
        int sum = 0;
        while(l<r){
            if(height[l]>lmax) lmax = height[l];
            if(height[r]>rmax) rmax = height[r];
            if(lmax>rmax){
                sum+=rmax-height[r];
                r--;
            }else{
                sum+=lmax-height[l];
                l++;
            }
        }
        return sum;
    }
}
