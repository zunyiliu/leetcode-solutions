// backtracking

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList();
        backtrack(new ArrayList(),0,n,k);
        return res;
    }
    public void backtrack(List<Integer> cur,int start,int n,int k){
        if(k==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=start;i<n;i++){
            cur.add(i+1);
            backtrack(cur,i+1,n,k-1);
            cur.remove(cur.size()-1);
        }
    }
}
