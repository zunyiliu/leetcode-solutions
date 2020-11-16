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
