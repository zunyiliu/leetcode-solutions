// solution 1: in-order tree traversal, the key point here is to traverse the tree and find two invalid nums.
// since the BST's in-order traverse will get ascending order nums, so the two invalid pair of nums are the location of the two swapped
// nums. Since it must be a larger num swapping with a smaller num, and the smaller number must occur before the larger number, thus
// the first invalid pair must be the smaller num's slot so the previous node is the invalid one, and for the larger number's slot the
// current num's slot is the invalid one. (Also the edge case which the two numbers in one pair swapped their positions, and in this case
// it still works like above) 

// solution 2: morris traverse using O(1) extra space, same concept using in-order traverse however morris traverse only needs constant
// extra space

// solution 1
class Solution {
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
        recur(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void recur(TreeNode node){
        if(node!=null){
            recur(node.left);
            visit(node);
            recur(node.right);
        }
    }
    public void visit(TreeNode node){
        if(pre.val>node.val){
            // notice these lines to deal with edge case(while one pair occurs two swapped numbers)
            if(first == null) {
                first = pre;
                second = node;
            }else second = node;
        }
        pre = node;
    }
}

// solution 2
