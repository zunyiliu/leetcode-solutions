// solution 1: dfs, easy problem won't make explanations here
// other solutions: a. bfs b. dp, very interesting, visit cells with values in increasing order, the min value cell can treat as a graph node with out-degree == 0

class Solution {
    int [][]matrix;
    int [][]depth;
    int m;
    int n;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int depth[][] = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                depth[i][j] = -1;
            }
        }
        this.depth = depth;
        this.matrix = matrix;
        this.m = m;
        this.n = n;
        
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                depth[i][j] = dfs(Integer.MIN_VALUE, i, j, 0);
                max = Math.max(depth[i][j], max);
            }
        }
        
        return max;
    }
    
    public int dfs(int pre, int i, int j, int len) {
        if (i < 0 || j < 0 || i >= m || j >= n || pre >= matrix[i][j]) {
            return len;
        }
        

        if (depth[i][j] != -1) {
            return len + depth[i][j];
        } else {
            int up = dfs(matrix[i][j], i - 1, j, 1);
            int down = dfs(matrix[i][j], i + 1, j, 1);
            int left = dfs(matrix[i][j], i, j - 1, 1);
            int right = dfs(matrix[i][j], i, j + 1, 1);
            depth[i][j] = Math.max(depth[i][j], Math.max(Math.max(down, up), Math.max(right, left)));
            return len + depth[i][j];
        }
    }
}
