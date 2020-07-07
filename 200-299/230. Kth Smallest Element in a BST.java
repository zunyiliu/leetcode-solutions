// solution 1: inorder tree traversal, recursion
// solution 2: morris traverse

// solution 1
class Solution {
    int count = 0;
    int res = -999;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return res;
    }
    
    public void inorder(TreeNode root,int k){
        if(root!=null){
            inorder(root.left,k);
            count++;
            if(count==k){
                res = root.val;
            }
            inorder(root.right,k);
        }
    }
}

// solution 2
class Solution {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        
        while(root!=null){
            if(root.left==null){
                count++;
                if(count==k){
                    return root.val;
                }else{
                    root = root.right;
                }
            }else{
                TreeNode cur = root.left;
                while(cur.right!=null && cur.right!=root){
                    cur = cur.right;
                }
                if(cur.right==root){
                    cur.right = null;
                    count++;
                    if(count==k){
                        return root.val;
                    }else{
                        root = root.right;
                    }
                }else{
                    cur.right = root;
                    root = root.left;
                }
            }
        }
        return -1;
    }
}
