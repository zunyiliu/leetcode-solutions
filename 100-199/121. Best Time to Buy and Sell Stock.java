//*** this should be a same problem as in CLRS, for a given stock price graph, find the best strategy to sell and buy stock
//*** once and get the most profit, the book has given some interesting ideas for the problem(such as max subarray)

// soltuion 1--memorization: using two 1D array, 1 recording all min values before index i, another recording all max values after
// index i, then for any index i, u can know the min value on its left side and the max value on its right side. loop and calculate the 
// max result, this is not a very efficient algorith since it finds all best profit for all days' sell

// solution 2:

// solution 1
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int []max = new int[prices.length];
        int []min = new int[prices.length];
        min[0] = prices[0];
        max[prices.length-1] = prices[prices.length-1];
        
        for(int i=1;i<prices.length;i++){
            min[i] = prices[i]<min[i-1]? prices[i]:min[i-1];
        }
        for(int i=prices.length-2;i>=0;i--){
            max[i] = prices[i]>max[i+1]? prices[i]:max[i+1];  
        }
        int res = 0;
        for(int i=0;i<prices.length;i++) res = Math.max(res,max[i]-min[i]);
        return res;
    }
}

//solution 2
