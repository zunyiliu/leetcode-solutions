// solution 1, 1.1 backtracking
// solution 2 : bfs
// solution 3: iteration

// solution 1
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

// solution 1.1
// one line optimization
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
        // i<=n-k is enough, since if i exceed that there will be no enough numbers for further k
        // thus no need to call backtrack for those numbers
        // e.g n=4 k=3, u can not call backtrack start from 3, since 3,4 only has two numbers which smaller than k
        for(int i=start;i<=n-k;i++){
            cur.add(i+1);
            backtrack(cur,i+1,n,k-1);
            cur.remove(cur.size()-1);
        }
    }
}

// solution 2
