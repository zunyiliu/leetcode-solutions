// solution 1: brute force
// solution 2: merge sort, use merge sort, and when merge two sorted array during mergesort, calculate the number of smaller elements on each element's right

// solution 1
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList();
        
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length-1) res.add(0);
            else {
                int count = 0;
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] < nums[i]) count++;
                }
                res.add(count);
            }
        }
        
        return res;
    }
}

// solution 2
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        node[] nodes = new node[len];

        // node.val is an element'value in nums
        // node.index the index of the element in nums
        // nodex.count is the count of smaller elements to the right of res[i][0]
        for (int i = 0; i < len; i++) {
            nodes[i] = new node(nums[i],i,0);
        }

        node[] ret = mergesort(nodes);
        int [] res = new int[len];

        for (int i = 0; i < ret.length; i++) {
            res[ret[i].index] = ret[i].count;
        }

        List<Integer> listRes = new ArrayList();

        for (int x : res) listRes.add(x);
        return listRes;
    }

    public node[] mergesort(node[] nodes) {
        int len = nodes.length;
        if (len == 1) return nodes;

        node[] left = copyNodes(nodes,0,(len-1)/2);
        node[] right = copyNodes(nodes,(len-1)/2+1,len-1);
        left = mergesort(left);
        right = mergesort(right);
        return merge(left,right);
    }

    public node[] merge(node[] left, node[] right) {
        int l = 0;
        int r = 0;
        node[] ret = new node[left.length+right.length];

        while (l < left.length || r < right.length) {
            int leftVal = l == left.length? 999999 : left[l].val;
            int rightVal = r == right.length? 999999 : right[r].val;

            if (leftVal <= rightVal) {
                ret[l+r] = left[l];
                ret[l+r].count += r;
                l++;
            } else {
                ret[l+r] = right[r];
                r++;
            }
        }
        return ret;
    }

    public node[] copyNodes(node[] nodes, int st, int end) {
        node[] ret = new node[end-st+1];

        for (int i = 0; i <= end-st; i++) {
            ret[i] = nodes[i+st];
        }

        return ret;
    }

    class node {
        int val;
        int index;
        int count;

        public node(int val, int index, int count) {
            this.val = val;
            this.index = index;
            this.count = count;
        }
    }
}
