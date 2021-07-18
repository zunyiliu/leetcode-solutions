class NumArray {
    segtree root;
    public NumArray(int[] nums) {
        root = buildtree(nums,0,nums.length-1);
    }
    
    public void update(int index, int val) {
        update(index,val,root);
    }
    
    public void update(int index, int val, segtree root) {
        if (root.start == root.end) root.sum = val;
        else {
            int mid = (root.start + root.end) / 2;
            if (index <= mid) {
                update(index,val,root.left);
            } else {
                update(index,val,root.right);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    public int sumRange(int left, int right) {
       return sumRange(left,right,root);
    }
    
    public int sumRange(int left, int right, segtree root) {
        if (left == root.start && right == root.end) return root.sum;
        
        int mid = (root.start + root.end) / 2;
        if (right <= mid) {
            return sumRange(left,right,root.left);
        } else if (left > mid) {
            return sumRange(left,right,root.right);
        } else {
            return sumRange(left,mid,root.left) + sumRange(mid+1,right,root.right);
        }
    }
    
    public segtree buildtree(int[] nums,int start,int end) {
        if (start == end) {
            return new segtree(start,end,nums[start]);
        } else {
            int mid = (start+end)/2;
            
            segtree left = buildtree(nums,start,mid);
            segtree right = buildtree(nums,mid+1,end);
            segtree ret = new segtree(start,end,left.sum + right.sum,left,right);
            return ret;
        }
    }
    
    class segtree {
        int start, end, sum;
        segtree left, right;
        
        segtree(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
        
        segtree(int start, int end, int sum, segtree left, segtree right) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
