// backtrack, try add numbers from small to big, go deep and if not right move back one step and try another deep, it's actually a dfs with backtracking

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        
        backtrack(k,n,0,new ArrayList(),res);
        return res;
    }
    
    public void backtrack(int k, int n, int last, List<Integer> cur, List<List<Integer>> res) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        if (k == 0 || n == 0) return;
        
        for (int i = last+1; i <= 9; i++) {
            cur.add(i);
            backtrack(k-1,n-i,i,cur,res);
            cur.remove(cur.size()-1);
        }
    }
}
