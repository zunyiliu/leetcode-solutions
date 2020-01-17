// solution 1 : recursive tree traversal
class Solution {
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList();
		walk(res,root);
		return res;
	}
	public void walk(List<Integer> res,TreeNode root){
		if(root!=null){
			walk(res,root.left);
			res.add(root.val);
			walk(res,root.right);
		}
	}
}
