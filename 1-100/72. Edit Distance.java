// really good problem
// solution 1: bot-up dp
// solution 2: top-down dp
// the concept is to use a 2-D array, array[i][j] represents the minimum step that word.substring(0,i+1) and word.substring(0,j+1)
// can be converted, and this can be transferred from array[i-1][j-1], array[i][j-1] and array[i-1][j], so the one among these 3 cells
// that takes the min step to get to (i,j) is the value of array[i][j]

//solution 1
class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0) return word2.length();
        if(word2.length()==0) return word1.length();
        
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        dp[0][0] = 0;
        for(int i=1;i<dp.length;i++) dp[i][0] = i;
        for(int i=1;i<dp[0].length;i++) dp[0][i] = i;
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //dp[i][j] is depending on the smallest value of its left cell/ right cell
                // and left-right corner cell
                boolean eq = word1.charAt(i-1)==word2.charAt(j-1);
                dp[i][j] = dp[i-1][j-1]+ (eq? 0:1);
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
                dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+1);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
