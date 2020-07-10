// solution 1: start from left-bot corner or right-top corner, move one step each time, O(n+m) complexity

// solution 2: Divide and Conquer, divide the square into four parts, discard zone 1 if target > matrix[rowMid][colMid]
// and discard zone 4 if target < matrix[rowMid][colMid]
  zone 1      zone 2
*  *  *  * | *  *  *  *
*  *  *  * | *  *  *  *
*  *  *  * | *  *  *  *
*  *  *  * | *  *  *  *
-----------------------
*  *  *  * | *  *  *  *
*  *  *  * | *  *  *  *
*  *  *  * | *  *  *  *
*  *  *  * | *  *  *  *
  zone 3      zone 4


// solution 1
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int row = 0;
        int col = matrix[0].length-1;
        
        while(row>=0 && row<matrix.length && col>=0 && col<matrix[0].length){
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]<target) row++;
            else col--;
        }
        
        return false;
    }
}

// solution 2
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int right[] = new int[n];
        int left[] = new int[n];
        int res[] = new int[n-k+1];
        
        
        for(int i=0;i<n;i++){
            if(i%k==0) left[i] = nums[i];
            else left[i] = Math.max(left[i-1],nums[i]);
        }
        
        for(int i=n-1;i>=0;i--){
            if(i==n-1 || (i+1)%k==0 ) right[i] = nums[i];
            else right[i] = Math.max(right[i+1],nums[i]);
        }
        
        for(int i=0;i<res.length;i++){
            res[i] = Math.max(right[i],left[i+k-1]);            
        }
        
        return res;
    }
}
