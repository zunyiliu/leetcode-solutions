// solution 1: DFS, try every possible combinations and return the max one
// hint -- for a given node, if it's parent's rob == true, it can't rob, return it's children dfs. If it's parent's rob == false, then it can choose either rob or not rob
// return the max value between a -- it's children dfs plus itself.val(rob) OR b-- it's children dfs (not rob)
 
// solution 2: top-down dp, memorized each node's rob/not rob maximum value

// solution 1
class Solution {
    int sum = -1;
    public int rob(TreeNode root) {
        return dfs(false,root);
    }
    
    public int dfs(boolean robParent,TreeNode cur){
        if(cur==null) return 0;
        if(robParent){
            return dfs(false,cur.left)+dfs(false,cur.right);
        }else{
            int rob = cur.val + dfs(true,cur.left) + dfs(true,cur.right);
            int notrob = dfs(false,cur.left) + dfs(false,cur.right);
            return Math.max(rob,notrob);
        }
    }
}

// solution 2
class Solution {
    public int rob(TreeNode root) {
        return Math.max(dfs(root)[0],dfs(root)[1]);
    }
    
    // int[0] for rob, int[1] for not rob
    public int[] dfs(TreeNode cur){
        if(cur==null) return new int[2];
        int res[] = new int[2];
        int left[] = new int[2];
        int right[] = new int[2];
        
        left = dfs(cur.left);
        right = dfs(cur.right);
        
        // if rob cur node, its left and right children must not rob
        res[0] = cur.val+left[1]+right[1];
        // if not rob cur node, you can choose 4 combinations of left and right children
        res[1] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return res;
    }
}
