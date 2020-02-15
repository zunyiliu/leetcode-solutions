//**very interesting problem!***//
//*** this should be a same problem as in CLRS, for a given stock price graph, find the best strategy to sell and buy stock
//*** once and get the most profit, the book has given some interesting ideas for the problem(such as max subarray)

// soltuion 1--memorization: using two 1D array, 1 recording all min values before index i, another recording all max values after
// index i, then for any index i, u can know the min value on its left side and the max value on its right side. loop and calculate the 
// max result, this is not a very efficient algorith since it finds all best profit for all days' sell

// solution 2: interesting solution, iterate the array, if the current iterated cell has a smaller value than previous, change
// the min value to be the current one, otherwise there must be a profit (current value minus min value), compare the profit to
// the max profit, so keep track the max profit and min value, iterate the array can get the final max result

// solution 3: interesting solution, finding max subarray(Kadane's algorithm)

// solution 4: encouraged by the problem 123 O(n) solution, for each step imagine if we buy the stock or sell the stock

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
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int min = prices[0];
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min) min = prices[i];
            else profit = Math.max(profit,prices[i]-min);
        }
        return profit;
    }
}

// solution 3
class Solution {
    public int maxProfit(int[] prices) {
        int cur = 0, max = 0;        
        for(int i=1;i<prices.length;i++){
            cur = Math.max(0,cur+=prices[i]-prices[i-1]);
            max = Math.max(cur,max);  
        }
        return max;
    }
}

// solution 4
class Solution {
    public int maxProfit(int[] prices) {
        int b = -999999, s = 0;    
        for(int i=0;i<prices.length;i++){ 
            b = Math.max(b,-prices[i]);
            s = Math.max(s,b+prices[i]);
        }
        return s;
    }
}
