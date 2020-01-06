// solution 1: naive way, nested-for loop to check every possible value and return the max one
// solution 2: 

// solution 1
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for(int i=0;i<heights.length;i++){
            int min = heights[i];
            for(int j=i;j<heights.length;j++){
                min = Math.min(heights[j],min);
                res = Math.max((j-i+1)*min,res);
            }
        }
        return res;
    }
}
