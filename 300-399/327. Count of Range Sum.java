// solution 1: merge sort
// split the problem into several sub-problem
// a. any range sum from i to j can be transferred to sum[j] - sum[i], where sum[x] represents preSum[x] which is the sum from nums[0] to nums[x]
// b. use divide and conquer, split the preSum into left part and right part, the result of origin array = result of left part + result of right part + mid part
// (where left part represents the range within left part's indices, and the same as right part, the mid part represents the range across left and right part)
// c. now we transfer the problem into a problem that calculate the count of ranges that across left and right part, naively this part's time complexity is O(N^2)
// d. we can sort left part and right part, then two sorted left and right parts' time complexity will reduce to O(N) (Proved, plz refer to leetcode answer)
// f. as we need sorted array, the merge sort can be introduced, and it's an O(NlogN) solution 

// solution 2: segment tree with Discretization

// solution 3: optimization, segment tree without discretization

// solution 4: binary indexed tree with Discretization

// solution 5: optimization, binary indexed tree without discretization

// solution 1
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long preSum[] = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }

        return mergeSort(preSum,0,preSum.length-1,lower,upper);
    }
    
    public int mergeSort(long[] preSum, int min, int max, int low, int up) {
        if (min == max) {
            return 0;
        } else {              
            int mid = (max - min) / 2 + min;
            int count = mergeSort(preSum, min, mid, low, up) + mergeSort(preSum, mid + 1, max, low, up);
            
            int r1 = mid + 1, r2 = mid + 1;
            for (int l = min; l <= mid; l++) {
                while (r1 <= max && preSum[r1] - preSum[l] < low) {
                    r1++;
                }
                while (r2 <= max && preSum[r2] - preSum[l] <= up) {
                    r2++;
                }
                count += r2 - r1;
            }
            
            long sorted[] = new long[max - min + 1];
            int p = 0, p1 = min, p2 = mid + 1;
            while (p1 <= mid || p2 <= max) {
                long num1 = p1 > mid ? Long.MAX_VALUE : preSum[p1];
                long num2 = p2 > max ? Long.MAX_VALUE : preSum[p2];
                sorted[p++] = num1 < num2? preSum[p1++] : preSum[p2++];
            }
            
            for (int i = 0; i < max - min + 1; i++) {
                preSum[min + i] = sorted[i];
            }
            
            return count;
        }
    }
}

// solution 2
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long []preSum = new long[nums.length+1];
        Set<Long> ts = new TreeSet();
        Map<Long, Integer> map = new HashMap();
        
        ts.add(preSum[0]);
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
            ts.add(preSum[i]);
            ts.add(preSum[i] - lower);
            ts.add(preSum[i] - upper);
        }
        
        // 离散化处理
        int index = -1;
        for (long num : ts) {
            map.put(num, ++index);
        }
        
        segNode root = buildSegTree(0, index);
        
        int count = 0;
        add(root, map.get(preSum[0]));
        for (int j = 1; j < preSum.length; j++) {
            int min = map.get(preSum[j] - upper);
            int max = map.get(preSum[j] - lower);
            int cur = map.get(preSum[j]);
            count += find(root, min, max);
            add(root, cur);
        }
        
        return count;
    }
    
    public void add(segNode node, int cur) {
        node.count++;
        if (node.min == node.max) {
            return;
        }
        
        int mid = (node.max - node.min) / 2 + node.min;
        if (cur <= mid) {
            add(node.left, cur);
        } else {
            add(node.right, cur);
        }
    }
    
    public int find(segNode node, int min, int max) {
        if (node.min == min && node.max == max) {
            return node.count;
        }
        
        int mid = (node.max - node.min) / 2 + node.min;
        
        if (mid >= max) {
            return find(node.left, min, max);
        } else if (mid + 1 <= min) {
            return find(node.right, min, max);
        } else {
            return find(node.left, min, mid) + find(node.right, mid + 1, max);
        }
    }
    
    public segNode buildSegTree(int min, int max) {
        segNode node = new segNode(min, max);
        if (min == max) {
            return node;
        }
        
        int mid = (max - min) / 2 + min;
        node.left = buildSegTree(min, mid);
        node.right = buildSegTree(mid + 1, max);
        return node;
    }
}

class segNode {
    int min;
    int max;
    int count;
    segNode left;
    segNode right;
    
    public segNode(int min, int max) {
        this.min = min;
        this.max = max;
    }
}
       
