class Solution{
	public boolean isSameTree(TreeNode p, TreeNode q){
		int pval = p==null? -99999:p.val;
		int qval = q==null? -99999:q.val;
		if(pval!=qval) return false;
        if(p==null && q==null) return true;
		return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
	}
}
