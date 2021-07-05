/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        if (root == null) return res;
        visit(res, new StringBuilder(), root);
        
        return res;
    }
    
    public void visit(List<String> res, StringBuilder sb, TreeNode root) {
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else{
            sb.append("->");
            if (root.left != null) visit(res, new StringBuilder(sb),root.left);
            if (root.right != null) visit(res, new StringBuilder(sb),root.right);
        }      
    }
}
