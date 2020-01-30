// backtracking: for int from start to end, each element is a middle parent node, and its left part becomes its left subtree,
// and right vice versa. So, recursively call this method, u can get all possible combinations

// solution 2: dp, use dp[i] stands for all possibilities of number i, the key point here is that for any node i+1, iterate
// from 0 to i+1 can get all combinations of dp[i+1] based on pre-solved trees stored in dp[0] to dp[i]. E.g. 1,2,3,4. If dp[0]
// to dp[3] has been solved and dp[4] is the desired result, first iterate 1 to 4 standing for root of the trees of dp[4],
// for example when the current iterated root is 3, then its left subtree is dp[2], and right subtree is dp[1] plus an offset 3.
// another key point is the offset, that is, all subtrees with length i are sharing the same structure as stored in dp[i], the
// only difference is the values stored in each treee is different, thus plus an offset is neccessary.

// solution 3: another dp
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return new ArrayList();
        return recur(1,n);
    }
    public List<TreeNode> recur(int st,int end){
        List<TreeNode> subtree = new ArrayList();
        if(st==end || st>end){
            subtree.add(st==end? new TreeNode(st):null);
            return subtree;
        }
        for(int i=st;i<=end;i++){
            List<TreeNode> rightTree = recur(i+1,end);
            List<TreeNode> leftTree = recur(st,i-1);
            for(TreeNode rcomb:rightTree){
                for(TreeNode lcomb:leftTree){
                    TreeNode t = new TreeNode(i);
                    t.left = lcomb;
                    t.right = rcomb;
                    subtree.add(t);
                }
            }
        }
        return subtree;
    }
}

// solution 2
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> []dp = new ArrayList[n+1];
        dp[0] = new ArrayList();
        if(n==0) return dp[0];
        dp[0].add(null);
        
        for(int i=1;i<=n;i++){
            dp[i] = new ArrayList();
            // j stands for left subtree of current node
            // i-j stands for right subtree of current node
            for(int j=0;j<i;j++){
                for(TreeNode leftTree:dp[j]){
                    for(TreeNode rightTree:dp[i-j-1]){
                        TreeNode root = new TreeNode(j+1);
                        root.left = leftTree;
                        root.right = clone(rightTree,j+1);
                        dp[i].add(root);
                    }
                }
            }
        }
        return dp[n];
    }
    public TreeNode clone(TreeNode node,int offset){
        if(node==null) return null;
        TreeNode t = new TreeNode(node.val+offset);
        t.right = clone(node.right,offset);
        t.left = clone(node.left,offset);
        return t;
    }
}
