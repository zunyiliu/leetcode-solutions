// solution 1, 1.1 backtracking -- dfs
// solution 2 : bfs, add nums layer by layer
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
class Solution {
    public List<List<Integer>> combine(int n, int k) {
      	List<List<Integer>> res = new ArrayList<>();
       	if (n < k) return res;
        
        while(k>0){
            List<List<Integer>> res1 = new ArrayList();
            if(res.size()==0){
                for(int j=1;j<=n-k+1;j++) res.add(new ArrayList<>(Arrays.asList(j)));
            }else{
                for(int i=0;i<res.size();i++){
                    int num = res.get(i).get(res.get(i).size()-1);
                    for(int j=num+1;j<=n-k+1;j++){
                        List<Integer> temp = new ArrayList<>(res.get(i));
                        temp.add(j);
                        res1.add(temp);
                    }
                }
                res = res1;
            }
            k--;
        }
        return res;
    }
}

// solution 3
// both solutions commented/not commented in while loop work, just different way operating pointer
class Solution {
    public List<List<Integer>> combine(int n, int k) {
      	List<List<Integer>> res = new ArrayList<>();
       	if (n < k) return res;
        Integer[] cur = new Integer[k];
        for (int i = 0; i < k; i++) cur[i] = i+1;
        int p = k-1;
        while(p>=0){
            // if(p==k-1){
            //     res.add(new ArrayList(Arrays.asList(cur)));
            //     if(cur[p]==p+n-k+1) p--;
            //     else cur[p]++;
            // }else{
            //     if(cur[p]<p+n-k+1){
            //         cur[p]++;
            //         for(int i=p+1;i<k;i++) cur[i] = cur[i-1]+1;
            //         p = k-1;               
            //     }else p--;
            // }
            if(cur[p]<=p+n-k+1){
                if(p==k-1){
                    res.add(new ArrayList(Arrays.asList(cur)));
                    cur[p]++;
                }else{
                    cur[p]++;
                    for(int i=p+1;i<k;i++) cur[i] = cur[i-1]+1;
                    p = k-1;
                }
            }else p--;
        }
        return res;
    }
}
