// solution 1: naive way, nested-for loop to check every possible value and return the max one
// solution 2: stack based algorithm, hard to understand

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
