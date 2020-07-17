// solution 1: DP, build from bottom, dp[i] represents the min coin that are needed for summing up to number i, if dp[i] = Integer.MAX_VALUE then 
// no such coin combinations exist

// Note: in BFS you should have a visited[] array to record if the current remaining of the amount has been visited (to prevent lots of re-visited)
// solution 2: BFS

// solution 3: DFS, since we are finding the path with shortest steps, BFS is much better as DFS will go through all paths thus exceeding the time limit
// solution 3.1: DFS with greedy, pruning unnecessary paths, the fastest solution

// solution 1
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i && dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(1+dp[i-coins[j]],dp[i]);
                }
            }
        }
        
        return dp[amount]==Integer.MAX_VALUE? -1:dp[amount];
    }
}

// solution 2
class Solution {
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        
        // the visited is crucial for preventing overflow
        // e.g [1,2,5], if not record visited, after few steps
        // step 1: [1,2,5] length 3 
        // step 2: [1+1,1+2,1+5,2+1,2+2....5+1,5+2,5+5] length 9
        // step 3: length 27
        // step n: length 3^n --> boom
        boolean visited[] = new boolean[amount+1];
        Queue<Integer> q = new LinkedList();
        q.add(amount);
        visited[amount] = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                int cur = q.poll();
                if(cur==0) return count;
                
                for(int num:coins){
                    if(num<=cur && !visited[cur-num]){
                        q.add(cur-num);
                        visited[cur-num] = true;
                    }
                }
            }
            
            count++;
        }
        
        return -1;
    }
}

// solution 3
class Solution {
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        dfs(coins,amount,0);
        return res==Integer.MAX_VALUE? -1:res;
    }
    
    public void dfs(int[] coins,int amount,int count){
        if(amount<0) return;
        if(amount==0){
            res = Math.min(count,res);
            return;
        }
        for(int i=0;i<coins.length;i++){
            dfs(coins,amount-coins[i],count+1);
        }
    }
}

// solution 3.1
class Solution {
    int res = Integer.MAX_VALUE;
    
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins,amount,coins.length-1,0);
        return res == Integer.MAX_VALUE? -1:res;
    }
    
    public void dfs(int[] coins,int amount,int index,int count){
        if(amount==0){
            res = Math.min(res,count);
            return;
        }
        if(index<0) return;
        int nums = amount/coins[index];
        for(int i=nums;i>=0;i--){
            if(count+i>=res) return;
            dfs(coins,amount-i*coins[index],index-1,count+i);
        }
    }
}
