// solution 1: split the array into two subarrays(so the problem is sperated into two 1 transaction easy problem), 
// iterate all possible splitting and find the one returning max result

// solution 2: O(n) complexity, for each step, assume if you 1st buy the stock, assume if you 1st sell the stock, 
// assume if you 2nd buy the stock, assume if you 2nd sell the stock. The key is for the 2nd buy stock, your actual
// cost is the profit earned by 1st transaction minus current stock'price, so 2nd buy should = 1st transaction - 2nd buy's price

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

// solution 2
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int b1 = -prices[0], s1 = 0, b2 = s1-prices[0], s2 = 0;
        for(int i=1;i<prices.length;i++){
            b1 = Math.max(b1,-prices[i]);
            s1 = Math.max(s1,b1+prices[i]);
            b2 = Math.max(b2,s1-prices[i]);
            s2 = Math.max(s2,b2+prices[i]);
        }
        return s2;
    }
}
