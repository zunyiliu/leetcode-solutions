// solution 1 & 1.1: backtracking same concept but add time different
// solution 2 : iteration solution, should consider previous res's size, for not doing duplicate nums in array

//olution 1
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        recur(res,new ArrayList(),0,nums);
        res.add(new ArrayList());
        return res;
    }
    public void recur(List<List<Integer>> res,List<Integer> cur,int st,int[] nums){
        if(st<nums.length){
            for(int i=st;i<nums.length;i++){
                if(i==st || nums[i-1]!=nums[i]){
                    cur.add(nums[i]);
                    res.add(new ArrayList(cur));
                    recur(res,cur,i+1,nums);
                    cur.remove(cur.size()-1);
                }
            }
        }
    }
}

//solution 1.1
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        recur(res,new ArrayList(),0,nums);
        return res;
    }
    public void recur(List<List<Integer>> res,List<Integer> cur,int st,int[] nums){
        res.add(new ArrayList(cur));
        if(st<nums.length){
            for(int i=st;i<nums.length;i++){
                if(i==st || nums[i-1]!=nums[i]){
                    cur.add(nums[i]);
                    recur(res,cur,i+1,nums);
                    cur.remove(cur.size()-1);
                }
            }
        }
    }
}

// solution 2
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        res.add(new ArrayList());
        
        int size = 0;
        for(int i=0;i<nums.length;i++){
            int stsize;
            if(i==0 || nums[i-1]!=nums[i]) stsize = 0;
            else stsize = size;
            size = res.size();
            for(int j=stsize;j<size;j++){
                List<Integer> tp = new ArrayList(res.get(j));
                tp.add(nums[i]);
                res.add(tp);
            }  
        }
        return res;
    }
}
