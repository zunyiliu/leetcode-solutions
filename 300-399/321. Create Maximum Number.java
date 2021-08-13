// solution 1: monotonic stack, first reduce then merge
//             1. create 1st max number of length i from nums1 and 2nd max number of length k-i from nums2
//             2. merge 1st max and 2nd max to the max number of length k
//             3. iterate all possible i and k-i and get the max
// solution 2: optimization, 

// solution 1
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int res[] = new int[k];
        
        for (int i = 0; i <= k; i++) {
            if (i > nums1.length || k-i > nums2.length) continue;
            
            int []n1 = getMax(nums1,i);
            int []n2 = getMax(nums2,k-i);
            int []n12 = merge(n1,n2);
            
            if (largerThan(n12,res,0,0)) {
                res = n12;
            }
        }
        
        return res;
    }
    
    public int[] getMax(int[] nums, int len) {
        if (len == 0) return new int[0];
        
        int res[] = new int[len];
        
        for (int i = 0; i < nums.length; i++) {
            int index = nums.length - i >= len ? 0 : len-(nums.length-i);
            
            for (int j = index; j < len; j++) {
                if (res[j] < nums[i]) {
                    res[j] = nums[i];
                    
                    for (int d = j+1; d < len; d++) {
                        res[d] = 0;
                    }
                    break;
                }
            }
        }
        
        return res;
    }
    
    public int[] merge(int[] n1, int[] n2) {
        int[] res = new int[n1.length+n2.length];
        
        int p = 0, p1 = 0, p2 = 0;
    
        while (p1 < n1.length || p2 < n2.length) {
            int num1 = p1 == n1.length? -1 : n1[p1];
            int num2 = p2 == n2.length? -1 : n2[p2];
            
            if (num1 < num2) {
                res[p] = n2[p2];
                p2++;
            } else if (num1 > num2) {
                res[p] = n1[p1];
                p1++;
            } else {
                if (!largerThan(n1,n2,p1,p2)) {
                    res[p] = n2[p2];
                    p2++;
                } else {
                    res[p] = n1[p1];
                    p1++;  
                }
            }
            p++;
        }
        
        return res;
    }
    
    public boolean largerThan(int n1[], int n2[], int i, int j) {
        while (i < n1.length && j < n2.length && n1[i] == n2[j]) {
            i++;
            j++;
        }
        
        if (i == n1.length) return false;
        if (j == n2.length) return true;
        return n1[i] > n2[j];
    }
}
