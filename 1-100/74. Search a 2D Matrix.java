// solution 1: use binary search firstly find the row the number belongs to, then use second binary search to find
// if the target is in the corresponding row
// solution 2: use binary search operating on the 2-D array directly(treats 2-D array as 1-D by considering the transformation
// of coordination)

// solution 1
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0 ||matrix[0][0]>target) return false;
        int row = searchRow(matrix,target,0,matrix.length-1);
        return searchCol(matrix[row],target,0,matrix[row].length-1);
    }
    public int searchRow(int[][] matrix,int target,int s,int end){
        int mid = (s+end)/2;
        if(matrix[mid][0]==target) return mid;
        if(matrix[mid][0]<target){
            if(mid==matrix.length-1) return mid;
            else if(matrix[mid+1][0]>target) return mid;
            else return searchRow(matrix,target,mid+1,end);
        }
        return searchRow(matrix,target,s,mid-1);
    }
    public boolean searchCol(int []line,int target,int s,int end){
        if(s>end) return false;
        int mid = (s+end)/2;
        if(target == line[mid]) return true;
        if(target > line[mid]) return searchCol(line,target,mid+1,end);
        else return searchCol(line,target,s,mid-1);
    }
}

// solution 2
