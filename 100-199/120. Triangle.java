// solution 1: 2D-array DP, O(n^2) space complexity. The mind is that the current row's min path sum is determined by 
// pre row's min path sum plus current row's corresponding cell's value
// solution 2

// solution 1
class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        if(t.size()==0) return 0;
        Integer [][] res = new Integer[t.size()][t.size()];
        res[0][0] = t.get(0).get(0);
        
        for(int i=0;i<t.size()-1;i++){
            for(int j=0;j<t.get(i).size();j++){
                if(res[i+1][j]==null) res[i+1][j] = res[i][j]+t.get(i+1).get(j);
                else res[i+1][j] = Math.min(res[i][j]+t.get(i+1).get(j),res[i+1][j]);
                if(res[i+1][j+1]==null) res[i+1][j+1] = res[i][j]+t.get(i+1).get(j+1);
                else res[i+1][j+1] = Math.min(res[i][j]+t.get(i+1).get(j+1),res[i+1][j+1]);
            }
        }
        int min = 999999;
        for(int i=0;i<res.length;i++){
            if(res[res.length-1][i]<min) min = res[res.length-1][i];
        }
        return min;
    }
}
