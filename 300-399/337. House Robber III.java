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
