// solution 1: naive way, nested-for loop to check every possible value and return the max one
// solution 2: stack based algorithm, hard to understand

// solution 3: using memory, for each index i in height[], assume the left most index i1 that all indices between i1 and i have a higher or equal
// height than height[i], same concept assuming the right most index i2. We can know the max rectangle expanding from i is
// (i2-i1+1)*height[i]. We can also know that the max rectangle from all indices must be among these values, return the max one so 
// the max value is found
// the memory is used for recording left most and right most index for each i in height[], so that time complexity will become O(n)
// instead of O(n^2)

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

// solution 2
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int ans = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length) ? -1 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= cur) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans = Math.max(ans, h * w);
            } 
            stack.push(i);
        }
        return ans;
    }
}

// solution 3
public class Solution {
    public int largestRectangleArea(int[] height) {
        int max = 0;
        // left most index that cur i can expand
        int []l = new int[height.length];
        // right most index that cur i can expand
        int []r = new int [height.length];
        
        for(int i=0;i<height.length;i++){
            int p = i;
            while(p>0 && height[p-1]>=height[i]) p = l[p-1];
            l[i] = p;
        }
        
        for(int i=height.length-1;i>=0;i--){
            int p = i;
            while(p<height.length-1 && height[p+1]>=height[i]) p = r[p+1];
            r[i] = p;
        }
        
        for(int i=0;i<height.length;i++){
            max = Math.max(max,(r[i]-l[i]+1)*height[i]);
        }
        return max;
    }
}
