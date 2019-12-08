// solution 1: not acceptable since -- O(m+n)
// solution 2: recursively binary search, 二分查找思想容易，分块难，奇数偶数个数搞不清楚

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int comb[] = new int[n+m];
        int p1 = 0, p2 = 0;
        while(p1<n || p2<m){
            int num1 = p1==n? Integer.MAX_VALUE:nums1[p1];
            int num2 = p2==m? Integer.MAX_VALUE:nums2[p2];
            if(num1<num2){
                comb[p1+p2] = num1;
                p1++;
            }else{
                comb[p1+p2] = num2;
                p2++;
            }
        }
        double l = (double)comb[(m+n-1)/2];
        double r = (double)comb[(m+n)/2];
        return (l+r)/2;
    }
}
