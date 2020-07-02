// solution 1: DFS, iterate all grids, once a grid is '1', expand that grid to all its neighbours that are '1's, and increment count 1 as one more island.

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    search(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void search(char[][] grid,int i,int j){
        if(i==-1 || j==-1 || i==grid.length || j==grid[0].length) return;
        if(grid[i][j]=='1'){
            grid[i][j] = '0';
            search(grid,i-1,j);
            search(grid,i+1,j);
            search(grid,i,j-1);
            search(grid,i,j+1);
        }
    }
}
