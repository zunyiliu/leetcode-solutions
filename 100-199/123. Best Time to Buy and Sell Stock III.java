// solution 1: split the array into two subarrays(so the problem is sperated into two 1 transaction easy problem), 
// iterate all possible splitting and find the one returning max result

// solution 1
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i=0;i<prices.length;i++){
            max = Math.max(max,cal(prices,i));
        }
        return max;
    }
    public int cal(int[] p,int len){
        int min = 9999999, max = 0;
        for(int i=0;i<len;i++){
            if(p[i]<min){
                min = p[i];
            }else{
                max = Math.max(p[i]-min,max);
            }
        }
        int min2 = 999999, max2 = 0;
        for(int i=len;i<p.length;i++){
            if(p[i]<min2) min2 = p[i];
            else max2 = Math.max(p[i]-min2,max2);
        }
        return max+max2;
    }
}
