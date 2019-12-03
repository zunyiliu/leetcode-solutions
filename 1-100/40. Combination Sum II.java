//backtracking
//solution 1: each time wants to add a new list into res, check if it has existed in res, low effieciency
//solution 2: opmitization, check duplicate nums in for loop so that it can be skipped directly, higher efficiency
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        solve(candidates,res,target,new ArrayList<>(),0);
        return res;
    }
    public void solve(int[] candidates,List<List<Integer>> res,int target,List<Integer> cur,int start){
        for(int i=start;i<candidates.length;i++){
            cur.add(candidates[i]);
            if(candidates[i]<target){
                solve(candidates,res,target-candidates[i],new ArrayList<>(cur),i+1);
            }else if(candidates[i]==target){
                if(!res.contains(cur)){
                    res.add(new ArrayList<>(cur));
                }
                break;
            }
            cur.remove(cur.size()-1);
        }
    }
}

//solution 2:
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        solve(candidates,res,target,new ArrayList<>(),0);
        return res;
    }
    public void solve(int[] candidates,List<List<Integer>> res,int target,List<Integer> cur,int start){
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]) continue;
            cur.add(candidates[i]);
            if(candidates[i]==target){
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size()-1);
            }else if(candidates[i]<target){
                solve(candidates,res,target-candidates[i],new ArrayList<>(cur),i+1);
                cur.remove(cur.size()-1);
            }else{
                cur.remove(cur.size()-1);
                break;
            }
        }   
    }
}
