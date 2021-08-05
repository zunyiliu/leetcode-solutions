// solution 1: 2D dp, draw the graph of state machine
// solution 2: as the state n+1 is only influenced by state n, so we simpliefied the memory utilization from O(k*prices.length) to O(k)

// solution 1
class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len == 0 || k == 0) return 0;
        
        int cansell[][] = new int[k+1][len];
        int canbuy[][] = new int[k+1][len];
        
        // init dps 
        for (int j = 0; j < len; j++) {
            canbuy[0][j] = 0;
            for (int i = 1; i <= k; i++) {
                canbuy[i][j] = -999999999;
                cansell[i][j] = -999999999;
            }
        }
        
        int max = 0;
        cansell[1][0] = -prices[0];
        for (int j = 1; j < len; j++) {
            for (int i = 1; i <= k; i++) {
                cansell[i][j] = Math.max(cansell[i][j-1],canbuy[i-1][j-1]-prices[j]);
                canbuy[i][j] = Math.max(canbuy[i][j-1],cansell[i][j-1]+prices[j]);
                max = Math.max(canbuy[i][j],max);
            }
        }
        
        return max;
    }
}

// solution 2
class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len == 0 || k == 0) return 0;
        
        int cansell[] = new int[k+1];
        int canbuy[] = new int[k+1];
        
        Arrays.fill(cansell,-1001);
        Arrays.fill(canbuy,-1001);
        canbuy[0] = 0;
        cansell[1] = -prices[0];
        
        int max = 0;
        for (int i = 1; i < len; i++) {
            for (int n = 1; n < k+1; n++) {
                canbuy[n] = Math.max(canbuy[n], cansell[n] + prices[i]);
                if (canbuy[n-1] != -1001) cansell[n] = Math.max(cansell[n], canbuy[n-1] - prices[i]);
                max = Math.max(canbuy[n],max);
            } 
        }
        
        return max;
    }
}

// solution 2
