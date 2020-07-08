// solution 1: backtracking, find p's and q's parents and stroe them into lists, compare the two lists
// and track till the last node that are common parent for both p and q

// solution 1
class Solution {
    List<TreeNode> pParents;
    List<TreeNode> qParents;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q,new Stack());
        int size = Math.min(pParents.size(),qParents.size());
        
        for(int i=0;i<size;i++){
            if(pParents.get(i)==qParents.get(i)) root = pParents.get(i);
            else break;
        }
        return root;
    }
    
    public void dfs(TreeNode root,TreeNode p,TreeNode q,Stack<TreeNode> stack){
        if(root!=null){
            stack.push(root);
            if(root==p){
                pParents = new ArrayList(stack);
            }
            if(root==q){
                qParents = new ArrayList(stack);
            }
            dfs(root.left,p,q,stack);
            dfs(root.right,p,q,stack);
            stack.pop();
        }
    }
}
