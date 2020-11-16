// solution 1: dfs tree traverse
class Solution {
    int sum = 0;
    public int countNodes(TreeNode root) {
        if (root == null) return sum;
        sum++;
        countNodes(root.left);
        countNodes(root.right);
        return sum;
    }
}

// same, but better code structure
class Solution {
    int sum = 0;
    public int countNodes(TreeNode root) {
        recur(root);
        return sum;
    }
    public void recur(TreeNode r) {
        if (r != null) {
            sum++;
            recur(r.left);
            recur(r.right);
        }
    }
}
