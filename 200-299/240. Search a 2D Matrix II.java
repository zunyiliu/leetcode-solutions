// solution 1: start from left-bot corner or right-top corner, move one step each time, O(n+m) complexity

// solution 2: Binary search


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
