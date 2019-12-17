//先按对角线翻转，再把每一行头尾对调
//reverse diagonally first, then reverse head and tail order in each line of the matrix --> get clockwise rotate 90degree effect
//e.g after these two steps you will get following result
//1 2 3     1 4 7     7 4 1
//4 5 6 --> 2 5 8 --> 8 5 2
//7 8 9     3 6 9     9 6 3
//the truth is that you want 1st row of matrix to become last column of the matrix
// 2nd row become second last column of the matrix
// ...
// last row to become 1st column of the matrix
// so on and so forth

class Solution {
    public void rotate(int[][] matrix) {
        //Reverse diagonally
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<=i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //make each line of matrix to be reverse order
        //e.g 1,2,3,4 in one line to become 4,3,2,1
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = temp;
            }
        }
    }
}
