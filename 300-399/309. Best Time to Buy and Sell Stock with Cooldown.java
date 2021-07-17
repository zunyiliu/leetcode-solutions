// dp with state machine，draw the state machine picture, there're 3 states, canbuy, cansell, cancool, draw how they transfer among each other then the coding will be easy

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int []canbuy = new int[len];
        int []cansell = new int[len];
        int []cancool = new int[len];
        
        canbuy[0] = 0;
        cansell[0] = -prices[0];
        cancool[0] = 0;
        
        for (int i = 1; i < len; i++) {
            canbuy[i] = Math.max(canbuy[i-1],cancool[i-1]);
            cansell[i] = Math.max(cansell[i-1],canbuy[i-1]-prices[i]);
            cancool[i] = cansell[i-1] + prices[i];
        }
        
        return Math.max(cancool[len-1],canbuy[len-1]);
    }
}
